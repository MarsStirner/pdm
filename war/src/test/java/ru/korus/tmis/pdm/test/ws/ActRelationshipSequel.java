
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipSequel.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipSequel">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="SEQL"/>
 *     &lt;enumeration value="APND"/>
 *     &lt;enumeration value="BSLN"/>
 *     &lt;enumeration value="COMPLY"/>
 *     &lt;enumeration value="DOC"/>
 *     &lt;enumeration value="FLFS"/>
 *     &lt;enumeration value="OCCR"/>
 *     &lt;enumeration value="OREF"/>
 *     &lt;enumeration value="SCH"/>
 *     &lt;enumeration value="GEN"/>
 *     &lt;enumeration value="GEVL"/>
 *     &lt;enumeration value="INST"/>
 *     &lt;enumeration value="MOD"/>
 *     &lt;enumeration value="MTCH"/>
 *     &lt;enumeration value="OPTN"/>
 *     &lt;enumeration value="RCHAL"/>
 *     &lt;enumeration value="REV"/>
 *     &lt;enumeration value="RPLC"/>
 *     &lt;enumeration value="SUCC"/>
 *     &lt;enumeration value="UPDT"/>
 *     &lt;enumeration value="XCRPT"/>
 *     &lt;enumeration value="VRXCRPT"/>
 *     &lt;enumeration value="XFRM"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipSequel")
@XmlEnum
public enum ActRelationshipSequel {

    SEQL,
    APND,
    BSLN,
    COMPLY,
    DOC,
    FLFS,
    OCCR,
    OREF,
    SCH,
    GEN,
    GEVL,
    INST,
    MOD,
    MTCH,
    OPTN,
    RCHAL,
    REV,
    RPLC,
    SUCC,
    UPDT,
    XCRPT,
    VRXCRPT,
    XFRM;

    public String value() {
        return name();
    }

    public static ActRelationshipSequel fromValue(String v) {
        return valueOf(v);
    }

}
