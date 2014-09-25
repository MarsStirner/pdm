
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassAdministerableMaterial.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassAdministerableMaterial">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="ADMM"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleClassAdministerableMaterial")
@XmlEnum
public enum RoleClassAdministerableMaterial {

    ADMM;

    public String value() {
        return name();
    }

    public static RoleClassAdministerableMaterial fromValue(String v) {
        return valueOf(v);
    }

}
