package ru.korus.tmis.pdm;

import javax.annotation.Resource;
import javax.jws.*;
import javax.xml.ws.WebServiceContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;

import org.springframework.data.mongodb.core.query.Query;
import ru.korus.tmis.pdm.ws.II;
import ru.korus.tmis.pdm.ws.ObjectFactory;
import ru.korus.tmis.pdm.ws.PDManager;
import ru.korus.tmis.pdm.ws.PRPAIN101305UV02;
import ru.korus.tmis.pdm.ws.PRPAIN101306UV02;
import ru.korus.tmis.pdm.ws.PRPAIN101307UV02;
import ru.korus.tmis.pdm.ws.PRPAIN101308UV02;
import ru.korus.tmis.pdm.ws.PRPAIN101311UV02;
import ru.korus.tmis.pdm.ws.PRPAIN101312UV02;
import ru.korus.tmis.pdm.ws.PRPAIN101312UV02MFMIMT700701UV01ControlActProcess;
import ru.korus.tmis.pdm.ws.PRPAIN101312UV02MFMIMT700701UV01RegistrationEvent;
import ru.korus.tmis.pdm.ws.PRPAIN101312UV02MFMIMT700701UV01Subject1;
import ru.korus.tmis.pdm.ws.PRPAIN101312UV02MFMIMT700701UV01Subject2;
import ru.korus.tmis.pdm.ws.PRPAMT101304UV02IdentifiedPerson;
import ru.korus.tmis.pdm.ws.PRPAMT101304UV02Person;

/**
 * Author: Sergey A. Zagrebelny <br>
 * Date: 02.07.2013, 12:07:21 <br>
 * Company: Korus Consulting IT<br>
 * Description: <br>
 */

@WebService(endpointInterface = "ru.korus.tmis.pdm.ws.PDManager", targetNamespace = "http://www.korusconsulting.ru/PDManager/",
        serviceName = "tmis-pdm", portName = "portPdm", name = "PDManager")
@HandlerChain(file="../../../../../handler-chain.xml")
public class PDManagerImpl implements PDManager {
	
	@Resource 
	WebServiceContext wsContext;
	
	static private ApplicationContext ctx = null;
	static private MongoOperations mongoOperation = null;
	
	static {
		 ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		 mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
	}



    /*
    * (non-Javadoc)
    *
    * @see ru.korus.tmis.pdm.ws.PDManager#add(ru.korus.tmis.pdm.ws.PRPAIN101311UV02)
    */
    @Override
    @WebMethod(action = "http://www.korusconsulting.ru/PDManager/new")
    @WebResult(name = "PRPA_IN101312UV02", targetNamespace = "urn:hl7-org:v3", partName = "parameters")
    public PRPAIN101312UV02 add(PRPAIN101311UV02 parameters)  {

        final PersonalData personalData = PersonalData.newInstance(parameters);
        final String id = save(personalData);
        return  getPRPAIN101312UV02(id);
    }

    /*
         * (non-Javadoc)
         *
         * @see ru.korus.tmis.pdm.ws.PDManager#findCandidates(ru.korus.tmis.pdm.ws.PRPAIN101305UV02)
         */
    @Override
    @WebMethod(action = "http://www.korusconsulting.ru/PDManager/findCandidates")
    @WebResult(name = "PRPA_IN101306UV02", targetNamespace = "urn:hl7-org:v3", partName = "result")
    public PRPAIN101306UV02 findCandidates(PRPAIN101305UV02 parameters) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ru.korus.tmis.pdm.ws.PDManager#getDemographics(ru.korus.tmis.pdm.ws.PRPAIN101307UV02)
     */
    @Override
    @WebMethod(action = "http://www.korusconsulting.ru/PDManager/getDemographics")
    @WebResult(name = "PRPA_IN101308UV02", targetNamespace = "urn:hl7-org:v3", partName = "result")
    public PRPAIN101308UV02 getDemographics(PRPAIN101307UV02 parameters) {
        // TODO Auto-generated method stub
        return null;
    }
    
    private PRPAIN101312UV02 getPRPAIN101312UV02(String id) {
		String pdmOid = "3.0.0.0";
		ObjectFactory factory = new ObjectFactory();
		PRPAIN101312UV02 res = new PRPAIN101312UV02();
		
        PRPAIN101312UV02MFMIMT700701UV01ControlActProcess controlActProcess = factory.createPRPAIN101312UV02MFMIMT700701UV01ControlActProcess();
        PRPAIN101312UV02MFMIMT700701UV01Subject1 subject1 = factory.createPRPAIN101312UV02MFMIMT700701UV01Subject1();
        PRPAIN101312UV02MFMIMT700701UV01RegistrationEvent registrationEvent = factory.createPRPAIN101312UV02MFMIMT700701UV01RegistrationEvent();
		PRPAMT101304UV02IdentifiedPerson identifiedPerson = factory.createPRPAMT101304UV02IdentifiedPerson();
		PRPAIN101312UV02MFMIMT700701UV01Subject2 subject2 = factory.createPRPAIN101312UV02MFMIMT700701UV01Subject2();
		PRPAMT101304UV02Person person = factory.createPRPAMT101304UV02Person();
		
        res.setControlActProcess(controlActProcess);
		controlActProcess.getSubject().add(subject1);
		subject1.setRegistrationEvent(registrationEvent);
		registrationEvent.setSubject1(subject2);
		subject2.setIdentifiedPerson(identifiedPerson);
		identifiedPerson.setIdentifiedPerson(person);
		II ii = factory.createII();
		ii.setExtension(id);
		ii.setRoot(pdmOid);
	    person.getId().add(ii);
		return res;
	}

    private String save(PersonalData personalData) {
        for(PersonalData.Term doc : personalData.getDocs()) {
            BasicQuery query = new BasicQuery(String.format("{docs: { $elemMatch: {code:'%s' , codeSystem : '%s'}}}", doc.getCode(), doc.getCodeSystem()));
            if (!mongoOperation.find(query, PersonalData.class).isEmpty() ){
                throw new RuntimeException("The person already added");
            }

        }
        mongoOperation.save(personalData);
		return personalData.getId();
	}

}
