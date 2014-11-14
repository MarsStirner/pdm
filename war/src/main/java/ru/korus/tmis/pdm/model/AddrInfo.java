package ru.korus.tmis.pdm.model;

import ru.korus.tmis.pdm.ws.hl7.*;

import javax.xml.bind.JAXBElement;
import java.io.Serializable;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        29.10.2014, 13:41 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class AddrInfo implements UseInfo {

    //Тип
    private String description;

    //Страна
    private String country;

    //Регион
    private String state;

    //Район
    private String county;

    //Населённый пункт
    private String precinct;

    //Город
    private String city;

    //Улица
    private String streetName;

    //Полный адрес
    private String streetAddressLine;

    //Индекс
    private String postalCode;

    //Номер дома
    private String houseNumber;

    //Корпус
    private String buildingNumberSuffix;

    //Квартира
    private String additionalLocator;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPrecinct() {
        return precinct;
    }

    public void setPrecinct(String precinct) {
        this.precinct = precinct;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetAddressLine() {
        return streetAddressLine;
    }

    public void setStreetAddressLine(String streetAddressLine) {
        this.streetAddressLine = streetAddressLine;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getBuildingNumberSuffix() {
        return buildingNumberSuffix;
    }

    public void setBuildingNumberSuffix(String buildingNumberSuffix) {
        this.buildingNumberSuffix = buildingNumberSuffix;
    }

    public String getAdditionalLocator() {
        return additionalLocator;
    }

    public void setAdditionalLocator(String additionalLocator) {
        this.additionalLocator = additionalLocator;
    }

    static public AddrInfo newInstance(ADExplicit addr, String use) {
        AddrInfo res = new AddrInfo();
        res.description = use;

        for (Serializable object : addr.getContent()) {
            if (object instanceof JAXBElement) {
                JAXBElement el = (JAXBElement) object;
                if (el.getValue() instanceof ADXPExplicit) {
                    final String value = ((ADXPExplicit) el.getValue()).getContent();
                    if (el.getValue() instanceof AdxpExplicitCountry) {
                        res.country = value;
                    } else if (el.getValue() instanceof AdxpExplicitStreetAddressLine) {
                        res.streetAddressLine = value;
                    } else if (el.getValue() instanceof AdxpExplicitStreetName) {
                        res.streetName = value;
                    } else if (el.getValue() instanceof AdxpExplicitAdditionalLocator) {
                        res.additionalLocator = value;
                    } else if (el.getValue() instanceof AdxpExplicitCounty) {
                        res.county = value;
                    } else if (el.getValue() instanceof AdxpExplicitPrecinct) {
                        res.precinct = value;
                    } else if (el.getValue() instanceof AdxpExplicitHouseNumber) {
                        res.houseNumber = value;
                    } else if (el.getValue() instanceof AdxpExplicitBuildingNumberSuffix) {
                        res.buildingNumberSuffix = value;
                    } else if (el.getValue() instanceof AdxpExplicitState) {
                        res.state = value;
                    } else if (el.getValue() instanceof AdxpExplicitCity) {
                        res.city = value;
                    } else if (el.getValue() instanceof AdxpExplicitPostalCode) {
                        res.postalCode = value;
                    }
                }
            }
        }

        return res;
    }

    public void set(AddrInfo addr) {
        this.country = addr.country;
        this.streetAddressLine = addr.streetAddressLine;
        this.postalCode = addr.postalCode;
        this.streetName = addr.streetName;
        this.additionalLocator = addr.additionalLocator;
        this.county = addr.county;
        this.precinct = addr.precinct;
        this.houseNumber = addr.houseNumber;
        this.buildingNumberSuffix = addr.buildingNumberSuffix;
        this.state = addr.state;
        this.city = addr.city;
    }

    @Override
    public String getUse() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddrInfo)) return false;

        AddrInfo addrInfo = (AddrInfo) o;

        if (additionalLocator != null ? !additionalLocator.equals(addrInfo.additionalLocator) : addrInfo.additionalLocator != null)
            return false;
        if (buildingNumberSuffix != null ? !buildingNumberSuffix.equals(addrInfo.buildingNumberSuffix) : addrInfo.buildingNumberSuffix != null)
            return false;
        if (city != null ? !city.equals(addrInfo.city) : addrInfo.city != null) return false;
        if (country != null ? !country.equals(addrInfo.country) : addrInfo.country != null) return false;
        if (county != null ? !county.equals(addrInfo.county) : addrInfo.county != null) return false;
        if (description != null ? !description.equals(addrInfo.description) : addrInfo.description != null)
            return false;
        if (houseNumber != null ? !houseNumber.equals(addrInfo.houseNumber) : addrInfo.houseNumber != null)
            return false;
        if (postalCode != null ? !postalCode.equals(addrInfo.postalCode) : addrInfo.postalCode != null) return false;
        if (precinct != null ? !precinct.equals(addrInfo.precinct) : addrInfo.precinct != null) return false;
        if (state != null ? !state.equals(addrInfo.state) : addrInfo.state != null) return false;
        if (streetAddressLine != null ? !streetAddressLine.equals(addrInfo.streetAddressLine) : addrInfo.streetAddressLine != null)
            return false;
        if (streetName != null ? !streetName.equals(addrInfo.streetName) : addrInfo.streetName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (county != null ? county.hashCode() : 0);
        result = 31 * result + (precinct != null ? precinct.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (streetName != null ? streetName.hashCode() : 0);
        result = 31 * result + (streetAddressLine != null ? streetAddressLine.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + (houseNumber != null ? houseNumber.hashCode() : 0);
        result = 31 * result + (buildingNumberSuffix != null ? buildingNumberSuffix.hashCode() : 0);
        result = 31 * result + (additionalLocator != null ? additionalLocator.hashCode() : 0);
        return result;
    }
}
