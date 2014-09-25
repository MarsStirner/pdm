package ru.korus.tmis.pdm.test;

import org.testng.annotations.Test;

import ru.korus.tmis.pdm.ws.PersonalData;
import ru.korus.tmis.pdm.test.ws.*;

import javax.xml.bind.JAXBElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.testng.Assert.*;

public class PDManagerTest {

    private static final String IVAN = "Иван";
    private static final String IVANOVICH = "Ivanovich";
    private static final String IVANOV = "Ivanov";
    private static final String TEST_STREET = "TestStreet";
    private static final String SENDER_ID ="4.0.0.0";
    private String newId = "5240172396004e5123a975ce";
    private Map<String, String> newDocId =  new HashMap<String, String>();

    /**
     * Проверка добавления новой персоны в ЗХПД
     */
    @Test
    public void addNewPersons() {
        final int maxPerson = Integer.valueOf(System.getProperty("pdm.MaxNew", "1"));
        for(int i = 0; i < maxPerson; ++i) {
           addNew();
           System.out.println("added person: " + i);
       }
    }

    private void addNew() {
        ObjectFactory factory = new ObjectFactory();
        PDManagerService serv = new PDManagerService();
        PDManager pdManager = serv.getPDManagerSOAP();

        PRPAIN101311UV02 prm = factory.createPRPAIN101311UV02();

        /* Идентификатор отправителя */
        final MCCIMT000100UV01Sender sender = factory.createMCCIMT000100UV01Sender();
        final MCCIMT000100UV01Device device = factory.createMCCIMT000100UV01Device();
        final II senderId = factory.createII();
        senderId.setRoot(SENDER_ID);
        device.getId().add(senderId);
        sender.setDevice(device);
        prm.setSender(sender);

        /* Заголовок HL7 */
        PRPAIN101311UV02MFMIMT700721UV01ControlActProcess controlActProcess = factory.createPRPAIN101311UV02MFMIMT700721UV01ControlActProcess();
        PRPAIN101311UV02MFMIMT700721UV01Subject1 subject1 = new PRPAIN101311UV02MFMIMT700721UV01Subject1();
        PRPAIN101311UV02MFMIMT700721UV01RegistrationRequest registrationRequest = new PRPAIN101311UV02MFMIMT700721UV01RegistrationRequest();
        PRPAMT101301UV02IdentifiedPerson identifiedPerson = new PRPAMT101301UV02IdentifiedPerson();
        PRPAIN101311UV02MFMIMT700721UV01Subject2 subject2 = new PRPAIN101311UV02MFMIMT700721UV01Subject2();
        PRPAMT101301UV02Person person = new PRPAMT101301UV02Person();

        prm.setControlActProcess(controlActProcess);
        controlActProcess.setSubject(subject1);
        subject1.setRegistrationRequest(registrationRequest);
        registrationRequest.setSubject1(subject2);
        subject2.setIdentifiedPerson(identifiedPerson);
        identifiedPerson.setIdentifiedPerson(person);

        /* ФИО персоны */
        PN name = factory.createPN();

        /* Имя (первое значение given) */
        EnGiven giv = factory.createEnGiven();
        giv.getContent().add(IVAN);
        name.getContent().add(factory.createENGiven(giv));

        /* Отчество (первое значение given) */
        EnGiven mn = factory.createEnGiven();
        mn.getContent().add(IVANOVICH);
        name.getContent().add(factory.createENGiven(mn));

        /* Фамилия */
        EnFamily family = factory.createEnFamily();
        family.getContent().add(IVANOV);
        name.getContent().add(factory.createENFamily(family));

        /* Паспорт */
        person.getName().add(name);
        newDocId.put(PersonalData.OID_DOC_PASSPORTNUMBER, UUID.randomUUID().toString());
        newDocId.put(PersonalData.OID_DOC_PASSPORT_DATE, "1800.100000.1987");
        for(Map.Entry<String, String> id : newDocId.entrySet()) {
            final PRPAMT101301UV02OtherIDs otherId = new PRPAMT101301UV02OtherIDs();
            otherId.getId().add(new II());
            otherId.getId().get(0).setRoot(id.getKey());
            otherId.getId().get(0).setExtension(id.getValue());
            person.getAsOtherIDs().add(otherId);
        }

        /* Домашний адрес */
        final AD addr = factory.createAD();
        person.getAddr().add(addr);
        AdxpStreetName street = factory.createAdxpStreetName();
        street.getContent().add(TEST_STREET);
        addr.getContent().add(factory.createADStreetName(street));
        addr.getUse().add(PostalAddressUse.HP);// признак - "домашний"

        /* Пол персоны */
        final CE ce = factory.createCE();
        ce.setCode("M");
        person.setAdministrativeGenderCode(ce);

        /* Ресгистрация новой персоны в ЗХПД */
        PRPAIN101312UV02 res = pdManager.add(prm);
        final II ii = res.getControlActProcess().getSubject().get(0).getRegistrationEvent().getSubject1().getIdentifiedPerson().
                getIdentifiedPerson().getId().get(0);
        String root = ii.getRoot();
        newId =  ii.getExtension();
        assertEquals(root, "3.0.0.0");
    }

