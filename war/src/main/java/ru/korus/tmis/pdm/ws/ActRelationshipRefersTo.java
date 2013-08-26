
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipRefersTo.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipRefersTo">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="REFR"/>
 *     &lt;enumeration value="USE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipRefersTo")
@XmlEnum
public enum ActRelationshipRefersTo {

    REFR,
    USE;

    public String value() {
        return name();
    }

    public static ActRelationshipRefersTo fromValue(String v) {
        return valueOf(v);
    }

}
