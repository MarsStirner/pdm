
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipStartsAfterEndOf.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipStartsAfterEndOf">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="SAE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipStartsAfterEndOf")
@XmlEnum
public enum ActRelationshipStartsAfterEndOf {

    SAE;

    public String value() {
        return name();
    }

    public static ActRelationshipStartsAfterEndOf fromValue(String v) {
        return valueOf(v);
    }

}
