
package ru.korus.tmis.pdm.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * 
 *                 A character string token representing a part of a name.
 *                 May have a type code signifying the role of the part in
 *                 the whole entity name, and a qualifier code for more detail
 *                 about the name part type. Typical name parts for person
 *                 names are given names, and family names, titles, etc.
 *             
 * 
 * <p>Java class for ENXP_explicit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ENXP_explicit">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="partType" type="{urn:hl7-org:v3}EntityNamePartType" />
 *       &lt;attribute name="qualifier" type="{urn:hl7-org:v3}set_EntityNamePartQualifier" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ENXP_explicit", propOrder = {
    "content"
})
@XmlSeeAlso({
    EnExplicitPrefix.class,
    EnExplicitSuffix.class,
    EnExplicitGiven.class,
    EnExplicitDelimiter.class,
    EnExplicitFamily.class
})
public class ENXPExplicit {

    @XmlValue
    protected String content;
    @XmlAttribute(name = "partType")
    protected EntityNamePartType partType;
    @XmlAttribute(name = "qualifier")
    protected List<EntityNamePartQualifier> qualifier;

    /**
     * 
     *                 A character string token representing a part of a name.
     *                 May have a type code signifying the role of the part in
     *                 the whole entity name, and a qualifier code for more detail
     *                 about the name part type. Typical name parts for person
     *                 names are given names, and family names, titles, etc.
     *             
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContent(String value) {
        this.content = value;
    }

    /**
     * Gets the value of the partType property.
     * 
     * @return
     *     possible object is
     *     {@link EntityNamePartType }
     *     
     */
    public EntityNamePartType getPartType() {
        return partType;
    }

    /**
     * Sets the value of the partType property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityNamePartType }
     *     
     */
    public void setPartType(EntityNamePartType value) {
        this.partType = value;
    }

    /**
     * Gets the value of the qualifier property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the qualifier property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getQualifier().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityNamePartQualifier }
     * 
     * 
     */
    public List<EntityNamePartQualifier> getQualifier() {
        if (qualifier == null) {
            qualifier = new ArrayList<EntityNamePartQualifier>();
        }
        return this.qualifier;
    }

}
