package ru.korus.tmis.pdm.service.impl;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.korus.tmis.pdm.entities.*;
import ru.korus.tmis.pdm.service.AuthService;
import ru.korus.tmis.pdm.service.PdmXmlConfigService;
import ru.korus.tmis.pdm.service.PdmDaoServiceLocator;
import ru.korus.tmis.pdm.service.PdmService;
import ru.korus.tmis.pdm.ws.hl7.*;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.JAXBElement;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        30.09.2014, 9:42 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
@Service
public class PdmServiceImpl implements PdmService {

    public static final String OID_PDM = "3.0.0.0";
    public static final String OID_PREFIX = "OID";
    public static final char DOT_CH = '_';
    public static final String OID_DOC_PASSPORTNUMBER = "3.0.0.1";
    public static final String OID_DOC_PASSPORT_DATE = "3.0.0.2";
    public static final String OID_DOC_PASSPORT_CREATER = "3.0.0.3";
    public static final String OID_DOC_ACTBIRTH_NUMBER = "3.0.0.4";
    public static final String OID_DOC_ACTBIRTH_DATE = "3.0.0.5";
    public static final String OID_DOC_INN = "3.0.0.6";
    public static final String OID_DOC_SNILS = "3.0.0.7";
    public static final String OID_DOC_INSURANCE_ID = "3.0.0.8";
    public static final String OID_DOC_INSURANCE_ID_EXT = "3.0.0.9";
    public static final String OID_DOC_INSURANCE_END_DATE = "3.0.0.10";
    public static final String OID_DOC_INSURANCE_BEG_DATE = "3.0.0.11";
    public static final String OID_DOC_INSURANCE_COMPANY = "3.0.0.12";
    public static final String OID_DEFAULT_GENDER_CODE_SYSTEM = "2.16.840.1.113883.5.1";
    private static final Logger logger = LoggerFactory.getLogger(PDManager.class);
    public static final String CRYPT_TYPE = "AES";
    public static final String PUBLIK_KEY_SALT = "salt";

    @Autowired
    private PdmDaoServiceLocator pdmDaoServiceLocator;

    @Autowired
    PdmXmlConfigService pdmXmlConfigService;

    @Autowired
    AuthService authService;


    private ru.korus.tmis.pdm.ws.hl7.ObjectFactory factoryHL7 = new ObjectFactory();

    /**
     * @param prm
     */
    static public PersonalData newInstance(PRPAIN101311UV02 prm) {
        PersonalData res = new PersonalData();
        res.setPrivateKey(null);
        PRPAMT101301UV02Person identifiedPerson = prm.getControlActProcess().getSubject().getRegistrationRequest().getSubject1().getIdentifiedPerson().getIdentifiedPerson();
        List<PNExplicit> names = identifiedPerson.getName();
        if (!names.isEmpty()) {
            initNames(res, names.get(0));
        }
        CE genderCode = identifiedPerson.getAdministrativeGenderCode();
        res.setGender(genderCode == null ? null : Term.newInstance(genderCode.getCode(), genderCode.getCodeSystem()));
        TS birthTime = identifiedPerson.getBirthTime();
        res.setBirthData(birthTime == null ? null : birthTime.getValue());

        initTelecom(res, identifiedPerson.getTelecom());

        for (PRPAMT101301UV02OtherIDs ids : identifiedPerson.getAsOtherIDs()) {
            initDocs(res, ids.getId());
        }

        initAddr(res, identifiedPerson.getAddr());

        if (identifiedPerson.getBirthPlace() instanceof JAXBElement &&
                identifiedPerson.getBirthPlace().getValue() instanceof PRPAMT101301UV02BirthPlace) {
            res.setBirthPlace(Addr.newInstance(identifiedPerson.getBirthPlace().getValue().getAddr(), null));
        }
        return res;
    }

    public static <A> void initAddr(PersonalData res, List<A> addrList) {
        for (A a : addrList) {
            ADExplicit addr = (ADExplicit) a;
            final String use = addr.getUse().isEmpty() ? null : addr.getUse().get(0).name();

            final Addr addrInfo = findByUseAttr(res.getAddress(), use);
            if (addrInfo == null) {
                res.getAddress().add(Addr.newInstance(addr, use));
            } else {
                addrInfo.set(Addr.newInstance(addr, use));
            }
        }
    }

