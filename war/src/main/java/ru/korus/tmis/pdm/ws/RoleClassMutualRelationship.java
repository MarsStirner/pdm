
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassMutualRelationship.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassMutualRelationship">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="AFFL"/>
 *     &lt;enumeration value="AGNT"/>
 *     &lt;enumeration value="ASSIGNED"/>
 *     &lt;enumeration value="COMPAR"/>
 *     &lt;enumeration value="SGNOFF"/>
 *     &lt;enumeration value="CON"/>
 *     &lt;enumeration value="ECON"/>
 *     &lt;enumeration value="NOK"/>
 *     &lt;enumeration value="GUARD"/>
 *     &lt;enumeration value="CIT"/>
 *     &lt;enumeration value="COVPTY"/>
 *     &lt;enumeration value="CLAIM"/>
 *     &lt;enumeration value="NAMED"/>
 *     &lt;enumeration value="DEPEN"/>
 *     &lt;enumeration value="INDIV"/>
 *     &lt;enumeration value="SUBSCR"/>
 *     &lt;enumeration value="PROG"/>
 *     &lt;enumeration value="CRINV"/>
 *     &lt;enumeration value="CRSPNSR"/>
 *     &lt;enumeration value="EMP"/>
 *     &lt;enumeration value="MIL"/>
 *     &lt;enumeration value="GUAR"/>
 *     &lt;enumeration value="INVSBJ"/>
 *     &lt;enumeration value="CASEBJ"/>
 *     &lt;enumeration value="RESBJ"/>
 *     &lt;enumeration value="LIC"/>
 *     &lt;enumeration value="NOT"/>
 *     &lt;enumeration value="PROV"/>
 *     &lt;enumeration value="PAT"/>
 *     &lt;enumeration value="PAYEE"/>
 *     &lt;enumeration value="PAYOR"/>
 *     &lt;enumeration value="POLHOLD"/>
 *     &lt;enumeration value="QUAL"/>
 *     &lt;enumeration value="SPNSR"/>
 *     &lt;enumeration value="STD"/>
 *     &lt;enumeration value="UNDWRT"/>
 *     &lt;enumeration value="CAREGIVER"/>
 *     &lt;enumeration value="PRS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleClassMutualRelationship")
@XmlEnum
public enum RoleClassMutualRelationship {

    AFFL,
    AGNT,
    ASSIGNED,
    COMPAR,
    SGNOFF,
    CON,
    ECON,
    NOK,
    GUARD,
    CIT,
    COVPTY,
    CLAIM,
    NAMED,
    DEPEN,
    INDIV,
    SUBSCR,
    PROG,
    CRINV,
    CRSPNSR,
    EMP,
    MIL,
    GUAR,
    INVSBJ,
    CASEBJ,
    RESBJ,
    LIC,
    NOT,
    PROV,
    PAT,
    PAYEE,
    PAYOR,
    POLHOLD,
    QUAL,
    SPNSR,
    STD,
    UNDWRT,
    CAREGIVER,
    PRS;

    public String value() {
        return name();
    }

    public static RoleClassMutualRelationship fromValue(String v) {
        return valueOf(v);
    }

}
