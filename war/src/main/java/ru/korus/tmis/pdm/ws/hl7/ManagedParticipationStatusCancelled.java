
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ManagedParticipationStatusCancelled.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ManagedParticipationStatusCancelled">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="cancelled"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ManagedParticipationStatusCancelled")
@XmlEnum
public enum ManagedParticipationStatusCancelled {

    @XmlEnumValue("cancelled")
    CANCELLED("cancelled");
    private final String value;

    ManagedParticipationStatusCancelled(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ManagedParticipationStatusCancelled fromValue(String v) {
        for (ManagedParticipationStatusCancelled c: ManagedParticipationStatusCancelled.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
