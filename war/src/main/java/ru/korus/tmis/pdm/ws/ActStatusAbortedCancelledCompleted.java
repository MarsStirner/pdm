
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActStatusAbortedCancelledCompleted.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActStatusAbortedCancelledCompleted">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="aborted"/>
 *     &lt;enumeration value="cancelled"/>
 *     &lt;enumeration value="completed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActStatusAbortedCancelledCompleted")
@XmlEnum
public enum ActStatusAbortedCancelledCompleted {

    @XmlEnumValue("aborted")
    ABORTED("aborted"),
    @XmlEnumValue("cancelled")
    CANCELLED("cancelled"),
    @XmlEnumValue("completed")
    COMPLETED("completed");
    private final String value;

    ActStatusAbortedCancelledCompleted(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ActStatusAbortedCancelledCompleted fromValue(String v) {
        for (ActStatusAbortedCancelledCompleted c: ActStatusAbortedCancelledCompleted.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
