
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipProvidesEvidenceFor.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipProvidesEvidenceFor">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="EVID"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipProvidesEvidenceFor")
@XmlEnum
public enum ActRelationshipProvidesEvidenceFor {

    EVID;

    public String value() {
        return name();
    }

    public static ActRelationshipProvidesEvidenceFor fromValue(String v) {
        return valueOf(v);
    }

}
