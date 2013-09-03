
package ru.korus.tmis.pdm.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PRPA_MT101302UV02.Person complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PRPA_MT101302UV02.Person">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{urn:hl7-org:v3}InfrastructureRootElements"/>
 *         &lt;element name="id" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Person.id" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="name" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Person.name" maxOccurs="unbounded"/>
 *         &lt;element name="desc" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Person.desc" minOccurs="0"/>
 *         &lt;element name="telecom" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Person.telecom" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="administrativeGenderCode" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Person.administrativeGenderCode" minOccurs="0"/>
 *         &lt;element name="birthTime" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Person.birthTime" minOccurs="0"/>
 *         &lt;element name="deceasedInd" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Person.deceasedInd" minOccurs="0"/>
 *         &lt;element name="deceasedTime" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Person.deceasedTime" minOccurs="0"/>
 *         &lt;element name="multipleBirthInd" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Person.multipleBirthInd" minOccurs="0"/>
 *         &lt;element name="multipleBirthOrderNumber" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Person.multipleBirthOrderNumber" minOccurs="0"/>
 *         &lt;element name="organDonorInd" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Person.organDonorInd" minOccurs="0"/>
 *         &lt;element name="addr" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Person.addr" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="maritalStatusCode" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Person.maritalStatusCode" minOccurs="0"/>
 *         &lt;element name="asEmployee" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Person.asEmployee" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="asCitizen" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Person.asCitizen" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="asStudent" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Person.asStudent" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="asMember" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Member" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="asOtherIDs" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Person.asOtherIDs" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="asRole" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Person.asRole" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="contactParty" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Person.contactParty" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="guardian" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Person.guardian" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="personalRelationship" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Person.personalRelationship" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="birthPlace" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Person.birthPlace" minOccurs="0"/>
 *         &lt;element name="languageCommunication" type="{urn:hl7-org:v3}PRPA_MT101302UV02.LanguageCommunication" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{urn:hl7-org:v3}InfrastructureRootAttributes"/>
 *       &lt;attribute name="nullFlavor" type="{urn:hl7-org:v3}NullFlavor" />
 *       &lt;attribute name="classCode" type="{urn:hl7-org:v3}EntityClass" fixed="PSN" />
 *       &lt;attribute name="determinerCode" type="{urn:hl7-org:v3}EntityDeterminer" fixed="INSTANCE" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PRPA_MT101302UV02.Person", propOrder = {
    "realmCode",
    "typeId",
    "templateId",
    "id",
    "name",
    "desc",
    "telecom",
    "administrativeGenderCode",
    "birthTime",
    "deceasedInd",
    "deceasedTime",
    "multipleBirthInd",
    "multipleBirthOrderNumber",
    "organDonorInd",
    "addr",
    "maritalStatusCode",
    "asEmployee",
    "asCitizen",
    "asStudent",
    "asMember",
    "asOtherIDs",
    "asRole",
    "contactParty",
    "guardian",
    "personalRelationship",
    "birthPlace",
    "languageCommunication"
})
@XmlSeeAlso({
    PRPAMT101302UV02IdentifiedPersonIdentifiedPerson.class
})
public class PRPAMT101302UV02Person {

