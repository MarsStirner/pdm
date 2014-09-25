
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassReview.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassReview">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="REV"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActClassReview")
@XmlEnum
public enum ActClassReview {

    REV;

    public String value() {
        return name();
    }

    public static ActClassReview fromValue(String v) {
        return valueOf(v);
    }

}
