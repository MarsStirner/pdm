
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipStartsConcurrentWith.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipStartsConcurrentWith">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="SCW"/>
 *     &lt;enumeration value="CONCURRENT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipStartsConcurrentWith")
@XmlEnum
public enum ActRelationshipStartsConcurrentWith {

    SCW,
    CONCURRENT;

    public String value() {
        return name();
    }

    public static ActRelationshipStartsConcurrentWith fromValue(String v) {
        return valueOf(v);
    }

}