    public static <T> void initTelecom(PersonalData res, List<T> telecomList) {
        for (T t : telecomList) {
            final TEL telecom = (TEL) t;
            final String use = telecom.getUse().isEmpty() ? null : telecom.getUse().get(0).name();
            Telecom tel = findByUseAttr(res.getTelecoms(), use);
            if (tel == null) {
                res.getTelecoms().add(Telecom.newInstance(telecom.getValue(), use));
            } else {
                tel.setValue(telecom.getValue());
            }
        }
    }

    private static <T> T findByUseAttr(List<T> list, String use) {
        for (T obj : list) {
            final String useCur = ((Use) obj).getUse();
            if (useCur == null && use == null) {
                return (T) obj;
            }
            if (useCur.equals(use)) {
                return (T) obj;
            }
        }
        return null;
    }

    private static void initDocs(PersonalData res, List<II> id1) {
        for (II ii : id1) {
            final String root = ii.getRoot();
            if (root != null) {
                res.getDocs().put(codeOID(root), ii.getExtension());
            }
        }
    }

    public static void initNames(PersonalData res, PNExplicit pn) {
        boolean isName = true;
        for (Serializable object : pn.getContent()) {
            if (object instanceof JAXBElement) {
                JAXBElement el = (JAXBElement) object;
                if (el.getValue() instanceof EnExplicitGiven) {
                    if (isName) {
                        res.setGiven(((EnExplicitGiven) el.getValue()).getContent());
                        isName = false;
                    } else {
                        res.setMiddleName(((EnExplicitGiven) el.getValue()).getContent());
                    }
                } else if (el.getValue() instanceof EnExplicitFamily) {
                    res.setFamily(((EnExplicitFamily) el.getValue()).getContent());
                }
            }
        }
    }

    public static PersonalData newInstance(PRPAIN101305UV02 prm) {
        PersonalData res = new PersonalData();
        final PRPAMT101306UV02ParameterList parameterList = prm.getControlActProcess().getQueryByParameter().getValue().getParameterList();
        List<PRPAMT101306UV02PersonName> personNames = parameterList.getPersonName();
        if (!personNames.isEmpty() && !personNames.get(0).getValue().isEmpty()) { // если задаано ФИО персоны
            initNames(res, personNames.get(0).getValue().get(0));
        }
        final List<PRPAMT101306UV02PersonAdministrativeGender> personAdministrativeGender = parameterList.getPersonAdministrativeGender();
        if (!personAdministrativeGender.isEmpty() &&
                !personAdministrativeGender.get(0).getValue().isEmpty()) { //если задан пол персоны
            CV genderCode = personAdministrativeGender.get(0).getValue().get(0);
            res.setGender(genderCode == null ? null : Term.newInstance(genderCode.getCode(), genderCode.getCodeSystem()));
        }
        for (PRPAMT101306UV02OtherIDsScopingOrganization otherId : parameterList.getOtherIDsScopingOrganization()) {
            initDocs(res, otherId.getValue());
        }

        for (PRPAMT101306UV02IdentifiedPersonTelecom telecom : parameterList.getIdentifiedPersonTelecom()) {
            initTelecom(res, telecom.getValue());
        }

        for (PRPAMT101306UV02IdentifiedPersonAddress address : parameterList.getIdentifiedPersonAddress()) {
            initAddr(res, address.getValue());
        }
        List<PRPAMT101306UV02PersonBirthPlaceAddress> birthPlaceAddressList = parameterList.getPersonBirthPlaceAddress();
        if (!birthPlaceAddressList.isEmpty() &&
                !birthPlaceAddressList.get(0).getValue().isEmpty()) {
            res.setBirthPlace(Addr.newInstance(birthPlaceAddressList.get(0).getValue().get(0), null));
        }

        return res;
    }

    public static String decodeOID(String root) {
        return root.replace(DOT_CH, '.').substring(OID_PREFIX.length());
    }

    public static String codeOID(String root) {
        return OID_PREFIX + root.replace('.', DOT_CH);
    }

