
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipTemporallyPertainsEnd.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipTemporallyPertainsEnd">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="EAE"/>
 *     &lt;enumeration value="EAS"/>
 *     &lt;enumeration value="EDU"/>
 *     &lt;enumeration value="EBS"/>
 *     &lt;enumeration value="ECW"/>
 *     &lt;enumeration value="CONCURRENT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipTemporallyPertainsEnd")
@XmlEnum
public enum ActRelationshipTemporallyPertainsEnd {

    EAE,
    EAS,
    EDU,
    EBS,
    ECW,
    CONCURRENT;

    public String value() {
        return name();
    }

    public static ActRelationshipTemporallyPertainsEnd fromValue(String v) {
        return valueOf(v);
    }

}
