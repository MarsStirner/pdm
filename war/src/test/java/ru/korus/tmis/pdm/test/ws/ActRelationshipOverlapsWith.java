
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipOverlapsWith.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipOverlapsWith">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="OVERLAP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipOverlapsWith")
@XmlEnum
public enum ActRelationshipOverlapsWith {

    OVERLAP;

    public String value() {
        return name();
    }

    public static ActRelationshipOverlapsWith fromValue(String v) {
        return valueOf(v);
    }

}
