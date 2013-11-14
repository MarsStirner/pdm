package ru.korus.tmis.pdm;

import ru.korus.tmis.pdm.alee.AleePdmOperations;
import ru.korus.tmis.pdm.mongo.MongoPdmOperations;
import ru.korus.tmis.pdm.ws.*;

import javax.jws.*;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * Author: Sergey A. Zagrebelny <br>
 * Date: 02.07.2013, 12:07:21 <br>
 * Company: Korus Consulting IT<br>
 * Description: <br>
 */

@WebService(endpointInterface = "ru.korus.tmis.pdm.ws.PDManager", targetNamespace = "http://www.korusconsulting.ru/PDManager/",
        serviceName = "tmis-pdm", portName = "portPdm", name = "PDManager")
public class PDManagerImpl implements PDManager {

    private static StorageOperations storageOperations = null;

    static {
        if (PdmSysProperties.getPdmStorageType().equals(PdmSysProperties.Value.STORAGE_TYPE_ALEE)) {
            storageOperations = new AleePdmOperations();
        } else {
            storageOperations = new MongoPdmOperations();
        }
    }

    private ObjectFactory factory = new ObjectFactory();

    /**
     * @see ru.korus.tmis.pdm.ws.PDManager#add(ru.korus.tmis.pdm.ws.PRPAIN101311UV02)
     */
    @Override
    @WebMethod(action = "http://www.korusconsulting.ru/PDManager/new")
    @WebResult(name = "PRPA_IN101312UV02", targetNamespace = "urn:hl7-org:v3", partName = "parameters")
    public PRPAIN101312UV02 add(PRPAIN101311UV02 parameters) {

        final PersonalData personalData = PersonalData.newInstance(parameters);
        final String id = save(personalData);
        return getPRPAIN101312UV02(id);
    }

    /**
     * @see ru.korus.tmis.pdm.ws.PDManager#findCandidates(ru.korus.tmis.pdm.ws.PRPAIN101305UV02)
     */
    @Override
    @WebMethod(action = "http://www.korusconsulting.ru/PDManager/findCandidates")
    @WebResult(name = "PRPA_IN101306UV02", targetNamespace = "urn:hl7-org:v3", partName = "result")
    public PRPAIN101306UV02 findCandidates(PRPAIN101305UV02 parameters) {
        final PersonalData person = PersonalData.newInstance(parameters);
        final List<PersonalData> personalDataList = findPerson(person);
        return getPRPAIN101306UV02(personalDataList);
    }

    /**
     * @see ru.korus.tmis.pdm.ws.PDManager#getDemographics(ru.korus.tmis.pdm.ws.PRPAIN101307UV02)
     */
    @Override
    @WebMethod(action = "http://www.korusconsulting.ru/PDManager/getDemographics")
    @WebResult(name = "PRPA_IN101308UV02", targetNamespace = "urn:hl7-org:v3", partName = "result")
    public PRPAIN101308UV02 getDemographics(PRPAIN101307UV02 parameters) {
        //TODO add verification
        final List<PRPAMT101307UV02IdentifiedPersonIdentifier> identifiedPersons = parameters.getControlActProcess().getQueryByParameter().getValue().
                getParameterList().getIdentifiedPersonIdentifier();

        List<PersonalData> personalDataList = new Vector<PersonalData>(identifiedPersons.size());
        for (PRPAMT101307UV02IdentifiedPersonIdentifier curPerson : identifiedPersons) {
            final String id = curPerson.getValue().get(0).getRoot();
            personalDataList.add(findById(id));
        }
        return getPRPAIN101308UV02(personalDataList);
    }

    /**
     * @see ru.korus.tmis.pdm.ws.PDManager#update(ru.korus.tmis.pdm.ws.PRPAIN101314UV02)
     */
    @Override
    @WebMethod(action = "http://www.korusconsulting.ru/PDManager/new")
    @WebResult(name = "PRPA_IN101315UV02", targetNamespace = "urn:hl7-org:v3", partName = "result")
    public PRPAIN101315UV02 update(@WebParam(name = "PRPA_IN101314UV02", targetNamespace = "urn:hl7-org:v3", partName = "parameters") PRPAIN101314UV02 parameters) {
        for (PRPAMT101302UV02PersonAsOtherIDs cur :
                parameters.getControlActProcess().getSubject().getRegistrationRequest().getSubject1().getIdentifiedPerson().getIdentifiedPerson().getAsOtherIDs()) {
            for (II ii : cur.getId()) {
                if (PersonalData.OID_PDM.equals(ii.getRoot())) {
                    final PersonalData personalData = findById(ii.getExtension());
                    final PersonalData personalDataNew = personalData.update(parameters);
                    savePerson(personalDataNew);
                    return getPRPAIN101315UV02(ii.getExtension());
                }
            }
        }
        throw new RuntimeException("The PDM ID is not set");
    }

