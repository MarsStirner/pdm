
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActStatusNew.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActStatusNew">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="new"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActStatusNew")
@XmlEnum
public enum ActStatusNew {

    @XmlEnumValue("new")
    NEW("new");
    private final String value;

    ActStatusNew(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ActStatusNew fromValue(String v) {
        for (ActStatusNew c: ActStatusNew.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
