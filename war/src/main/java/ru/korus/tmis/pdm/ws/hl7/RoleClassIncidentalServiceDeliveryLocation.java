
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassIncidentalServiceDeliveryLocation.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassIncidentalServiceDeliveryLocation">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="ISDLOC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleClassIncidentalServiceDeliveryLocation")
@XmlEnum
public enum RoleClassIncidentalServiceDeliveryLocation {

    ISDLOC;

    public String value() {
        return name();
    }

    public static RoleClassIncidentalServiceDeliveryLocation fromValue(String v) {
        return valueOf(v);
    }

}
