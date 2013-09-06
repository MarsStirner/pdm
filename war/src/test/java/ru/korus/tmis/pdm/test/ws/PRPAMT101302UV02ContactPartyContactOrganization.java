
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PRPA_MT101302UV02.ContactParty.contactOrganization complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PRPA_MT101302UV02.ContactParty.contactOrganization">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:hl7-org:v3}COCT_MT150007UV.Organization">
 *       &lt;attribute name="updateMode" type="{urn:hl7-org:v3}PRPA_MT101302UV02.ContactParty.contactOrganization.updateMode" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PRPA_MT101302UV02.ContactParty.contactOrganization")
public class PRPAMT101302UV02ContactPartyContactOrganization
    extends COCTMT150007UVOrganization
{

    @XmlAttribute(name = "updateMode")
    protected PRPAMT101302UV02ContactPartyContactOrganizationUpdateMode updateMode;

    /**
     * Gets the value of the updateMode property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT101302UV02ContactPartyContactOrganizationUpdateMode }
     *     
     */
    public PRPAMT101302UV02ContactPartyContactOrganizationUpdateMode getUpdateMode() {
        return updateMode;
    }

    /**
     * Sets the value of the updateMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT101302UV02ContactPartyContactOrganizationUpdateMode }
     *     
     */
    public void setUpdateMode(PRPAMT101302UV02ContactPartyContactOrganizationUpdateMode value) {
        this.updateMode = value;
    }

}
