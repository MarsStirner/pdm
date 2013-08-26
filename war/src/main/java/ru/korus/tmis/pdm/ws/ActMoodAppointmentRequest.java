
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActMoodAppointmentRequest.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActMoodAppointmentRequest">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="ARQ"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActMoodAppointmentRequest")
@XmlEnum
public enum ActMoodAppointmentRequest {

    ARQ;

    public String value() {
        return name();
    }

    public static ActMoodAppointmentRequest fromValue(String v) {
        return valueOf(v);
    }

}
