
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipConditional.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipConditional">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="CIND"/>
 *     &lt;enumeration value="PRCN"/>
 *     &lt;enumeration value="RSON"/>
 *     &lt;enumeration value="BLOCK"/>
 *     &lt;enumeration value="CURE"/>
 *     &lt;enumeration value="CURE.ADJ"/>
 *     &lt;enumeration value="DIAG"/>
 *     &lt;enumeration value="MITGT"/>
 *     &lt;enumeration value="RCVY"/>
 *     &lt;enumeration value="MTGT.ADJ"/>
 *     &lt;enumeration value="SYMP"/>
 *     &lt;enumeration value="TRIG"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipConditional")
@XmlEnum
public enum ActRelationshipConditional {

    CIND("CIND"),
    PRCN("PRCN"),
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
    SYMP("SYMP"),
    TRIG("TRIG");
    private final String value;

    ActRelationshipConditional(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ActRelationshipConditional fromValue(String v) {
        for (ActRelationshipConditional c: ActRelationshipConditional.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
