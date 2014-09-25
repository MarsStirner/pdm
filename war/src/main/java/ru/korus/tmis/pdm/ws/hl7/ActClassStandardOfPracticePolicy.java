
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassStandardOfPracticePolicy.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassStandardOfPracticePolicy">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="STDPOL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActClassStandardOfPracticePolicy")
@XmlEnum
public enum ActClassStandardOfPracticePolicy {

    STDPOL;

    public String value() {
        return name();
    }

    public static ActClassStandardOfPracticePolicy fromValue(String v) {
        return valueOf(v);
    }

}