    protected List<CS> realmCode;
    protected II typeId;
    protected List<II> templateId;
    protected List<PRPAMT101302UV02PersonId> id;
    @XmlElement(required = true)
    protected List<PRPAMT101302UV02PersonName> name;
    protected PRPAMT101302UV02PersonDesc desc;
    protected List<PRPAMT101302UV02PersonTelecom> telecom;
    protected PRPAMT101302UV02PersonAdministrativeGenderCode administrativeGenderCode;
    protected PRPAMT101302UV02PersonBirthTime birthTime;
    protected PRPAMT101302UV02PersonDeceasedInd deceasedInd;
    protected PRPAMT101302UV02PersonDeceasedTime deceasedTime;
    protected PRPAMT101302UV02PersonMultipleBirthInd multipleBirthInd;
    protected PRPAMT101302UV02PersonMultipleBirthOrderNumber multipleBirthOrderNumber;
    protected PRPAMT101302UV02PersonOrganDonorInd organDonorInd;
    protected List<PRPAMT101302UV02PersonAddr> addr;
    protected PRPAMT101302UV02PersonMaritalStatusCode maritalStatusCode;
    @XmlElement(nillable = true)
    protected List<PRPAMT101302UV02PersonAsEmployee> asEmployee;
    @XmlElement(nillable = true)
    protected List<PRPAMT101302UV02PersonAsCitizen> asCitizen;
    @XmlElement(nillable = true)
    protected List<PRPAMT101302UV02PersonAsStudent> asStudent;
    @XmlElement(nillable = true)
    protected List<PRPAMT101302UV02Member> asMember;
    @XmlElement(nillable = true)
    protected List<PRPAMT101302UV02PersonAsOtherIDs> asOtherIDs;
    @XmlElement(nillable = true)
    protected List<PRPAMT101302UV02PersonAsRole> asRole;
    @XmlElement(nillable = true)
    protected List<PRPAMT101302UV02PersonContactParty> contactParty;
    @XmlElement(nillable = true)
    protected List<PRPAMT101302UV02PersonGuardian> guardian;
    @XmlElement(nillable = true)
    protected List<PRPAMT101302UV02PersonPersonalRelationship> personalRelationship;
    @XmlElementRef(name = "birthPlace", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false)
    protected JAXBElement<PRPAMT101302UV02PersonBirthPlace> birthPlace;
    @XmlElement(nillable = true)
    protected List<PRPAMT101302UV02LanguageCommunication> languageCommunication;
    @XmlAttribute(name = "nullFlavor")
    protected NullFlavor nullFlavor;
    @XmlAttribute(name = "classCode")
    protected EntityClass classCode;
    @XmlAttribute(name = "determinerCode")
    protected EntityDeterminer determinerCode;

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
     * {@link PRPAMT101302UV02PersonId }
     * 
     * 
     */
    public List<PRPAMT101302UV02PersonId> getId() {
        if (id == null) {
            id = new ArrayList<PRPAMT101302UV02PersonId>();
        }
        return this.id;
    }

    /**
     * Gets the value of the name property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the name property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PRPAMT101302UV02PersonName }
     * 
     * 
     */
    public List<PRPAMT101302UV02PersonName> getName() {
        if (name == null) {
            name = new ArrayList<PRPAMT101302UV02PersonName>();
        }
        return this.name;
    }

    /**
     * Gets the value of the desc property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT101302UV02PersonDesc }
     *     
     */
    public PRPAMT101302UV02PersonDesc getDesc() {
        return desc;
    }

