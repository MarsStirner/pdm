
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
 * <p>Java class for PRPA_MT101302UV02.Citizen complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PRPA_MT101302UV02.Citizen">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{urn:hl7-org:v3}InfrastructureRootElements"/>
 *         &lt;element name="id" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Citizen.id" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="code" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Citizen.code" minOccurs="0"/>
 *         &lt;element name="effectiveTime" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Citizen.effectiveTime" minOccurs="0"/>
 *         &lt;element name="politicalNation" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Citizen.politicalNation"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{urn:hl7-org:v3}InfrastructureRootAttributes"/>
 *       &lt;attribute name="nullFlavor" type="{urn:hl7-org:v3}NullFlavor" />
 *       &lt;attribute name="classCode" type="{urn:hl7-org:v3}RoleClass" fixed="CIT" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PRPA_MT101302UV02.Citizen", propOrder = {
    "realmCode",
    "typeId",
    "templateId",
    "id",
    "code",
    "effectiveTime",
    "politicalNation"
})
@XmlSeeAlso({
    PRPAMT101302UV02PersonAsCitizen.class
})
public class PRPAMT101302UV02Citizen {

    protected List<CS> realmCode;
    protected II typeId;
    protected List<II> templateId;
    protected List<PRPAMT101302UV02CitizenId> id;
    protected PRPAMT101302UV02CitizenCode code;
    protected PRPAMT101302UV02CitizenEffectiveTime effectiveTime;
    @XmlElement(required = true)
    protected PRPAMT101302UV02CitizenPoliticalNation politicalNation;
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
     * {@link PRPAMT101302UV02CitizenId }
     * 
     * 
     */
    public List<PRPAMT101302UV02CitizenId> getId() {
        if (id == null) {
            id = new ArrayList<PRPAMT101302UV02CitizenId>();
        }
        return this.id;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT101302UV02CitizenCode }
     *     
     */
    public PRPAMT101302UV02CitizenCode getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT101302UV02CitizenCode }
     *     
     */
    public void setCode(PRPAMT101302UV02CitizenCode value) {
        this.code = value;
    }

    /**
     * Gets the value of the effectiveTime property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT101302UV02CitizenEffectiveTime }
     *     
     */
    public PRPAMT101302UV02CitizenEffectiveTime getEffectiveTime() {
        return effectiveTime;
    }

    /**
     * Sets the value of the effectiveTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT101302UV02CitizenEffectiveTime }
     *     
     */
    public void setEffectiveTime(PRPAMT101302UV02CitizenEffectiveTime value) {
        this.effectiveTime = value;
    }

    /**
     * Gets the value of the politicalNation property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT101302UV02CitizenPoliticalNation }
     *     
     */
    public PRPAMT101302UV02CitizenPoliticalNation getPoliticalNation() {
        return politicalNation;
    }

    /**
     * Sets the value of the politicalNation property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT101302UV02CitizenPoliticalNation }
     *     
     */
    public void setPoliticalNation(PRPAMT101302UV02CitizenPoliticalNation value) {
        this.politicalNation = value;
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
            return RoleClass.CIT;
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