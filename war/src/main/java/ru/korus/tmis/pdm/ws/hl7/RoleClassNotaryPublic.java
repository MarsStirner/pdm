
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassNotaryPublic.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassNotaryPublic">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="NOT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleClassNotaryPublic")
@XmlEnum
public enum RoleClassNotaryPublic {

    NOT;

    public String value() {
        return name();
    }

    public static RoleClassNotaryPublic fromValue(String v) {
        return valueOf(v);
    }

}
