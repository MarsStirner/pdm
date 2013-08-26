
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for x_ActClassCareProvisionObservation.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="x_ActClassCareProvisionObservation">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="OBS"/>
 *     &lt;enumeration value="PCPR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "x_ActClassCareProvisionObservation")
@XmlEnum
public enum XActClassCareProvisionObservation {

    OBS,
    PCPR;

    public String value() {
        return name();
    }

    public static XActClassCareProvisionObservation fromValue(String v) {
        return valueOf(v);
    }

}
