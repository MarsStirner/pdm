
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipSchedulesRequest.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipSchedulesRequest">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="SCH"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipSchedulesRequest")
@XmlEnum
public enum ActRelationshipSchedulesRequest {

    SCH;

    public String value() {
        return name();
    }

    public static ActRelationshipSchedulesRequest fromValue(String v) {
        return valueOf(v);
    }

}
