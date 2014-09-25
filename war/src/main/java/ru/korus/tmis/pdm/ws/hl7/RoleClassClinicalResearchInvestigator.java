
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassClinicalResearchInvestigator.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassClinicalResearchInvestigator">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="CRINV"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleClassClinicalResearchInvestigator")
@XmlEnum
public enum RoleClassClinicalResearchInvestigator {

    CRINV;

    public String value() {
        return name();
    }

    public static RoleClassClinicalResearchInvestigator fromValue(String v) {
        return valueOf(v);
    }

}
