
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassSubstancePresence.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassSubstancePresence">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="CONT"/>
 *     &lt;enumeration value="INGR"/>
 *     &lt;enumeration value="ACTI"/>
 *     &lt;enumeration value="ACTIB"/>
 *     &lt;enumeration value="ACTIM"/>
 *     &lt;enumeration value="ACTIR"/>
 *     &lt;enumeration value="ADJV"/>
 *     &lt;enumeration value="ADTV"/>
 *     &lt;enumeration value="BASE"/>
 *     &lt;enumeration value="IACT"/>
 *     &lt;enumeration value="COLR"/>
 *     &lt;enumeration value="FLVR"/>
 *     &lt;enumeration value="PRSV"/>
 *     &lt;enumeration value="STBL"/>
 *     &lt;enumeration value="MECH"/>
 *     &lt;enumeration value="LOCE"/>
 *     &lt;enumeration value="STOR"/>
 *     &lt;enumeration value="PART"/>
 *     &lt;enumeration value="ACTM"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleClassSubstancePresence")
@XmlEnum
public enum RoleClassSubstancePresence {

    CONT,
    INGR,
    ACTI,
    ACTIB,
    ACTIM,
    ACTIR,
    ADJV,
    ADTV,
    BASE,
    IACT,
    COLR,
    FLVR,
    PRSV,
    STBL,
    MECH,
    LOCE,
    STOR,
    PART,
    ACTM;

    public String value() {
        return name();
    }

    public static RoleClassSubstancePresence fromValue(String v) {
        return valueOf(v);
    }

}