    public PersonalData update(PersonalData personalData, PRPAIN101314UV02 prm) {

        PRPAMT101302UV02IdentifiedPersonIdentifiedPerson identifiedPerson = prm.getControlActProcess().getSubject().getRegistrationRequest().getSubject1().getIdentifiedPerson().getIdentifiedPerson();
        List<PRPAMT101302UV02PersonName> names = identifiedPerson.getName();
        if (!names.isEmpty()) {
            initNames(personalData, names.get(0));
        }
        CE genderCode = identifiedPerson.getAdministrativeGenderCode();
        personalData.setGender(genderCode == null ? null : Term.newInstance(genderCode.getCode(), genderCode.getCodeSystem()));
        TS birthTime = identifiedPerson.getBirthTime();
        personalData.setBirthData(birthTime == null ? null : birthTime.getValue());

        initTelecom(personalData, identifiedPerson.getTelecom());

        for (PRPAMT101302UV02PersonAsOtherIDs cur :
                identifiedPerson.getAsOtherIDs()) {
            for (II ii : cur.getId()) {
                final String root = ii.getRoot();
                if (!OID_PDM.equals(root)) {
                    personalData.getDocs().put(codeOID(root), ii.getExtension());
                }
            }

        }

        initAddr(personalData, identifiedPerson.getAddr());

        if (identifiedPerson.getBirthPlace() instanceof JAXBElement &&
                identifiedPerson.getBirthPlace().getValue() instanceof PRPAMT101302UV02PersonBirthPlace) {
            personalData.setBirthPlace(Addr.newInstance(identifiedPerson.getBirthPlace().getValue().getAddr(), null));
        }

        return personalData;

    }

    @Override
    public PRPAIN101312UV02 add(PRPAIN101311UV02 parameters) {
        logger.info("Adding a new person. Parsing input parameters...");
        final PersonalData personalData = newInstance(parameters);
        logger.info("Adding a new person. Save to storage...");
        String senderId = parameters.getSender().getDevice().getId().get(0).getRoot();
        final String id = toPublicKey(save(personalData), senderId);
        logger.info("Adding a new person. Prepare and sending the response...");
        return getPRPAIN101312UV02(id);

    }

