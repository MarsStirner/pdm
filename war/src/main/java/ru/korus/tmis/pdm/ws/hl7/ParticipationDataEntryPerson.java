
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ParticipationDataEntryPerson.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ParticipationDataEntryPerson">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="ENT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ParticipationDataEntryPerson")
@XmlEnum
public enum ParticipationDataEntryPerson {

    ENT;

    public String value() {
        return name();
    }

    public static ParticipationDataEntryPerson fromValue(String v) {
        return valueOf(v);
    }

}
