
package ru.korus.tmis.pdm.test.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PRPA_MT101306UV02.ParameterList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PRPA_MT101306UV02.ParameterList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{urn:hl7-org:v3}InfrastructureRootElements"/>
 *         &lt;element name="id" type="{urn:hl7-org:v3}II" minOccurs="0"/>
 *         &lt;element name="groupId" type="{urn:hl7-org:v3}PRPA_MT101306UV02.GroupId" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="identifiedPersonAddress" type="{urn:hl7-org:v3}PRPA_MT101306UV02.IdentifiedPersonAddress" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="identifiedPersonStatusCode" type="{urn:hl7-org:v3}PRPA_MT101306UV02.IdentifiedPersonStatusCode" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="identifiedPersonTelecom" type="{urn:hl7-org:v3}PRPA_MT101306UV02.IdentifiedPersonTelecom" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="mothersMaidenName" type="{urn:hl7-org:v3}PRPA_MT101306UV02.MothersMaidenName" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="otherIDsScopingOrganization" type="{urn:hl7-org:v3}PRPA_MT101306UV02.OtherIDsScopingOrganization" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="personAdministrativeGender" type="{urn:hl7-org:v3}PRPA_MT101306UV02.PersonAdministrativeGender" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="personBirthPlaceAddress" type="{urn:hl7-org:v3}PRPA_MT101306UV02.PersonBirthPlaceAddress" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="personBirthPlaceName" type="{urn:hl7-org:v3}PRPA_MT101306UV02.PersonBirthPlaceName" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="personBirthTime" type="{urn:hl7-org:v3}PRPA_MT101306UV02.PersonBirthTime" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="personDeceased" type="{urn:hl7-org:v3}PRPA_MT101306UV02.PersonDeceased" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="personDeceasedTime" type="{urn:hl7-org:v3}PRPA_MT101306UV02.PersonDeceasedTime" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="personId" type="{urn:hl7-org:v3}PRPA_MT101306UV02.PersonId" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="personName" type="{urn:hl7-org:v3}PRPA_MT101306UV02.PersonName" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="personRoleId" type="{urn:hl7-org:v3}PRPA_MT101306UV02.PersonRoleId" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{urn:hl7-org:v3}InfrastructureRootAttributes"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PRPA_MT101306UV02.ParameterList", propOrder = {
    "realmCode",
    "typeId",
    "templateId",
    "id",
    "groupId",
    "identifiedPersonAddress",
    "identifiedPersonStatusCode",
    "identifiedPersonTelecom",
    "mothersMaidenName",
    "otherIDsScopingOrganization",
    "personAdministrativeGender",
    "personBirthPlaceAddress",
    "personBirthPlaceName",
    "personBirthTime",
    "personDeceased",
    "personDeceasedTime",
    "personId",
    "personName",
    "personRoleId"
})
public class PRPAMT101306UV02ParameterList {

