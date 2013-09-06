
package ru.korus.tmis.pdm.test.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PRPA_MT101302UV02.IdentifiedPerson complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PRPA_MT101302UV02.IdentifiedPerson">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{urn:hl7-org:v3}InfrastructureRootElements"/>
 *         &lt;element name="id" type="{urn:hl7-org:v3}PRPA_MT101302UV02.IdentifiedPerson.id" maxOccurs="unbounded"/>
 *         &lt;element name="addr" type="{urn:hl7-org:v3}PRPA_MT101302UV02.IdentifiedPerson.addr" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="telecom" type="{urn:hl7-org:v3}PRPA_MT101302UV02.IdentifiedPerson.telecom" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="statusCode" type="{urn:hl7-org:v3}PRPA_MT101302UV02.IdentifiedPerson.statusCode"/>
 *         &lt;element name="effectiveTime" type="{urn:hl7-org:v3}PRPA_MT101302UV02.IdentifiedPerson.effectiveTime" minOccurs="0"/>
 *         &lt;element name="confidentialityCode" type="{urn:hl7-org:v3}PRPA_MT101302UV02.IdentifiedPerson.confidentialityCode" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="identifiedPerson" type="{urn:hl7-org:v3}PRPA_MT101302UV02.IdentifiedPerson.identifiedPerson"/>
 *         &lt;element name="assigningOrganization" type="{urn:hl7-org:v3}PRPA_MT101302UV02.IdentifiedPerson.assigningOrganization" minOccurs="0"/>
 *         &lt;element name="subjectOf" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Subject4" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{urn:hl7-org:v3}InfrastructureRootAttributes"/>
 *       &lt;attribute name="classCode" use="required" type="{urn:hl7-org:v3}RoleClassIdentifiedEntity" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PRPA_MT101302UV02.IdentifiedPerson", propOrder = {
    "realmCode",
    "typeId",
    "templateId",
    "id",
    "addr",
    "telecom",
    "statusCode",
    "effectiveTime",
    "confidentialityCode",
    "identifiedPerson",
    "assigningOrganization",
    "subjectOf"
})
public class PRPAMT101302UV02IdentifiedPerson {

