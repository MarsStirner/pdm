
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipJoinKill.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipJoinKill">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="K"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipJoinKill")
@XmlEnum
public enum ActRelationshipJoinKill {

    K;

    public String value() {
        return name();
    }

    public static ActRelationshipJoinKill fromValue(String v) {
        return valueOf(v);
    }

}
