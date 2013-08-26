
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ManagedParticipationStatusActive.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ManagedParticipationStatusActive">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="active"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ManagedParticipationStatusActive")
@XmlEnum
public enum ManagedParticipationStatusActive {

    @XmlEnumValue("active")
    ACTIVE("active");
    private final String value;

    ManagedParticipationStatusActive(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ManagedParticipationStatusActive fromValue(String v) {
        for (ManagedParticipationStatusActive c: ManagedParticipationStatusActive.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
