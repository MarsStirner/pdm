
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * 
 *             A character string that may have a type-tag signifying its
 *             role in the address. Typical parts that exist in about
 *             every address are street, house number, or post box,
 *             postal code, city, country but other roles may be defined
 *             regionally, nationally, or on an enterprise level (e.g. in
 *             military addresses). Addresses are usually broken up into
 *             lines, which are indicated by special line-breaking
 *             delimiter elements (e.g., DEL).
 *             
 * 
 * <p>Java class for ADXP_explicit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ADXP_explicit">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="partType" type="{urn:hl7-org:v3}AddressPartType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ADXP_explicit", propOrder = {
    "content"
})
@XmlSeeAlso({
    AdxpExplicitBuildingNumberSuffix.class,
    AdxpExplicitStreetAddressLine.class,
    AdxpExplicitCensusTract.class,
    AdxpExplicitDeliveryInstallationType.class,
    AdxpExplicitDeliveryAddressLine.class,
    AdxpExplicitUnitID.class,
    AdxpExplicitHouseNumberNumeric.class,
    AdxpExplicitPrecinct.class,
    AdxpExplicitHouseNumber.class,
    AdxpExplicitState.class,
    AdxpExplicitCareOf.class,
    AdxpExplicitStreetNameType1 .class,
    AdxpExplicitDirection.class,
    AdxpExplicitUnitType.class,
    AdxpExplicitPostBox.class,
    AdxpExplicitAdditionalLocator.class,
    AdxpExplicitCounty.class,
    AdxpExplicitDeliveryInstallationArea.class,
    AdxpExplicitCity.class,
    AdxpExplicitStreetNameBase.class,
    AdxpExplicitDelimiter.class,
    AdxpExplicitStreetName.class,
    AdxpExplicitPostalCode.class,
    AdxpExplicitDeliveryInstallationQualifier.class,
    AdxpExplicitDeliveryMode.class,
    AdxpExplicitDeliveryModeIdentifier.class,
    AdxpExplicitCountry.class
})
public class ADXPExplicit {

    @XmlValue
    protected String content;
    @XmlAttribute(name = "partType")
    protected AddressPartType partType;

    /**
     * 
     *             A character string that may have a type-tag signifying its
     *             role in the address. Typical parts that exist in about
     *             every address are street, house number, or post box,
     *             postal code, city, country but other roles may be defined
     *             regionally, nationally, or on an enterprise level (e.g. in
     *             military addresses). Addresses are usually broken up into
     *             lines, which are indicated by special line-breaking
     *             delimiter elements (e.g., DEL).
     *             
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContent(String value) {
        this.content = value;
    }

    /**
     * Gets the value of the partType property.
     * 
     * @return
     *     possible object is
     *     {@link AddressPartType }
     *     
     */
    public AddressPartType getPartType() {
        return partType;
    }

    /**
     * Sets the value of the partType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressPartType }
     *     
     */
    public void setPartType(AddressPartType value) {
        this.partType = value;
    }

}
