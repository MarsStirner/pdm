
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleStatusNullified.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleStatusNullified">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="nullified"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleStatusNullified")
@XmlEnum
public enum RoleStatusNullified {

    @XmlEnumValue("nullified")
    NULLIFIED("nullified");
    private final String value;

    RoleStatusNullified(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RoleStatusNullified fromValue(String v) {
        for (RoleStatusNullified c: RoleStatusNullified.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
