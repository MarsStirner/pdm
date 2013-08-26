
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipStartsBeforeStartOf.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipStartsBeforeStartOf">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="SBS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipStartsBeforeStartOf")
@XmlEnum
public enum ActRelationshipStartsBeforeStartOf {

    SBS;

    public String value() {
        return name();
    }

    public static ActRelationshipStartsBeforeStartOf fromValue(String v) {
        return valueOf(v);
    }

}
