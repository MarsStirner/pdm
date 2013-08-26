
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipEvaluatesGoal.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipEvaluatesGoal">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="GEVL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipEvaluatesGoal")
@XmlEnum
public enum ActRelationshipEvaluatesGoal {

    GEVL;

    public String value() {
        return name();
    }

    public static ActRelationshipEvaluatesGoal fromValue(String v) {
        return valueOf(v);
    }

}
