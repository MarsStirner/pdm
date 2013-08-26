
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ManagedParticipationStatusCompleted.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ManagedParticipationStatusCompleted">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="completed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ManagedParticipationStatusCompleted")
@XmlEnum
public enum ManagedParticipationStatusCompleted {

    @XmlEnumValue("completed")
    COMPLETED("completed");
    private final String value;

    ManagedParticipationStatusCompleted(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ManagedParticipationStatusCompleted fromValue(String v) {
        for (ManagedParticipationStatusCompleted c: ManagedParticipationStatusCompleted.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
