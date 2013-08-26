
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassICSRInvestigationSubject.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassICSRInvestigationSubject">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="CASEBJ"/>
 *     &lt;enumeration value="INVSBJ"/>
 *     &lt;enumeration value="PAT"/>
 *     &lt;enumeration value="RESBJ"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleClassICSRInvestigationSubject")
@XmlEnum
public enum RoleClassICSRInvestigationSubject {

    CASEBJ,
    INVSBJ,
    PAT,
    RESBJ;

    public String value() {
        return name();
    }

    public static RoleClassICSRInvestigationSubject fromValue(String v) {
        return valueOf(v);
    }

}
