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
        person.getName().add(name);
        person.getAsOtherIDs().add(new PRPAMT101301UV02OtherIDs() );
        person.getAsOtherIDs().get(0).getId().add(new II());
        person.getAsOtherIDs().get(0).getId().get(0).setRoot("3.0.0.1");
        person.getAsOtherIDs().get(0).getId().get(0).setExtension(UUID.randomUUID().toString());

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
        ii.setRoot("521de96e1462e75663ae98ea");

        PRPAIN101308UV02 res = pdManager.getDemographics(prm);
        String root = res.getControlActProcess().getSubject().get(0).getRegistrationEvent().getSubject1().getIdentifiedPerson().getId().get(0).getRoot();
        assertEquals(root, "3.0.0.0");
    }

}
