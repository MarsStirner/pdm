
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassActiveMoiety.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassActiveMoiety">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="ACTM"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleClassActiveMoiety")
@XmlEnum
public enum RoleClassActiveMoiety {

    ACTM;

    public String value() {
        return name();
    }

    public static RoleClassActiveMoiety fromValue(String v) {
        return valueOf(v);
    }

}
