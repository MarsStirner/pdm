
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for x_AccommodationRequestorRole.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="x_AccommodationRequestorRole">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="AGNT"/>
 *     &lt;enumeration value="PAT"/>
 *     &lt;enumeration value="PROV"/>
 *     &lt;enumeration value="PRS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "x_AccommodationRequestorRole")
@XmlEnum
public enum XAccommodationRequestorRole {

    AGNT,
    PAT,
    PROV,
    PRS;

    public String value() {
        return name();
    }

    public static XAccommodationRequestorRole fromValue(String v) {
        return valueOf(v);
    }

}
