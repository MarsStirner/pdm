
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipSplitExclusiveTryOnce.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipSplitExclusiveTryOnce">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="E1"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipSplitExclusiveTryOnce")
@XmlEnum
public enum ActRelationshipSplitExclusiveTryOnce {

    @XmlEnumValue("E1")
    E_1("E1");
    private final String value;

    ActRelationshipSplitExclusiveTryOnce(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ActRelationshipSplitExclusiveTryOnce fromValue(String v) {
        for (ActRelationshipSplitExclusiveTryOnce c: ActRelationshipSplitExclusiveTryOnce.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
