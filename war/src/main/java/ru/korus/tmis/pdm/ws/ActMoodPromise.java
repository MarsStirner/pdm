
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActMoodPromise.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActMoodPromise">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="PRMS"/>
 *     &lt;enumeration value="APT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActMoodPromise")
@XmlEnum
public enum ActMoodPromise {

    PRMS,
    APT;

    public String value() {
        return name();
    }

    public static ActMoodPromise fromValue(String v) {
        return valueOf(v);
    }

}
