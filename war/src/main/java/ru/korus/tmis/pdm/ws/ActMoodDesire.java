
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActMoodDesire.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActMoodDesire">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="ARQ"/>
 *     &lt;enumeration value="PERMRQ"/>
 *     &lt;enumeration value="RQO"/>
 *     &lt;enumeration value="PRP"/>
 *     &lt;enumeration value="RMD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActMoodDesire")
@XmlEnum
public enum ActMoodDesire {

    ARQ,
    PERMRQ,
    RQO,
    PRP,
    RMD;

    public String value() {
        return name();
    }

    public static ActMoodDesire fromValue(String v) {
        return valueOf(v);
    }

}
