
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EntityClassStateOrProvince.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EntityClassStateOrProvince">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="PROVINCE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EntityClassStateOrProvince")
@XmlEnum
public enum EntityClassStateOrProvince {

    PROVINCE;

    public String value() {
        return name();
    }

    public static EntityClassStateOrProvince fromValue(String v) {
        return valueOf(v);
    }

}