    private void savePerson(PersonalData personalDataNew) {
        storageOperations.save(personalDataNew);
    }


    private List<PersonalData> findPerson(PersonalData person) {
        return storageOperations.find(person);
    }


    private PRPAIN101315UV02 getPRPAIN101315UV02(String id) {
        PRPAIN101315UV02 res = factory.createPRPAIN101315UV02();

        final PRPAMT101303UV02IdentifiedPerson identifiedPerson = factory.createPRPAMT101303UV02IdentifiedPerson();
        final PRPAIN101315UV02MFMIMT700701UV01Subject2 subject2 = factory.createPRPAIN101315UV02MFMIMT700701UV01Subject2();
        final PRPAMT101303UV02Person person = factory.createPRPAMT101303UV02Person();

        final PRPAIN101315UV02MFMIMT700701UV01ControlActProcess controlActProcess = factory.createPRPAIN101315UV02MFMIMT700701UV01ControlActProcess();
        res.setControlActProcess(controlActProcess);
        final PRPAIN101315UV02MFMIMT700701UV01Subject1 subject1 = factory.createPRPAIN101315UV02MFMIMT700701UV01Subject1();
        controlActProcess.getSubject().add(subject1);
        final PRPAIN101315UV02MFMIMT700701UV01RegistrationEvent registrationEvent = factory.createPRPAIN101315UV02MFMIMT700701UV01RegistrationEvent();
        subject1.setRegistrationEvent(registrationEvent);
        registrationEvent.setSubject1(subject2);
        subject2.setIdentifiedPerson(identifiedPerson);
        identifiedPerson.setIdentifiedPerson(person);
        II ii = createPdmII(id);
        person.getId().add(ii);
        return res;
    }

    private PRPAIN101312UV02 getPRPAIN101312UV02(String id) {
        PRPAIN101312UV02 res = factory.createPRPAIN101312UV02();

        final PRPAIN101312UV02MFMIMT700701UV01ControlActProcess controlActProcess = factory.createPRPAIN101312UV02MFMIMT700701UV01ControlActProcess();
        final PRPAIN101312UV02MFMIMT700701UV01Subject1 subject1 = factory.createPRPAIN101312UV02MFMIMT700701UV01Subject1();
        final PRPAIN101312UV02MFMIMT700701UV01RegistrationEvent registrationEvent = factory.createPRPAIN101312UV02MFMIMT700701UV01RegistrationEvent();
        final PRPAMT101304UV02IdentifiedPerson identifiedPerson = factory.createPRPAMT101304UV02IdentifiedPerson();
        final PRPAIN101312UV02MFMIMT700701UV01Subject2 subject2 = factory.createPRPAIN101312UV02MFMIMT700701UV01Subject2();
        final PRPAMT101304UV02Person person = factory.createPRPAMT101304UV02Person();

        res.setControlActProcess(controlActProcess);
        controlActProcess.getSubject().add(subject1);
        subject1.setRegistrationEvent(registrationEvent);
        registrationEvent.setSubject1(subject2);
        subject2.setIdentifiedPerson(identifiedPerson);
        identifiedPerson.setIdentifiedPerson(person);
        II ii = createPdmII(id);
        person.getId().add(ii);
        return res;
    }

