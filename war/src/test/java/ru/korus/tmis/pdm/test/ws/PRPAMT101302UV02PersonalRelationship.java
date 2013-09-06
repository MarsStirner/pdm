
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
 * <p>Java class for PRPA_MT101302UV02.PersonalRelationship complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PRPA_MT101302UV02.PersonalRelationship">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{urn:hl7-org:v3}InfrastructureRootElements"/>
 *         &lt;element name="id" type="{urn:hl7-org:v3}PRPA_MT101302UV02.PersonalRelationship.id" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="code" type="{urn:hl7-org:v3}PRPA_MT101302UV02.PersonalRelationship.code"/>
 *         &lt;element name="addr" type="{urn:hl7-org:v3}PRPA_MT101302UV02.PersonalRelationship.addr" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="telecom" type="{urn:hl7-org:v3}PRPA_MT101302UV02.PersonalRelationship.telecom" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="statusCode" type="{urn:hl7-org:v3}PRPA_MT101302UV02.PersonalRelationship.statusCode" minOccurs="0"/>
 *         &lt;element name="effectiveTime" type="{urn:hl7-org:v3}PRPA_MT101302UV02.PersonalRelationship.effectiveTime" minOccurs="0"/>
 *         &lt;element name="relationshipHolder" type="{urn:hl7-org:v3}COCT_MT030207UV07.Person"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{urn:hl7-org:v3}InfrastructureRootAttributes"/>
 *       &lt;attribute name="nullFlavor" type="{urn:hl7-org:v3}NullFlavor" />
 *       &lt;attribute name="classCode" type="{urn:hl7-org:v3}RoleClass" fixed="PRS" />
 *       &lt;attribute name="negationInd" type="{urn:hl7-org:v3}bl" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PRPA_MT101302UV02.PersonalRelationship", propOrder = {
    "realmCode",
    "typeId",
    "templateId",
    "id",
    "code",
    "addr",
    "telecom",
    "statusCode",
    "effectiveTime",
    "relationshipHolder"
})
@XmlSeeAlso({
    PRPAMT101302UV02PersonPersonalRelationship.class
})
public class PRPAMT101302UV02PersonalRelationship {

    protected List<CS> realmCode;
    protected II typeId;
    protected List<II> templateId;
    protected List<PRPAMT101302UV02PersonalRelationshipId> id;
    @XmlElement(required = true)
    protected PRPAMT101302UV02PersonalRelationshipCode code;
    protected List<PRPAMT101302UV02PersonalRelationshipAddr> addr;
    protected List<PRPAMT101302UV02PersonalRelationshipTelecom> telecom;
    protected PRPAMT101302UV02PersonalRelationshipStatusCode statusCode;
    protected PRPAMT101302UV02PersonalRelationshipEffectiveTime effectiveTime;
    @XmlElement(required = true, nillable = true)
    protected COCTMT030207UV07Person relationshipHolder;
    @XmlAttribute(name = "nullFlavor")
    protected NullFlavor nullFlavor;
    @XmlAttribute(name = "classCode")
    protected RoleClass classCode;
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
     * {@link PRPAMT101302UV02PersonalRelationshipId }
     * 
     * 
     */
    public List<PRPAMT101302UV02PersonalRelationshipId> getId() {
        if (id == null) {
            id = new ArrayList<PRPAMT101302UV02PersonalRelationshipId>();
        }
        return this.id;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT101302UV02PersonalRelationshipCode }
     *     
     */
    public PRPAMT101302UV02PersonalRelationshipCode getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT101302UV02PersonalRelationshipCode }
     *     
     */
    public void setCode(PRPAMT101302UV02PersonalRelationshipCode value) {
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
     * {@link PRPAMT101302UV02PersonalRelationshipAddr }
     * 
     * 
     */
    public List<PRPAMT101302UV02PersonalRelationshipAddr> getAddr() {
        if (addr == null) {
            addr = new ArrayList<PRPAMT101302UV02PersonalRelationshipAddr>();
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
     * {@link PRPAMT101302UV02PersonalRelationshipTelecom }
     * 
     * 
     */
    public List<PRPAMT101302UV02PersonalRelationshipTelecom> getTelecom() {
        if (telecom == null) {
            telecom = new ArrayList<PRPAMT101302UV02PersonalRelationshipTelecom>();
        }
        return this.telecom;
    }

    /**
     * Gets the value of the statusCode property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT101302UV02PersonalRelationshipStatusCode }
     *     
     */
    public PRPAMT101302UV02PersonalRelationshipStatusCode getStatusCode() {
        return statusCode;
    }

    /**
     * Sets the value of the statusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT101302UV02PersonalRelationshipStatusCode }
     *     
     */
    public void setStatusCode(PRPAMT101302UV02PersonalRelationshipStatusCode value) {
        this.statusCode = value;
    }

    /**
     * Gets the value of the effectiveTime property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT101302UV02PersonalRelationshipEffectiveTime }
     *     
     */
    public PRPAMT101302UV02PersonalRelationshipEffectiveTime getEffectiveTime() {
        return effectiveTime;
    }

    /**
     * Sets the value of the effectiveTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT101302UV02PersonalRelationshipEffectiveTime }
     *     
     */
    public void setEffectiveTime(PRPAMT101302UV02PersonalRelationshipEffectiveTime value) {
        this.effectiveTime = value;
    }

    /**
     * Gets the value of the relationshipHolder property.
     * 
     * @return
     *     possible object is
     *     {@link COCTMT030207UV07Person }
     *     
     */
    public COCTMT030207UV07Person getRelationshipHolder() {
        return relationshipHolder;
    }

    /**
     * Sets the value of the relationshipHolder property.
     * 
     * @param value
     *     allowed object is
     *     {@link COCTMT030207UV07Person }
     *     
     */
    public void setRelationshipHolder(COCTMT030207UV07Person value) {
        this.relationshipHolder = value;
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
            return RoleClass.PRS;
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
