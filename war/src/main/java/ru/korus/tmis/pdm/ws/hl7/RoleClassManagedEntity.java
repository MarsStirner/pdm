
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassManagedEntity.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassManagedEntity">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="ACCESS"/>
 *     &lt;enumeration value="HLD"/>
 *     &lt;enumeration value="MNT"/>
 *     &lt;enumeration value="OWN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleClassManagedEntity")
@XmlEnum
public enum RoleClassManagedEntity {

    ACCESS,
    HLD,
    MNT,
    OWN;

    public String value() {
        return name();
    }

    public static RoleClassManagedEntity fromValue(String v) {
        return valueOf(v);
    }

}
