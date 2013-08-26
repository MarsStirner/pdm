
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassCorrelatedObservationSequences.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassCorrelatedObservationSequences">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="OBSCOR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActClassCorrelatedObservationSequences")
@XmlEnum
public enum ActClassCorrelatedObservationSequences {

    OBSCOR;

    public String value() {
        return name();
    }

    public static ActClassCorrelatedObservationSequences fromValue(String v) {
        return valueOf(v);
    }

}
