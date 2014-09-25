
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipSplitInclusiveTryOnce.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipSplitInclusiveTryOnce">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="I1"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipSplitInclusiveTryOnce")
@XmlEnum
public enum ActRelationshipSplitInclusiveTryOnce {

    @XmlEnumValue("I1")
    I_1("I1");
    private final String value;

    ActRelationshipSplitInclusiveTryOnce(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ActRelationshipSplitInclusiveTryOnce fromValue(String v) {
        for (ActRelationshipSplitInclusiveTryOnce c: ActRelationshipSplitInclusiveTryOnce.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
