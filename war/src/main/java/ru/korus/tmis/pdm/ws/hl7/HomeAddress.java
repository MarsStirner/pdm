
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HomeAddress.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HomeAddress">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="H"/>
 *     &lt;enumeration value="HP"/>
 *     &lt;enumeration value="HV"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HomeAddress")
@XmlEnum
public enum HomeAddress {

    H,
    HP,
    HV;

    public String value() {
        return name();
    }

    public static HomeAddress fromValue(String v) {
        return valueOf(v);
    }

}
