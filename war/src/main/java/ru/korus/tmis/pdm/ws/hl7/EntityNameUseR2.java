
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EntityNameUseR2.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EntityNameUseR2">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="A"/>
 *     &lt;enumeration value="ABC"/>
 *     &lt;enumeration value="ANON"/>
 *     &lt;enumeration value="Assumed"/>
 *     &lt;enumeration value="DN"/>
 *     &lt;enumeration value="I"/>
 *     &lt;enumeration value="IDE"/>
 *     &lt;enumeration value="M"/>
 *     &lt;enumeration value="N"/>
 *     &lt;enumeration value="NameRepresentationUse"/>
 *     &lt;enumeration value="OLD"/>
 *     &lt;enumeration value="OR"/>
 *     &lt;enumeration value="P"/>
 *     &lt;enumeration value="PHON"/>
 *     &lt;enumeration value="R"/>
 *     &lt;enumeration value="SRCH"/>
 *     &lt;enumeration value="SYL"/>
 *     &lt;enumeration value="T"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EntityNameUseR2")
@XmlEnum
public enum EntityNameUseR2 {

    A("A"),
    ABC("ABC"),
    ANON("ANON"),
    @XmlEnumValue("Assumed")
    ASSUMED("Assumed"),
    DN("DN"),
    I("I"),
    IDE("IDE"),
    M("M"),
    N("N"),
    @XmlEnumValue("NameRepresentationUse")
    NAME_REPRESENTATION_USE("NameRepresentationUse"),
    OLD("OLD"),
    OR("OR"),
    P("P"),
    PHON("PHON"),
    R("R"),
    SRCH("SRCH"),
    SYL("SYL"),
    T("T");
    private final String value;

    EntityNameUseR2(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EntityNameUseR2 fromValue(String v) {
        for (EntityNameUseR2 c: EntityNameUseR2 .values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
