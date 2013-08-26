
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassNursePractitioner.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassNursePractitioner">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="NURPRAC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleClassNursePractitioner")
@XmlEnum
public enum RoleClassNursePractitioner {

    NURPRAC;

    public String value() {
        return name();
    }

    public static RoleClassNursePractitioner fromValue(String v) {
        return valueOf(v);
    }

}