    private String toPublicKey(byte[] privateKey, String senderId) {
        try {
            byte key[] = pdmXmlConfigService.getSystemDbKey(senderId);
            if(key != null) {
                Key aesKey = new SecretKeySpec(key, CRYPT_TYPE);
                Cipher cipher = Cipher.getInstance(CRYPT_TYPE);
                cipher.init(Cipher.ENCRYPT_MODE, aesKey);
                byte[] encrypted = cipher.doFinal(privateKey);
                return Base64.encode(encrypted);
            }
            return null;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }

    private byte[] toPrivateKey(String publicKey, String senderId) {
        try {
            byte key[] = pdmXmlConfigService.getSystemDbKey(senderId);
            if(key != null) {
                Key aesKey = new SecretKeySpec(key, CRYPT_TYPE);
                byte[] text = Base64.decode(publicKey);
                Cipher cipher = Cipher.getInstance(CRYPT_TYPE);
                cipher.init(Cipher.DECRYPT_MODE, aesKey);
                return cipher.doFinal(text);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PRPAIN101306UV02 findCandidates(PRPAIN101305UV02 parameters) {
        logger.info("Find by demographics info. Parsing input parameters...");
        final PersonalData person = newInstance(parameters);
        logger.info("Find by demographics info. Find in storage...");
        final List<PersonalData> personalDataList = findPerson(person);
        logger.info("Find by demographics info. Prepare and sending the response...");
        String senderId = parameters.getSender().getDevice().getId().get(0).getRoot();
        return getPRPAIN101306UV02(personalDataList, senderId);
    }

    @Override
    public PRPAIN101308UV02 getDemographics(PRPAIN101307UV02 parameters) {
        logger.info("Get demographics info by id. Parsing input parameters...");
        //TODO add verification
        final List<PRPAMT101307UV02IdentifiedPersonIdentifier> identifiedPersons = parameters.getControlActProcess().getQueryByParameter().getValue().
                getParameterList().getIdentifiedPersonIdentifier();
        logger.info("Get demographics info by id. Count of inputsIDs : ", identifiedPersons == null ? "not set" : ("" + identifiedPersons.size()));
        List<PersonalData> personalDataList = new Vector<PersonalData>(identifiedPersons.size());
        for (PRPAMT101307UV02IdentifiedPersonIdentifier curPerson : identifiedPersons) {
            String senderId = parameters.getSender().getDevice().getId().get(0).getRoot();
            String publicKey = curPerson.getValue().get(0).getRoot();
            final byte[] privateKey = toPrivateKey(publicKey, senderId);
            logger.info("Get demographics info by id. Find demographics info for id = " + publicKey);
            personalDataList.add(findById(privateKey));
        }
        logger.info("Get demographics info by id. Prepare and sending the response...");
        String senderId = parameters.getSender().getDevice().getId().get(0).getRoot();
        return getPRPAIN101308UV02(personalDataList, senderId);

    }

    @Override
    public PRPAIN101315UV02 update(PRPAIN101314UV02 parameters) {
        logger.info("Update demographics info by id. Parsing input parameters...");
        for (PRPAMT101302UV02PersonAsOtherIDs cur :
                parameters.getControlActProcess().getSubject().getRegistrationRequest().getSubject1().getIdentifiedPerson().getIdentifiedPerson().getAsOtherIDs()) {
            for (II ii : cur.getId()) {
                logger.error("Update demographics info by id. Check document root: ", ii.getRoot());
                if (OID_PDM.equals(ii.getRoot())) {
                    String publicKey = ii.getExtension();
                    String senderId = parameters.getSender().getDevice().getId().get(0).getRoot();
                    final byte[] privateKey = toPrivateKey(publicKey, senderId);
                    final PersonalData personalData = findById(privateKey);
                    final PersonalData personalDataNew = update(personalData, parameters);
                    savePerson(personalDataNew);
                    return getPRPAIN101315UV02(ii.getExtension());
                }
            }
        }
        logger.error("Update demographics info by id. Wrong input parameters. Not found PDM OID: {}", OID_PDM);
        throw new RuntimeException("The PDM ID is not set");
    }

    @Override
    public PRPAIN101306UV02 findLike(PRPAIN101305UV02 parameters) {
        logger.info("Find Like. Parsing input parameters...");
        final PersonalData person = newInstance(parameters);
        logger.info("Find Like. Find like in storage...");
        final List<PersonalData> personalDataList = findPersonLike(person);
        logger.info("Find Like. Prepare and sending the response...");
        String senderId = parameters.getSender().getDevice().getId().get(0).getRoot();
        return getPRPAIN101306UV02(personalDataList, senderId);
    }

    @Override
    public String login(String oid, String password) {
        String res = null;
        if(pdmXmlConfigService.login(oid, password) != null) {
            res = authService.addToken(oid);
        }
        return res;
    }

    @Override
    public boolean logout(String token) {
        return authService.logout(token)&& pdmXmlConfigService.logout(token);
    }


    private List<PersonalData> findPersonLike(PersonalData person) {
        return pdmDaoServiceLocator.getPdmDaoService().findPersonLike(person);
    }

    private void savePerson(PersonalData personalDataNew) {
        pdmDaoServiceLocator.getPdmDaoService().save(personalDataNew);
    }


    private List<PersonalData> findPerson(PersonalData person) {
        return pdmDaoServiceLocator.getPdmDaoService().find(person);
    }


    private PRPAIN101315UV02 getPRPAIN101315UV02(String id) {
        logger.info("Creating the response PRPAIN101315UV02. Person id = {}", id);
        PRPAIN101315UV02 res = factoryHL7.createPRPAIN101315UV02();

        final PRPAMT101303UV02IdentifiedPerson identifiedPerson = factoryHL7.createPRPAMT101303UV02IdentifiedPerson();
        final PRPAIN101315UV02MFMIMT700701UV01Subject2 subject2 = factoryHL7.createPRPAIN101315UV02MFMIMT700701UV01Subject2();
        final PRPAMT101303UV02Person person = factoryHL7.createPRPAMT101303UV02Person();

        final PRPAIN101315UV02MFMIMT700701UV01ControlActProcess controlActProcess = factoryHL7.createPRPAIN101315UV02MFMIMT700701UV01ControlActProcess();
        res.setControlActProcess(controlActProcess);
        final PRPAIN101315UV02MFMIMT700701UV01Subject1 subject1 = factoryHL7.createPRPAIN101315UV02MFMIMT700701UV01Subject1();
        controlActProcess.getSubject().add(subject1);
        final PRPAIN101315UV02MFMIMT700701UV01RegistrationEvent registrationEvent = factoryHL7.createPRPAIN101315UV02MFMIMT700701UV01RegistrationEvent();
        subject1.setRegistrationEvent(registrationEvent);
        registrationEvent.setSubject1(subject2);
        subject2.setIdentifiedPerson(identifiedPerson);
        identifiedPerson.setIdentifiedPerson(person);
        II ii = createPdmII(id);
        person.getId().add(ii);
        logger.info("The message PRPAIN101315UV02 is completed");
        return res;
    }

    private PRPAIN101312UV02 getPRPAIN101312UV02(String id) {
        logger.info("Creating the response PRPAIN101312UV02. Person id = {}", id);
        PRPAIN101312UV02 res = factoryHL7.createPRPAIN101312UV02();

        final PRPAIN101312UV02MFMIMT700701UV01ControlActProcess controlActProcess = factoryHL7.createPRPAIN101312UV02MFMIMT700701UV01ControlActProcess();
        final PRPAIN101312UV02MFMIMT700701UV01Subject1 subject1 = factoryHL7.createPRPAIN101312UV02MFMIMT700701UV01Subject1();
        final PRPAIN101312UV02MFMIMT700701UV01RegistrationEvent registrationEvent = factoryHL7.createPRPAIN101312UV02MFMIMT700701UV01RegistrationEvent();
        final PRPAMT101304UV02IdentifiedPerson identifiedPerson = factoryHL7.createPRPAMT101304UV02IdentifiedPerson();
        final PRPAIN101312UV02MFMIMT700701UV01Subject2 subject2 = factoryHL7.createPRPAIN101312UV02MFMIMT700701UV01Subject2();
        final PRPAMT101304UV02Person person = factoryHL7.createPRPAMT101304UV02Person();

        res.setControlActProcess(controlActProcess);
        controlActProcess.getSubject().add(subject1);
        subject1.setRegistrationEvent(registrationEvent);
        registrationEvent.setSubject1(subject2);
        subject2.setIdentifiedPerson(identifiedPerson);
        identifiedPerson.setIdentifiedPerson(person);
        II ii = createPdmII(id);
        person.getId().add(ii);
        logger.info("The message PRPAIN101312UV02 is completed");
        return res;
    }

    private PRPAIN101306UV02 getPRPAIN101306UV02(List<PersonalData> personalDataList, String senderId) {
        logger.info("Creating the response PRPAIN101306UV02. The count of persons: {}", personalDataList == null ? "not set" : personalDataList.size());
        PRPAIN101306UV02 res = factoryHL7.createPRPAIN101306UV02();
        PRPAIN101306UV02MFMIMT700711UV01ControlActProcess controlActProcess = factoryHL7.createPRPAIN101306UV02MFMIMT700711UV01ControlActProcess();
        res.setControlActProcess(controlActProcess);
        for (PersonalData personalData : personalDataList) {
            logger.info("Creating the response PRPAIN101306UV02. Current person id: {}", personalData.getPrivateKey());
            PRPAIN101306UV02MFMIMT700711UV01Subject1 subject = factoryHL7.createPRPAIN101306UV02MFMIMT700711UV01Subject1();
            controlActProcess.getSubject().add(subject);
            PRPAIN101306UV02MFMIMT700711UV01RegistrationEvent event = factoryHL7.createPRPAIN101306UV02MFMIMT700711UV01RegistrationEvent();
            subject.setRegistrationEvent(event);
            final PRPAIN101306UV02MFMIMT700711UV01Subject2 subject2 = factoryHL7.createPRPAIN101306UV02MFMIMT700711UV01Subject2();
            event.setSubject1(subject2);
            final PRPAMT101310UV02IdentifiedPerson person = factoryHL7.createPRPAMT101310UV02IdentifiedPerson();
            subject2.setIdentifiedPerson(person);
            II ii = createPdmII(toPublicKey(personalData.getPrivateKey(), senderId));
            person.getId().add(ii);
            person.setStatusCode(factoryHL7.createCS());
            person.getStatusCode().setCode("active");
            person.setIdentifiedPerson(factoryHL7.createPRPAMT101310UV02Person());
            person.getIdentifiedPerson().getName().add(getHL7Name(personalData));
            person.getIdentifiedPerson().setAdministrativeGenderCode(getHL7Gender(personalData));
            person.getIdentifiedPerson().setBirthTime(getHL7BirthDate(personalData));

            for (Map.Entry<String, String> doc : personalData.getDocs().entrySet()) {
                PRPAMT101310UV02OtherIDs otherId = factoryHL7.createPRPAMT101310UV02OtherIDs();
                otherId.getId().add(createII(doc));
                person.getIdentifiedPerson().getAsOtherIDs().add(otherId);
            }

            for (Telecom telecom : personalData.getTelecoms()) {
                person.getIdentifiedPerson().getTelecom().add(getHL7Telecom(telecom));
            }

            for (Addr addr : personalData.getAddress()) {
                person.getIdentifiedPerson().getAddr().add(getHL7Addr(addr));
            }

            if (personalData.getBirthPlace() != null) {
                PRPAMT101310UV02BirthPlace birthPlace = factoryHL7.createPRPAMT101310UV02BirthPlace();
                birthPlace.setAddr(getHL7Addr(personalData.getBirthPlace()));
                person.getIdentifiedPerson().setBirthPlace(factoryHL7.createPRPAMT101310UV02PersonBirthPlace(birthPlace));
            }

        }
        logger.info("The message PRPAIN101306UV02 is completed");
        return res;
    }

    /**
     * Генерация выходного сообщения HL7 для метода getDemographics
     *
     * @param personalDataList - входные персональные данные
     * @return - сообшение HL7 PRPA_IN101308UV02, содержащее входные персональные данные
     */
    private PRPAIN101308UV02 getPRPAIN101308UV02(List<PersonalData> personalDataList, String senderId) {
        logger.info("Creating the response PRPAIN101308UV02. The count of persons: {}", personalDataList == null ? "not set" : personalDataList.size());
        PRPAIN101308UV02 res = factoryHL7.createPRPAIN101308UV02();
        final PRPAIN101308UV02MFMIMT700711UV01ControlActProcess controlActProcess = factoryHL7.createPRPAIN101308UV02MFMIMT700711UV01ControlActProcess();
        res.setControlActProcess(controlActProcess);
        for (PersonalData personalData : personalDataList) {
            logger.info("Creating the response PRPAIN101308UV02. Current person id: {}", personalData.getPrivateKey());
            final PRPAIN101308UV02MFMIMT700711UV01Subject1 subject1 = factoryHL7.createPRPAIN101308UV02MFMIMT700711UV01Subject1();
            controlActProcess.getSubject().add(subject1);
            final PRPAIN101308UV02MFMIMT700711UV01RegistrationEvent registrationEvent = factoryHL7.createPRPAIN101308UV02MFMIMT700711UV01RegistrationEvent();
            subject1.setRegistrationEvent(registrationEvent);
            final PRPAIN101308UV02MFMIMT700711UV01Subject2 subject2 = factoryHL7.createPRPAIN101308UV02MFMIMT700711UV01Subject2();
            registrationEvent.setSubject1(subject2);
            final PRPAMT101303UV02IdentifiedPerson person = factoryHL7.createPRPAMT101303UV02IdentifiedPerson();
            subject2.setIdentifiedPerson(person);
            II ii = createPdmII(toPublicKey(personalData.getPrivateKey(), senderId));
            person.getId().add(ii);
            person.setStatusCode(factoryHL7.createCS());
            person.getStatusCode().setCode("active");
            person.setIdentifiedPerson(factoryHL7.createPRPAMT101303UV02Person());
            person.getIdentifiedPerson().getName().add(getHL7Name(personalData));
            person.getIdentifiedPerson().setAdministrativeGenderCode(getHL7Gender(personalData));
            person.getIdentifiedPerson().setBirthTime(getHL7BirthDate(personalData));

            for (Map.Entry<String, String> doc : personalData.getDocs().entrySet()) {
                PRPAMT101303UV02OtherIDs otherId = factoryHL7.createPRPAMT101303UV02OtherIDs();
                otherId.getId().add(createII(doc));
                person.getIdentifiedPerson().getAsOtherIDs().add(otherId);
            }

            for (Telecom telecom : personalData.getTelecoms()) {
                person.getIdentifiedPerson().getTelecom().add(getHL7Telecom(telecom));
            }

            for (Addr addr : personalData.getAddress()) {
                person.getIdentifiedPerson().getAddr().add(getHL7Addr(addr));
            }

            if (personalData.getBirthPlace() != null) {
                PRPAMT101303UV02BirthPlace birthPlace = factoryHL7.createPRPAMT101303UV02BirthPlace();
                birthPlace.setAddr(getHL7Addr(personalData.getBirthPlace()));
                person.getIdentifiedPerson().setBirthPlace(factoryHL7.createPRPAMT101303UV02PersonBirthPlace(birthPlace));
            }
        }
        logger.info("The message PRPAIN101308UV02 is completed");
        return res;
    }

    private AD getHL7Addr(Addr addr) {
        AD res = factoryHL7.createAD();
        AdxpExplicitCountry country = factoryHL7.createAdxpExplicitCountry();
        AdxpExplicitStreetAddressLine addrLine = factoryHL7.createAdxpExplicitStreetAddressLine();
        AdxpExplicitDirection direction = factoryHL7.createAdxpExplicitDirection();
        AdxpExplicitPostBox postBox = factoryHL7.createAdxpExplicitPostBox();
        AdxpExplicitUnitType unitType = factoryHL7.createAdxpExplicitUnitType();
        AdxpExplicitDelimiter delimiter = factoryHL7.createAdxpExplicitDelimiter();
        AdxpExplicitDeliveryInstallationArea deliveryInstallationArea = factoryHL7.createAdxpExplicitDeliveryInstallationArea();
        AdxpExplicitDeliveryModeIdentifier celiveryModeIdentifier = factoryHL7.createAdxpExplicitDeliveryModeIdentifier();
        AdxpExplicitPostalCode postalCode = factoryHL7.createAdxpExplicitPostalCode();
        AdxpExplicitDeliveryAddressLine deliveryAddressLine = factoryHL7.createAdxpExplicitDeliveryAddressLine();
        AdxpExplicitStreetName explicitStreetName = factoryHL7.createAdxpExplicitStreetName();
        AdxpExplicitUnitID edxpExplicitUnitID = factoryHL7.createAdxpExplicitUnitID();
        AdxpExplicitAdditionalLocator additionalLocator = factoryHL7.createAdxpExplicitAdditionalLocator();
        AdxpExplicitDeliveryMode deliveryMode = factoryHL7.createAdxpExplicitDeliveryMode();
        AdxpExplicitStreetNameBase streetNameBase = factoryHL7.createAdxpExplicitStreetNameBase();
        AdxpExplicitDeliveryInstallationQualifier deliveryInstallationQualifier = factoryHL7.createAdxpExplicitDeliveryInstallationQualifier();
        AdxpExplicitCounty county = factoryHL7.createAdxpExplicitCounty();
        AdxpExplicitPrecinct explicitPrecinct = factoryHL7.createAdxpExplicitPrecinct();
        AdxpExplicitCareOf careOf = factoryHL7.createAdxpExplicitCareOf();
        AdxpExplicitHouseNumber houseNumber = factoryHL7.createAdxpExplicitHouseNumber();
        AdxpExplicitCensusTract censusTract = factoryHL7.createAdxpExplicitCensusTract();
        AdxpExplicitBuildingNumberSuffix buildingNumberSuffix = factoryHL7.createAdxpExplicitBuildingNumberSuffix();
        AdxpExplicitHouseNumberNumeric houseNumberNumeric = factoryHL7.createAdxpExplicitHouseNumberNumeric();
        AdxpExplicitStreetNameType1 streetNameType1 = factoryHL7.createAdxpExplicitStreetNameType1();
        AdxpExplicitDeliveryInstallationType deliveryInstallationType = factoryHL7.createAdxpExplicitDeliveryInstallationType();
        AdxpExplicitState state = factoryHL7.createAdxpExplicitState();
        AdxpExplicitCity city = factoryHL7.createAdxpExplicitCity();

        country.setContent(addr.getCountry());
        addrLine.setContent(addr.getStreetAddressLine());
        direction.setContent(addr.getDirection());
        postBox.setContent(addr.getPostBox());
        unitType.setContent(addr.getUnitType());
        delimiter.setContent(addr.getDelimiter());
        deliveryInstallationArea.setContent(addr.getDeliveryInstallationArea());
        celiveryModeIdentifier.setContent(addr.getDeliveryModeIdentifier());
        postalCode.setContent(addr.getPostalCode());
        deliveryAddressLine.setContent(addr.getDeliveryAddressLine());
        explicitStreetName.setContent(addr.getStreetName());
        edxpExplicitUnitID.setContent(addr.getUnitID());
        additionalLocator.setContent(addr.getAdditionalLocator());
        deliveryMode.setContent(addr.getDeliveryMode());
        streetNameBase.setContent(addr.getStreetNameBase());
        deliveryInstallationQualifier.setContent(addr.getDeliveryInstallationQualifier());
        county.setContent(addr.getCounty());
        explicitPrecinct.setContent(addr.getPrecinct());
        careOf.setContent(addr.getCareOf());
        houseNumber.setContent(addr.getHouseNumber());
        censusTract.setContent(addr.getCensusTract());
        buildingNumberSuffix.setContent(addr.getBuildingNumberSuffix());
        houseNumberNumeric.setContent(addr.getHouseNumberNumeric());
        streetNameType1.setContent(addr.getStreetNameType());
        deliveryInstallationType.setContent(addr.getDeliveryInstallationType());
        state.setContent(addr.getState());
        city.setContent(addr.getCity());

        res.getContent().add(factoryHL7.createADExplicitCountry(country));
        res.getContent().add(factoryHL7.createADExplicitStreetAddressLine(addrLine));
        res.getContent().add(factoryHL7.createADExplicitDirection(direction));
        res.getContent().add(factoryHL7.createADExplicitPostBox(postBox));
        res.getContent().add(factoryHL7.createADExplicitUnitType(unitType));
        res.getContent().add(factoryHL7.createADExplicitDelimiter(delimiter));
        res.getContent().add(factoryHL7.createADExplicitDeliveryInstallationArea(deliveryInstallationArea));
        res.getContent().add(factoryHL7.createADExplicitDeliveryModeIdentifier(celiveryModeIdentifier));
        res.getContent().add(factoryHL7.createADExplicitPostalCode(postalCode));
        res.getContent().add(factoryHL7.createADExplicitDeliveryAddressLine(deliveryAddressLine));
        res.getContent().add(factoryHL7.createADExplicitStreetName(explicitStreetName));
        res.getContent().add(factoryHL7.createADExplicitUnitID(edxpExplicitUnitID));
        res.getContent().add(factoryHL7.createADExplicitAdditionalLocator(additionalLocator));
        res.getContent().add(factoryHL7.createADExplicitDeliveryMode(deliveryMode));
        res.getContent().add(factoryHL7.createADExplicitStreetNameBase(streetNameBase));
        res.getContent().add(factoryHL7.createADExplicitDeliveryInstallationQualifier(deliveryInstallationQualifier));
        res.getContent().add(factoryHL7.createADExplicitCounty(county));
        res.getContent().add(factoryHL7.createADExplicitPrecinct(explicitPrecinct));
        res.getContent().add(factoryHL7.createADExplicitCareOf(careOf));
        res.getContent().add(factoryHL7.createADExplicitHouseNumber(houseNumber));
        res.getContent().add(factoryHL7.createADExplicitCensusTract(censusTract));
        res.getContent().add(factoryHL7.createADExplicitBuildingNumberSuffix(buildingNumberSuffix));
        res.getContent().add(factoryHL7.createADExplicitHouseNumberNumeric(houseNumberNumeric));
        res.getContent().add(factoryHL7.createADExplicitStreetNameType(streetNameType1));
        res.getContent().add(factoryHL7.createADExplicitDeliveryInstallationType(deliveryInstallationType));
        res.getContent().add(factoryHL7.createADExplicitState(state));
        res.getContent().add(factoryHL7.createADExplicitCity(city));

        final String addrType = addr.getUse();
        if (addrType != null) {
            res.getUse().add(PostalAddressUse.fromValue(addrType));
        }

        return res;
    }

    private TEL getHL7Telecom(Telecom telecom) {
        TEL res = factoryHL7.createTEL();
        res.setValue(telecom.getValue());
        if (telecom.getUse() != null) {
            res.getUse().add(TelecommunicationAddressUse.fromValue(telecom.getUse()));
        }
        return res;
    }

    private II createII(Map.Entry<String, String> doc) {
        return createII(doc.getValue(), decodeOID(doc.getKey()));
    }


    private byte[] save(PersonalData personalData) {
        boolean isAdded = false;
        for (Map.Entry<String, String> doc : personalData.getDocs().entrySet()) {
            isAdded |= pdmDaoServiceLocator.getPdmDaoService().find(doc);
        }
        if(!isAdded) {
            pdmDaoServiceLocator.getPdmDaoService().save(personalData);
        }
        return personalData.getPrivateKey();
    }


    private PersonalData findById(byte[] id) {
        return pdmDaoServiceLocator.getPdmDaoService().findById(id);
    }

    private II createPdmII(String id) {
        return createII(id, OID_PDM);
    }

    private II createII(String extension, String root) {
        II ii = factoryHL7.createII();
        ii.setExtension(extension);
        ii.setRoot(root);
        return ii;
    }

    private PN getHL7Name(PersonalData personalData) {
        PN name = factoryHL7.createPN();

        EnExplicitGiven given = factoryHL7.createEnExplicitGiven();
        given.setContent(personalData.getGiven());
        name.getContent().add(factoryHL7.createENExplicitGiven(given));

        EnExplicitGiven middleName = factoryHL7.createEnExplicitGiven();
        middleName.setContent(personalData.getMiddleName());
        name.getContent().add(factoryHL7.createENExplicitGiven(middleName));

        EnExplicitFamily family = factoryHL7.createEnExplicitFamily();
        family.setContent(personalData.getFamily());
        name.getContent().add(factoryHL7.createENExplicitFamily(family));

        return name;
    }

    private CE getHL7Gender(PersonalData personalData) {
        Term gender = personalData.getGender();
        if (gender == null) {
            return null;
        }
        CE res = factoryHL7.createCE();
        res.setCode(gender.getCode());
        res.setCodeSystem(gender.getCodeSystem());
        return res;
    }

    private TS getHL7BirthDate(PersonalData personalData) {
        String birthDate = personalData.getBirthData();
        if (birthDate == null) {
            return null;
        }
        TS res = factoryHL7.createTS();
        res.setValue(birthDate);
        return res;
    }


}
