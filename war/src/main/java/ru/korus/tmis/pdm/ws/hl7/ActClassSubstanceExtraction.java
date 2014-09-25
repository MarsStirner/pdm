
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassSubstanceExtraction.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassSubstanceExtraction">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="SBEXT"/>
 *     &lt;enumeration value="SPECCOLLECT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActClassSubstanceExtraction")
@XmlEnum
public enum ActClassSubstanceExtraction {

    SBEXT,
    SPECCOLLECT;

    public String value() {
        return name();
    }

    public static ActClassSubstanceExtraction fromValue(String v) {
        return valueOf(v);
    }

}
