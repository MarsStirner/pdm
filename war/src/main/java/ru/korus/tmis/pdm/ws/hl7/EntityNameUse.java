
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EntityNameUse.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EntityNameUse">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="A"/>
 *     &lt;enumeration value="ABC"/>
 *     &lt;enumeration value="ASGN"/>
 *     &lt;enumeration value="C"/>
 *     &lt;enumeration value="I"/>
 *     &lt;enumeration value="IDE"/>
 *     &lt;enumeration value="L"/>
 *     &lt;enumeration value="OR"/>
 *     &lt;enumeration value="P"/>
 *     &lt;enumeration value="PHON"/>
 *     &lt;enumeration value="R"/>
 *     &lt;enumeration value="SNDX"/>
 *     &lt;enumeration value="SRCH"/>
 *     &lt;enumeration value="SYL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EntityNameUse")
@XmlEnum
public enum EntityNameUse {

    A,
    ABC,
    ASGN,
    C,
    I,
    IDE,
    L,
    OR,
    P,
    PHON,
    R,
    SNDX,
    SRCH,
    SYL;

    public String value() {
        return name();
    }

    public static EntityNameUse fromValue(String v) {
        return valueOf(v);
    }

}
