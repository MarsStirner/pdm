
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActMoodActRequest.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActMoodActRequest">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="ARQ"/>
 *     &lt;enumeration value="PERMRQ"/>
 *     &lt;enumeration value="RQO"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActMoodActRequest")
@XmlEnum
public enum ActMoodActRequest {

    ARQ,
    PERMRQ,
    RQO;

    public String value() {
        return name();
    }

    public static ActMoodActRequest fromValue(String v) {
        return valueOf(v);
    }

}
