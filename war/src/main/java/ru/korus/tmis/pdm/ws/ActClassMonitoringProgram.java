
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassMonitoringProgram.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassMonitoringProgram">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="MPROT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActClassMonitoringProgram")
@XmlEnum
public enum ActClassMonitoringProgram {

    MPROT;

    public String value() {
        return name();
    }

    public static ActClassMonitoringProgram fromValue(String v) {
        return valueOf(v);
    }

}
