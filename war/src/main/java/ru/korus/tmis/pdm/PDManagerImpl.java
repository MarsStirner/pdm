package ru.korus.tmis.pdm;

import javax.annotation.Resource;
import javax.jws.*;
import javax.xml.ws.WebServiceContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
import ru.korus.tmis.pdm.ws.*;

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
    public static final String OID_PDM = "3.0.0.0";
	
	@Resource 
	WebServiceContext wsContext;
	
	static private ApplicationContext ctx = null;
	static private MongoOperations mongoOperation = null;
	
	static {
		 ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		 mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
	}

    private ObjectFactory factory = new ObjectFactory();
    /*
    * (non-Javadoc)
    *
    * @see ru.korus.tmis.pdm.ws.PDManager#add(ru.korus.tmis.pdm.ws.PRPAIN101311UV02)
    */
    @Override
    @WebMethod(action = "http://www.korusconsulting.ru/PDManager/new")
    @WebResult(name = "PRPA_IN101312UV02", targetNamespace = "urn:hl7-org:v3", partName = "parameters")
    public PRPAIN101312UV02 add(PRPAIN101311UV02 parameters();

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
        //TODO add verification
        final String id = parameters.getControlActProcess().getQueryByParameter().getValue().
                getParameterList().getIdentifiedPersonIdentifier().get(0).getValue().get(0).getRoot();
        final PersonalData personalData = findById(id);
        return getPRPAIN101308UV02(personalData);
    }
    
    private PRPAIN101312UV02 getPRPAIN101312UV02(String id) {
		PRPAIN101312UV02 res =  factory.createPRPAIN101312UV02();
		
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

    private PRPAIN101308UV02 getPRPAIN101308UV02(PersonalData personalData) {

        PRPAIN101308UV02 res = factory.createPRPAIN101308UV02();
        final PRPAIN101308UV02MFMIMT700711UV01ControlActProcess controlActProcess = factory.createPRPAIN101308UV02MFMIMT700711UV01ControlActProcess();
        res.setControlActProcess(controlActProcess);
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
        
        for(PersonalData.Term doc : personalData.getDocs()) {
            PRPAMT101303UV02OtherIDs otherId = factory.createPRPAMT101303UV02OtherIDs();
            otherId.getId().add(createII(doc));
            person.getIdentifiedPerson().getAsOtherIDs().add(otherId);
        }
        
        for(PersonalData.Telecom telecom : personalData.getTelecoms()) {
            person.getIdentifiedPerson().getTelecom().add(getHL7Telecom(telecom));
        }
        
        for(PersonalData.Addr addr: personalData.getAddress()) {
            person.getIdentifiedPerson().getAddr().add(getHL7Addr(addr));
        }

        if (personalData.getBirthPlace() != null) {
            PRPAMT101303UV02BirthPlace birthPlace = factory.createPRPAMT101303UV02BirthPlace();
            birthPlace.setAddr(getHL7Addr(personalData.getBirthPlace()));
            person.getIdentifiedPerson().setBirthPlace(factory.createPRPAMT101303UV02PersonBirthPlace(birthPlace));
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

        return res;
    }

    private TEL getHL7Telecom(PersonalData.Telecom telecom) {
        TEL res = factory.createTEL();
        res.setValue(telecom.getValue());
        res.getUse().add(TelecommunicationAddressUse.fromValue(telecom.getUse()));
        return res;
    }

    private II createII(PersonalData.Term doc) {
        return  createII(doc.getCode(), doc.getCodeSystem());
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

    private PersonalData findById(String id) {
        PersonalData person = mongoOperation.findById(id, PersonalData.class);
        if( person == null ) {
            throw new RuntimeException("The person with id'" + id + "' not found");
        }
        return person;    
    }

    private II createPdmII(String id) {
        return createII(id, OID_PDM);
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
        middleName.setContent(personalData.getFamily());
        name.getContent().add(factory.createENExplicitFamily(family));
     
        return name;
    }

    private CE getHL7Gender(PersonalData personalData) {
        PersonalData.Term gender = personalData.getGender();
        if(gender == null) {
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