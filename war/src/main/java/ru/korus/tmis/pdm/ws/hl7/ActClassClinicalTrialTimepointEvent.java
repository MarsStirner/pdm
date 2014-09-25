
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassClinicalTrialTimepointEvent.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassClinicalTrialTimepointEvent">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="CTTEVENT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActClassClinicalTrialTimepointEvent")
@XmlEnum
public enum ActClassClinicalTrialTimepointEvent {

    CTTEVENT;

    public String value() {
        return name();
    }

    public static ActClassClinicalTrialTimepointEvent fromValue(String v) {
        return valueOf(v);
    }

}
