
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ManagedParticipationStatusNullified.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ManagedParticipationStatusNullified">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="nullified"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ManagedParticipationStatusNullified")
@XmlEnum
public enum ManagedParticipationStatusNullified {

    @XmlEnumValue("nullified")
    NULLIFIED("nullified");
    private final String value;

    ManagedParticipationStatusNullified(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ManagedParticipationStatusNullified fromValue(String v) {
        for (ManagedParticipationStatusNullified c: ManagedParticipationStatusNullified.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
