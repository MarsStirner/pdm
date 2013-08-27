package ru.korus.tmis.pdm;

import java.io.Serializable;
import java.util.List;
import java.util.Vector;


import javax.xml.bind.JAXBElement;
import javax.xml.ws.WebServiceContext;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import ru.korus.tmis.pdm.ws.*;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        02.07.2013, 12:35:19 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */

/**
 * 
 */
@Document(collection = "users")
public class PersonalData {

    public static class Term {
        private final String code;
        private final String codeSystem;
    	private Term(String code, String codeSystem) {
    		this.code = code;
    		this.codeSystem = codeSystem;
    	}
    }

    public static class Telecom {
        private final String value;
        private final String use;
    	private Telecom(String value, String use) {
    		this.value = value;
    		this.use = use;
    	}

    }
    
    public static class Addr {
        private final String use;
        
        private final String country;
        private final String streetAddressLine;
        private final String direction;
        private final String postBox;
        private final String unitType;
        private final String delimiter;
        private final String deliveryInstallationArea;
        private final String deliveryModeIdentifier;
        private final String postalCode;
        private final String deliveryAddressLine;
        private final String streetName;
        private final String unitID;
        private final String additionalLocator;
        private final String deliveryMode;
        private final String streetNameBase;
        private final String deliveryInstallationQualifier;
        private final String county;
        private final String precinct;
        private final String careOf;
        private final String houseNumber;
        private final String censusTract;
        private final String buildingNumberSuffix;
        private final String houseNumberNumeric;
        private final String streetNameType;
        private final String deliveryInstallationType;
        private final String state;
        private final String city;

