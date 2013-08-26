
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReactionParticipant.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReactionParticipant">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="CAT"/>
 *     &lt;enumeration value="CSM"/>
 *     &lt;enumeration value="PRD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReactionParticipant")
@XmlEnum
public enum ReactionParticipant {

    CAT,
    CSM,
    PRD;

    public String value() {
        return name();
    }

    public static ReactionParticipant fromValue(String v) {
        return valueOf(v);
    }

}
