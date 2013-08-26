
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClassNullFlavor.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ClassNullFlavor">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="ASKU"/>
 *     &lt;enumeration value="MSK"/>
 *     &lt;enumeration value="NA"/>
 *     &lt;enumeration value="NASK"/>
 *     &lt;enumeration value="NAV"/>
 *     &lt;enumeration value="NI"/>
 *     &lt;enumeration value="UNK"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ClassNullFlavor")
@XmlEnum
public enum ClassNullFlavor {

    ASKU,
    MSK,
    NA,
    NASK,
    NAV,
    NI,
    UNK;

    public String value() {
        return name();
    }

    public static ClassNullFlavor fromValue(String v) {
        return valueOf(v);
    }

}
