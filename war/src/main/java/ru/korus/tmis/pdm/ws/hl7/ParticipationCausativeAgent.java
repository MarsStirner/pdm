
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ParticipationCausativeAgent.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ParticipationCausativeAgent">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="CAGNT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ParticipationCausativeAgent")
@XmlEnum
public enum ParticipationCausativeAgent {

    CAGNT;

    public String value() {
        return name();
    }

    public static ParticipationCausativeAgent fromValue(String v) {
        return valueOf(v);
    }

}
