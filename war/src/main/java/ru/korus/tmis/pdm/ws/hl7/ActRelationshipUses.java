
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipUses.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipUses">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="USE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipUses")
@XmlEnum
public enum ActRelationshipUses {

    USE;

    public String value() {
        return name();
    }

    public static ActRelationshipUses fromValue(String v) {
        return valueOf(v);
    }

}
