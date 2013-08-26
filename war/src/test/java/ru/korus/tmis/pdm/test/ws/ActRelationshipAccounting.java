
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipAccounting.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipAccounting">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="CHRG"/>
 *     &lt;enumeration value="COST"/>
 *     &lt;enumeration value="CHRG"/>
 *     &lt;enumeration value="COST"/>
 *     &lt;enumeration value="CREDIT"/>
 *     &lt;enumeration value="DEBIT"/>
 *     &lt;enumeration value="CREDIT"/>
 *     &lt;enumeration value="DEBIT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipAccounting")
@XmlEnum
public enum ActRelationshipAccounting {

    CHRG,
    COST,
    CREDIT,
    DEBIT;

    public String value() {
        return name();
    }

    public static ActRelationshipAccounting fromValue(String v) {
        return valueOf(v);
    }

}
