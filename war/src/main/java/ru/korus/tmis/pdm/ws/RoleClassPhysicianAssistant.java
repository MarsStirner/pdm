
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassPhysicianAssistant.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassPhysicianAssistant">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="PA"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleClassPhysicianAssistant")
@XmlEnum
public enum RoleClassPhysicianAssistant {

    PA;

    public String value() {
        return name();
    }

    public static RoleClassPhysicianAssistant fromValue(String v) {
        return valueOf(v);
    }

}
