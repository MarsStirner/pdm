
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ParticipationPrimaryPerformer.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ParticipationPrimaryPerformer">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="PPRF"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ParticipationPrimaryPerformer")
@XmlEnum
public enum ParticipationPrimaryPerformer {

    PPRF;

    public String value() {
        return name();
    }

    public static ParticipationPrimaryPerformer fromValue(String v) {
        return valueOf(v);
    }

}
