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
        private String code;
        private String codeSystem;
    	static private Term newInstance(String code, String codeSystem) {
            Term res = new Term();
    		res.code = code;
    		res.codeSystem = codeSystem;
            return res;
    	}

        public String getCode() {
            return code;
        }

        public String getCodeSystem() {
            return codeSystem;
        }
    }

    public static class Telecom {
        private String value;
        private String use;
        static private Telecom newInstance(String value, String use) {
            Telecom res = new Telecom();
    		res.value = value;
    		res.use = use;
            return res;
    	}

    }
    
    public static class Addr {
        private String use;
        
        private String country;
        private String streetAddressLine;
        private String direction;
        private String postBox;
        private String unitType;
        private String delimiter;
        private String deliveryInstallationArea;
        private String deliveryModeIdentifier;
        private String postalCode;
        private String deliveryAddressLine;
        private String streetName;
        private String unitID;
        private String additionalLocator;
        private String deliveryMode;
        private String streetNameBase;
        private String deliveryInstallationQualifier;
        private String county;
        private String precinct;
        private String careOf;
        private String houseNumber;
        private String censusTract;
        private String buildingNumberSuffix;
        private String houseNumberNumeric;
        private String streetNameType;
        private String deliveryInstallationType;
        private String state;
        private String city;

        static public Addr newInstance(AD addr, String use) {
            Addr res = new Addr();
            res.use = use;

            for (Serializable object : addr.getContent()) {
                if (object instanceof JAXBElement) {
                    JAXBElement el = (JAXBElement) object;
                    if (el.getValue() instanceof ADXPExplicit) {
                        final String value =  ((ADXPExplicit)el.getValue()).getContent();
                        if (el.getValue() instanceof AdxpExplicitCountry) {
                            res.country = value;
                        } else if (el.getValue() instanceof AdxpExplicitStreetAddressLine) {
                            res.streetAddressLine = value;
                        } else if (el.getValue() instanceof AdxpExplicitDirection)  {
                            res.direction = value;
                        } else if (el.getValue() instanceof AdxpExplicitPostBox)  {
                            res.postBox = value;
                        } else if (el.getValue() instanceof AdxpExplicitUnitType)  {
                            res.unitType = value;
                        } else if (el.getValue() instanceof AdxpExplicitDelimiter)  {
                            res.delimiter = value;
                        } else if (el.getValue() instanceof AdxpExplicitDeliveryInstallationArea)  {
                            res.deliveryInstallationArea = value;
                        } else if (el.getValue() instanceof AdxpExplicitDeliveryModeIdentifier)  {
                            res.deliveryModeIdentifier = value;
                        } else if (el.getValue() instanceof AdxpExplicitPostalCode)  {
                            res.postalCode = value;
                        } else if (el.getValue() instanceof AdxpExplicitDeliveryAddressLine)  {
                            res.deliveryAddressLine = value;
                        } else if (el.getValue() instanceof AdxpExplicitStreetName)  {
                            res.streetName = value;
                        } else if (el.getValue() instanceof AdxpExplicitUnitID)  {
                            res.unitID = value;
                        } else if (el.getValue() instanceof AdxpExplicitAdditionalLocator)  {
                            res.additionalLocator = value;
                        } else if (el.getValue() instanceof AdxpExplicitDeliveryMode)  {
                            res.deliveryMode = value;
                        } else if (el.getValue() instanceof AdxpExplicitStreetNameBase)  {
                            res.streetNameBase = value;
                        } else if (el.getValue() instanceof AdxpExplicitDeliveryInstallationQualifier)  {
                            res.deliveryInstallationQualifier = value;
                        } else if (el.getValue() instanceof AdxpExplicitCounty)  {
                            res.county = value;
                        } else if (el.getValue() instanceof AdxpExplicitPrecinct)  {
                            res.precinct = value;
                        } else if (el.getValue() instanceof AdxpExplicitCareOf)  {
                            res.careOf = value;
                        } else if (el.getValue() instanceof AdxpExplicitHouseNumber)  {
                            res.houseNumber = value;
                        } else if (el.getValue() instanceof AdxpExplicitCensusTract)  {
                            res.censusTract = value;
                        } else if (el.getValue() instanceof AdxpExplicitBuildingNumberSuffix)  {
                            res.buildingNumberSuffix = value;
                        } else if (el.getValue() instanceof AdxpExplicitHouseNumberNumeric)  {
                            res.houseNumberNumeric = value;
                        } else if (el.getValue() instanceof  AdxpExplicitStreetNameType1)  {
                            res.streetNameType = value;
                        } else if (el.getValue() instanceof AdxpExplicitDeliveryInstallationType)  {
                            res.deliveryInstallationType = value;
                        } else if (el.getValue() instanceof AdxpExplicitState)  {
                            res.state = value;
                        } else if (el.getValue() instanceof AdxpExplicitCity)  {
                            res.city = value;
                        }
                    }
                }
            }
            return res;
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
    private String given;
    
     /**
     * Отчество 
     */
    private String middleName;
    
    /**
     * Фамилия
     */
    private String family;
    
    /**
     * Пол
     */
    private Term gender;

    /**
     * Дата рождения в фомате yyyyMMdd 
     */
    private String birthData;
    
    /**
     * Документы: 
     * Документ, удостоверяющий личность; 
     * ИНН; 
     * Номер полиса обязательного медицинского страхования; 
     * Документ, удостоверяющий временную нетрудоспособность; 
     * Документ об образовании  
     */
    private Vector<Term> docs = new Vector<Term>();
    
    /**
     * Контактные телефоны и электронные адреса
     */
    private Vector<Telecom> telecoms = new Vector<Telecom>();

    /**
     *   Домашний/ рабочий т др. адреса.
     *   Возможные значения атрибута use:
     *   "H" - home address; "HP" - primary home; "HV" - vacation home,
     *   "WP" - work place, "DIR" - direct, "PUB" - public, "BAD" - bad address, "TMP"
     */
    private Vector<Addr> address = new Vector<Addr>();

    private Addr birthPlace;

    public PersonalData() {
        id = null;
        given = null;
        middleName = null;
        family = null;
        gender = null;
        birthData = null;
        birthPlace = null;
    }

    /**
     *
     * @param prm
     */
    static public PersonalData newInstance(PRPAIN101311UV02 prm) {
        PersonalData res = new PersonalData();
        res.id = null;
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
        res.given = given;
        res.family = family;
        res.middleName = middleName;
        CE genderCode = identifiedPerson.getAdministrativeGenderCode();
        res.gender = genderCode == null ? null : Term.newInstance(genderCode.getCode(), genderCode.getCodeSystem());
        TS birthTime = identifiedPerson.getBirthTime();
        res.birthData = birthTime == null ? null : birthTime.getValue();
        
        for( TEL telecom : identifiedPerson.getTelecom() ) {
           final String use = telecom.getUse().isEmpty() ? null : telecom.getUse().get(0).name();
            res.telecoms.add(Telecom.newInstance(telecom.getValue(), use));
        }       
        
        for (PRPAMT101301UV02OtherIDs ids : identifiedPerson.getAsOtherIDs()) {
        	for(II ii : ids.getId() ) {
        		res.docs.add(Term.newInstance(ii.getExtension(), ii.getRoot()));
        	}
        }
        
        for(AD addr : identifiedPerson.getAddr()) {
            final String use = addr.getUse().isEmpty() ? null : addr.getUse().get(0).name();
            res.address.add(Addr.newInstance(addr, use));
        }

        Addr birthPlace = null;
        if (identifiedPerson.getBirthPlace() instanceof JAXBElement &&
            identifiedPerson.getBirthPlace().getValue() instanceof PRPAMT101301UV02BirthPlace ){
            birthPlace = Addr.newInstance(identifiedPerson.getBirthPlace().getValue().getAddr(), null);
        }
        res.birthPlace = birthPlace;
        return res;
    }
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

    public String getGiven() {
        return given;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getFamily() {
        return family;
    }

    public Term getGender() {
        return gender;
    }

    public String getBirthData() {
        return birthData;
    }

    public Vector<Term> getDocs() {
        return docs;
    }

    public Vector<Telecom> getTelecoms() {
        return telecoms;
    }

    public Vector<Addr> getAddress() {
        return address;
    }

    public Addr getBirthPlace() {
        return birthPlace;
    }
}
