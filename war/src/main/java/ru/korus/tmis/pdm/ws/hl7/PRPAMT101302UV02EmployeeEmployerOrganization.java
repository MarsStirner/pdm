
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PRPA_MT101302UV02.Employee.employerOrganization complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PRPA_MT101302UV02.Employee.employerOrganization">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:hl7-org:v3}COCT_MT150007UV.Organization">
 *       &lt;attribute name="updateMode" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Employee.employerOrganization.updateMode" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PRPA_MT101302UV02.Employee.employerOrganization")
public class PRPAMT101302UV02EmployeeEmployerOrganization
    extends COCTMT150007UVOrganization
{

    @XmlAttribute(name = "updateMode")
    protected PRPAMT101302UV02EmployeeEmployerOrganizationUpdateMode updateMode;

    /**
     * Gets the value of the updateMode property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT101302UV02EmployeeEmployerOrganizationUpdateMode }
     *     
     */
    public PRPAMT101302UV02EmployeeEmployerOrganizationUpdateMode getUpdateMode() {
        return updateMode;
    }

    /**
     * Sets the value of the updateMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT101302UV02EmployeeEmployerOrganizationUpdateMode }
     *     
     */
    public void setUpdateMode(PRPAMT101302UV02EmployeeEmployerOrganizationUpdateMode value) {
        this.updateMode = value;
    }

}
