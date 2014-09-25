
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassConnection.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassConnection">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="CONC"/>
 *     &lt;enumeration value="BOND"/>
 *     &lt;enumeration value="CONY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleClassConnection")
@XmlEnum
public enum RoleClassConnection {

    CONC,
    BOND,
    CONY;

    public String value() {
        return name();
    }

    public static RoleClassConnection fromValue(String v) {
        return valueOf(v);
    }

}
