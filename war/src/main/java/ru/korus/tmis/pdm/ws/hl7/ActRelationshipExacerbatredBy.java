
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipExacerbatredBy.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipExacerbatredBy">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="EXACBY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipExacerbatredBy")
@XmlEnum
public enum ActRelationshipExacerbatredBy {

    EXACBY;

    public String value() {
        return name();
    }

    public static ActRelationshipExacerbatredBy fromValue(String v) {
        return valueOf(v);
    }

}
