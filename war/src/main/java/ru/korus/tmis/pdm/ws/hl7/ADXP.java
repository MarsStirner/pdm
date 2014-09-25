
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


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
 * <p>Java class for ADXP complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ADXP">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:hl7-org:v3}ST">
 *       &lt;attribute name="partType" type="{urn:hl7-org:v3}AddressPartType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ADXP")
@XmlSeeAlso({
    AdxpDeliveryInstallationType.class,
    AdxpPrecinct.class,
    AdxpUnitID.class,
    AdxpDeliveryInstallationQualifier.class,
    AdxpBuildingNumberSuffix.class,
    AdxpCensusTract.class,
    AdxpDeliveryAddressLine.class,
    AdxpState.class,
    AdxpCity.class,
    AdxpPostBox.class,
    AdxpDeliveryInstallationArea.class,
    AdxpDeliveryMode.class,
    AdxpDelimiter.class,
    AdxpStreetAddressLine.class,
    AdxpUnitType.class,
    AdxpCountry.class,
    AdxpHouseNumberNumeric.class,
    AdxpCareOf.class,
    AdxpCounty.class,
    AdxpHouseNumber.class,
    AdxpDeliveryModeIdentifier.class,
    AdxpStreetName.class,
    AdxpStreetNameType.class,
    AdxpDirection.class,
    AdxpPostalCode.class,
    AdxpStreetNameBase.class,
    AdxpAdditionalLocator.class
})
public class ADXP
    extends ST
{

    @XmlAttribute(name = "partType")
    protected AddressPartType partType;

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
