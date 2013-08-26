
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActMoodCompletionTrack.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActMoodCompletionTrack">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="DEF"/>
 *     &lt;enumeration value="PERM"/>
 *     &lt;enumeration value="SLOT"/>
 *     &lt;enumeration value="EVN"/>
 *     &lt;enumeration value="INT"/>
 *     &lt;enumeration value="ARQ"/>
 *     &lt;enumeration value="PERMRQ"/>
 *     &lt;enumeration value="RQO"/>
 *     &lt;enumeration value="PRP"/>
 *     &lt;enumeration value="RMD"/>
 *     &lt;enumeration value="PRMS"/>
 *     &lt;enumeration value="APT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActMoodCompletionTrack")
@XmlEnum
public enum ActMoodCompletionTrack {

    DEF,
    PERM,
    SLOT,
    EVN,
    INT,
    ARQ,
    PERMRQ,
    RQO,
    PRP,
    RMD,
    PRMS,
    APT;

    public String value() {
        return name();
    }

    public static ActMoodCompletionTrack fromValue(String v) {
        return valueOf(v);
    }

}
