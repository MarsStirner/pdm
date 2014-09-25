
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActMoodExpectation.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActMoodExpectation">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="EXPEC"/>
 *     &lt;enumeration value="GOL"/>
 *     &lt;enumeration value="RSK"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActMoodExpectation")
@XmlEnum
public enum ActMoodExpectation {

    EXPEC,
    GOL,
    RSK;

    public String value() {
        return name();
    }

    public static ActMoodExpectation fromValue(String v) {
        return valueOf(v);
    }

}
