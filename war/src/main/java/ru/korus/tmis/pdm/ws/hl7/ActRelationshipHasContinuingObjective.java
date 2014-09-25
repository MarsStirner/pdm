
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipHasContinuingObjective.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipHasContinuingObjective">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="OBJC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipHasContinuingObjective")
@XmlEnum
public enum ActRelationshipHasContinuingObjective {

    OBJC;

    public String value() {
        return name();
    }

    public static ActRelationshipHasContinuingObjective fromValue(String v) {
        return valueOf(v);
    }

}
