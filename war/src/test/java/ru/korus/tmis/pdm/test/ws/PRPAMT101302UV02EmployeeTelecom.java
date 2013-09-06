
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PRPA_MT101302UV02.Employee.telecom complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PRPA_MT101302UV02.Employee.telecom">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:hl7-org:v3}TEL">
 *       &lt;attribute name="updateMode" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Employee.telecom.updateMode" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PRPA_MT101302UV02.Employee.telecom")
public class PRPAMT101302UV02EmployeeTelecom
    extends TEL
{

    @XmlAttribute(name = "updateMode")
    protected PRPAMT101302UV02EmployeeTelecomUpdateMode updateMode;

    /**
     * Gets the value of the updateMode property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT101302UV02EmployeeTelecomUpdateMode }
     *     
     */
    public PRPAMT101302UV02EmployeeTelecomUpdateMode getUpdateMode() {
        return updateMode;
    }

    /**
     * Sets the value of the updateMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT101302UV02EmployeeTelecomUpdateMode }
     *     
     */
    public void setUpdateMode(PRPAMT101302UV02EmployeeTelecomUpdateMode value) {
        this.updateMode = value;
    }

}
