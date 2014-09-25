
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipOccurrence.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipOccurrence">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="OCCR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipOccurrence")
@XmlEnum
public enum ActRelationshipOccurrence {

    OCCR;

    public String value() {
        return name();
    }

    public static ActRelationshipOccurrence fromValue(String v) {
        return valueOf(v);
    }

}