    private PRPAIN101306UV02 getPRPAIN101306UV02(List<PersonalData> personalDataList) {
        PRPAIN101306UV02 res = factory.createPRPAIN101306UV02();
        PRPAIN101306UV02MFMIMT700711UV01ControlActProcess controlActProcess = factory.createPRPAIN101306UV02MFMIMT700711UV01ControlActProcess();
        res.setControlActProcess(controlActProcess);
        for (PersonalData personalData : personalDataList) {
            PRPAIN101306UV02MFMIMT700711UV01Subject1 subject = factory.createPRPAIN101306UV02MFMIMT700711UV01Subject1();
            controlActProcess.getSubject().add(subject);
            PRPAIN101306UV02MFMIMT700711UV01RegistrationEvent event = factory.createPRPAIN101306UV02MFMIMT700711UV01RegistrationEvent();
            subject.setRegistrationEvent(event);
            final PRPAIN101306UV02MFMIMT700711UV01Subject2 subject2 = factory.createPRPAIN101306UV02MFMIMT700711UV01Subject2();
            event.setSubject1(subject2);
            final PRPAMT101310UV02IdentifiedPerson person = factory.createPRPAMT101310UV02IdentifiedPerson();
            subject2.setIdentifiedPerson(person);
            II ii = createPdmII(personalData.getId());
            person.getId().add(ii);
            person.setStatusCode(factory.createCS());
            person.getStatusCode().setCode("active");
            person.setIdentifiedPerson(factory.createPRPAMT101310UV02Person());
            person.getIdentifiedPerson().getName().add(getHL7Name(personalData));
            person.getIdentifiedPerson().setAdministrativeGenderCode(getHL7Gender(personalData));
            person.getIdentifiedPerson().setBirthTime(getHL7BirthDate(personalData));

            for (Map.Entry<String, String> doc : personalData.getDocs().entrySet()) {
                PRPAMT101310UV02OtherIDs otherId = factory.createPRPAMT101310UV02OtherIDs();
                otherId.getId().add(createII(doc));
                person.getIdentifiedPerson().getAsOtherIDs().add(otherId);
            }

            for (PersonalData.Telecom telecom : personalData.getTelecoms()) {
                person.getIdentifiedPerson().getTelecom().add(getHL7Telecom(telecom));
            }

            for (PersonalData.Addr addr : personalData.getAddress()) {
                person.getIdentifiedPerson().getAddr().add(getHL7Addr(addr));
            }

            if (personalData.getBirthPlace() != null) {
                PRPAMT101310UV02BirthPlace birthPlace = factory.createPRPAMT101310UV02BirthPlace();
                birthPlace.setAddr(getHL7Addr(personalData.getBirthPlace()));
                person.getIdentifiedPerson().setBirthPlace(factory.createPRPAMT101310UV02PersonBirthPlace(birthPlace));
            }

        }
        return res;
    }

    /**
     * Генерация выходного сообщения HL7 для метода getDemographics
     *
     * @param personalDataList - входные персональные данные
     * @return - сообшение HL7 PRPA_IN101308UV02, содержащее входные персональные данные
     */
    private PRPAIN101308UV02 getPRPAIN101308UV02(List<PersonalData> personalDataList) {

        PRPAIN101308UV02 res = factory.createPRPAIN101308UV02();
        final PRPAIN101308UV02MFMIMT700711UV01ControlActProcess controlActProcess = factory.createPRPAIN101308UV02MFMIMT700711UV01ControlActProcess();
        res.setControlActProcess(controlActProcess);
        for (PersonalData personalData : personalDataList) {
            final PRPAIN101308UV02MFMIMT700711UV01Subject1 subject1 = factory.createPRPAIN101308UV02MFMIMT700711UV01Subject1();
            controlActProcess.getSubject().add(subject1);
            final PRPAIN101308UV02MFMIMT700711UV01RegistrationEvent registrationEvent = factory.createPRPAIN101308UV02MFMIMT700711UV01RegistrationEvent();
            subject1.setRegistrationEvent(registrationEvent);
            final PRPAIN101308UV02MFMIMT700711UV01Subject2 subject2 = factory.createPRPAIN101308UV02MFMIMT700711UV01Subject2();
            registrationEvent.setSubject1(subject2);
            final PRPAMT101303UV02IdentifiedPerson person = factory.createPRPAMT101303UV02IdentifiedPerson();
            subject2.setIdentifiedPerson(person);
            II ii = createPdmII(personalData.getId());
            person.getId().add(ii);
            person.setStatusCode(factory.createCS());
            person.getStatusCode().setCode("active");
            person.setIdentifiedPerson(factory.createPRPAMT101303UV02Person());
            person.getIdentifiedPerson().getName().add(getHL7Name(personalData));
            person.getIdentifiedPerson().setAdministrativeGenderCode(getHL7Gender(personalData));
            person.getIdentifiedPerson().setBirthTime(getHL7BirthDate(personalData));

            for (Map.Entry<String, String> doc : personalData.getDocs().entrySet()) {
                PRPAMT101303UV02OtherIDs otherId = factory.createPRPAMT101303UV02OtherIDs();
                otherId.getId().add(createII(doc));
                person.getIdentifiedPerson().getAsOtherIDs().add(otherId);
            }

            for (PersonalData.Telecom telecom : personalData.getTelecoms()) {
                person.getIdentifiedPerson().getTelecom().add(getHL7Telecom(telecom));
            }

            for (PersonalData.Addr addr : personalData.getAddress()) {
                person.getIdentifiedPerson().getAddr().add(getHL7Addr(addr));
            }

            if (personalData.getBirthPlace() != null) {
                PRPAMT101303UV02BirthPlace birthPlace = factory.createPRPAMT101303UV02BirthPlace();
                birthPlace.setAddr(getHL7Addr(personalData.getBirthPlace()));
                person.getIdentifiedPerson().setBirthPlace(factory.createPRPAMT101303UV02PersonBirthPlace(birthPlace));
            }
        }

        return res;
    }