    @Test
    public void findById() {
        ObjectFactory factory = new ObjectFactory();
        PDManagerService serv = new PDManagerService();
        PDManager pdManager = serv.getPDManagerSOAP();
        PRPAIN101307UV02 prm = factory.createPRPAIN101307UV02();
        final PRPAIN101307UV02QUQIMT021001UV01ControlActProcess controlActProcess = factory.createPRPAIN101307UV02QUQIMT021001UV01ControlActProcess();
        prm.setControlActProcess(controlActProcess);
        final PRPAMT101307UV02QueryByParameter query = factory.createPRPAMT101307UV02QueryByParameter();
        final JAXBElement<PRPAMT101307UV02QueryByParameter> queryPrm =
                factory.createPRPAIN101307UV02QUQIMT021001UV01ControlActProcessQueryByParameter(query);
        controlActProcess.setQueryByParameter(queryPrm);
        final PRPAMT101307UV02ParameterList prmList = factory.createPRPAMT101307UV02ParameterList();
        query.setParameterList(prmList);
        final PRPAMT101307UV02IdentifiedPersonIdentifier personIdentifier = factory.createPRPAMT101307UV02IdentifiedPersonIdentifier();
        prmList.getIdentifiedPersonIdentifier().add(personIdentifier);
        final II ii = factory.createII();
        personIdentifier.getValue().add(ii);
        ii.setRoot(newId);

        PRPAIN101308UV02 res = pdManager.getDemographics(prm);
        final PRPAMT101303UV02IdentifiedPerson identifiedPerson = res.getControlActProcess().getSubject().get(0).getRegistrationEvent().getSubject1().getIdentifiedPerson();
        final II personId = identifiedPerson.getId().get(0);
        assertEquals(personId.getRoot(), "3.0.0.0");
        assertEquals(personId.getExtension(), newId);
        final List<PN> name = identifiedPerson.getIdentifiedPerson().getName();
        assertEquals(name.size(), 1);
        EnGiven giv = (EnGiven)((JAXBElement)(name.get(0).getContent().get(0))).getValue();
        assertEquals(giv.getContent().size(), 1);
        assertEquals((String)giv.getContent().get(0), IVAN);
        EnGiven mn = (EnGiven)((JAXBElement)(name.get(0).getContent().get(1))).getValue();
        assertEquals(mn.getContent().size(), 1);
        assertEquals((String)mn.getContent().get(0), IVANOVICH);
        EnFamily family = (EnFamily)((JAXBElement)(name.get(0).getContent().get(2))).getValue();
        assertEquals(family.getContent().size(), 1);
        assertEquals((String)family.getContent().get(0), IVANOV);
        assertEquals(identifiedPerson.getIdentifiedPerson().getAdministrativeGenderCode().getCode(), "M");
        assertEquals(identifiedPerson.getIdentifiedPerson().getAddr().size(), 1);
        AD homeAddress = identifiedPerson.getIdentifiedPerson().getAddr().get(0);
        assertEquals(homeAddress.getUse().get(0), PostalAddressUse.HP);
        final int countOfAddrElements = 27;
        assertEquals(homeAddress.getContent().size(), countOfAddrElements);
        final int indexOfStreetAddr = 10;
        AdxpStreetName streetName = (AdxpStreetName)((JAXBElement)(homeAddress.getContent().get(indexOfStreetAddr))).getValue();
        assertEquals(streetName.getContent().get(0), TEST_STREET);
        List<PRPAMT101303UV02OtherIDs> asOtherId = identifiedPerson.getIdentifiedPerson().getAsOtherIDs();
        assertEquals(asOtherId.size(), newDocId.size());
        for(int index = 0; index < newDocId.size(); ++index) {
            final String root = asOtherId.get(index).getId().get(0).getRoot();
            assertEquals(asOtherId.get(index).getId().get(0).getExtension(), newDocId.get(root));
        }
    }

