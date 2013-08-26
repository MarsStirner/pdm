
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipJoinExclusiveWait.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipJoinExclusiveWait">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="X"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipJoinExclusiveWait")
@XmlEnum
public enum ActRelationshipJoinExclusiveWait {

    X;

    public String value() {
        return name();
    }

    public static ActRelationshipJoinExclusiveWait fromValue(String v) {
        return valueOf(v);
    }

}