    private AD getHL7Addr(PersonalData.Addr addr) {
        AD res = factory.createAD();
        AdxpExplicitCountry country = factory.createAdxpExplicitCountry();
        AdxpExplicitStreetAddressLine addrLine = factory.createAdxpExplicitStreetAddressLine();
        AdxpExplicitDirection direction = factory.createAdxpExplicitDirection();
        AdxpExplicitPostBox postBox = factory.createAdxpExplicitPostBox();
        AdxpExplicitUnitType unitType = factory.createAdxpExplicitUnitType();
        AdxpExplicitDelimiter delimiter = factory.createAdxpExplicitDelimiter();
        AdxpExplicitDeliveryInstallationArea deliveryInstallationArea = factory.createAdxpExplicitDeliveryInstallationArea();
        AdxpExplicitDeliveryModeIdentifier celiveryModeIdentifier = factory.createAdxpExplicitDeliveryModeIdentifier();
        AdxpExplicitPostalCode postalCode = factory.createAdxpExplicitPostalCode();
        AdxpExplicitDeliveryAddressLine deliveryAddressLine = factory.createAdxpExplicitDeliveryAddressLine();
        AdxpExplicitStreetName explicitStreetName = factory.createAdxpExplicitStreetName();
        AdxpExplicitUnitID edxpExplicitUnitID = factory.createAdxpExplicitUnitID();
        AdxpExplicitAdditionalLocator additionalLocator = factory.createAdxpExplicitAdditionalLocator();
        AdxpExplicitDeliveryMode deliveryMode = factory.createAdxpExplicitDeliveryMode();
        AdxpExplicitStreetNameBase streetNameBase = factory.createAdxpExplicitStreetNameBase();
        AdxpExplicitDeliveryInstallationQualifier deliveryInstallationQualifier = factory.createAdxpExplicitDeliveryInstallationQualifier();
        AdxpExplicitCounty county = factory.createAdxpExplicitCounty();
        AdxpExplicitPrecinct explicitPrecinct = factory.createAdxpExplicitPrecinct();
        AdxpExplicitCareOf careOf = factory.createAdxpExplicitCareOf();
        AdxpExplicitHouseNumber houseNumber = factory.createAdxpExplicitHouseNumber();
        AdxpExplicitCensusTract censusTract = factory.createAdxpExplicitCensusTract();
        AdxpExplicitBuildingNumberSuffix buildingNumberSuffix = factory.createAdxpExplicitBuildingNumberSuffix();
        AdxpExplicitHouseNumberNumeric houseNumberNumeric = factory.createAdxpExplicitHouseNumberNumeric();
        AdxpExplicitStreetNameType1 streetNameType1 = factory.createAdxpExplicitStreetNameType1();
        AdxpExplicitDeliveryInstallationType deliveryInstallationType = factory.createAdxpExplicitDeliveryInstallationType();
        AdxpExplicitState state = factory.createAdxpExplicitState();
        AdxpExplicitCity city = factory.createAdxpExplicitCity();

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

        res.getContent().add(factory.createADExplicitCountry(country));
        res.getContent().add(factory.createADExplicitStreetAddressLine(addrLine));
        res.getContent().add(factory.createADExplicitDirection(direction));
        res.getContent().add(factory.createADExplicitPostBox(postBox));
        res.getContent().add(factory.createADExplicitUnitType(unitType));
        res.getContent().add(factory.createADExplicitDelimiter(delimiter));
        res.getContent().add(factory.createADExplicitDeliveryInstallationArea(deliveryInstallationArea));
        res.getContent().add(factory.createADExplicitDeliveryModeIdentifier(celiveryModeIdentifier));
        res.getContent().add(factory.createADExplicitPostalCode(postalCode));
        res.getContent().add(factory.createADExplicitDeliveryAddressLine(deliveryAddressLine));
        res.getContent().add(factory.createADExplicitStreetName(explicitStreetName));
        res.getContent().add(factory.createADExplicitUnitID(edxpExplicitUnitID));
        res.getContent().add(factory.createADExplicitAdditionalLocator(additionalLocator));
        res.getContent().add(factory.createADExplicitDeliveryMode(deliveryMode));
        res.getContent().add(factory.createADExplicitStreetNameBase(streetNameBase));
        res.getContent().add(factory.createADExplicitDeliveryInstallationQualifier(deliveryInstallationQualifier));
        res.getContent().add(factory.createADExplicitCounty(county));
        res.getContent().add(factory.createADExplicitPrecinct(explicitPrecinct));
        res.getContent().add(factory.createADExplicitCareOf(careOf));
        res.getContent().add(factory.createADExplicitHouseNumber(houseNumber));
        res.getContent().add(factory.createADExplicitCensusTract(censusTract));
        res.getContent().add(factory.createADExplicitBuildingNumberSuffix(buildingNumberSuffix));
        res.getContent().add(factory.createADExplicitHouseNumberNumeric(houseNumberNumeric));
        res.getContent().add(factory.createADExplicitStreetNameType(streetNameType1));
        res.getContent().add(factory.createADExplicitDeliveryInstallationType(deliveryInstallationType));
        res.getContent().add(factory.createADExplicitState(state));
        res.getContent().add(factory.createADExplicitCity(city));

        final String addrType = addr.getUse();
        if (addrType != null) {
            res.getUse().add(PostalAddressUse.fromValue(addrType));
        }

        return res;
    }

