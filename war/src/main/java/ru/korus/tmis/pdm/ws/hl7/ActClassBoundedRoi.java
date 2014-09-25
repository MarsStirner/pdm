
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassBoundedRoi.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassBoundedRoi">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="ROIBND"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActClassBoundedRoi")
@XmlEnum
public enum ActClassBoundedRoi {

    ROIBND;

    public String value() {
        return name();
    }

    public static ActClassBoundedRoi fromValue(String v) {
        return valueOf(v);
    }

}