    protected List<CS> realmCode;
    protected II typeId;
    protected List<II> templateId;
    @XmlElement(required = true)
    protected List<PRPAMT101302UV02IdentifiedPersonId> id;
    protected List<PRPAMT101302UV02IdentifiedPersonAddr> addr;
    protected List<PRPAMT101302UV02IdentifiedPersonTelecom> telecom;
    @XmlElement(required = true)
    protected PRPAMT101302UV02IdentifiedPersonStatusCode statusCode;
    protected PRPAMT101302UV02IdentifiedPersonEffectiveTime effectiveTime;
    protected List<PRPAMT101302UV02IdentifiedPersonConfidentialityCode> confidentialityCode;
    @XmlElement(required = true, nillable = true)
    protected PRPAMT101302UV02IdentifiedPersonIdentifiedPerson identifiedPerson;
    @XmlElementRef(name = "assigningOrganization", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false)
    protected JAXBElement<PRPAMT101302UV02IdentifiedPersonAssigningOrganization> assigningOrganization;
    @XmlElement(nillable = true)
    protected List<PRPAMT101302UV02Subject4> subjectOf;
    @XmlAttribute(name = "classCode", required = true)
    protected RoleClassIdentifiedEntity classCode;

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
     * {@link PRPAMT101302UV02IdentifiedPersonId }
     * 
     * 
     */
    public List<PRPAMT101302UV02IdentifiedPersonId> getId() {
        if (id == null) {
            id = new ArrayList<PRPAMT101302UV02IdentifiedPersonId>();
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
     * {@link PRPAMT101302UV02IdentifiedPersonAddr }
     * 
     * 
     */
    public List<PRPAMT101302UV02IdentifiedPersonAddr> getAddr() {
        if (addr == null) {
            addr = new ArrayList<PRPAMT101302UV02IdentifiedPersonAddr>();
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
     * {@link PRPAMT101302UV02IdentifiedPersonTelecom }
     * 
     * 
     */
    public List<PRPAMT101302UV02IdentifiedPersonTelecom> getTelecom() {
        if (telecom == null) {
            telecom = new ArrayList<PRPAMT101302UV02IdentifiedPersonTelecom>();
        }
        return this.telecom;
    }

    /**
     * Gets the value of the statusCode property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT101302UV02IdentifiedPersonStatusCode }
     *     
     */
    public PRPAMT101302UV02IdentifiedPersonStatusCode getStatusCode() {
        return statusCode;
    }

    /**
     * Sets the value of the statusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT101302UV02IdentifiedPersonStatusCode }
     *     
     */
    public void setStatusCode(PRPAMT101302UV02IdentifiedPersonStatusCode value) {
        this.statusCode = value;
    }

    /**
     * Gets the value of the effectiveTime property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT101302UV02IdentifiedPersonEffectiveTime }
     *     
     */
    public PRPAMT101302UV02IdentifiedPersonEffectiveTime getEffectiveTime() {
        return effectiveTime;
    }

    /**
     * Sets the value of the effectiveTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT101302UV02IdentifiedPersonEffectiveTime }
     *     
     */
    public void setEffectiveTime(PRPAMT101302UV02IdentifiedPersonEffectiveTime value) {
        this.effectiveTime = value;
    }

    /**
     * Gets the value of the confidentialityCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the confidentialityCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConfidentialityCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PRPAMT101302UV02IdentifiedPersonConfidentialityCode }
     * 
     * 
     */
    public List<PRPAMT101302UV02IdentifiedPersonConfidentialityCode> getConfidentialityCode() {
        if (confidentialityCode == null) {
            confidentialityCode = new ArrayList<PRPAMT101302UV02IdentifiedPersonConfidentialityCode>();
        }
        return this.confidentialityCode;
    }

    /**
     * Gets the value of the identifiedPerson property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT101302UV02IdentifiedPersonIdentifiedPerson }
     *     
     */
    public PRPAMT101302UV02IdentifiedPersonIdentifiedPerson getIdentifiedPerson() {
        return identifiedPerson;
    }

    /**
     * Sets the value of the identifiedPerson property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT101302UV02IdentifiedPersonIdentifiedPerson }
     *     
     */
    public void setIdentifiedPerson(PRPAMT101302UV02IdentifiedPersonIdentifiedPerson value) {
        this.identifiedPerson = value;
    }

    /**
     * Gets the value of the assigningOrganization property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PRPAMT101302UV02IdentifiedPersonAssigningOrganization }{@code >}
     *     
     */
    public JAXBElement<PRPAMT101302UV02IdentifiedPersonAssigningOrganization> getAssigningOrganization() {
        return assigningOrganization;
    }

    /**
     * Sets the value of the assigningOrganization property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PRPAMT101302UV02IdentifiedPersonAssigningOrganization }{@code >}
     *     
     */
    public void setAssigningOrganization(JAXBElement<PRPAMT101302UV02IdentifiedPersonAssigningOrganization> value) {
        this.assigningOrganization = value;
    }

    /**
     * Gets the value of the subjectOf property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subjectOf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubjectOf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PRPAMT101302UV02Subject4 }
     * 
     * 
     */
    public List<PRPAMT101302UV02Subject4> getSubjectOf() {
        if (subjectOf == null) {
            subjectOf = new ArrayList<PRPAMT101302UV02Subject4>();
        }
        return this.subjectOf;
    }

    /**
     * Gets the value of the classCode property.
     * 
     * @return
     *     possible object is
     *     {@link RoleClassIdentifiedEntity }
     *     
     */
    public RoleClassIdentifiedEntity getClassCode() {
        return classCode;
    }

    /**
     * Sets the value of the classCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link RoleClassIdentifiedEntity }
     *     
     */
    public void setClassCode(RoleClassIdentifiedEntity value) {
        this.classCode = value;
    }

}
