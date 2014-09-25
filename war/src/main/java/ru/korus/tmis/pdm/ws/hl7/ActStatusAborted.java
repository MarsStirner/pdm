
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActStatusAborted.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActStatusAborted">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="aborted"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActStatusAborted")
@XmlEnum
public enum ActStatusAborted {

    @XmlEnumValue("aborted")
    ABORTED("aborted");
    private final String value;

    ActStatusAborted(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ActStatusAborted fromValue(String v) {
        for (ActStatusAborted c: ActStatusAborted.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
