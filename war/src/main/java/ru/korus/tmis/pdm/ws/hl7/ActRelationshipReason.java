
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipReason.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipReason">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="RSON"/>
 *     &lt;enumeration value="BLOCK"/>
 *     &lt;enumeration value="CURE"/>
 *     &lt;enumeration value="CURE.ADJ"/>
 *     &lt;enumeration value="DIAG"/>
 *     &lt;enumeration value="MITGT"/>
 *     &lt;enumeration value="RCVY"/>
 *     &lt;enumeration value="MTGT.ADJ"/>
 *     &lt;enumeration value="SYMP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipReason")
@XmlEnum
public enum ActRelationshipReason {

    RSON("RSON"),
    BLOCK("BLOCK"),
    CURE("CURE"),
    @XmlEnumValue("CURE.ADJ")
    CURE_ADJ("CURE.ADJ"),
    DIAG("DIAG"),
    MITGT("MITGT"),
    RCVY("RCVY"),
    @XmlEnumValue("MTGT.ADJ")
    MTGT_ADJ("MTGT.ADJ"),
    SYMP("SYMP");
    private final String value;

    ActRelationshipReason(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ActRelationshipReason fromValue(String v) {
        for (ActRelationshipReason c: ActRelationshipReason.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
