
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassTransmissionExposure.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassTransmissionExposure">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="TEXPOS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActClassTransmissionExposure")
@XmlEnum
public enum ActClassTransmissionExposure {

    TEXPOS;

    public String value() {
        return name();
    }

    public static ActClassTransmissionExposure fromValue(String v) {
        return valueOf(v);
    }

}
