
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipEndsConcurrentWith.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipEndsConcurrentWith">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="ECW"/>
 *     &lt;enumeration value="CONCURRENT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipEndsConcurrentWith")
@XmlEnum
public enum ActRelationshipEndsConcurrentWith {

    ECW,
    CONCURRENT;

    public String value() {
        return name();
    }

    public static ActRelationshipEndsConcurrentWith fromValue(String v) {
        return valueOf(v);
    }

}
