
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for x_ActStatusPrevious.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="x_ActStatusPrevious">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="cancelled"/>
 *     &lt;enumeration value="nullified"/>
 *     &lt;enumeration value="obsolete"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "x_ActStatusPrevious")
@XmlEnum
public enum XActStatusPrevious {

    @XmlEnumValue("cancelled")
    CANCELLED("cancelled"),
    @XmlEnumValue("nullified")
    NULLIFIED("nullified"),
    @XmlEnumValue("obsolete")
    OBSOLETE("obsolete");
    private final String value;

    XActStatusPrevious(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static XActStatusPrevious fromValue(String v) {
        for (XActStatusPrevious c: XActStatusPrevious.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