    //@Test
    public void findByPersonInfo() {
        ObjectFactory factory = new ObjectFactory();
        PDManagerService serv = new PDManagerService();
        PDManager pdManager = serv.getPDManagerSOAP();
        PRPAIN101305UV02 prm = factory.createPRPAIN101305UV02();
        final PRPAIN101305UV02QUQIMT021001UV01ControlActProcess controlActProcess = factory.createPRPAIN101305UV02QUQIMT021001UV01ControlActProcess();
        prm.setControlActProcess(controlActProcess);
        final PRPAMT101306UV02QueryByParameter query = factory.createPRPAMT101306UV02QueryByParameter();
        final JAXBElement<PRPAMT101306UV02QueryByParameter> queryPrm = factory.createPRPAIN101305UV02QUQIMT021001UV01ControlActProcessQueryByParameter(query);
        controlActProcess.setQueryByParameter(queryPrm);
        final PRPAMT101306UV02ParameterList prmList = factory.createPRPAMT101306UV02ParameterList();
        query.setParameterList(prmList);

        final PRPAMT101306UV02PersonName personName = factory.createPRPAMT101306UV02PersonName();
        prmList.getPersonName().add(personName);
        final PN pn = factory.createPN();
        personName.getValue().add(pn);
        EnGiven giv = factory.createEnGiven();
        giv.getContent().add("Ivan");
        pn.getContent().add(factory.createENGiven(giv));

        final PRPAMT101306UV02PersonAdministrativeGender gender = factory.createPRPAMT101306UV02PersonAdministrativeGender();
        final CV genderCode = factory.createCV();
        genderCode.setCode("M");
        gender.getValue().add(genderCode);
        prmList.getPersonAdministrativeGender().add(gender);

        //TODO добавить при создании персоны
        /*final PRPAMT101306UV02PersonBirthPlaceAddress birthPlaceAddress = factory.createPRPAMT101306UV02PersonBirthPlaceAddress();
        final AD addr = factory.createAD();
        AdxpCity city = factory.createAdxpCity();
        city.getContent().add("TestStreet");
        addr.getContent().add(factory.createADCity(city));
        birthPlaceAddress.getValue().add(addr);
        prmList.getPersonBirthPlaceAddress().add(birthPlaceAddress);*/

        /* final PRPAMT101306UV02PersonBirthTime birthTime = factory.createPRPAMT101306UV02PersonBirthTime();
        final IVLTS ivlts = factory.createIVLTS();
        ivlts.setValue("19930123");
        birthTime.getValue().add(ivlts);
        prmList.getPersonBirthTime().add(birthTime);*/

       /* final PRPAMT101306UV02IdentifiedPersonTelecom telecom = factory.createPRPAMT101306UV02IdentifiedPersonTelecom();
        TEL tel = factory.createTEL();
        tel.setValue("tel:+7 (495) 229-53-70");
        tel.getUse().add(TelecommunicationAddressUse.HP);
        telecom.getValue().add(tel);
        telecom.getValue().add(tel);
        prmList.getIdentifiedPersonTelecom().add(telecom);*/

      /*  final PRPAMT101306UV02IdentifiedPersonAddress personAddr = factory.createPRPAMT101306UV02IdentifiedPersonAddress();
        final AD ad = factory.createAD();
        AdxpCity personCity = factory.createAdxpCity();
        personCity.getContent().add("TestCity");
        ad.getContent().add(factory.createADCity(personCity));
        ad.getUse().add(PostalAddressUse.HP);
        personAddr.getValue().add(ad);
        prmList.getIdentifiedPersonAddress().add(personAddr);
*/
      /*  final PRPAMT101306UV02OtherIDsScopingOrganization otherId = factory.createPRPAMT101306UV02OtherIDsScopingOrganization();
        final II ii = factory.createII();
        final String rootDoc = "3.0.0.1";
        ii.setRoot(rootDoc);
        ii.setExtension(newDocId.get(rootDoc));
        otherId.getValue().add(ii);
        prmList.getOtherIDsScopingOrganization().add(otherId);*/

        PRPAIN101306UV02 res = pdManager.findCandidates(prm);
        final List<II> listId = res.getControlActProcess().getSubject().get(0).getRegistrationEvent().getSubject1().getIdentifiedPerson().getId();
        assertFalse(listId.isEmpty());
        final II personId = listId.get(0);
        assertEquals(personId.getRoot(), "3.0.0.0");
        assertTrue(personId.getExtension().length() >= "52405a4d960030f25fb91713".length());
    }


