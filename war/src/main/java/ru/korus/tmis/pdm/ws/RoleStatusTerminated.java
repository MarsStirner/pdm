
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleStatusTerminated.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleStatusTerminated">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="terminated"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleStatusTerminated")
@XmlEnum
public enum RoleStatusTerminated {

    @XmlEnumValue("terminated")
    TERMINATED("terminated");
    private final String value;

    RoleStatusTerminated(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RoleStatusTerminated fromValue(String v) {
        for (RoleStatusTerminated c: RoleStatusTerminated.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
