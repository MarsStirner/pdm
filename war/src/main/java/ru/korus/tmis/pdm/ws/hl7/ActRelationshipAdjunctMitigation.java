
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipAdjunctMitigation.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipAdjunctMitigation">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="MTGT.ADJ"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipAdjunctMitigation")
@XmlEnum
public enum ActRelationshipAdjunctMitigation {

    @XmlEnumValue("MTGT.ADJ")
    MTGT_ADJ("MTGT.ADJ");
    private final String value;

    ActRelationshipAdjunctMitigation(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ActRelationshipAdjunctMitigation fromValue(String v) {
        for (ActRelationshipAdjunctMitigation c: ActRelationshipAdjunctMitigation.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