        public Addr(ADExplicit addr, String use) {
            this.use = use;
            String country = null;
            String streetAddressLine = null;
            String direction = null;
            String postBox = null;
            String unitType = null;
            String delimiter = null;
            String deliveryInstallationArea = null;
            String deliveryModeIdentifier = null;
            String postalCode = null;
            String deliveryAddressLine = null;
            String streetName = null;
            String unitID = null;
            String additionalLocator = null;
            String deliveryMode = null;
            String streetNameBase = null;
            String deliveryInstallationQualifier = null;
            String county = null;
            String precinct = null;
            String careOf = null;
            String houseNumber = null;
            String censusTract = null;
            String buildingNumberSuffix = null;
            String houseNumberNumeric = null;
            String streetNameType = null;
            String deliveryInstallationType = null;
            String state = null;
            String city = null;
            for (Serializable object : addr.getContent()) {
                if (object instanceof JAXBElement) {
                    JAXBElement el = (JAXBElement) object;
                    if (el.getValue() instanceof ADXPExplicit) {
                        final String value =  ((ADXPExplicit)el.getValue()).getContent();
                        if (el.getValue() instanceof AdxpExplicitCountry) {
                            country = value;
                        } else if (el.getValue() instanceof AdxpExplicitStreetAddressLine) {
                            streetAddressLine = value;
                        } else if (el.getValue() instanceof AdxpExplicitDirection)  {
                            direction = value;
                        } else if (el.getValue() instanceof AdxpExplicitPostBox)  {
                            postBox = value;
                        } else if (el.getValue() instanceof AdxpExplicitUnitType)  {
                            unitType = value;
                        } else if (el.getValue() instanceof AdxpExplicitDelimiter)  {
                            delimiter = value;
                        } else if (el.getValue() instanceof AdxpExplicitDeliveryInstallationArea)  {
                            deliveryInstallationArea = value;
                        } else if (el.getValue() instanceof AdxpExplicitDeliveryModeIdentifier)  {
                            deliveryModeIdentifier = value;
                        } else if (el.getValue() instanceof AdxpExplicitPostalCode)  {
                            postalCode = value;
                        } else if (el.getValue() instanceof AdxpExplicitDeliveryAddressLine)  {
                            deliveryAddressLine = value;
                        } else if (el.getValue() instanceof AdxpExplicitStreetName)  {
                            streetName = value;
                        } else if (el.getValue() instanceof AdxpExplicitUnitID)  {
                            unitID = value;
                        } else if (el.getValue() instanceof AdxpExplicitAdditionalLocator)  {
                            additionalLocator = value;
                        } else if (el.getValue() instanceof AdxpExplicitDeliveryMode)  {
                            deliveryMode = value;
                        } else if (el.getValue() instanceof AdxpExplicitStreetNameBase)  {
                            streetNameBase = value;
                        } else if (el.getValue() instanceof AdxpExplicitDeliveryInstallationQualifier)  {
                            deliveryInstallationQualifier = value;
                        } else if (el.getValue() instanceof AdxpExplicitCounty)  {
                            county = value;
                        } else if (el.getValue() instanceof AdxpExplicitPrecinct)  {
                            precinct = value;
                        } else if (el.getValue() instanceof AdxpExplicitCareOf)  {
                            careOf = value;
                        } else if (el.getValue() instanceof AdxpExplicitHouseNumber)  {
                            houseNumber = value;
                        } else if (el.getValue() instanceof AdxpExplicitCensusTract)  {
                            censusTract = value;
                        } else if (el.getValue() instanceof AdxpExplicitBuildingNumberSuffix)  {
                            buildingNumberSuffix = value;
                        } else if (el.getValue() instanceof AdxpExplicitHouseNumberNumeric)  {
                            houseNumberNumeric = value;
                        } else if (el.getValue() instanceof  AdxpExplicitStreetNameType1)  {
                            streetNameType = value;
                        } else if (el.getValue() instanceof AdxpExplicitDeliveryInstallationType)  {
                            deliveryInstallationType = value;
                        } else if (el.getValue() instanceof AdxpExplicitState)  {
                            state = value;
                        } else if (el.getValue() instanceof AdxpExplicitCity)  {
                            city = value;
                        }
                    }

                }
            }
            this.country = country;
            this.streetAddressLine = streetAddressLine;
            this.direction = direction;
            this.postBox = postBox;
            this.unitType = unitType;
            this.delimiter = delimiter;
            this.deliveryInstallationArea = deliveryInstallationArea;
            this.deliveryModeIdentifier = deliveryModeIdentifier;
            this.postalCode = postalCode;
            this.deliveryAddressLine = deliveryAddressLine;
            this.streetName = streetName;
            this.unitID = unitID;
            this.additionalLocator = additionalLocator;
            this.deliveryMode = deliveryMode;
            this.streetNameBase = streetNameBase;
            this.deliveryInstallationQualifier = deliveryInstallationQualifier;
            this.county = county;
            this.precinct = precinct;
            this.careOf = careOf;
            this.houseNumber = houseNumber;
            this.censusTract = censusTract;
            this.buildingNumberSuffix = buildingNumberSuffix;
            this.houseNumberNumeric = houseNumberNumeric;
            this.streetNameType = streetNameType;
            this.deliveryInstallationType = deliveryInstallationType;
            this.state = state;
            this.city = city;
        }
        
        public String getCountry() {
            return country;
        }

        public String getStreetAddressLine() {
            return streetAddressLine;
        }

        public String getDirection() {
            return direction;
        }

        public String getPostBox() {
            return postBox;
        }

        public String getUnitType() {
            return unitType;
        }

        public String getDelimiter() {
            return delimiter;
        }

        public String getDeliveryInstallationArea() {
            return deliveryInstallationArea;
        }

