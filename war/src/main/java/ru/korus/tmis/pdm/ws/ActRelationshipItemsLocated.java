
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipItemsLocated.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipItemsLocated">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="ITEMSLOC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipItemsLocated")
@XmlEnum
public enum ActRelationshipItemsLocated {

    ITEMSLOC;

    public String value() {
        return name();
    }

    public static ActRelationshipItemsLocated fromValue(String v) {
        return valueOf(v);
    }

}
