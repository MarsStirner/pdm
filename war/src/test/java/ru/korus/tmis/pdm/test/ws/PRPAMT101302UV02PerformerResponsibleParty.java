
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PRPA_MT101302UV02.Performer.responsibleParty complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PRPA_MT101302UV02.Performer.responsibleParty">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:hl7-org:v3}COCT_MT040200UV09.ResponsibleParty">
 *       &lt;attribute name="updateMode" type="{urn:hl7-org:v3}PRPA_MT101302UV02.Performer.responsibleParty.updateMode" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PRPA_MT101302UV02.Performer.responsibleParty")
public class PRPAMT101302UV02PerformerResponsibleParty
    extends COCTMT040200UV09ResponsibleParty
{

    @XmlAttribute(name = "updateMode")
    protected PRPAMT101302UV02PerformerResponsiblePartyUpdateMode updateMode;

    /**
     * Gets the value of the updateMode property.
     * 
     * @return
     *     possible object is
     *     {@link PRPAMT101302UV02PerformerResponsiblePartyUpdateMode }
     *     
     */
    public PRPAMT101302UV02PerformerResponsiblePartyUpdateMode getUpdateMode() {
        return updateMode;
    }

    /**
     * Sets the value of the updateMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PRPAMT101302UV02PerformerResponsiblePartyUpdateMode }
     *     
     */
    public void setUpdateMode(PRPAMT101302UV02PerformerResponsiblePartyUpdateMode value) {
        this.updateMode = value;
    }

}
