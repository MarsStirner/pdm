
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EntityClassFood.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EntityClassFood">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="FOOD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EntityClassFood")
@XmlEnum
public enum EntityClassFood {

    FOOD;

    public String value() {
        return name();
    }

    public static EntityClassFood fromValue(String v) {
        return valueOf(v);
    }

}
