package ru.korus.tmis.pdm.test;

import org.testng.annotations.Test;

import ru.korus.tmis.pdm.test.ws.*;

import javax.xml.bind.JAXBElement;

import java.util.UUID;

import static org.testng.Assert.*;

public class PDManagerTest {

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
        person.getAsOtherIDs().get(0).getId().get(0).setExtension(UUID.randomUUID().toString());
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
        String root = res.getControlActProcess().getSubject().get(0).getRegistrationEvent().getSubject1().getIdentifiedPerson().
                getIdentifiedPerson().getId().get(0).getRoot();
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
        final PRPAMT101307UV02IdentifiedPersonIdentifier person = factory.createPRPAMT101307UV02IdentifiedPersonIdentifier();
        prmList.getIdentifiedPersonIdentifier().add(person);
        final II ii = factory.createII();
        person.getValue().add(ii);
        ii.setRoot("5225d1cbbf5ba6e90a27887f");

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
