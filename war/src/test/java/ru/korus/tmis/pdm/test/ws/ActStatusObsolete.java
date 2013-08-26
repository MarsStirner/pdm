
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActStatusObsolete.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActStatusObsolete">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="obsolete"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActStatusObsolete")
@XmlEnum
public enum ActStatusObsolete {

    @XmlEnumValue("obsolete")
    OBSOLETE("obsolete");
    private final String value;

    ActStatusObsolete(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ActStatusObsolete fromValue(String v) {
        for (ActStatusObsolete c: ActStatusObsolete.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
