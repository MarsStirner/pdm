
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipConcurrentWith.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipConcurrentWith">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="CONCURRENT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipConcurrentWith")
@XmlEnum
public enum ActRelationshipConcurrentWith {

    CONCURRENT;

    public String value() {
        return name();
    }

    public static ActRelationshipConcurrentWith fromValue(String v) {
        return valueOf(v);
    }

}
