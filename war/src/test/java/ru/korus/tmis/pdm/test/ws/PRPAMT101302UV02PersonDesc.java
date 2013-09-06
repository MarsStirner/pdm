
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PRPA_MT101302UV02.Person.desc complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PRPA_MT101302UV02.Person.desc">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:hl7-org:v3}ED">
 *       &lt;attribute name="updateMode" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Person.desc.updateMode" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PRPA_MT101302UV02.Person.desc")
public class PRPAMT101302UV02PersonDesc
    extends ED
{

    @XmlAttribute(name = "updateMode")
    protected PRPAMT101302UV02PersonDescUpdateMode updateMode;

    /**
     * Gets the value of the updateMode property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT101302UV02PersonDescUpdateMode }
     *     
     */
    public PRPAMT101302UV02PersonDescUpdateMode getUpdateMode() {
        return updateMode;
    }

    /**
     * Sets the value of the updateMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT101302UV02PersonDescUpdateMode }
     *     
     */
    public void setUpdateMode(PRPAMT101302UV02PersonDescUpdateMode value) {
        this.updateMode = value;
    }

}
