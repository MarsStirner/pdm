
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ParticipationPrimaryInformationRecipient.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ParticipationPrimaryInformationRecipient">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="PRCP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ParticipationPrimaryInformationRecipient")
@XmlEnum
public enum ParticipationPrimaryInformationRecipient {

    PRCP;

    public String value() {
        return name();
    }

    public static ParticipationPrimaryInformationRecipient fromValue(String v) {
        return valueOf(v);
    }

}
