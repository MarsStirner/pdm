
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassPlaceOfDeath.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassPlaceOfDeath">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="DEATHPLC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleClassPlaceOfDeath")
@XmlEnum
public enum RoleClassPlaceOfDeath {

    DEATHPLC;

    public String value() {
        return name();
    }

    public static RoleClassPlaceOfDeath fromValue(String v) {
        return valueOf(v);
    }

}
