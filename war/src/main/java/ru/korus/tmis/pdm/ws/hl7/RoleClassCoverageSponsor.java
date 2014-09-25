
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassCoverageSponsor.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassCoverageSponsor">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="SPNSR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleClassCoverageSponsor")
@XmlEnum
public enum RoleClassCoverageSponsor {

    SPNSR;

    public String value() {
        return name();
    }

    public static RoleClassCoverageSponsor fromValue(String v) {
        return valueOf(v);
    }

}
