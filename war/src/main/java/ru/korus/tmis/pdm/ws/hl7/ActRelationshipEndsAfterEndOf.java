
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipEndsAfterEndOf.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipEndsAfterEndOf">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="EAE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipEndsAfterEndOf")
@XmlEnum
public enum ActRelationshipEndsAfterEndOf {

    EAE;

    public String value() {
        return name();
    }

    public static ActRelationshipEndsAfterEndOf fromValue(String v) {
        return valueOf(v);
    }

}
