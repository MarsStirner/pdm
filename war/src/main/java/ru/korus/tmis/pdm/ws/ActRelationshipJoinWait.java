
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipJoinWait.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipJoinWait">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="W"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipJoinWait")
@XmlEnum
public enum ActRelationshipJoinWait {

    W;

    public String value() {
        return name();
    }

    public static ActRelationshipJoinWait fromValue(String v) {
        return valueOf(v);
    }

}
