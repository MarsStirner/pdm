
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipAdjunctCurativeIndication.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipAdjunctCurativeIndication">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="CURE.ADJ"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipAdjunctCurativeIndication")
@XmlEnum
public enum ActRelationshipAdjunctCurativeIndication {

    @XmlEnumValue("CURE.ADJ")
    CURE_ADJ("CURE.ADJ");
    private final String value;

    ActRelationshipAdjunctCurativeIndication(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ActRelationshipAdjunctCurativeIndication fromValue(String v) {
        for (ActRelationshipAdjunctCurativeIndication c: ActRelationshipAdjunctCurativeIndication.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