    @Test
    public void update() {
        ObjectFactory factory = new ObjectFactory();
        PDManagerService serv = new PDManagerService();
        PDManager pdManager = serv.getPDManagerSOAP();
        final PRPAIN101314UV02 prm = factory.createPRPAIN101314UV02();
        final PRPAIN101314UV02MFMIMT700721UV01ControlActProcess controlActProcess = factory.createPRPAIN101314UV02MFMIMT700721UV01ControlActProcess();
        prm.setControlActProcess(controlActProcess);
        final PRPAIN101314UV02MFMIMT700721UV01Subject1 subject1 = factory.createPRPAIN101314UV02MFMIMT700721UV01Subject1();
        controlActProcess.setSubject(subject1);
        final PRPAIN101314UV02MFMIMT700721UV01RegistrationRequest regRequest = factory.createPRPAIN101314UV02MFMIMT700721UV01RegistrationRequest();
        subject1.setRegistrationRequest(regRequest);
        final PRPAIN101314UV02MFMIMT700721UV01Subject2 subject2 = factory.createPRPAIN101314UV02MFMIMT700721UV01Subject2();
        regRequest.setSubject1(subject2);
        final PRPAMT101302UV02IdentifiedPerson identifiedPerson = factory.createPRPAMT101302UV02IdentifiedPerson();
        subject2.setIdentifiedPerson(identifiedPerson);
        final PRPAMT101302UV02IdentifiedPersonIdentifiedPerson person = factory.createPRPAMT101302UV02IdentifiedPersonIdentifiedPerson();
        identifiedPerson.setIdentifiedPerson(person);
        final PRPAMT101302UV02PersonAsOtherIDs otherId = factory.createPRPAMT101302UV02PersonAsOtherIDs();
        person.getAsOtherIDs().add(otherId);
        final PRPAMT101302UV02OtherIDsId id = factory.createPRPAMT101302UV02OtherIDsId();
        otherId.getId().add(id);
        id.setRoot(PersonalData.OID_PDM);
        id.setExtension(newId);

        final PRPAMT101302UV02PersonName pn = factory.createPRPAMT101302UV02PersonName();
        person.getName().add(pn);
        EnFamily family = factory.createEnFamily();
        family.getContent().add("Petrov");
        pn.getContent().add(factory.createENFamily(family));

        EnGiven given = factory.createEnGiven();
        given.getContent().add("Peter");
        pn.getContent().add(factory.createENGiven(given));

        EnGiven middleName = factory.createEnGiven();
        middleName.getContent().add("Peterovich");
        pn.getContent().add(factory.createENGiven(middleName));

       final PRPAMT101302UV02PersonTelecom telecom = factory.createPRPAMT101302UV02PersonTelecom();
        person.getTelecom().add(telecom);
        telecom.setValue("tel:+7 (495) 999-99-99");
        telecom.getUse().add(TelecommunicationAddressUse.HP);

        final PRPAMT101302UV02PersonAddr personAddr = factory.createPRPAMT101302UV02PersonAddr();
        person.getAddr().add(personAddr);
        AdxpStreetAddressLine strAdrLine = factory.createAdxpStreetAddressLine();
        strAdrLine.getContent().add("Update address line");
        personAddr.getContent().add(factory.createADStreetAddressLine(strAdrLine));
        personAddr.getUse().add(PostalAddressUse.HP);

        final PRPAMT101302UV02PersonAsOtherIDs passportOtherIDs = factory.createPRPAMT101302UV02PersonAsOtherIDs();
        person.getAsOtherIDs().add(passportOtherIDs);
        final PRPAMT101302UV02OtherIDsId passportId = factory.createPRPAMT101302UV02OtherIDsId();
        passportOtherIDs.getId().add(passportId);
        passportId.setRoot(PersonalData.OID_DOC_PASSPORT_CREATER);
        passportId.setExtension("1234578987654321");

        final PRPAMT101302UV02PersonAsOtherIDs snilsOtherIDs = factory.createPRPAMT101302UV02PersonAsOtherIDs();
        person.getAsOtherIDs().add(snilsOtherIDs);
        final PRPAMT101302UV02OtherIDsId snilsId = factory.createPRPAMT101302UV02OtherIDsId();
        passportOtherIDs.getId().add(snilsId);
        snilsId.setRoot(PersonalData.OID_DOC_PASSPORT_DATE);
        snilsId.setExtension("1313.1313.1980");

        final PRPAIN101315UV02 res = pdManager.update(prm);
        final List<II> listId = res.getControlActProcess().getSubject().get(0).getRegistrationEvent().getSubject1().getIdentifiedPerson().getIdentifiedPerson().getId();
        String root = listId.get(0).getRoot();
        assertEquals(root, "3.0.0.0");
    }


