
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassCommissioningParty.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassCommissioningParty">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="COMPAR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleClassCommissioningParty")
@XmlEnum
public enum RoleClassCommissioningParty {

    COMPAR;

    public String value() {
        return name();
    }

    public static RoleClassCommissioningParty fromValue(String v) {
        return valueOf(v);
    }

}
