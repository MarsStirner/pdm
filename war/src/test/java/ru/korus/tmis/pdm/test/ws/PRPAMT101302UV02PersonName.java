
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PRPA_MT101302UV02.Person.name complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PRPA_MT101302UV02.Person.name">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:hl7-org:v3}PN">
 *       &lt;attribute name="updateMode" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Person.name.updateMode" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PRPA_MT101302UV02.Person.name")
public class PRPAMT101302UV02PersonName
    extends PN
{

    @XmlAttribute(name = "updateMode")
    protected PRPAMT101302UV02PersonNameUpdateMode updateMode;

    /**
     * Gets the value of the updateMode property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT101302UV02PersonNameUpdateMode }
     *     
     */
    public PRPAMT101302UV02PersonNameUpdateMode getUpdateMode() {
        return updateMode;
    }

    /**
     * Sets the value of the updateMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT101302UV02PersonNameUpdateMode }
     *     
     */
    public void setUpdateMode(PRPAMT101302UV02PersonNameUpdateMode value) {
        this.updateMode = value;
    }

}