    //@Test
    public void findLike() {
        ObjectFactory factory = new ObjectFactory();
        PDManagerService serv = new PDManagerService();
        PDManager pdManager = serv.getPDManagerSOAP();
        PRPAIN101305UV02 prm = factory.createPRPAIN101305UV02();
        final PRPAIN101305UV02QUQIMT021001UV01ControlActProcess controlActProcess = factory.createPRPAIN101305UV02QUQIMT021001UV01ControlActProcess();
        prm.setControlActProcess(controlActProcess);
        final PRPAMT101306UV02QueryByParameter query = factory.createPRPAMT101306UV02QueryByParameter();
        final JAXBElement<PRPAMT101306UV02QueryByParameter> queryPrm = factory.createPRPAIN101305UV02QUQIMT021001UV01ControlActProcessQueryByParameter(query);
        controlActProcess.setQueryByParameter(queryPrm);
        final PRPAMT101306UV02ParameterList prmList = factory.createPRPAMT101306UV02ParameterList();
        query.setParameterList(prmList);

        final PRPAMT101306UV02PersonName personName = factory.createPRPAMT101306UV02PersonName();
        prmList.getPersonName().add(personName);
        final PN pn = factory.createPN();
        personName.getValue().add(pn);
        EnGiven giv = factory.createEnGiven();
        giv.getContent().add("Ivan");
        pn.getContent().add(factory.createENGiven(giv));

       /* final PRPAMT101306UV02PersonAdministrativeGender gender = factory.createPRPAMT101306UV02PersonAdministrativeGender();
        final CV genderCode = factory.createCV();
        genderCode.setCode("M");
        gender.getValue().add(genderCode);
        prmList.getPersonAdministrativeGender().add(gender);*/

        //TODO добавить при создании персоны
        /*final PRPAMT101306UV02PersonBirthPlaceAddress birthPlaceAddress = factory.createPRPAMT101306UV02PersonBirthPlaceAddress();
        final AD addr = factory.createAD();
        AdxpCity city = factory.createAdxpCity();
        city.getContent().add("TestStreet");
        addr.getContent().add(factory.createADCity(city));
        birthPlaceAddress.getValue().add(addr);
        prmList.getPersonBirthPlaceAddress().add(birthPlaceAddress);*/

        /* final PRPAMT101306UV02PersonBirthTime birthTime = factory.createPRPAMT101306UV02PersonBirthTime();
        final IVLTS ivlts = factory.createIVLTS();
        ivlts.setValue("19930123");
        birthTime.getValue().add(ivlts);
        prmList.getPersonBirthTime().add(birthTime);*/

       /* final PRPAMT101306UV02IdentifiedPersonTelecom telecom = factory.createPRPAMT101306UV02IdentifiedPersonTelecom();
        TEL tel = factory.createTEL();
        tel.setValue("tel:+7 (495) 229-53-70");
        tel.getUse().add(TelecommunicationAddressUse.HP);
        telecom.getValue().add(tel);
        telecom.getValue().add(tel);
        prmList.getIdentifiedPersonTelecom().add(telecom);*/

      /*  final PRPAMT101306UV02IdentifiedPersonAddress personAddr = factory.createPRPAMT101306UV02IdentifiedPersonAddress();
        final AD ad = factory.createAD();
        AdxpCity personCity = factory.createAdxpCity();
        personCity.getContent().add("TestCity");
        ad.getContent().add(factory.createADCity(personCity));
        ad.getUse().add(PostalAddressUse.HP);
        personAddr.getValue().add(ad);
        prmList.getIdentifiedPersonAddress().add(personAddr);
*/
      /*  final PRPAMT101306UV02OtherIDsScopingOrganization otherId = factory.createPRPAMT101306UV02OtherIDsScopingOrganization();
        final II ii = factory.createII();
        final String rootDoc = "3.0.0.1";
        ii.setRoot(rootDoc);
        ii.setExtension(newDocId.get(rootDoc));
        otherId.getValue().add(ii);
        prmList.getOtherIDsScopingOrganization().add(otherId);*/

        PRPAIN101306UV02 res = pdManager.findLike(prm);
        final List<II> listId = res.getControlActProcess().getSubject().get(0).getRegistrationEvent().getSubject1().getIdentifiedPerson().getId();
        assertFalse(listId.isEmpty());
        final II personId = listId.get(0);
        assertEquals(personId.getRoot(), "3.0.0.0");
        assertTrue(personId.getExtension().length() >= "52405a4d960030f25fb91713".length());
    }



}
