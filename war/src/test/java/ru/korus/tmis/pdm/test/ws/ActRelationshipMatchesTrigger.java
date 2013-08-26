
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipMatchesTrigger.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipMatchesTrigger">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="MTCH"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipMatchesTrigger")
@XmlEnum
public enum ActRelationshipMatchesTrigger {

    MTCH;

    public String value() {
        return name();
    }

    public static ActRelationshipMatchesTrigger fromValue(String v) {
        return valueOf(v);
    }

}
