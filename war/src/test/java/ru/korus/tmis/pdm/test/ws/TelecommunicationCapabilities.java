
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TelecommunicationCapabilities.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TelecommunicationCapabilities">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="DATA"/>
 *     &lt;enumeration value="FAX"/>
 *     &lt;enumeration value="SMS"/>
 *     &lt;enumeration value="TTY"/>
 *     &lt;enumeration value="VOICE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TelecommunicationCapabilities")
@XmlEnum
public enum TelecommunicationCapabilities {

    DATA,
    FAX,
    SMS,
    TTY,
    VOICE;

    public String value() {
        return name();
    }

    public static TelecommunicationCapabilities fromValue(String v) {
        return valueOf(v);
    }

}
