package ru.korus.tmis.pdm.entities;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import ru.korus.tmis.pdm.ws.hl7.*;

import javax.xml.bind.JAXBElement;
import java.io.Serializable;

/**
* Author:      Sergey A. Zagrebelny <br>
* Date:        06.10.2014, 17:14 <br>
* Company:     Korus Consulting IT<br>
* Description:  <br>
*/
public class Addr extends Use {
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

    static public Addr fromJson(String json) {
        try {
            return (new Gson()).fromJson(json, Addr.class);
        } catch (JsonSyntaxException ex) {
            Addr res = new Addr();
            res.streetAddressLine = json;
            return res;
        }
    }

    static public Addr newInstance(ADExplicit addr, String use) {
        Addr res = new Addr();
        res.setUse(use);

        for (Serializable object : addr.getContent()) {
            if (object instanceof JAXBElement) {
                JAXBElement el = (JAXBElement) object;
                if (el.getValue() instanceof ADXPExplicit) {
                    final String value = ((ADXPExplicit) el.getValue()).getContent();
                    if (el.getValue() instanceof AdxpExplicitCountry) {
                        res.country = value;
                    } else if (el.getValue() instanceof AdxpExplicitStreetAddressLine) {
                        res.streetAddressLine = value;
                    } else if (el.getValue() instanceof AdxpExplicitDirection) {
                        res.direction = value;
                    } else if (el.getValue() instanceof AdxpExplicitPostBox) {
                        res.postBox = value;
                    } else if (el.getValue() instanceof AdxpExplicitUnitType) {
                        res.unitType = value;
                    } else if (el.getValue() instanceof AdxpExplicitDelimiter) {
                        res.delimiter = value;
                    } else if (el.getValue() instanceof AdxpExplicitDeliveryInstallationArea) {
                        res.deliveryInstallationArea = value;
                    } else if (el.getValue() instanceof AdxpExplicitDeliveryModeIdentifier) {
                        res.deliveryModeIdentifier = value;
                    } else if (el.getValue() instanceof AdxpExplicitPostalCode) {
                        res.postalCode = value;
                    } else if (el.getValue() instanceof AdxpExplicitDeliveryAddressLine) {
                        res.deliveryAddressLine = value;
                    } else if (el.getValue() instanceof AdxpExplicitStreetName) {
                        res.streetName = value;
                    } else if (el.getValue() instanceof AdxpExplicitUnitID) {
                        res.unitID = value;
                    } else if (el.getValue() instanceof AdxpExplicitAdditionalLocator) {
                        res.additionalLocator = value;
                    } else if (el.getValue() instanceof AdxpExplicitDeliveryMode) {
                        res.deliveryMode = value;
                    } else if (el.getValue() instanceof AdxpExplicitStreetNameBase) {
                        res.streetNameBase = value;
                    } else if (el.getValue() instanceof AdxpExplicitDeliveryInstallationQualifier) {
                        res.deliveryInstallationQualifier = value;
                    } else if (el.getValue() instanceof AdxpExplicitCounty) {
                        res.county = value;
                    } else if (el.getValue() instanceof AdxpExplicitPrecinct) {
                        res.precinct = value;
                    } else if (el.getValue() instanceof AdxpExplicitCareOf) {
                        res.careOf = value;
                    } else if (el.getValue() instanceof AdxpExplicitHouseNumber) {
                        res.houseNumber = value;
                    } else if (el.getValue() instanceof AdxpExplicitCensusTract) {
                        res.censusTract = value;
                    } else if (el.getValue() instanceof AdxpExplicitBuildingNumberSuffix) {
                        res.buildingNumberSuffix = value;
                    } else if (el.getValue() instanceof AdxpExplicitHouseNumberNumeric) {
                        res.houseNumberNumeric = value;
                    } else if (el.getValue() instanceof AdxpExplicitStreetNameType1) {
                        res.streetNameType = value;
                    } else if (el.getValue() instanceof AdxpExplicitDeliveryInstallationType) {
                        res.deliveryInstallationType = value;
                    } else if (el.getValue() instanceof AdxpExplicitState) {
                        res.state = value;
                    } else if (el.getValue() instanceof AdxpExplicitCity) {
                        res.city = value;
                    }
                }
            }
        }
        return res;
    }

    public void set(Addr addr) {
        this.country = addr.country;
        this.streetAddressLine = addr.streetAddressLine;
        this.direction = addr.direction;
        this.postBox = addr.postBox;
        this.unitType = addr.unitType;
        this.delimiter = addr.delimiter;
        this.deliveryInstallationArea = addr.deliveryInstallationArea;
        this.deliveryModeIdentifier = addr.deliveryModeIdentifier;
        this.postalCode = addr.postalCode;
        this.deliveryAddressLine = addr.deliveryAddressLine;
        this.streetName = addr.streetName;
        this.unitID = addr.unitID;
        this.additionalLocator = addr.additionalLocator;
        this.deliveryMode = addr.deliveryMode;
        this.streetNameBase = addr.streetNameBase;
        this.deliveryInstallationQualifier = addr.deliveryInstallationQualifier;
        this.county = addr.county;
        this.precinct = addr.precinct;
        this.careOf = addr.careOf;
        this.houseNumber = addr.houseNumber;
        this.censusTract = addr.censusTract;
        this.buildingNumberSuffix = addr.buildingNumberSuffix;
        this.houseNumberNumeric = addr.houseNumberNumeric;
        this.streetNameType = addr.streetNameType;
        this.deliveryInstallationType = addr.deliveryInstallationType;
        this.state = addr.state;
        this.city = addr.city;
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

    public String toJson() {
        return (new Gson()).toJson(this);
    }
}
