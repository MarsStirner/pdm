
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassSpecimenObservation.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassSpecimenObservation">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="SPCOBS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActClassSpecimenObservation")
@XmlEnum
public enum ActClassSpecimenObservation {

    SPCOBS;

    public String value() {
        return name();
    }

    public static ActClassSpecimenObservation fromValue(String v) {
        return valueOf(v);
    }

}
