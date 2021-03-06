
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipRecovery.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipRecovery">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="RCVY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipRecovery")
@XmlEnum
public enum ActRelationshipRecovery {

    RCVY;

    public String value() {
        return name();
    }

    public static ActRelationshipRecovery fromValue(String v) {
        return valueOf(v);
    }

}
