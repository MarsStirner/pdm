
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassHealthcareProvider.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassHealthcareProvider">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="PROV"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleClassHealthcareProvider")
@XmlEnum
public enum RoleClassHealthcareProvider {

    PROV;

    public String value() {
        return name();
    }

    public static RoleClassHealthcareProvider fromValue(String v) {
        return valueOf(v);
    }

}
