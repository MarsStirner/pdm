package ru.korus.tmis.pdm.test;

import org.testng.annotations.Test;

import ru.korus.tmis.pdm.test.ws.*;

import javax.xml.bind.JAXBElement;

import java.util.UUID;

import static org.testng.Assert.*;

public class PDManagerTest {

    private String newId = "111";
    private String newDocId = "222";

    @Test
    public void addNewPerson() {
        PDManagerService serv = new PDManagerService();
        PDManager pdManager = serv.getPDManagerSOAP();

        PRPAIN101311UV02 prm = new PRPAIN101311UV02();
        PRPAIN101311UV02MFMIMT700721UV01ControlActProcess controlActProcess = new PRPAIN101311UV02MFMIMT700721UV01ControlActProcess();
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

        ObjectFactory factory = new ObjectFactory();
        PN name = factory.createPN();
        
        EnGiven giv = factory.createEnGiven();
        giv.getContent().add("Ivan");
        name.getContent().add(factory.createENGiven(giv));

        EnGiven mn = factory.createEnGiven();
        mn.getContent().add("Ivanovich");
        name.getContent().add(factory.createENGiven(mn));
        person.getName().add(name);
        person.getAsOtherIDs().add(new PRPAMT101301UV02OtherIDs() );
        person.getAsOtherIDs().get(0).getId().add(new II());
        person.getAsOtherIDs().get(0).getId().get(0).setRoot("3.0.0.1");
        newDocId = UUID.randomUUID().toString();
        person.getAsOtherIDs().get(0).getId().get(0).setExtension(newDocId);
        person.getAsOtherIDs().add(new PRPAMT101301UV02OtherIDs() );
        person.getAsOtherIDs().get(1).getId().add(new II());
        person.getAsOtherIDs().get(1).getId().get(0).setRoot("3.0.0.2");
        person.getAsOtherIDs().get(1).getId().get(0).setExtension(UUID.randomUUID().toString());

        final AD addr = factory.createAD();
        person.getAddr().add(addr);
        AdxpStreetName street = factory.createAdxpStreetName();
        street.getContent().add("TestStreet");
        addr.getContent().add(factory.createADStreetName(street));

        final CE ce = factory.createCE();
        ce.setCode("M");
        person.setAdministrativeGenderCode(ce);

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
        String root = res.getControlActProcess().getSubject().get(0).getRegistrationEvent().getSubject1().getIdentifiedPerson().getId().get(0).getRoot();
        assertEquals(root, "3.0.0.0");
    }

    @Test
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

        final PRPAMT101306UV02PersonBirthPlaceAddress birthPlaceAddress = factory.createPRPAMT101306UV02PersonBirthPlaceAddress();
        final AD addr = factory.createAD();
        AdxpCity city = factory.createAdxpCity();
        city.getContent().add("TestStreet");
        addr.getContent().add(factory.createADCity(city));
        birthPlaceAddress.getValue().add(addr);
        prmList.getPersonBirthPlaceAddress().add(birthPlaceAddress);

        final PRPAMT101306UV02IdentifiedPersonTelecom telecom = factory.createPRPAMT101306UV02IdentifiedPersonTelecom();
        TEL tel = factory.createTEL();
        tel.setValue("tel:+7 (495) 229-53-70");
        tel.getUse().add(TelecommunicationAddressUse.HP);
        telecom.getValue().add(tel);
        telecom.getValue().add(tel);
        prmList.getIdentifiedPersonTelecom().add(telecom);

        final PRPAMT101306UV02PersonBirthTime birthTime = factory.createPRPAMT101306UV02PersonBirthTime();
        final IVLTS ivlts = factory.createIVLTS();
        ivlts.setValue("19930123");
        birthTime.getValue().add(ivlts);
        prmList.getPersonBirthTime().add(birthTime);

        final PRPAMT101306UV02IdentifiedPersonAddress personAddr = factory.createPRPAMT101306UV02IdentifiedPersonAddress();
        final AD ad = factory.createAD();
        AdxpCity personCity = factory.createAdxpCity();
        personCity.getContent().add("TestCity");
        ad.getContent().add(factory.createADCity(personCity));
        ad.getUse().add(PostalAddressUse.HP);
        personAddr.getValue().add(ad);
        prmList.getIdentifiedPersonAddress().add(personAddr);

        final PRPAMT101306UV02OtherIDsScopingOrganization otherId = factory.createPRPAMT101306UV02OtherIDsScopingOrganization();
        final II ii = factory.createII();
        ii.setRoot("3.0.0.1");
        ii.setExtension(newDocId);
        otherId.getValue().add(ii);
        prmList.getOtherIDsScopingOrganization().add(otherId);

        PRPAIN101306UV02 res = pdManager.findCandidates(prm);
        String root = res.getControlActProcess().getSubject().get(0).getRegistrationEvent().getSubject1().getIdentifiedPerson().getId().get(0).getRoot();
        assertEquals(root, "3.0.0.0");
    }


    @Test
    public void update() {
        ObjectFactory factory = new ObjectFactory();
        PDManagerService serv = new PDManagerService();
        PDManager pdManager = serv.getPDManagerSOAP();
        final PRPAIN101315UV02 res = pdManager.update(factory.createPRPAIN101314UV02());
        String root = res.getControlActProcess().getSubject().get(0).getRegistrationEvent().getSubject1().getIdentifiedPerson().getId().get(0).getRoot();
        assertEquals(root, "3.0.0.0");
    }

}
