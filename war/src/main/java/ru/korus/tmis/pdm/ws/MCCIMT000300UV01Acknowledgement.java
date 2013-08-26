
package ru.korus.tmis.pdm.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MCCI_MT000300UV01.Acknowledgement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MCCI_MT000300UV01.Acknowledgement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{urn:hl7-org:v3}InfrastructureRootElements"/>
 *         &lt;element name="messageWaitingNumber" type="{urn:hl7-org:v3}INT" minOccurs="0"/>
 *         &lt;element name="messageWaitingPriorityCode" type="{urn:hl7-org:v3}CE" minOccurs="0"/>
 *         &lt;element name="targetMessage" type="{urn:hl7-org:v3}MCCI_MT000300UV01.TargetMessage"/>
 *         &lt;element name="acknowledgementDetail" type="{urn:hl7-org:v3}MCCI_MT000300UV01.AcknowledgementDetail" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{urn:hl7-org:v3}InfrastructureRootAttributes"/>
 *       &lt;attribute name="nullFlavor" type="{urn:hl7-org:v3}NullFlavor" />
 *       &lt;attribute name="typeCode" use="required" type="{urn:hl7-org:v3}AcknowledgementType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MCCI_MT000300UV01.Acknowledgement", propOrder = {
    "realmCode",
    "typeId",
    "templateId",
    "messageWaitingNumber",
    "messageWaitingPriorityCode",
    "targetMessage",
    "acknowledgementDetail"
})
public class MCCIMT000300UV01Acknowledgement {

    protected List<CS> realmCode;
    protected II typeId;
    protected List<II> templateId;
    protected INT messageWaitingNumber;
    protected CE messageWaitingPriorityCode;
    @XmlElement(required = true, nillable = true)
    protected MCCIMT000300UV01TargetMessage targetMessage;
    @XmlElement(nillable = true)
    protected List<MCCIMT000300UV01AcknowledgementDetail> acknowledgementDetail;
    @XmlAttribute(name = "nullFlavor")
    protected NullFlavor nullFlavor;
    @XmlAttribute(name = "typeCode", required = true)
    protected AcknowledgementType typeCode;

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
     * Gets the value of the messageWaitingNumber property.
     * 
     * @return
     *     possible object is
     *     {@link INT }
     *     
     */
    public INT getMessageWaitingNumber() {
        return messageWaitingNumber;
    }

    /**
     * Sets the value of the messageWaitingNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link INT }
     *     
     */
    public void setMessageWaitingNumber(INT value) {
        this.messageWaitingNumber = value;
    }

    /**
     * Gets the value of the messageWaitingPriorityCode property.
     * 
     * @return
     *     possible object is
     *     {@link CE }
     *     
     */
    public CE getMessageWaitingPriorityCode() {
        return messageWaitingPriorityCode;
    }

    /**
     * Sets the value of the messageWaitingPriorityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CE }
     *     
     */
    public void setMessageWaitingPriorityCode(CE value) {
        this.messageWaitingPriorityCode = value;
    }

    /**
     * Gets the value of the targetMessage property.
     * 
     * @return
     *     possible object is
     *     {@link MCCIMT000300UV01TargetMessage }
     *     
     */
    public MCCIMT000300UV01TargetMessage getTargetMessage() {
        return targetMessage;
    }

    /**
     * Sets the value of the targetMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link MCCIMT000300UV01TargetMessage }
     *     
     */
    public void setTargetMessage(MCCIMT000300UV01TargetMessage value) {
        this.targetMessage = value;
    }

    /**
     * Gets the value of the acknowledgementDetail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the acknowledgementDetail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAcknowledgementDetail().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MCCIMT000300UV01AcknowledgementDetail }
     * 
     * 
     */
    public List<MCCIMT000300UV01AcknowledgementDetail> getAcknowledgementDetail() {
        if (acknowledgementDetail == null) {
            acknowledgementDetail = new ArrayList<MCCIMT000300UV01AcknowledgementDetail>();
        }
        return this.acknowledgementDetail;
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
     * Gets the value of the typeCode property.
     * 
     * @return
     *     possible object is
     *     {@link AcknowledgementType }
     *     
     */
    public AcknowledgementType getTypeCode() {
        return typeCode;
    }

    /**
     * Sets the value of the typeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link AcknowledgementType }
     *     
     */
    public void setTypeCode(AcknowledgementType value) {
        this.typeCode = value;
    }

}
