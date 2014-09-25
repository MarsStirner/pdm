
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PRPA_MT101302UV02.ContactParty.code complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PRPA_MT101302UV02.ContactParty.code">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:hl7-org:v3}CE">
 *       &lt;attribute name="updateMode" type="{urn:hl7-org:v3}PRPA_MT101302UV02.ContactParty.code.updateMode" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PRPA_MT101302UV02.ContactParty.code")
public class PRPAMT101302UV02ContactPartyCode
    extends CE
{

    @XmlAttribute(name = "updateMode")
    protected PRPAMT101302UV02ContactPartyCodeUpdateMode updateMode;

    /**
     * Gets the value of the updateMode property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT101302UV02ContactPartyCodeUpdateMode }
     *     
     */
    public PRPAMT101302UV02ContactPartyCodeUpdateMode getUpdateMode() {
        return updateMode;
    }

    /**
     * Sets the value of the updateMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT101302UV02ContactPartyCodeUpdateMode }
     *     
     */
    public void setUpdateMode(PRPAMT101302UV02ContactPartyCodeUpdateMode value) {
        this.updateMode = value;
    }

}
