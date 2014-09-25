
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ManagedParticipationStatusPending.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ManagedParticipationStatusPending">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="pending"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ManagedParticipationStatusPending")
@XmlEnum
public enum ManagedParticipationStatusPending {

    @XmlEnumValue("pending")
    PENDING("pending");
    private final String value;

    ManagedParticipationStatusPending(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ManagedParticipationStatusPending fromValue(String v) {
        for (ManagedParticipationStatusPending c: ManagedParticipationStatusPending.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
