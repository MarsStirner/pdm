
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipHasFinalObjective.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipHasFinalObjective">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="OBJF"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipHasFinalObjective")
@XmlEnum
public enum ActRelationshipHasFinalObjective {

    OBJF;

    public String value() {
        return name();
    }

    public static ActRelationshipHasFinalObjective fromValue(String v) {
        return valueOf(v);
    }

}
