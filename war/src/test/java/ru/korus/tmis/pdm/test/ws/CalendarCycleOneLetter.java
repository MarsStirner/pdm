
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CalendarCycleOneLetter.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CalendarCycleOneLetter">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="CW"/>
 *     &lt;enumeration value="W"/>
 *     &lt;enumeration value="CY"/>
 *     &lt;enumeration value="Y"/>
 *     &lt;enumeration value="D"/>
 *     &lt;enumeration value="DM"/>
 *     &lt;enumeration value="DW"/>
 *     &lt;enumeration value="J"/>
 *     &lt;enumeration value="H"/>
 *     &lt;enumeration value="HD"/>
 *     &lt;enumeration value="M"/>
 *     &lt;enumeration value="MY"/>
 *     &lt;enumeration value="N"/>
 *     &lt;enumeration value="NH"/>
 *     &lt;enumeration value="S"/>
 *     &lt;enumeration value="SN"/>
 *     &lt;enumeration value="D"/>
 *     &lt;enumeration value="H"/>
 *     &lt;enumeration value="J"/>
 *     &lt;enumeration value="M"/>
 *     &lt;enumeration value="N"/>
 *     &lt;enumeration value="S"/>
 *     &lt;enumeration value="W"/>
 *     &lt;enumeration value="Y"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CalendarCycleOneLetter")
@XmlEnum
public enum CalendarCycleOneLetter {

    CW,
    W,
    CY,
    Y,
    D,
    DM,
    DW,
    J,
    H,
    HD,
    M,
    MY,
    N,
    NH,
    S,
    SN;

    public String value() {
        return name();
    }

    public static CalendarCycleOneLetter fromValue(String v) {
        return valueOf(v);
    }

}
