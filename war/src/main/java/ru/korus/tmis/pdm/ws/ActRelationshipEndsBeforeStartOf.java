
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipEndsBeforeStartOf.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipEndsBeforeStartOf">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="EBS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipEndsBeforeStartOf")
@XmlEnum
public enum ActRelationshipEndsBeforeStartOf {

    EBS;

    public String value() {
        return name();
    }

    public static ActRelationshipEndsBeforeStartOf fromValue(String v) {
        return valueOf(v);
    }

}
