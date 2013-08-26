
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AddressUse.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AddressUse">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="AS"/>
 *     &lt;enumeration value="BAD"/>
 *     &lt;enumeration value="CONF"/>
 *     &lt;enumeration value="DIR"/>
 *     &lt;enumeration value="EC"/>
 *     &lt;enumeration value="H"/>
 *     &lt;enumeration value="HP"/>
 *     &lt;enumeration value="HV"/>
 *     &lt;enumeration value="MC"/>
 *     &lt;enumeration value="PG"/>
 *     &lt;enumeration value="PHYS"/>
 *     &lt;enumeration value="PST"/>
 *     &lt;enumeration value="PUB"/>
 *     &lt;enumeration value="TMP"/>
 *     &lt;enumeration value="WP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AddressUse")
@XmlEnum
public enum AddressUse {

    AS,
    BAD,
    CONF,
    DIR,
    EC,
    H,
    HP,
    HV,
    MC,
    PG,
    PHYS,
    PST,
    PUB,
    TMP,
    WP;

    public String value() {
        return name();
    }

    public static AddressUse fromValue(String v) {
        return valueOf(v);
    }

}
