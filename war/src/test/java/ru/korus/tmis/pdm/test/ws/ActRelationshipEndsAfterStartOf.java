
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipEndsAfterStartOf.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipEndsAfterStartOf">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="EAS"/>
 *     &lt;enumeration value="EDU"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipEndsAfterStartOf")
@XmlEnum
public enum ActRelationshipEndsAfterStartOf {

    EAS,
    EDU;

    public String value() {
        return name();
    }

    public static ActRelationshipEndsAfterStartOf fromValue(String v) {
        return valueOf(v);
    }

}
