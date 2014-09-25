
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EntityClassCityOrTown.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EntityClassCityOrTown">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="CITY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EntityClassCityOrTown")
@XmlEnum
public enum EntityClassCityOrTown {

    CITY;

    public String value() {
        return name();
    }

    public static EntityClassCityOrTown fromValue(String v) {
        return valueOf(v);
    }

}
