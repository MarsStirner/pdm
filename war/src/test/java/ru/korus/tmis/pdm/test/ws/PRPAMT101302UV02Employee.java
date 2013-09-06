
package ru.korus.tmis.pdm.test.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PRPA_MT101302UV02.Employee complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PRPA_MT101302UV02.Employee">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{urn:hl7-org:v3}InfrastructureRootElements"/>
 *         &lt;element name="id" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Employee.id" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="code" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Employee.code" minOccurs="0"/>
 *         &lt;element name="addr" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Employee.addr" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="telecom" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Employee.telecom" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="statusCode" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Employee.statusCode" minOccurs="0"/>
 *         &lt;element name="effectiveTime" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Employee.effectiveTime" minOccurs="0"/>
 *         &lt;element name="jobTitleName" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Employee.jobTitleName" minOccurs="0"/>
 *         &lt;element name="jobClassCode" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Employee.jobClassCode" minOccurs="0"/>
 *         &lt;element name="occupationCode" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Employee.occupationCode" minOccurs="0"/>
 *         &lt;element name="employerOrganization" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Employee.employerOrganization"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{urn:hl7-org:v3}InfrastructureRootAttributes"/>
 *       &lt;attribute name="nullFlavor" type="{urn:hl7-org:v3}NullFlavor" />
 *       &lt;attribute name="classCode" use="required" type="{urn:hl7-org:v3}RoleClassEmployee" />
 *       &lt;attribute name="negationInd" type="{urn:hl7-org:v3}bl" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PRPA_MT101302UV02.Employee", propOrder = {
    "realmCode",
    "typeId",
    "templateId",
    "id",
    "code",
    "addr",
    "telecom",
    "statusCode",
    "effectiveTime",
    "jobTitleName",
    "jobClassCode",
    "occupationCode",
    "employerOrganization"
})
@XmlSeeAlso({
    PRPAMT101302UV02PersonAsEmployee.class
})
public class PRPAMT101302UV02Employee {

    protected List<CS> realmCode;
    protected II typeId;
    protected List<II> templateId;
    protected List<PRPAMT101302UV02EmployeeId> id;
    protected PRPAMT101302UV02EmployeeCode code;
    protected List<PRPAMT101302UV02EmployeeAddr> addr;
    protected List<PRPAMT101302UV02EmployeeTelecom> telecom;
    protected PRPAMT101302UV02EmployeeStatusCode statusCode;
    protected PRPAMT101302UV02EmployeeEffectiveTime effectiveTime;
    protected PRPAMT101302UV02EmployeeJobTitleName jobTitleName;
    protected PRPAMT101302UV02EmployeeJobClassCode jobClassCode;
    protected PRPAMT101302UV02EmployeeOccupationCode occupationCode;
    @XmlElement(required = true, nillable = true)
    protected PRPAMT101302UV02EmployeeEmployerOrganization employerOrganization;
    @XmlAttribute(name = "nullFlavor")
    protected NullFlavor nullFlavor;
    @XmlAttribute(name = "classCode", required = true)
    protected RoleClassEmployee classCode;
    @XmlAttribute(name = "negationInd")
    protected Boolean negationInd;

    /**
     * Gets the value of the realmCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the realmCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRealmCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CS }
     * 
     * 
     */
    public List<CS> getRealmCode() {
        if (realmCode == null) {
            realmCode = new ArrayList<CS>();
        }
        return this.realmCode;
    }

    /**
     * Gets the value of the typeId property.
     * 
     * @return
     *     possible object is
     *     {@link II }
     *     
     */
    public II getTypeId() {
        return typeId;
    }

    /**
     * Sets the value of the typeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link II }
     *     
     */
    public void setTypeId(II value) {
        this.typeId = value;
    }

    /**
     * Gets the value of the templateId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the templateId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTemplateId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link II }
     * 
     * 
     */
    public List<II> getTemplateId() {
        if (templateId == null) {
            templateId = new ArrayList<II>();
        }
        return this.templateId;
    }

