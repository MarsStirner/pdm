
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleStatusSuspended.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleStatusSuspended">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="suspended"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleStatusSuspended")
@XmlEnum
public enum RoleStatusSuspended {

    @XmlEnumValue("suspended")
    SUSPENDED("suspended");
    private final String value;

    RoleStatusSuspended(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RoleStatusSuspended fromValue(String v) {
        for (RoleStatusSuspended c: RoleStatusSuspended.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
