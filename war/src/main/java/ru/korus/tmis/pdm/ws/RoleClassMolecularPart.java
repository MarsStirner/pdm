
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassMolecularPart.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassMolecularPart">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="ACTM"/>
 *     &lt;enumeration value="PART"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleClassMolecularPart")
@XmlEnum
public enum RoleClassMolecularPart {

    ACTM,
    PART;

    public String value() {
        return name();
    }

    public static RoleClassMolecularPart fromValue(String v) {
        return valueOf(v);
    }

}
