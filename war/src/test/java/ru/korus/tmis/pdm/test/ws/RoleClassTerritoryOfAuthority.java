
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassTerritoryOfAuthority.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassTerritoryOfAuthority">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="TERR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleClassTerritoryOfAuthority")
@XmlEnum
public enum RoleClassTerritoryOfAuthority {

    TERR;

    public String value() {
        return name();
    }

    public static RoleClassTerritoryOfAuthority fromValue(String v) {
        return valueOf(v);
    }

}
