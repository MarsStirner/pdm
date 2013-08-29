
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipCurativeIndication.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipCurativeIndication">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="CURE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipCurativeIndication")
@XmlEnum
public enum ActRelationshipCurativeIndication {

    CURE;

    public String value() {
        return name();
    }

    public static ActRelationshipCurativeIndication fromValue(String v) {
        return valueOf(v);
    }

}