
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ParticipationNon-reuseableDevice.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ParticipationNon-reuseableDevice">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="NRD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ParticipationNon-reuseableDevice")
@XmlEnum
public enum ParticipationNonReuseableDevice {

    NRD;

    public String value() {
        return name();
    }

    public static ParticipationNonReuseableDevice fromValue(String v) {
        return valueOf(v);
    }

}
