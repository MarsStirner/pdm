
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActMoodResourceSlot.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActMoodResourceSlot">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="SLOT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActMoodResourceSlot")
@XmlEnum
public enum ActMoodResourceSlot {

    SLOT;

    public String value() {
        return name();
    }

    public static ActMoodResourceSlot fromValue(String v) {
        return valueOf(v);
    }

}
