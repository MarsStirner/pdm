
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassPositionCoordinate.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassPositionCoordinate">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="POSCOORD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActClassPositionCoordinate")
@XmlEnum
public enum ActClassPositionCoordinate {

    POSCOORD;

    public String value() {
        return name();
    }

    public static ActClassPositionCoordinate fromValue(String v) {
        return valueOf(v);
    }

}
