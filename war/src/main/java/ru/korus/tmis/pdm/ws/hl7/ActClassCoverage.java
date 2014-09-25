
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassCoverage.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassCoverage">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="COV"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActClassCoverage")
@XmlEnum
public enum ActClassCoverage {

    COV;

    public String value() {
        return name();
    }

    public static ActClassCoverage fromValue(String v) {
        return valueOf(v);
    }

}
