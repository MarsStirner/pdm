package ru.korus.tmis.pdm.test;

import org.testng.annotations.Test;

import ru.korus.tmis.pdm.test.ws.EnGiven;
import ru.korus.tmis.pdm.test.ws.ObjectFactory;
import ru.korus.tmis.pdm.test.ws.PDManager;
import ru.korus.tmis.pdm.test.ws.PDManagerService;
import ru.korus.tmis.pdm.test.ws.PN;
import ru.korus.tmis.pdm.test.ws.PRPAIN101311UV02;
import ru.korus.tmis.pdm.test.ws.PRPAIN101311UV02MFMIMT700721UV01ControlActProcess;
import ru.korus.tmis.pdm.test.ws.PRPAIN101311UV02MFMIMT700721UV01RegistrationRequest;
import ru.korus.tmis.pdm.test.ws.PRPAIN101311UV02MFMIMT700721UV01Subject1;
import ru.korus.tmis.pdm.test.ws.PRPAIN101311UV02MFMIMT700721UV01Subject2;
import ru.korus.tmis.pdm.test.ws.PRPAIN101312UV02;
import ru.korus.tmis.pdm.test.ws.PRPAMT101301UV02IdentifiedPerson;
import ru.korus.tmis.pdm.test.ws.PRPAMT101301UV02Person;
import static org.testng.Assert.*;

public class PDManagerTest {
    static PRPAIN101312UV02 tmp;

    @Test
    static public void addNewPerson() {
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
        // final EnGiven enGiven = new EnGiven();
        // enGiven.getContent().add("Ivan");
        // ObjectFactory factory = new ObjectFactory();
        // JAXBElement<EnGiven> givenJAXBElement = factory.createENGiven(enGiven);
        // givenJAXBElement.setValue(enGiven);
        // PN pn = new PN();
        // pn.getContent().add(givenJAXBElement);
        // person.getName().add(pn);

        tmp = pdManager.add(prm);
        String root = tmp.getControlActProcess().getSubject().get(0).getRegistrationEvent().getSubject1().getIdentifiedPerson().
                getIdentifiedPerson().getId().get(0).getRoot();
        assertEquals(root, "3.0.0.0");
    }

}
