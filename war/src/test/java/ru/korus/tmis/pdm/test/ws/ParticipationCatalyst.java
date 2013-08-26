
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ParticipationCatalyst.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ParticipationCatalyst">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="CAT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ParticipationCatalyst")
@XmlEnum
public enum ParticipationCatalyst {

    CAT;

    public String value() {
        return name();
    }

    public static ParticipationCatalyst fromValue(String v) {
        return valueOf(v);
    }

}
