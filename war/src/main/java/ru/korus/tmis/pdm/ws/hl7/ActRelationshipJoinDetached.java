
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipJoinDetached.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipJoinDetached">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="D"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipJoinDetached")
@XmlEnum
public enum ActRelationshipJoinDetached {

    D;

    public String value() {
        return name();
    }

    public static ActRelationshipJoinDetached fromValue(String v) {
        return valueOf(v);
    }

}
