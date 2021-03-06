
package ru.korus.tmis.pdm.ws.hl7;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 A name for a person. A sequence of name parts, such as
 *                 given name or family name, prefix, suffix, etc. PN differs
 *                 from EN because the qualifier type cannot include LS
 *                 (Legal Status).
 *             
 * 
 * <p>Java class for PN_explicit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PN_explicit">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="delimiter" type="{urn:hl7-org:v3}en_explicit.delimiter"/>
 *           &lt;element name="family" type="{urn:hl7-org:v3}en_explicit.family"/>
 *           &lt;element name="given" type="{urn:hl7-org:v3}en_explicit.given"/>
 *           &lt;element name="prefix" type="{urn:hl7-org:v3}en_explicit.prefix"/>
 *           &lt;element name="suffix" type="{urn:hl7-org:v3}en_explicit.suffix"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="nullFlavor" type="{urn:hl7-org:v3}NullFlavor" />
 *       &lt;attribute name="use" type="{urn:hl7-org:v3}set_EntityNameUse" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PN_explicit", propOrder = {
    "content"
})
@XmlSeeAlso({
    PRPAMT101302UV02PersonName.class
})
public class PNExplicit {

    @XmlElementRefs({
        @XmlElementRef(name = "family", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "suffix", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "prefix", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "given", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "delimiter", namespace = "urn:hl7-org:v3", type = JAXBElement.class, required = false)
    })
    @XmlMixed
    protected List<Serializable> content;
    @XmlAttribute(name = "nullFlavor")
    protected NullFlavor nullFlavor;
    @XmlAttribute(name = "use")
    protected List<EntityNameUse> use;

    /**
     * 
     *                 A name for a person. A sequence of name parts, such as
     *                 given name or family name, prefix, suffix, etc. PN differs
     *                 from EN because the qualifier type cannot include LS
     *                 (Legal Status).
     *             Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link EnExplicitSuffix }{@code >}
     * {@link JAXBElement }{@code <}{@link EnExplicitPrefix }{@code >}
     * {@link JAXBElement }{@code <}{@link EnExplicitDelimiter }{@code >}
     * {@link JAXBElement }{@code <}{@link EnExplicitGiven }{@code >}
     * {@link String }
     * {@link JAXBElement }{@code <}{@link EnExplicitFamily }{@code >}
     * 
     * 
     */
    public List<Serializable> getContent() {
        if (content == null) {
            content = new ArrayList<Serializable>();
        }
        return this.content;
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
     * Gets the value of the use property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the use property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUse().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityNameUse }
     * 
     * 
     */
    public List<EntityNameUse> getUse() {
        if (use == null) {
            use = new ArrayList<EntityNameUse>();
        }
        return this.use;
    }

}
