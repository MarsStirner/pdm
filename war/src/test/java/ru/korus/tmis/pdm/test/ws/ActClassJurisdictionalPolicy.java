
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassJurisdictionalPolicy.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassJurisdictionalPolicy">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="JURISPOL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActClassJurisdictionalPolicy")
@XmlEnum
public enum ActClassJurisdictionalPolicy {

    JURISPOL;

    public String value() {
        return name();
    }

    public static ActClassJurisdictionalPolicy fromValue(String v) {
        return valueOf(v);
    }

}