        public String getDeliveryModeIdentifier() {
            return deliveryModeIdentifier;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public String getDeliveryAddressLine() {
            return deliveryAddressLine;
        }

        public String getStreetName() {
            return streetName;
        }

        public String getUnitID() {
            return unitID;
        }

        public String getAdditionalLocator() {
            return additionalLocator;
        }

        public String getDeliveryMode() {
            return deliveryMode;
        }

        public String getStreetNameBase() {
            return streetNameBase;
        }

        public String getDeliveryInstallationQualifier() {
            return deliveryInstallationQualifier;
        }

        public String getCounty() {
            return county;
        }

        public String getPrecinct() {
            return precinct;
        }

        public String getCareOf() {
            return careOf;
        }

        public String getHouseNumber() {
            return houseNumber;
        }

        public String getCensusTract() {
            return censusTract;
        }

        public String getBuildingNumberSuffix() {
            return buildingNumberSuffix;
        }

        public String getHouseNumberNumeric() {
            return houseNumberNumeric;
        }

        public String getStreetNameType() {
            return streetNameType;
        }

        public String getDeliveryInstallationType() {
            return deliveryInstallationType;
        }

        public String getState() {
            return state;
        }

        public String getCity() {
            return city;
        }
        
    }
    
    /**
     * Уникальный идентификатор субъекта ПДн в ЗХПД
     */
     @Id
     private String id;

    /**
     * Имя
     */
    final private String given;
    
     /**
     * Отчество 
     */
    final private String middleName;
    
    /**
     * Фамилия
     */
    final private String family;
    
    /**
     * Пол
     */
    final private Term gender; 

    /**
     * Дата рождения в фомате yyyyMMdd 
     */
    final private String birthData;
    
    /**
     * Документы: 
     * Документ, удостоверяющий личность; 
     * ИНН; 
     * Номер полиса обязательного медицинского страхования; 
     * Документ, удостоверяющий временную нетрудоспособность; 
     * Документ об образовании  
     */
    final private Vector<Term> docs = new Vector<Term>();
    
    /**
     * Контактные телефоны и электронные адреса
     */
    final private Vector<Telecom> telecoms = new Vector<Telecom>();
   
    final private Vector<Addr> address = new Vector<Addr>();
	/**
     * @param parameters
     */
    public PersonalData(PRPAIN101311UV02 prm, WebServiceContext wsContext) {
        id = null;
        String given = null;
        String family = null;
        String middleName = null;
        PRPAMT101301UV02Person identifiedPerson = prm.getControlActProcess().getSubject().getRegistrationRequest().getSubject1().getIdentifiedPerson().getIdentifiedPerson();
        List<PNExplicit> names = identifiedPerson.getName();
        if (!names.isEmpty()) {
            PNExplicit pn = names.get(0);
            for (Serializable object : pn.getContent()) {
                if (object instanceof JAXBElement) {
                    JAXBElement el = (JAXBElement) object;
                    if (el.getValue() instanceof EnExplicitGiven) {
                        if (given == null) {
                            given = ((EnExplicitGiven)el.getValue()).getContent();
                        } else {
                            middleName = ((EnExplicitGiven)el.getValue()).getContent();
                        }
                    } else if (el.getValue() instanceof EnExplicitFamily) {
                        family = ((EnExplicitGiven)el.getValue()).getContent();
                    }
                }
            }
        }
        this.given = given;
        this.family = family;
        this.middleName = middleName;
        CE genderCode = identifiedPerson.getAdministrativeGenderCode();
        this.gender = genderCode == null ? null : new Term(genderCode.getCode(), genderCode.getCodeSystem());
        TS birthTime = identifiedPerson.getBirthTime();
        this.birthData = birthTime == null ? null : birthTime.getValue();
        
        for( TEL telecom : identifiedPerson.getTelecom() ) {
           final String use = telecom.getUse().isEmpty() ? null : telecom.getUse().get(0).name();
           telecoms.add(new Telecom(telecom.getValue(), use));
        }       
        
        for (PRPAMT101301UV02OtherIDs ids : identifiedPerson.getAsOtherIDs()) {
        	for(II ii : ids.getId() ) {
        		docs.add(new Term(ii.getExtension(), ii.getRoot()));
        	}
        }
        
        for(ADExplicit addr : identifiedPerson.getAddr()) {
            final String use = addr.getUse().isEmpty() ? null : addr.getUse().get(0).name();
            address.add(new Addr(addr, use));
        }
    }
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
