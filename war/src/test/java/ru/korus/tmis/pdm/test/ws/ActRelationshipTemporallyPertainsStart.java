
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipTemporallyPertainsStart.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipTemporallyPertainsStart">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="SAE"/>
 *     &lt;enumeration value="SAS"/>
 *     &lt;enumeration value="SDU"/>
 *     &lt;enumeration value="SBS"/>
 *     &lt;enumeration value="SCW"/>
 *     &lt;enumeration value="CONCURRENT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipTemporallyPertainsStart")
@XmlEnum
public enum ActRelationshipTemporallyPertainsStart {

    SAE,
    SAS,
    SDU,
    SBS,
    SCW,
    CONCURRENT;

    public String value() {
        return name();
    }

    public static ActRelationshipTemporallyPertainsStart fromValue(String v) {
        return valueOf(v);
    }

}
