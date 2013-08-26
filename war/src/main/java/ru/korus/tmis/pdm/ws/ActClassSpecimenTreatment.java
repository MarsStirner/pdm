
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassSpecimenTreatment.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassSpecimenTreatment">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="SPCTRT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActClassSpecimenTreatment")
@XmlEnum
public enum ActClassSpecimenTreatment {

    SPCTRT;

    public String value() {
        return name();
    }

    public static ActClassSpecimenTreatment fromValue(String v) {
        return valueOf(v);
    }

}