    /**
     * Sets the value of the desc property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT101302UV02PersonDesc }
     *     
     */
    public void setDesc(PRPAMT101302UV02PersonDesc value) {
        this.desc = value;
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
     * {@link PRPAMT101302UV02PersonTelecom }
     * 
     * 
     */
    public List<PRPAMT101302UV02PersonTelecom> getTelecom() {
        if (telecom == null) {
            telecom = new ArrayList<PRPAMT101302UV02PersonTelecom>();
        }
        return this.telecom;
    }

    /**
     * Gets the value of the administrativeGenderCode property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT101302UV02PersonAdministrativeGenderCode }
     *     
     */
    public PRPAMT101302UV02PersonAdministrativeGenderCode getAdministrativeGenderCode() {
        return administrativeGenderCode;
    }

    /**
     * Sets the value of the administrativeGenderCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT101302UV02PersonAdministrativeGenderCode }
     *     
     */
    public void setAdministrativeGenderCode(PRPAMT101302UV02PersonAdministrativeGenderCode value) {
        this.administrativeGenderCode = value;
    }

    /**
     * Gets the value of the birthTime property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT101302UV02PersonBirthTime }
     *     
     */
    public PRPAMT101302UV02PersonBirthTime getBirthTime() {
        return birthTime;
    }

    /**
     * Sets the value of the birthTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT101302UV02PersonBirthTime }
     *     
     */
    public void setBirthTime(PRPAMT101302UV02PersonBirthTime value) {
        this.birthTime = value;
    }

    /**
     * Gets the value of the deceasedInd property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT101302UV02PersonDeceasedInd }
     *     
     */
    public PRPAMT101302UV02PersonDeceasedInd getDeceasedInd() {
        return deceasedInd;
    }

    /**
     * Sets the value of the deceasedInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT101302UV02PersonDeceasedInd }
     *     
     */
    public void setDeceasedInd(PRPAMT101302UV02PersonDeceasedInd value) {
        this.deceasedInd = value;
    }

    /**
     * Gets the value of the deceasedTime property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT101302UV02PersonDeceasedTime }
     *     
     */
    public PRPAMT101302UV02PersonDeceasedTime getDeceasedTime() {
        return deceasedTime;
    }

    /**
     * Sets the value of the deceasedTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT101302UV02PersonDeceasedTime }
     *     
     */
    public void setDeceasedTime(PRPAMT101302UV02PersonDeceasedTime value) {
        this.deceasedTime = value;
    }

    /**
     * Gets the value of the multipleBirthInd property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT101302UV02PersonMultipleBirthInd }
     *     
     */
    public PRPAMT101302UV02PersonMultipleBirthInd getMultipleBirthInd() {
        return multipleBirthInd;
    }

    /**
     * Sets the value of the multipleBirthInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT101302UV02PersonMultipleBirthInd }
     *     
     */
    public void setMultipleBirthInd(PRPAMT101302UV02PersonMultipleBirthInd value) {
        this.multipleBirthInd = value;
    }

    /**
     * Gets the value of the multipleBirthOrderNumber property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT101302UV02PersonMultipleBirthOrderNumber }
     *     
     */
    public PRPAMT101302UV02PersonMultipleBirthOrderNumber getMultipleBirthOrderNumber() {
        return multipleBirthOrderNumber;
    }

    /**
     * Sets the value of the multipleBirthOrderNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT101302UV02PersonMultipleBirthOrderNumber }
     *     
     */
    public void setMultipleBirthOrderNumber(PRPAMT101302UV02PersonMultipleBirthOrderNumber value) {
        this.multipleBirthOrderNumber = value;
    }

    /**
     * Gets the value of the organDonorInd property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT101302UV02PersonOrganDonorInd }
     *     
     */
    public PRPAMT101302UV02PersonOrganDonorInd getOrganDonorInd() {
        return organDonorInd;
    }

    /**
     * Sets the value of the organDonorInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT101302UV02PersonOrganDonorInd }
     *     
     */
    public void setOrganDonorInd(PRPAMT101302UV02PersonOrganDonorInd value) {
        this.organDonorInd = value;
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
     * {@link PRPAMT101302UV02PersonAddr }
     * 
     * 
     */
    public List<PRPAMT101302UV02PersonAddr> getAddr() {
        if (addr == null) {
            addr = new ArrayList<PRPAMT101302UV02PersonAddr>();
        }
        return this.addr;
    }

    /**
     * Gets the value of the maritalStatusCode property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT101302UV02PersonMaritalStatusCode }
     *     
     */
    public PRPAMT101302UV02PersonMaritalStatusCode getMaritalStatusCode() {
        return maritalStatusCode;
    }

    /**
     * Sets the value of the maritalStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT101302UV02PersonMaritalStatusCode }
     *     
     */
    public void setMaritalStatusCode(PRPAMT101302UV02PersonMaritalStatusCode value) {
        this.maritalStatusCode = value;
    }

    /**
     * Gets the value of the asEmployee property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the asEmployee property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAsEmployee().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PRPAMT101302UV02PersonAsEmployee }
     * 
     * 
     */
    public List<PRPAMT101302UV02PersonAsEmployee> getAsEmployee() {
        if (asEmployee == null) {
            asEmployee = new ArrayList<PRPAMT101302UV02PersonAsEmployee>();
        }
        return this.asEmployee;
    }

    /**
     * Gets the value of the asCitizen property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the asCitizen property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAsCitizen().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PRPAMT101302UV02PersonAsCitizen }
     * 
     * 
     */
    public List<PRPAMT101302UV02PersonAsCitizen> getAsCitizen() {
        if (asCitizen == null) {
            asCitizen = new ArrayList<PRPAMT101302UV02PersonAsCitizen>();
        }
        return this.asCitizen;
    }

    /**
     * Gets the value of the asStudent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the asStudent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAsStudent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PRPAMT101302UV02PersonAsStudent }
     * 
     * 
     */
    public List<PRPAMT101302UV02PersonAsStudent> getAsStudent() {
        if (asStudent == null) {
            asStudent = new ArrayList<PRPAMT101302UV02PersonAsStudent>();
        }
        return this.asStudent;
    }

    /**
     * Gets the value of the asMember property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the asMember property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAsMember().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PRPAMT101302UV02Member }
     * 
     * 
     */
    public List<PRPAMT101302UV02Member> getAsMember() {
        if (asMember == null) {
            asMember = new ArrayList<PRPAMT101302UV02Member>();
        }
        return this.asMember;
    }

    /**
     * Gets the value of the asOtherIDs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the asOtherIDs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAsOtherIDs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PRPAMT101302UV02PersonAsOtherIDs }
     * 
     * 
     */
    public List<PRPAMT101302UV02PersonAsOtherIDs> getAsOtherIDs() {
        if (asOtherIDs == null) {
            asOtherIDs = new ArrayList<PRPAMT101302UV02PersonAsOtherIDs>();
        }
        return this.asOtherIDs;
    }

    /**
     * Gets the value of the asRole property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the asRole property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAsRole().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PRPAMT101302UV02PersonAsRole }
     * 
     * 
     */
    public List<PRPAMT101302UV02PersonAsRole> getAsRole() {
        if (asRole == null) {
            asRole = new ArrayList<PRPAMT101302UV02PersonAsRole>();
        }
        return this.asRole;
    }

    /**
     * Gets the value of the contactParty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contactParty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContactParty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PRPAMT101302UV02PersonContactParty }
     * 
     * 
     */
    public List<PRPAMT101302UV02PersonContactParty> getContactParty() {
        if (contactParty == null) {
            contactParty = new ArrayList<PRPAMT101302UV02PersonContactParty>();
        }
        return this.contactParty;
    }

    /**
     * Gets the value of the guardian property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the guardian property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGuardian().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PRPAMT101302UV02PersonGuardian }
     * 
     * 
     */
    public List<PRPAMT101302UV02PersonGuardian> getGuardian() {
        if (guardian == null) {
            guardian = new ArrayList<PRPAMT101302UV02PersonGuardian>();
        }
        return this.guardian;
    }

    /**
     * Gets the value of the personalRelationship property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the personalRelationship property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonalRelationship().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PRPAMT101302UV02PersonPersonalRelationship }
     * 
     * 
     */
    public List<PRPAMT101302UV02PersonPersonalRelationship> getPersonalRelationship() {
        if (personalRelationship == null) {
            personalRelationship = new ArrayList<PRPAMT101302UV02PersonPersonalRelationship>();
        }
        return this.personalRelationship;
    }

    /**
     * Gets the value of the birthPlace property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PRPAMT101302UV02PersonBirthPlace }{@code >}
     *     
     */
    public JAXBElement<PRPAMT101302UV02PersonBirthPlace> getBirthPlace() {
        return birthPlace;
    }

    /**
     * Sets the value of the birthPlace property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PRPAMT101302UV02PersonBirthPlace }{@code >}
     *     
     */
    public void setBirthPlace(JAXBElement<PRPAMT101302UV02PersonBirthPlace> value) {
        this.birthPlace = value;
    }

    /**
     * Gets the value of the languageCommunication property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the languageCommunication property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLanguageCommunication().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PRPAMT101302UV02LanguageCommunication }
     * 
     * 
     */
    public List<PRPAMT101302UV02LanguageCommunication> getLanguageCommunication() {
        if (languageCommunication == null) {
            languageCommunication = new ArrayList<PRPAMT101302UV02LanguageCommunication>();
        }
        return this.languageCommunication;
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
     *     {@link EntityClass }
     *     
     */
    public EntityClass getClassCode() {
        if (classCode == null) {
            return EntityClass.PSN;
        } else {
            return classCode;
        }
    }

    /**
     * Sets the value of the classCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityClass }
     *     
     */
    public void setClassCode(EntityClass value) {
        this.classCode = value;
    }

    /**
     * Gets the value of the determinerCode property.
     * 
     * @return
     *     possible object is
     *     {@link EntityDeterminer }
     *     
     */
    public EntityDeterminer getDeterminerCode() {
        if (determinerCode == null) {
            return EntityDeterminer.INSTANCE;
        } else {
            return determinerCode;
        }
    }

    /**
     * Sets the value of the determinerCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityDeterminer }
     *     
     */
    public void setDeterminerCode(EntityDeterminer value) {
        this.determinerCode = value;
    }

}