    private TEL getHL7Telecom(PersonalData.Telecom telecom) {
        TEL res = factory.createTEL();
        res.setValue(telecom.getValue());
        if (telecom.getUse() != null) {
            res.getUse().add(TelecommunicationAddressUse.fromValue(telecom.getUse()));
        }
        return res;
    }

    private II createII(Map.Entry<String, String> doc) {
        return createII(doc.getValue(), PersonalData.decodeOID(doc.getKey()));
    }


    private String save(PersonalData personalData) {
        for (Map.Entry<String, String> doc : personalData.getDocs().entrySet()) {
            find(doc);
        }
        storageOperations.save(personalData);
        return personalData.getId();
    }

    private void find(Map.Entry<String, String> doc) {
        storageOperations.find(doc);
    }

    private PersonalData findById(String id) {
        return storageOperations.findById(id);
    }

    private II createPdmII(String id) {
        return createII(id, PersonalData.OID_PDM);
    }

    private II createII(String extension, String root) {
        II ii = factory.createII();
        ii.setExtension(extension);
        ii.setRoot(root);
        return ii;
    }

    private PN getHL7Name(PersonalData personalData) {
        PN name = factory.createPN();

        EnExplicitGiven given = factory.createEnExplicitGiven();
        given.setContent(personalData.getGiven());
        name.getContent().add(factory.createENExplicitGiven(given));

        EnExplicitGiven middleName = factory.createEnExplicitGiven();
        middleName.setContent(personalData.getMiddleName());
        name.getContent().add(factory.createENExplicitGiven(middleName));

        EnExplicitFamily family = factory.createEnExplicitFamily();
        family.setContent(personalData.getFamily());
        name.getContent().add(factory.createENExplicitFamily(family));

        return name;
    }

    private CE getHL7Gender(PersonalData personalData) {
        PersonalData.Term gender = personalData.getGender();
        if (gender == null) {
            return null;
        }
        CE res = factory.createCE();
        res.setCode(gender.getCode());
        res.setCodeSystem(gender.getCodeSystem());
        return res;
    }

    private TS getHL7BirthDate(PersonalData personalData) {
        String birthDate = personalData.getBirthData();
        if (birthDate == null) {
            return null;
        }
        TS res = factory.createTS();
        res.setValue(birthDate);
        return res;
    }

}
