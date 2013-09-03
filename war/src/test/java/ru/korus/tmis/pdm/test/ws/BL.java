
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *             The Boolean type stands for the values of two-valued logic.
 *             A Boolean value can be either true or
 *             false, or, as any other value may be NULL.
 *          
 * 
 * <p>Java class for BL complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BL">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:hl7-org:v3}ANY">
 *       &lt;attribute name="value" type="{urn:hl7-org:v3}bl" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BL")
@XmlSeeAlso({
    PRPAMT101302UV02PersonOrganDonorInd.class,
    PRPAMT101302UV02GuardianNegationInd.class,
    PRPAMT101302UV02EmployeeNegationInd.class,
    PRPAMT101302UV02ContactPartyNegationInd.class,
    PRPAMT101302UV02PersonalRelationshipNegationInd.class,
    PRPAMT101302UV02PersonMultipleBirthInd.class,
    PRPAMT101302UV02PersonDeceasedInd.class
})
public class BL
    extends ANY
{

    @XmlAttribute(name = "value")
    protected Boolean value;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setValue(Boolean value) {
        this.value = value;
    }

}
