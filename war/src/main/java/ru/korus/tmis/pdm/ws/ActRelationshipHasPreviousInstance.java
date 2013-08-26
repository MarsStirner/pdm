
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipHasPreviousInstance.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipHasPreviousInstance">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="PREV"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipHasPreviousInstance")
@XmlEnum
public enum ActRelationshipHasPreviousInstance {

    PREV;

    public String value() {
        return name();
    }

    public static ActRelationshipHasPreviousInstance fromValue(String v) {
        return valueOf(v);
    }

}
