
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PRPA_MT101302UV02.BirthPlace.subjectOf complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PRPA_MT101302UV02.BirthPlace.subjectOf">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:hl7-org:v3}PRPA_MT101302UV02.Subject2">
 *       &lt;attribute name="updateMode" type="{urn:hl7-org:v3}PRPA_MT101302UV02.BirthPlace.subjectOf.updateMode" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PRPA_MT101302UV02.BirthPlace.subjectOf")
public class PRPAMT101302UV02BirthPlaceSubjectOf
    extends PRPAMT101302UV02Subject2
{

    @XmlAttribute(name = "updateMode")
    protected PRPAMT101302UV02BirthPlaceSubjectOfUpdateMode updateMode;

    /**
     * Gets the value of the updateMode property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT101302UV02BirthPlaceSubjectOfUpdateMode }
     *     
     */
    public PRPAMT101302UV02BirthPlaceSubjectOfUpdateMode getUpdateMode() {
        return updateMode;
    }

    /**
     * Sets the value of the updateMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT101302UV02BirthPlaceSubjectOfUpdateMode }
     *     
     */
    public void setUpdateMode(PRPAMT101302UV02BirthPlaceSubjectOfUpdateMode value) {
        this.updateMode = value;
    }

}
