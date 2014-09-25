
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleStatusActive.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleStatusActive">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="active"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleStatusActive")
@XmlEnum
public enum RoleStatusActive {

    @XmlEnumValue("active")
    ACTIVE("active");
    private final String value;

    RoleStatusActive(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RoleStatusActive fromValue(String v) {
        for (RoleStatusActive c: RoleStatusActive.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
