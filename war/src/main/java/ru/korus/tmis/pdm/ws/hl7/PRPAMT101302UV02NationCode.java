
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PRPA_MT101302UV02.Nation.code complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PRPA_MT101302UV02.Nation.code">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:hl7-org:v3}CD">
 *       &lt;attribute name="updateMode" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Nation.code.updateMode" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PRPA_MT101302UV02.Nation.code")
public class PRPAMT101302UV02NationCode
    extends CD
{

    @XmlAttribute(name = "updateMode")
    protected PRPAMT101302UV02NationCodeUpdateMode updateMode;

    /**
     * Gets the value of the updateMode property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT101302UV02NationCodeUpdateMode }
     *     
     */
    public PRPAMT101302UV02NationCodeUpdateMode getUpdateMode() {
        return updateMode;
    }

    /**
     * Sets the value of the updateMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT101302UV02NationCodeUpdateMode }
     *     
     */
    public void setUpdateMode(PRPAMT101302UV02NationCodeUpdateMode value) {
        this.updateMode = value;
    }

}
