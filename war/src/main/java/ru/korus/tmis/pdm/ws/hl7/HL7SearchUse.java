
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HL7SearchUse.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HL7SearchUse">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="SRCH"/>
 *     &lt;enumeration value="PHON"/>
 *     &lt;enumeration value="SNDX"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HL7SearchUse")
@XmlEnum
public enum HL7SearchUse {

    SRCH,
    PHON,
    SNDX;

    public String value() {
        return name();
    }

    public static HL7SearchUse fromValue(String v) {
        return valueOf(v);
    }

}