    /**
     * Gets the value of the id property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the id property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PRPAMT101302UV02EmployeeId }
     * 
     * 
     */
    public List<PRPAMT101302UV02EmployeeId> getId() {
        if (id == null) {
            id = new ArrayList<PRPAMT101302UV02EmployeeId>();
        }
        return this.id;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT101302UV02EmployeeCode }
     *     
     */
    public PRPAMT101302UV02EmployeeCode getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT101302UV02EmployeeCode }
     *     
     */
    public void setCode(PRPAMT101302UV02EmployeeCode value) {
        this.code = value;
    }

    /**
     * Gets the value of the addr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the addr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddr().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PRPAMT101302UV02EmployeeAddr }
     * 
     * 
     */
    public List<PRPAMT101302UV02EmployeeAddr> getAddr() {
        if (addr == null) {
            addr = new ArrayList<PRPAMT101302UV02EmployeeAddr>();
        }
        return this.addr;
    }

    /**
     * Gets the value of the telecom property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the telecom property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTelecom().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PRPAMT101302UV02EmployeeTelecom }
     * 
     * 
     */
    public List<PRPAMT101302UV02EmployeeTelecom> getTelecom() {
        if (telecom == null) {
            telecom = new ArrayList<PRPAMT101302UV02EmployeeTelecom>();
        }
        return this.telecom;
    }

    /**
     * Gets the value of the statusCode property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT101302UV02EmployeeStatusCode }
     *     
     */
    public PRPAMT101302UV02EmployeeStatusCode getStatusCode() {
        return statusCode;
    }

    /**
     * Sets the value of the statusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT101302UV02EmployeeStatusCode }
     *     
     */
    public void setStatusCode(PRPAMT101302UV02EmployeeStatusCode value) {
        this.statusCode = value;
    }

    /**
     * Gets the value of the effectiveTime property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT101302UV02EmployeeEffectiveTime }
     *     
     */
    public PRPAMT101302UV02EmployeeEffectiveTime getEffectiveTime() {
        return effectiveTime;
    }

    /**
     * Sets the value of the effectiveTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT101302UV02EmployeeEffectiveTime }
     *     
     */
    public void setEffectiveTime(PRPAMT101302UV02EmployeeEffectiveTime value) {
        this.effectiveTime = value;
    }

    /**
     * Gets the value of the jobTitleName property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT101302UV02EmployeeJobTitleName }
     *     
     */
    public PRPAMT101302UV02EmployeeJobTitleName getJobTitleName() {
        return jobTitleName;
    }

    /**
     * Sets the value of the jobTitleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT101302UV02EmployeeJobTitleName }
     *     
     */
    public void setJobTitleName(PRPAMT101302UV02EmployeeJobTitleName value) {
        this.jobTitleName = value;
    }

    /**
     * Gets the value of the jobClassCode property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT101302UV02EmployeeJobClassCode }
     *     
     */
    public PRPAMT101302UV02EmployeeJobClassCode getJobClassCode() {
        return jobClassCode;
    }

    /**
     * Sets the value of the jobClassCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT101302UV02EmployeeJobClassCode }
     *     
     */
    public void setJobClassCode(PRPAMT101302UV02EmployeeJobClassCode value) {
        this.jobClassCode = value;
    }

    /**
     * Gets the value of the occupationCode property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT101302UV02EmployeeOccupationCode }
     *     
     */
    public PRPAMT101302UV02EmployeeOccupationCode getOccupationCode() {
        return occupationCode;
    }

    /**
     * Sets the value of the occupationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT101302UV02EmployeeOccupationCode }
     *     
     */
    public void setOccupationCode(PRPAMT101302UV02EmployeeOccupationCode value) {
        this.occupationCode = value;
    }

    /**
     * Gets the value of the employerOrganization property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT101302UV02EmployeeEmployerOrganization }
     *     
     */
    public PRPAMT101302UV02EmployeeEmployerOrganization getEmployerOrganization() {
        return employerOrganization;
    }

    /**
     * Sets the value of the employerOrganization property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT101302UV02EmployeeEmployerOrganization }
     *     
     */
    public void setEmployerOrganization(PRPAMT101302UV02EmployeeEmployerOrganization value) {
        this.employerOrganization = value;
    }

    /**
     * Gets the value of the nullFlavor property.
     * 
     * @return
     *     possible object is
     *     {@link NullFlavor }
     *     
     */
    public NullFlavor getNullFlavor() {
        return nullFlavor;
    }

    /**
     * Sets the value of the nullFlavor property.
     * 
     * @param value
     *     allowed object is
     *     {@link NullFlavor }
     *     
     */
    public void setNullFlavor(NullFlavor value) {
        this.nullFlavor = value;
    }

    /**
     * Gets the value of the classCode property.
     * 
     * @return
     *     possible object is
     *     {@link RoleClassEmployee }
     *     
     */
    public RoleClassEmployee getClassCode() {
        return classCode;
    }

    /**
     * Sets the value of the classCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link RoleClassEmployee }
     *     
     */
    public void setClassCode(RoleClassEmployee value) {
        this.classCode = value;
    }

    /**
     * Gets the value of the negationInd property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNegationInd() {
        return negationInd;
    }

    /**
     * Sets the value of the negationInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNegationInd(Boolean value) {
        this.negationInd = value;
    }

}
