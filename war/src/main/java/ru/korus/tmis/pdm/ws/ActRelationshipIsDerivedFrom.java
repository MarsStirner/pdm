
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipIsDerivedFrom.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipIsDerivedFrom">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="DRIV"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipIsDerivedFrom")
@XmlEnum
public enum ActRelationshipIsDerivedFrom {

    DRIV;

    public String value() {
        return name();
    }

    public static ActRelationshipIsDerivedFrom fromValue(String v) {
        return valueOf(v);
    }

}
