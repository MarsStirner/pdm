
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassBioSequenceVariation.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassBioSequenceVariation">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="SEQVAR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActClassBioSequenceVariation")
@XmlEnum
public enum ActClassBioSequenceVariation {

    SEQVAR;

    public String value() {
        return name();
    }

    public static ActClassBioSequenceVariation fromValue(String v) {
        return valueOf(v);
    }

}
