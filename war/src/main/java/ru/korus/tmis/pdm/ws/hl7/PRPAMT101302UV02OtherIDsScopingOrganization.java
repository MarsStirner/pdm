
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PRPA_MT101302UV02.OtherIDs.scopingOrganization complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PRPA_MT101302UV02.OtherIDs.scopingOrganization">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:hl7-org:v3}COCT_MT150002UV01.Organization">
 *       &lt;attribute name="updateMode" type="{urn:hl7-org:v3}PRPA_MT101302UV02.OtherIDs.scopingOrganization.updateMode" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PRPA_MT101302UV02.OtherIDs.scopingOrganization")
public class PRPAMT101302UV02OtherIDsScopingOrganization
    extends COCTMT150002UV01Organization
{

    @XmlAttribute(name = "updateMode")
    protected PRPAMT101302UV02OtherIDsScopingOrganizationUpdateMode updateMode;

    /**
     * Gets the value of the updateMode property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT101302UV02OtherIDsScopingOrganizationUpdateMode }
     *     
     */
    public PRPAMT101302UV02OtherIDsScopingOrganizationUpdateMode getUpdateMode() {
        return updateMode;
    }

    /**
     * Sets the value of the updateMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT101302UV02OtherIDsScopingOrganizationUpdateMode }
     *     
     */
    public void setUpdateMode(PRPAMT101302UV02OtherIDsScopingOrganizationUpdateMode value) {
        this.updateMode = value;
    }

}