    protected List<CS> realmCode;
    protected II typeId;
    protected List<II> templateId;
    protected II id;
    @XmlElement(nillable = true)
    protected List<PRPAMT101306UV02GroupId> groupId;
    @XmlElement(nillable = true)
    protected List<PRPAMT101306UV02IdentifiedPersonAddress> identifiedPersonAddress;
    @XmlElement(nillable = true)
    protected List<PRPAMT101306UV02IdentifiedPersonStatusCode> identifiedPersonStatusCode;
    @XmlElement(nillable = true)
    protected List<PRPAMT101306UV02IdentifiedPersonTelecom> identifiedPersonTelecom;
    @XmlElement(nillable = true)
    protected List<PRPAMT101306UV02MothersMaidenName> mothersMaidenName;
    @XmlElement(nillable = true)
    protected List<PRPAMT101306UV02OtherIDsScopingOrganization> otherIDsScopingOrganization;
    @XmlElement(nillable = true)
    protected List<PRPAMT101306UV02PersonAdministrativeGender> personAdministrativeGender;
    @XmlElement(nillable = true)
    protected List<PRPAMT101306UV02PersonBirthPlaceAddress> personBirthPlaceAddress;
    @XmlElement(nillable = true)
    protected List<PRPAMT101306UV02PersonBirthPlaceName> personBirthPlaceName;
    @XmlElement(nillable = true)
    protected List<PRPAMT101306UV02PersonBirthTime> personBirthTime;
    @XmlElement(nillable = true)
    protected List<PRPAMT101306UV02PersonDeceased> personDeceased;
    @XmlElement(nillable = true)
    protected List<PRPAMT101306UV02PersonDeceasedTime> personDeceasedTime;
    @XmlElement(nillable = true)
    protected List<PRPAMT101306UV02PersonId> personId;
    @XmlElement(nillable = true)
    protected List<PRPAMT101306UV02PersonName> personName;
    @XmlElement(nillable = true)
    protected List<PRPAMT101306UV02PersonRoleId> personRoleId;

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
     * @return
     *     possible object is
     *     {@link II }
     *     
     */
    public II getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link II }
     *     
     */
    public void setId(II value) {
        this.id = value;
    }

    /**
     * Gets the value of the groupId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the groupId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGroupId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PRPAMT101306UV02GroupId }
     * 
     * 
     */
    public List<PRPAMT101306UV02GroupId> getGroupId() {
        if (groupId == null) {
            groupId = new ArrayList<PRPAMT101306UV02GroupId>();
        }
        return this.groupId;
    }

    /**
     * Gets the value of the identifiedPersonAddress property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the identifiedPersonAddress property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIdentifiedPersonAddress().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PRPAMT101306UV02IdentifiedPersonAddress }
     * 
     * 
     */
    public List<PRPAMT101306UV02IdentifiedPersonAddress> getIdentifiedPersonAddress() {
        if (identifiedPersonAddress == null) {
            identifiedPersonAddress = new ArrayList<PRPAMT101306UV02IdentifiedPersonAddress>();
        }
        return this.identifiedPersonAddress;
    }

    /**
     * Gets the value of the identifiedPersonStatusCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the identifiedPersonStatusCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIdentifiedPersonStatusCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PRPAMT101306UV02IdentifiedPersonStatusCode }
     * 
     * 
     */
    public List<PRPAMT101306UV02IdentifiedPersonStatusCode> getIdentifiedPersonStatusCode() {
        if (identifiedPersonStatusCode == null) {
            identifiedPersonStatusCode = new ArrayList<PRPAMT101306UV02IdentifiedPersonStatusCode>();
        }
        return this.identifiedPersonStatusCode;
    }

    /**
     * Gets the value of the identifiedPersonTelecom property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the identifiedPersonTelecom property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIdentifiedPersonTelecom().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PRPAMT101306UV02IdentifiedPersonTelecom }
     * 
     * 
     */
    public List<PRPAMT101306UV02IdentifiedPersonTelecom> getIdentifiedPersonTelecom() {
        if (identifiedPersonTelecom == null) {
            identifiedPersonTelecom = new ArrayList<PRPAMT101306UV02IdentifiedPersonTelecom>();
        }
        return this.identifiedPersonTelecom;
    }

    /**
     * Gets the value of the mothersMaidenName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mothersMaidenName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMothersMaidenName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PRPAMT101306UV02MothersMaidenName }
     * 
     * 
     */
    public List<PRPAMT101306UV02MothersMaidenName> getMothersMaidenName() {
        if (mothersMaidenName == null) {
            mothersMaidenName = new ArrayList<PRPAMT101306UV02MothersMaidenName>();
        }
        return this.mothersMaidenName;
    }

    /**
     * Gets the value of the otherIDsScopingOrganization property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the otherIDsScopingOrganization property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOtherIDsScopingOrganization().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PRPAMT101306UV02OtherIDsScopingOrganization }
     * 
     * 
     */
    public List<PRPAMT101306UV02OtherIDsScopingOrganization> getOtherIDsScopingOrganization() {
        if (otherIDsScopingOrganization == null) {
            otherIDsScopingOrganization = new ArrayList<PRPAMT101306UV02OtherIDsScopingOrganization>();
        }
        return this.otherIDsScopingOrganization;
    }

    /**
     * Gets the value of the personAdministrativeGender property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the personAdministrativeGender property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonAdministrativeGender().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PRPAMT101306UV02PersonAdministrativeGender }
     * 
     * 
     */
    public List<PRPAMT101306UV02PersonAdministrativeGender> getPersonAdministrativeGender() {
        if (personAdministrativeGender == null) {
            personAdministrativeGender = new ArrayList<PRPAMT101306UV02PersonAdministrativeGender>();
        }
        return this.personAdministrativeGender;
    }

    /**
     * Gets the value of the personBirthPlaceAddress property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the personBirthPlaceAddress property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonBirthPlaceAddress().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PRPAMT101306UV02PersonBirthPlaceAddress }
     * 
     * 
     */
    public List<PRPAMT101306UV02PersonBirthPlaceAddress> getPersonBirthPlaceAddress() {
        if (personBirthPlaceAddress == null) {
            personBirthPlaceAddress = new ArrayList<PRPAMT101306UV02PersonBirthPlaceAddress>();
        }
        return this.personBirthPlaceAddress;
    }

    /**
     * Gets the value of the personBirthPlaceName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the personBirthPlaceName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonBirthPlaceName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PRPAMT101306UV02PersonBirthPlaceName }
     * 
     * 
     */
    public List<PRPAMT101306UV02PersonBirthPlaceName> getPersonBirthPlaceName() {
        if (personBirthPlaceName == null) {
            personBirthPlaceName = new ArrayList<PRPAMT101306UV02PersonBirthPlaceName>();
        }
        return this.personBirthPlaceName;
    }

    /**
     * Gets the value of the personBirthTime property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the personBirthTime property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonBirthTime().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PRPAMT101306UV02PersonBirthTime }
     * 
     * 
     */
    public List<PRPAMT101306UV02PersonBirthTime> getPersonBirthTime() {
        if (personBirthTime == null) {
            personBirthTime = new ArrayList<PRPAMT101306UV02PersonBirthTime>();
        }
        return this.personBirthTime;
    }

    /**
     * Gets the value of the personDeceased property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the personDeceased property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonDeceased().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PRPAMT101306UV02PersonDeceased }
     * 
     * 
     */
    public List<PRPAMT101306UV02PersonDeceased> getPersonDeceased() {
        if (personDeceased == null) {
            personDeceased = new ArrayList<PRPAMT101306UV02PersonDeceased>();
        }
        return this.personDeceased;
    }

    /**
     * Gets the value of the personDeceasedTime property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the personDeceasedTime property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonDeceasedTime().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PRPAMT101306UV02PersonDeceasedTime }
     * 
     * 
     */
    public List<PRPAMT101306UV02PersonDeceasedTime> getPersonDeceasedTime() {
        if (personDeceasedTime == null) {
            personDeceasedTime = new ArrayList<PRPAMT101306UV02PersonDeceasedTime>();
        }
        return this.personDeceasedTime;
    }

    /**
     * Gets the value of the personId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the personId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PRPAMT101306UV02PersonId }
     * 
     * 
     */
    public List<PRPAMT101306UV02PersonId> getPersonId() {
        if (personId == null) {
            personId = new ArrayList<PRPAMT101306UV02PersonId>();
        }
        return this.personId;
    }

    /**
     * Gets the value of the personName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the personName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PRPAMT101306UV02PersonName }
     * 
     * 
     */
    public List<PRPAMT101306UV02PersonName> getPersonName() {
        if (personName == null) {
            personName = new ArrayList<PRPAMT101306UV02PersonName>();
        }
        return this.personName;
    }

    /**
     * Gets the value of the personRoleId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the personRoleId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonRoleId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PRPAMT101306UV02PersonRoleId }
     * 
     * 
     */
    public List<PRPAMT101306UV02PersonRoleId> getPersonRoleId() {
        if (personRoleId == null) {
            personRoleId = new ArrayList<PRPAMT101306UV02PersonRoleId>();
        }
        return this.personRoleId;
    }

}
