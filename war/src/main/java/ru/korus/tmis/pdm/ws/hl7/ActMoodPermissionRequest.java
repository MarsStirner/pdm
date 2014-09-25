
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActMoodPermissionRequest.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActMoodPermissionRequest">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="PERMRQ"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActMoodPermissionRequest")
@XmlEnum
public enum ActMoodPermissionRequest {

    PERMRQ;

    public String value() {
        return name();
    }

    public static ActMoodPermissionRequest fromValue(String v) {
        return valueOf(v);
    }

}
