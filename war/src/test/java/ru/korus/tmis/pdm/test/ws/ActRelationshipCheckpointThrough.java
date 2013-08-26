
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipCheckpointThrough.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipCheckpointThrough">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="T"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipCheckpointThrough")
@XmlEnum
public enum ActRelationshipCheckpointThrough {

    T;

    public String value() {
        return name();
    }

    public static ActRelationshipCheckpointThrough fromValue(String v) {
        return valueOf(v);
    }

}
