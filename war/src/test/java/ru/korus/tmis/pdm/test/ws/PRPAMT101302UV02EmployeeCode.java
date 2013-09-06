
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PRPA_MT101302UV02.Employee.code complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PRPA_MT101302UV02.Employee.code">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:hl7-org:v3}CE">
 *       &lt;attribute name="updateMode" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Employee.code.updateMode" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PRPA_MT101302UV02.Employee.code")
public class PRPAMT101302UV02EmployeeCode
    extends CE
{

    @XmlAttribute(name = "updateMode")
    protected PRPAMT101302UV02EmployeeCodeUpdateMode updateMode;

    /**
     * Gets the value of the updateMode property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT101302UV02EmployeeCodeUpdateMode }
     *     
     */
    public PRPAMT101302UV02EmployeeCodeUpdateMode getUpdateMode() {
        return updateMode;
    }

    /**
     * Sets the value of the updateMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT101302UV02EmployeeCodeUpdateMode }
     *     
     */
    public void setUpdateMode(PRPAMT101302UV02EmployeeCodeUpdateMode value) {
        this.updateMode = value;
    }

}
