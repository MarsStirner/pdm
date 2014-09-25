
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassPositionAccuracy.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassPositionAccuracy">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="POSACC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActClassPositionAccuracy")
@XmlEnum
public enum ActClassPositionAccuracy {

    POSACC;

    public String value() {
        return name();
    }

    public static ActClassPositionAccuracy fromValue(String v) {
        return valueOf(v);
    }

}
