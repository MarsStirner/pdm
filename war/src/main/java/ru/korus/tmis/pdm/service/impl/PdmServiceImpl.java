package ru.korus.tmis.pdm.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.korus.tmis.pdm.entities.Addr;
import ru.korus.tmis.pdm.entities.PrivateKey;
import ru.korus.tmis.pdm.entities.Telecom;
import ru.korus.tmis.pdm.model.*;
import ru.korus.tmis.pdm.model.api.Identifier;
import ru.korus.tmis.pdm.model.api.PersonalInfo;
import ru.korus.tmis.pdm.model.api.PublicKeyInfo;
import ru.korus.tmis.pdm.model.api.ValueInfo;
import ru.korus.tmis.pdm.service.*;
import ru.korus.tmis.pdm.service.impl.xml.PdmConfig;
import ru.korus.tmis.pdm.utilities.Crypting;
import ru.korus.tmis.pdm.ws.hl7.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.JAXBElement;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.util.*;

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
    public static final String INTERNAL_ERROR = "Internal error";

    @Autowired
    private PdmDaoServiceLocator pdmDaoServiceLocator;

    @Autowired
    PdmXmlConfigService pdmXmlConfigService;

    @Autowired
    AuthService authService;

    @Autowired
    PersonalDataBuilderService personalDataBuilderService;

    private ru.korus.tmis.pdm.ws.hl7.ObjectFactory factoryHL7 = new ObjectFactory();

    /**
     * @param prm
     */
    public PersonalInfo newInstance(PRPAIN101311UV02 prm) {
        PersonalInfo res = new PersonalInfo();
        PRPAMT101301UV02Person identifiedPerson = prm.getControlActProcess().getSubject().getRegistrationRequest().getSubject1().getIdentifiedPerson().getIdentifiedPerson();
        List<PNExplicit> names = identifiedPerson.getName();
        if (!names.isEmpty()) {
            initNames(res, names.get(0));
        }
        CE genderCode = identifiedPerson.getAdministrativeGenderCode();
        res.setGender(genderCode == null ? null : new ValueInfo(null, genderCode.getCode(), genderCode.getCodeSystem()));
        TS birthTime = identifiedPerson.getBirthTime();
        res.getBirthInfo().setBirthDate(birthTime == null ? null : birthTime.getValue());

        initTelecom(res, identifiedPerson.getTelecom());

        Map<String, DocsInfo> docs = new HashMap<>();
        for (PRPAMT101301UV02OtherIDs ids : identifiedPerson.getAsOtherIDs()) {
            initDocs(res, ids.getId(), docs);
        }
        addDocs(res, docs);

        initAddr(res, identifiedPerson.getAddr());

        if (identifiedPerson.getBirthPlace() instanceof JAXBElement &&
                identifiedPerson.getBirthPlace().getValue() instanceof PRPAMT101301UV02BirthPlace) {
            res.getBirthInfo().setBirthPlace(AddrInfo.newInstance(identifiedPerson.getBirthPlace().getValue().getAddr(), null));
        }
        return res;
    }

    public static <A> void initAddr(PersonalInfo res, List<A> addrList) {
        for (A a : addrList) {
            ADExplicit addr = (ADExplicit) a;
            final String use = addr.getUse().isEmpty() ? null : addr.getUse().get(0).name();

            final AddrInfo addrInfo = findByUseAttr(res.getAddressList(), use);
            if (addrInfo == null) {
                res.getAddressList().add(AddrInfo.newInstance(addr, use));
            } else {
                addrInfo.set(AddrInfo.newInstance(addr, use));
            }
        }
    }

    public static <T> void initTelecom(PersonalInfo res, List<T> telecomList) {
        for (T t : telecomList) {
            final TEL telecom = (TEL) t;
            final String use = telecom.getUse().isEmpty() ? null : telecom.getUse().get(0).name();
            ValueInfo tel = findByUseAttr(res.getTelecoms(), use);
            if (tel == null) {
                ValueInfo valueInfo = new ValueInfo();
                valueInfo.setDescription(use);
                valueInfo.setValue(telecom.getValue());
                res.getTelecoms().add(valueInfo);
            } else {
                tel.setValue(telecom.getValue());
            }
        }
    }

    private static <T> T findByUseAttr(List<T> list, String use) {
        for (T obj : list) {
            final String useCur = ((UseInfo) obj).getUse();
            if (useCur == null && use == null) {
                return (T) obj;
            }
            if (useCur.equals(use)) {
                return (T) obj;
            }
        }
        return null;
    }

    private <T> void initDocs(PersonalInfo res, List<T> iiList, Map<String, DocsInfo> docs) {
        for (T obj : iiList) {
            II ii = (II) obj;
            final String root = ii.getRoot();
            if (root != null) {
                PdmConfig.Docs.Doc doc = pdmXmlConfigService.getDocsNameByAttrOid(root);
                if (doc != null) {
                    DocsInfo docsInfo = docs.get(doc.getName());
                    String name = doc.getName();
                    if (docsInfo == null && name != null) {
                        docsInfo = new DocsInfo();
                        docsInfo.setName(name);
                        docsInfo.setDescription(docsInfo.getDescription());
                        docs.put(name, docsInfo);
                    }
                    docsInfo.getAttrs().add(new ValueInfo(null, ii.getExtension(), root));
                }
            }
        }
    }

    private void addDocs(PersonalInfo res, Map<String, DocsInfo> docs) {
        for (DocsInfo doc : docs.values()) {
            res.getDocs().add(doc);
        }
    }

    public static void initNames(PersonalInfo res, PNExplicit pn) {
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

    public PersonalInfo newInstance(PRPAIN101305UV02 prm) {
        PersonalInfo res = new PersonalInfo();
        final PRPAMT101306UV02ParameterList parameterList = prm.getControlActProcess().getQueryByParameter().getValue().getParameterList();
        List<PRPAMT101306UV02PersonName> personNames = parameterList.getPersonName();
        if (!personNames.isEmpty() && !personNames.get(0).getValue().isEmpty()) { // если задаано ФИО персоны
            initNames(res, personNames.get(0).getValue().get(0));
        }
        final List<PRPAMT101306UV02PersonAdministrativeGender> personAdministrativeGender = parameterList.getPersonAdministrativeGender();
        if (!personAdministrativeGender.isEmpty() &&
                !personAdministrativeGender.get(0).getValue().isEmpty()) { //если задан пол персоны
            CV genderCode = personAdministrativeGender.get(0).getValue().get(0);
            res.setGender(genderCode == null ? null : new ValueInfo(null, genderCode.getCode(), genderCode.getCodeSystem()));
        }
        Map<String, DocsInfo> docs = new HashMap<>();
        for (PRPAMT101306UV02OtherIDsScopingOrganization otherId : parameterList.getOtherIDsScopingOrganization()) {
            initDocs(res, otherId.getValue(), docs);
        }
        addDocs(res, docs);

        for (PRPAMT101306UV02IdentifiedPersonTelecom telecom : parameterList.getIdentifiedPersonTelecom()) {
            initTelecom(res, telecom.getValue());
        }

        for (PRPAMT101306UV02IdentifiedPersonAddress address : parameterList.getIdentifiedPersonAddress()) {
            initAddr(res, address.getValue());
        }
        List<PRPAMT101306UV02PersonBirthPlaceAddress> birthPlaceAddressList = parameterList.getPersonBirthPlaceAddress();
        if (!birthPlaceAddressList.isEmpty() &&
                !birthPlaceAddressList.get(0).getValue().isEmpty()) {
            res.getBirthInfo().setBirthPlace(AddrInfo.newInstance(birthPlaceAddressList.get(0).getValue().get(0), null));
        }

        return res;
    }

    public PersonalInfo update(PersonalInfo personalInfo, PRPAIN101314UV02 prm) {

        PRPAMT101302UV02IdentifiedPersonIdentifiedPerson identifiedPerson = prm.getControlActProcess().getSubject().getRegistrationRequest().getSubject1().getIdentifiedPerson().getIdentifiedPerson();
        List<PRPAMT101302UV02PersonName> names = identifiedPerson.getName();

        if (!names.isEmpty()) {
            initNames(personalInfo, names.get(0));
        }
        CE genderCode = identifiedPerson.getAdministrativeGenderCode();
        personalInfo.setGender(genderCode == null ? null : new ValueInfo(null, genderCode.getCode(), genderCode.getCodeSystem()));
        TS birthTime = identifiedPerson.getBirthTime();
        personalInfo.getBirthInfo().setBirthDate(birthTime == null ? null : birthTime.getValue());

        initTelecom(personalInfo, identifiedPerson.getTelecom());

        Map<String, DocsInfo> docs = new HashMap<>();
        for (PRPAMT101302UV02PersonAsOtherIDs cur :
                identifiedPerson.getAsOtherIDs()) {
            initDocs(personalInfo, cur.getId(), docs);
        }
        addDocs(personalInfo, docs);

        initAddr(personalInfo, identifiedPerson.getAddr());

        if (identifiedPerson.getBirthPlace() instanceof JAXBElement &&
                identifiedPerson.getBirthPlace().getValue() instanceof PRPAMT101302UV02PersonBirthPlace) {
            personalInfo.getBirthInfo().setBirthPlace(AddrInfo.newInstance(identifiedPerson.getBirthPlace().getValue().getAddr(), null));
        }

        return personalInfo;

    }

    @Override
    public PRPAIN101312UV02 add(PRPAIN101311UV02 parameters) {
        logger.info("Adding a new person. Parsing input parameters...");
        final PersonalInfo personalInfo = newInstance(parameters);
        logger.info("Adding a new person. Save to storage...");
        String senderOid = parameters.getSender().getDevice().getId().get(0).getRoot();
        final Identifier identifiedPerson = add(personalInfo, senderOid);
        logger.info("Adding a new person. Prepare and sending the response...");
        return getPRPAIN101312UV02(identifiedPerson.getId());

    }

    @Override
    public Identifier add(PersonalInfo personalInfo, String senderOid) {
        logger.info("Adding a new person. Save to storage...");
        return toPublicKey(save(personalInfo), senderOid);
    }


    private Identifier toPublicKey(List<Byte> privateKey, String senderId) {
        byte key[] = pdmXmlConfigService.getSystemDbKey(senderId);
        return Crypting.toPublicKey(privateKey, key);
    }

    private byte[] toPrivateKey(String publicKey, String senderId) {
        try {
            byte key[] = pdmXmlConfigService.getSystemDbKey(senderId);
            if (key != null) {
                byte[] text = DatatypeConverter.parseBase64Binary(publicKey);
                return Crypting.decrypt(key, text);
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
        final PersonalInfo person = newInstance(parameters);
        logger.info("Find by demographics info. Find in storage...");
        String senderId = parameters.getSender().getDevice().getId().get(0).getRoot();
        final List<PersonalInfo> personalDataList = findPerson(person, senderId);
        logger.info("Find by demographics info. Prepare and sending the response...");
        return getPRPAIN101306UV02(personalDataList);
    }

    @Override
    public PRPAIN101308UV02 getDemographics(PRPAIN101307UV02 parameters) {
        logger.info("Get demographics info by id. Parsing input parameters...");
        //TODO add verification

        final List<PRPAMT101307UV02IdentifiedPersonIdentifier> identifiedPersons =
                parameters.getControlActProcess()
                        .getQueryByParameter()
                        .getValue()
                        .getParameterList()
                        .getIdentifiedPersonIdentifier();

        logger.info("Get demographics info by id. Count of inputsIDs : ", identifiedPersons == null ? "not set" : ("" + identifiedPersons.size()));

        List<PersonalInfo> personalDataList = new Vector<PersonalInfo>(identifiedPersons.size());
        for (PRPAMT101307UV02IdentifiedPersonIdentifier curPerson : identifiedPersons) {
            final String senderId = parameters.getSender().getDevice().getId().get(0).getRoot();
            final String publicKey = curPerson.getValue().get(0).getRoot();

            logger.info("Get demographics info by id. Find demographics info for id = " + publicKey);
            try {
                personalDataList.add(findById(publicKey, senderId));
            } catch (BadPaddingException
                    | NoSuchAlgorithmException
                    | NoSuchPaddingException
                    | IllegalBlockSizeException
                    | InvalidKeyException | InvalidKeySpecException e) {
                e.printStackTrace();
                throw new RuntimeException(INTERNAL_ERROR);
            }
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
                    final PersonalInfo personalInfo;
                    try {
                        personalInfo = findById(publicKey, senderId);
                    } catch (BadPaddingException
                            | NoSuchAlgorithmException
                            | NoSuchPaddingException
                            | IllegalBlockSizeException
                            | InvalidKeyException
                            | InvalidKeySpecException e) {
                        e.printStackTrace();
                        throw new RuntimeException(INTERNAL_ERROR);
                    }
                    final PersonalInfo personalDataNew = update(personalInfo, parameters);
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
        final PersonalInfo person = newInstance(parameters);
        logger.info("Find Like. Find like in storage...");
        String senderId = parameters.getSender().getDevice().getId().get(0).getRoot();
        final List<PersonalInfo> personalDataList = findPersonLike(person, senderId);
        logger.info("Find Like. Prepare and sending the response...");
        return getPRPAIN101306UV02(personalDataList);
    }

    @Override
    public String login(String oid, String password) {
        String res = null;
        if (pdmXmlConfigService.login(oid, password) != null) {
            res = authService.addToken(oid);
        }
        return res;
    }

    @Override
    public boolean logout(String token) {
        return authService.logout(token) && pdmXmlConfigService.logout(token);
    }

    @Override
    public List<PersonalInfo> getPersons(String senderOid) {
        return pdmDaoServiceLocator.getPdmDaoService().getPersons(senderOid);
    }


    private List<PersonalInfo> findPersonLike(PersonalInfo person, String senderId) {
        return pdmDaoServiceLocator.getPdmDaoService().findPersonLike(person, senderId);
    }

    private void savePerson(PersonalInfo personalInfoNew) {
        try {
            pdmDaoServiceLocator.getPdmDaoService().save(personalInfoNew);
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }


    private List<PersonalInfo> findPerson(PersonalInfo person, String senderId) {
        return pdmDaoServiceLocator.getPdmDaoService().find(person, senderId);
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

    private PRPAIN101306UV02 getPRPAIN101306UV02(List<PersonalInfo> personalInfoList) {
        logger.info("Creating the response PRPAIN101306UV02. The count of persons: {}", personalInfoList == null ? "not set" : personalInfoList.size());
        PRPAIN101306UV02 res = factoryHL7.createPRPAIN101306UV02();
        PRPAIN101306UV02MFMIMT700711UV01ControlActProcess controlActProcess = factoryHL7.createPRPAIN101306UV02MFMIMT700711UV01ControlActProcess();
        res.setControlActProcess(controlActProcess);
        for (PersonalInfo personalInfo : personalInfoList) {
            logger.info("Creating the response PRPAIN101306UV02. Current person id: {}", personalInfo.getPublicKey());
            PRPAIN101306UV02MFMIMT700711UV01Subject1 subject = factoryHL7.createPRPAIN101306UV02MFMIMT700711UV01Subject1();
            controlActProcess.getSubject().add(subject);
            PRPAIN101306UV02MFMIMT700711UV01RegistrationEvent event = factoryHL7.createPRPAIN101306UV02MFMIMT700711UV01RegistrationEvent();
            subject.setRegistrationEvent(event);
            final PRPAIN101306UV02MFMIMT700711UV01Subject2 subject2 = factoryHL7.createPRPAIN101306UV02MFMIMT700711UV01Subject2();
            event.setSubject1(subject2);
            final PRPAMT101310UV02IdentifiedPerson person = factoryHL7.createPRPAMT101310UV02IdentifiedPerson();
            subject2.setIdentifiedPerson(person);
            II ii = createPdmII(personalInfo.getPublicKey());
            person.getId().add(ii);
            person.setStatusCode(factoryHL7.createCS());
            person.getStatusCode().setCode("active");
            person.setIdentifiedPerson(factoryHL7.createPRPAMT101310UV02Person());
            person.getIdentifiedPerson().getName().add(getHL7Name(personalInfo));
            person.getIdentifiedPerson().setAdministrativeGenderCode(getHL7Gender(personalInfo));
            person.getIdentifiedPerson().setBirthTime(getHL7BirthDate(personalInfo));

            for (DocsInfo doc : personalInfo.getDocs()) {
                for (ValueInfo attr : doc.getAttrs()) {
                    PRPAMT101310UV02OtherIDs otherId = factoryHL7.createPRPAMT101310UV02OtherIDs();
                    otherId.getId().add(createII(attr));
                    person.getIdentifiedPerson().getAsOtherIDs().add(otherId);
                }
            }

            for (ValueInfo telecom : personalInfo.getTelecoms()) {
                person.getIdentifiedPerson().getTelecom().add(getHL7Telecom(telecom));
            }

            for (AddrInfo addrInfo : personalInfo.getAddressList()) {
                person.getIdentifiedPerson().getAddr().add(getHL7Addr(addrInfo));
            }

            if (personalInfo.getBirthInfo().getBirthPlace() != null) {
                PRPAMT101310UV02BirthPlace birthPlace = factoryHL7.createPRPAMT101310UV02BirthPlace();
                birthPlace.setAddr(getHL7Addr(personalInfo.getBirthInfo().getBirthPlace()));
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
    private PRPAIN101308UV02 getPRPAIN101308UV02(List<PersonalInfo> personalDataList, String senderId) {
        logger.info("Creating the response PRPAIN101308UV02. The count of persons: {}", personalDataList == null ? "not set" : personalDataList.size());
        PRPAIN101308UV02 res = factoryHL7.createPRPAIN101308UV02();
        final PRPAIN101308UV02MFMIMT700711UV01ControlActProcess controlActProcess = factoryHL7.createPRPAIN101308UV02MFMIMT700711UV01ControlActProcess();
        res.setControlActProcess(controlActProcess);
        for (PersonalInfo personalInfo : personalDataList) {
            logger.info("Creating the response PRPAIN101308UV02. Current person id: {}", personalInfo.getPublicKey());
            final PRPAIN101308UV02MFMIMT700711UV01Subject1 subject1 = factoryHL7.createPRPAIN101308UV02MFMIMT700711UV01Subject1();
            controlActProcess.getSubject().add(subject1);
            final PRPAIN101308UV02MFMIMT700711UV01RegistrationEvent registrationEvent = factoryHL7.createPRPAIN101308UV02MFMIMT700711UV01RegistrationEvent();
            subject1.setRegistrationEvent(registrationEvent);
            final PRPAIN101308UV02MFMIMT700711UV01Subject2 subject2 = factoryHL7.createPRPAIN101308UV02MFMIMT700711UV01Subject2();
            registrationEvent.setSubject1(subject2);
            final PRPAMT101303UV02IdentifiedPerson person = factoryHL7.createPRPAMT101303UV02IdentifiedPerson();
            subject2.setIdentifiedPerson(person);
            II ii = createPdmII(personalInfo.getPublicKey());
            person.getId().add(ii);
            person.setStatusCode(factoryHL7.createCS());
            person.getStatusCode().setCode("active");
            person.setIdentifiedPerson(factoryHL7.createPRPAMT101303UV02Person());
            person.getIdentifiedPerson().getName().add(getHL7Name(personalInfo));
            person.getIdentifiedPerson().setAdministrativeGenderCode(getHL7Gender(personalInfo));
            person.getIdentifiedPerson().setBirthTime(getHL7BirthDate(personalInfo));

            for (DocsInfo doc : personalInfo.getDocs()) {
                for (ValueInfo attr : doc.getAttrs()) {
                    PRPAMT101303UV02OtherIDs otherId = factoryHL7.createPRPAMT101303UV02OtherIDs();
                    otherId.getId().add(createII(attr));
                    person.getIdentifiedPerson().getAsOtherIDs().add(otherId);
                }
            }

            for (ValueInfo telecom : personalInfo.getTelecoms()) {
                person.getIdentifiedPerson().getTelecom().add(getHL7Telecom(telecom));
            }

            for (AddrInfo addr : personalInfo.getAddressList()) {
                person.getIdentifiedPerson().getAddr().add(getHL7Addr(addr));
            }

            if (personalInfo.getBirthInfo().getBirthPlace() != null) {
                PRPAMT101303UV02BirthPlace birthPlace = factoryHL7.createPRPAMT101303UV02BirthPlace();
                birthPlace.setAddr(getHL7Addr(personalInfo.getBirthInfo().getBirthPlace()));
                person.getIdentifiedPerson().setBirthPlace(factoryHL7.createPRPAMT101303UV02PersonBirthPlace(birthPlace));
            }
        }
        logger.info("The message PRPAIN101308UV02 is completed");
        return res;
    }

    private AD getHL7Addr(AddrInfo addr) {
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
        postalCode.setContent(addr.getPostalCode());
        explicitStreetName.setContent(addr.getStreetName());
        additionalLocator.setContent(addr.getAdditionalLocator());
        county.setContent(addr.getCounty());
        explicitPrecinct.setContent(addr.getPrecinct());
        houseNumber.setContent(addr.getHouseNumber());
        buildingNumberSuffix.setContent(addr.getBuildingNumberSuffix());
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

    private TEL getHL7Telecom(ValueInfo telecom) {
        TEL res = factoryHL7.createTEL();
        res.setValue(telecom.getValue());
        if (telecom.getUse() != null) {
            res.getUse().add(TelecommunicationAddressUse.fromValue(telecom.getUse()));
        }
        return res;
    }

    private II createII(ValueInfo attr) {
        return createII(attr.getValue(), attr.getOid());
    }


    private List<Byte> save(PersonalInfo personalInfo) {
        boolean isAdded = false;
        for (DocsInfo docInfo : personalInfo.getDocs()) {
            isAdded |= pdmDaoServiceLocator.getPdmDaoService().find(docInfo);
        }
        if (!isAdded) {
            try {
                return pdmDaoServiceLocator.getPdmDaoService().save(personalInfo);
            } catch (BadPaddingException
                    | NoSuchAlgorithmException
                    | IllegalBlockSizeException
                    | NoSuchPaddingException
                    | InvalidKeyException
                    | InvalidKeySpecException e) {
                logger.error("security exception", e);
            }
        }
        throw new RuntimeException("Cannot register a new person!");
    }

    @Override
    public PersonalInfo getPerson(String publicKey, String senderId) {
        try {
            return findById(publicKey, senderId);
        } catch (BadPaddingException
                | NoSuchAlgorithmException
                | IllegalBlockSizeException
                | NoSuchPaddingException
                | InvalidKeyException
                | InvalidKeySpecException e) {
            logger.error("security exception", e);
        }
        return null;
    }

    @Override
    public PersonalInfo update(PersonalInfo personalInfo, String senderOid) {
        try {
            PersonalInfo personalInfoOld = findById(personalInfo.getPublicKey(), senderOid);
            byte[] privateKey = toPrivateKey(personalInfo.getPublicKey(), senderOid);

            // update Name, MiddleName, Family
            if (personalInfoOld.isNeedUpdateNames(personalInfo)) {
                pdmDaoServiceLocator.getPdmDaoService().updateNames(privateKey, personalInfo);
            }
            // update gender
            if (personalInfoOld.getGender() != null && personalInfoOld.getGender().isNeedUpdate(personalInfo.getGender())) {
                pdmDaoServiceLocator.getPdmDaoService().updateGender(privateKey, personalInfo);
            }

            // update birth info
            if (personalInfoOld.getBirthInfo() != null && personalInfoOld.getBirthInfo().isNeedUpdate(personalInfo.getBirthInfo())) {
                pdmDaoServiceLocator.getPdmDaoService().updateBirth(privateKey, personalInfo);
            }

            // update telecom
            Map<String, ValueInfo> telecomByPublicKey = initObjByPublicKey(personalInfoOld.getTelecoms());
            for (ValueInfo telecom : personalInfo.getTelecoms()) {
                if(telecom.getPublicKey() == null) {
                    pdmDaoServiceLocator.getPdmDaoService().addTelecom(privateKey, telecom);
                } else {
                    ValueInfo telecomOld = telecomByPublicKey.get(telecom.getPublicKey());
                    if (telecomOld != null && telecomOld.isNeedUpdate(telecom)) {
                        byte[] privateKeyTelecom = toPrivateKey(telecomOld.getPublicKey(), senderOid);
                        pdmDaoServiceLocator.getPdmDaoService().updateTelecom(privateKeyTelecom, telecom);
                    }
                }
            }

            //update Address
            Map<String, AddrInfo> addrByPublicKey = initObjByPublicKey(personalInfoOld.getAddressList());
            for (AddrInfo addrInfo : personalInfo.getAddressList()) {
                if(addrInfo.getPublicKey() == null) {
                    pdmDaoServiceLocator.getPdmDaoService().addAddr(privateKey, addrInfo);
                } else {
                    AddrInfo addrOld = addrByPublicKey.get(addrInfo.getPublicKey());
                    if (addrOld != null && addrOld.isNeedUpdate(addrInfo)) {
                        byte[] privateKeyTelecom = toPrivateKey(addrOld.getPublicKey(), senderOid);
                        pdmDaoServiceLocator.getPdmDaoService().updateAddr(privateKeyTelecom, addrInfo);
                    }
                }
            }


            return personalInfo;
        } catch (BadPaddingException
                | NoSuchAlgorithmException
                | IllegalBlockSizeException
                | NoSuchPaddingException
                | InvalidKeyException
                | InvalidKeySpecException e) {
            logger.error("security exception", e);
        }
        //TODO send error info!
        return null;
    }



    private <T extends PublicKeyInfo> Map<String, T> initObjByPublicKey(List<T> publicKeyInfos) {
        Map<String, T> res = new HashMap<>();
        for (T t : publicKeyInfos) {
            res.put(t.getPublicKey(), t);
        }
        return res;
    }


    private PersonalInfo findById(String publicKey, String senderOid) throws BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, InvalidKeyException, InvalidKeySpecException {
        byte[] privateKey = toPrivateKey(publicKey, senderOid);
        return pdmDaoServiceLocator.getPdmDaoService().findById(privateKey, senderOid);
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

    private PN getHL7Name(PersonalInfo personalInfo) {
        PN name = factoryHL7.createPN();

        EnExplicitGiven given = factoryHL7.createEnExplicitGiven();
        given.setContent(personalInfo.getGiven());
        name.getContent().add(factoryHL7.createENExplicitGiven(given));

        EnExplicitGiven middleName = factoryHL7.createEnExplicitGiven();
        middleName.setContent(personalInfo.getMiddleName());
        name.getContent().add(factoryHL7.createENExplicitGiven(middleName));

        EnExplicitFamily family = factoryHL7.createEnExplicitFamily();
        family.setContent(personalInfo.getFamily());
        name.getContent().add(factoryHL7.createENExplicitFamily(family));

        return name;
    }

    private CE getHL7Gender(PersonalInfo personalInfo) {
        ValueInfo gender = personalInfo.getGender();
        if (gender == null) {
            return null;
        }
        CE res = factoryHL7.createCE();
        res.setCode(gender.getValue());
        res.setCodeSystem(gender.getDescription());
        return res;
    }

    private TS getHL7BirthDate(PersonalInfo personalInfo) {
        String birthDate = personalInfo.getBirthInfo().getBirthDate();
        if (birthDate == null) {
            return null;
        }
        TS res = factoryHL7.createTS();
        res.setValue(birthDate);
        return res;
    }


}
