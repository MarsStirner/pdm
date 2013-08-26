
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipSplitExclusiveWait.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipSplitExclusiveWait">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="EW"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipSplitExclusiveWait")
@XmlEnum
public enum ActRelationshipSplitExclusiveWait {

    EW;

    public String value() {
        return name();
    }

    public static ActRelationshipSplitExclusiveWait fromValue(String v) {
        return valueOf(v);
    }

}
