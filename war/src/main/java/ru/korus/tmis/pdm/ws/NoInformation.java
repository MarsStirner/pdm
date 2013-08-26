
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NoInformation.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="NoInformation">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="NI"/>
 *     &lt;enumeration value="INV"/>
 *     &lt;enumeration value="DER"/>
 *     &lt;enumeration value="OTH"/>
 *     &lt;enumeration value="NINF"/>
 *     &lt;enumeration value="PINF"/>
 *     &lt;enumeration value="UNC"/>
 *     &lt;enumeration value="MSK"/>
 *     &lt;enumeration value="NA"/>
 *     &lt;enumeration value="UNK"/>
 *     &lt;enumeration value="ASKU"/>
 *     &lt;enumeration value="NAV"/>
 *     &lt;enumeration value="NASK"/>
 *     &lt;enumeration value="QS"/>
 *     &lt;enumeration value="TRC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "NoInformation")
@XmlEnum
public enum NoInformation {

    NI,
    INV,
    DER,
    OTH,
    NINF,
    PINF,
    UNC,
    MSK,
    NA,
    UNK,
    ASKU,
    NAV,
    NASK,
    QS,
    TRC;

    public String value() {
        return name();
    }

    public static NoInformation fromValue(String v) {
        return valueOf(v);
    }

}
