
package ru.korus.tmis.pdm.test.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PRPA_MT101302UV02.Student complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PRPA_MT101302UV02.Student">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{urn:hl7-org:v3}InfrastructureRootElements"/>
 *         &lt;element name="id" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Student.id" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="addr" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Student.addr" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="telecom" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Student.telecom" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="statusCode" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Student.statusCode" minOccurs="0"/>
 *         &lt;element name="effectiveTime" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Student.effectiveTime" minOccurs="0"/>
 *         &lt;element name="schoolOrganization" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Student.schoolOrganization" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{urn:hl7-org:v3}InfrastructureRootAttributes"/>
 *       &lt;attribute name="nullFlavor" type="{urn:hl7-org:v3}NullFlavor" />
 *       &lt;attribute name="classCode" type="{urn:hl7-org:v3}RoleClass" fixed="STD" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PRPA_MT101302UV02.Student", propOrder = {
    "realmCode",
    "typeId",
    "templateId",
    "id",
    "addr",
    "telecom",
    "statusCode",
    "effectiveTime",
    "schoolOrganization"
})
@XmlSeeAlso({
    PRPAMT101302UV02PersonAsStudent.class
})
public class PRPAMT101302UV02Student {

    protected List<CS> realmCode;
    protected II typeId;
    protected List<II> templateId;
    protected List<PRPAMT101302UV02StudentId> id;
    protected List<PRPAMT101302UV02StudentAddr> addr;
    protected List<PRPAMT101302UV02StudentTelecom> telecom;
    protected PRPAMT101302UV02StudentStatusCode statusCode;
    protected PRPAMT101302UV02StudentEffectiveTime effectiveTime;
    @XmlElementRef(name = "schoolOrganization", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false)
    protected JAXBElement<PRPAMT101302UV02StudentSchoolOrganization> schoolOrganization;
    @XmlAttribute(name = "nullFlavor")
    protected NullFlavor nullFlavor;
    @XmlAttribute(name = "classCode")
    protected RoleClass classCode;

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
     * {@link PRPAMT101302UV02StudentId }
     * 
     * 
     */
    public List<PRPAMT101302UV02StudentId> getId() {
        if (id == null) {
            id = new ArrayList<PRPAMT101302UV02StudentId>();
        }
        return this.id;
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
     * {@link PRPAMT101302UV02StudentAddr }
     * 
     * 
     */
    public List<PRPAMT101302UV02StudentAddr> getAddr() {
        if (addr == null) {
            addr = new ArrayList<PRPAMT101302UV02StudentAddr>();
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
     * {@link PRPAMT101302UV02StudentTelecom }
     * 
     * 
     */
    public List<PRPAMT101302UV02StudentTelecom> getTelecom() {
        if (telecom == null) {
            telecom = new ArrayList<PRPAMT101302UV02StudentTelecom>();
        }
        return this.telecom;
    }

    /**
     * Gets the value of the statusCode property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT101302UV02StudentStatusCode }
     *     
     */
    public PRPAMT101302UV02StudentStatusCode getStatusCode() {
        return statusCode;
    }

    /**
     * Sets the value of the statusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT101302UV02StudentStatusCode }
     *     
     */
    public void setStatusCode(PRPAMT101302UV02StudentStatusCode value) {
        this.statusCode = value;
    }

    /**
     * Gets the value of the effectiveTime property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT101302UV02StudentEffectiveTime }
     *     
     */
    public PRPAMT101302UV02StudentEffectiveTime getEffectiveTime() {
        return effectiveTime;
    }

    /**
     * Sets the value of the effectiveTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT101302UV02StudentEffectiveTime }
     *     
     */
    public void setEffectiveTime(PRPAMT101302UV02StudentEffectiveTime value) {
        this.effectiveTime = value;
    }

    /**
     * Gets the value of the schoolOrganization property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PRPAMT101302UV02StudentSchoolOrganization }{@code >}
     *     
     */
    public JAXBElement<PRPAMT101302UV02StudentSchoolOrganization> getSchoolOrganization() {
        return schoolOrganization;
    }

    /**
     * Sets the value of the schoolOrganization property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PRPAMT101302UV02StudentSchoolOrganization }{@code >}
     *     
     */
    public void setSchoolOrganization(JAXBElement<PRPAMT101302UV02StudentSchoolOrganization> value) {
        this.schoolOrganization = value;
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
     *     {@link RoleClass }
     *     
     */
    public RoleClass getClassCode() {
        if (classCode == null) {
            return RoleClass.STD;
        } else {
            return classCode;
        }
    }

    /**
     * Sets the value of the classCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link RoleClass }
     *     
     */
    public void setClassCode(RoleClass value) {
        this.classCode = value;
    }

}
