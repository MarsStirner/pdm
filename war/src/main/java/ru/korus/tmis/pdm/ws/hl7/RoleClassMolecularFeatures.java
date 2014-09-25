
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassMolecularFeatures.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassMolecularFeatures">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="BOND"/>
 *     &lt;enumeration value="PART"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleClassMolecularFeatures")
@XmlEnum
public enum RoleClassMolecularFeatures {

    BOND,
    PART;

    public String value() {
        return name();
    }

    public static RoleClassMolecularFeatures fromValue(String v) {
        return valueOf(v);
    }

}
