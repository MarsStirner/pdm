
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActStatusCancelled.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActStatusCancelled">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="cancelled"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActStatusCancelled")
@XmlEnum
public enum ActStatusCancelled {

    @XmlEnumValue("cancelled")
    CANCELLED("cancelled");
    private final String value;

    ActStatusCancelled(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ActStatusCancelled fromValue(String v) {
        for (ActStatusCancelled c: ActStatusCancelled.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
