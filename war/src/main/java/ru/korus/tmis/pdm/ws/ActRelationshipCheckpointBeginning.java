
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipCheckpointBeginning.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipCheckpointBeginning">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="B"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipCheckpointBeginning")
@XmlEnum
public enum ActRelationshipCheckpointBeginning {

    B;

    public String value() {
        return name();
    }

    public static ActRelationshipCheckpointBeginning fromValue(String v) {
        return valueOf(v);
    }

}
