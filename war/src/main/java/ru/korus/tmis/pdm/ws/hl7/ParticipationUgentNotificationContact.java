
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ParticipationUgentNotificationContact.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ParticipationUgentNotificationContact">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="NOT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ParticipationUgentNotificationContact")
@XmlEnum
public enum ParticipationUgentNotificationContact {

    NOT;

    public String value() {
        return name();
    }

    public static ParticipationUgentNotificationContact fromValue(String v) {
        return valueOf(v);
    }

}
