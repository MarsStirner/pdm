
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassSigningAuthorityOrOfficer.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassSigningAuthorityOrOfficer">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="SGNOFF"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleClassSigningAuthorityOrOfficer")
@XmlEnum
public enum RoleClassSigningAuthorityOrOfficer {

    SGNOFF;

    public String value() {
        return name();
    }

    public static RoleClassSigningAuthorityOrOfficer fromValue(String v) {
        return valueOf(v);
    }

}
