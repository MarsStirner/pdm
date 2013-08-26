
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipAuthorizedBy.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipAuthorizedBy">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="AUTH"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipAuthorizedBy")
@XmlEnum
public enum ActRelationshipAuthorizedBy {

    AUTH;

    public String value() {
        return name();
    }

    public static ActRelationshipAuthorizedBy fromValue(String v) {
        return valueOf(v);
    }

}
