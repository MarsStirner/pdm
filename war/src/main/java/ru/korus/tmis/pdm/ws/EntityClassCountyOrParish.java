
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EntityClassCountyOrParish.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EntityClassCountyOrParish">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="COUNTY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EntityClassCountyOrParish")
@XmlEnum
public enum EntityClassCountyOrParish {

    COUNTY;

    public String value() {
        return name();
    }

    public static EntityClassCountyOrParish fromValue(String v) {
        return valueOf(v);
    }

}
