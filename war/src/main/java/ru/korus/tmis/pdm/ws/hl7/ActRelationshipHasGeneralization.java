
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipHasGeneralization.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipHasGeneralization">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="GEN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipHasGeneralization")
@XmlEnum
public enum ActRelationshipHasGeneralization {

    GEN;

    public String value() {
        return name();
    }

    public static ActRelationshipHasGeneralization fromValue(String v) {
        return valueOf(v);
    }

}
