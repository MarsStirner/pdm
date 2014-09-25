
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipCheckpointEntry.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipCheckpointEntry">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="S"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipCheckpointEntry")
@XmlEnum
public enum ActRelationshipCheckpointEntry {

    S;

    public String value() {
        return name();
    }

    public static ActRelationshipCheckpointEntry fromValue(String v) {
        return valueOf(v);
    }

}
