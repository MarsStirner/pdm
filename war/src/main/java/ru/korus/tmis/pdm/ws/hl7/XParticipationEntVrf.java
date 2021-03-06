
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for x_ParticipationEntVrf.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="x_ParticipationEntVrf">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="ENT"/>
 *     &lt;enumeration value="VRF"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "x_ParticipationEntVrf")
@XmlEnum
public enum XParticipationEntVrf {

    ENT,
    VRF;

    public String value() {
        return name();
    }

    public static XParticipationEntVrf fromValue(String v) {
        return valueOf(v);
    }

}
