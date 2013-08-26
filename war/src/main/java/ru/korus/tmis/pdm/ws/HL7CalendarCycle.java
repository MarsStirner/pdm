
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HL7CalendarCycle.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HL7CalendarCycle">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="CD"/>
 *     &lt;enumeration value="CH"/>
 *     &lt;enumeration value="CM"/>
 *     &lt;enumeration value="CN"/>
 *     &lt;enumeration value="CS"/>
 *     &lt;enumeration value="CW"/>
 *     &lt;enumeration value="CY"/>
 *     &lt;enumeration value="DM"/>
 *     &lt;enumeration value="DW"/>
 *     &lt;enumeration value="DY"/>
 *     &lt;enumeration value="HD"/>
 *     &lt;enumeration value="MY"/>
 *     &lt;enumeration value="NH"/>
 *     &lt;enumeration value="SN"/>
 *     &lt;enumeration value="WY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HL7CalendarCycle")
@XmlEnum
public enum HL7CalendarCycle {

    CD,
    CH,
    CM,
    CN,
    CS,
    CW,
    CY,
    DM,
    DW,
    DY,
    HD,
    MY,
    NH,
    SN,
    WY;

    public String value() {
        return name();
    }

    public static HL7CalendarCycle fromValue(String v) {
        return valueOf(v);
    }

}
