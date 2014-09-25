
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ParticipationSecondaryPerformer.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ParticipationSecondaryPerformer">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="SPRF"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ParticipationSecondaryPerformer")
@XmlEnum
public enum ParticipationSecondaryPerformer {

    SPRF;

    public String value() {
        return name();
    }

    public static ParticipationSecondaryPerformer fromValue(String v) {
        return valueOf(v);
    }

}
