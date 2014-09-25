
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EntityStatusInactive.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EntityStatusInactive">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="inactive"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EntityStatusInactive")
@XmlEnum
public enum EntityStatusInactive {

    @XmlEnumValue("inactive")
    INACTIVE("inactive");
    private final String value;

    EntityStatusInactive(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EntityStatusInactive fromValue(String v) {
        for (EntityStatusInactive c: EntityStatusInactive.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
