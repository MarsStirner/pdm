
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipICSRInvestigation.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipICSRInvestigation">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="RPLC"/>
 *     &lt;enumeration value="SEQL"/>
 *     &lt;enumeration value="SPRT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipICSRInvestigation")
@XmlEnum
public enum ActRelationshipICSRInvestigation {

    RPLC,
    SEQL,
    SPRT;

    public String value() {
        return name();
    }

    public static ActRelationshipICSRInvestigation fromValue(String v) {
        return valueOf(v);
    }

}
