
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipCheckpointEnd.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipCheckpointEnd">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="E"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipCheckpointEnd")
@XmlEnum
public enum ActRelationshipCheckpointEnd {

    E;

    public String value() {
        return name();
    }

    public static ActRelationshipCheckpointEnd fromValue(String v) {
        return valueOf(v);
    }

}
