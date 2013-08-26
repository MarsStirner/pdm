
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ParticipationTargetDirect.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ParticipationTargetDirect">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="DIR"/>
 *     &lt;enumeration value="ALY"/>
 *     &lt;enumeration value="BBY"/>
 *     &lt;enumeration value="CAT"/>
 *     &lt;enumeration value="CSM"/>
 *     &lt;enumeration value="DEV"/>
 *     &lt;enumeration value="NRD"/>
 *     &lt;enumeration value="RDV"/>
 *     &lt;enumeration value="DON"/>
 *     &lt;enumeration value="EXPAGNT"/>
 *     &lt;enumeration value="EXPART"/>
 *     &lt;enumeration value="EXPTRGT"/>
 *     &lt;enumeration value="EXSRC"/>
 *     &lt;enumeration value="PRD"/>
 *     &lt;enumeration value="SBJ"/>
 *     &lt;enumeration value="SPC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ParticipationTargetDirect")
@XmlEnum
public enum ParticipationTargetDirect {

    DIR,
    ALY,
    BBY,
    CAT,
    CSM,
    DEV,
    NRD,
    RDV,
    DON,
    EXPAGNT,
    EXPART,
    EXPTRGT,
    EXSRC,
    PRD,
    SBJ,
    SPC;

    public String value() {
        return name();
    }

    public static ParticipationTargetDirect fromValue(String v) {
        return valueOf(v);
    }

}
