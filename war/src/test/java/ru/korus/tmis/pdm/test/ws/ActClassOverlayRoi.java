
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassOverlayRoi.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassOverlayRoi">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="ROIOVL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActClassOverlayRoi")
@XmlEnum
public enum ActClassOverlayRoi {

    ROIOVL;

    public String value() {
        return name();
    }

    public static ActClassOverlayRoi fromValue(String v) {
        return valueOf(v);
    }

}
