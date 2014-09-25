
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassClinicalResearchSponsor.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassClinicalResearchSponsor">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="CRSPNSR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleClassClinicalResearchSponsor")
@XmlEnum
public enum RoleClassClinicalResearchSponsor {

    CRSPNSR;

    public String value() {
        return name();
    }

    public static RoleClassClinicalResearchSponsor fromValue(String v) {
        return valueOf(v);
    }

}
