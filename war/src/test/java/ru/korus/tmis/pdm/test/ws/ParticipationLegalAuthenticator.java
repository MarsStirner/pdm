
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ParticipationLegalAuthenticator.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ParticipationLegalAuthenticator">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="LA"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ParticipationLegalAuthenticator")
@XmlEnum
public enum ParticipationLegalAuthenticator {

    LA;

    public String value() {
        return name();
    }

    public static ParticipationLegalAuthenticator fromValue(String v) {
        return valueOf(v);
    }

}
