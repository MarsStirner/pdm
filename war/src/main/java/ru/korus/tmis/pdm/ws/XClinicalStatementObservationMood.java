
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for x_ClinicalStatementObservationMood.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="x_ClinicalStatementObservationMood">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="APT"/>
 *     &lt;enumeration value="ARQ"/>
 *     &lt;enumeration value="CRT"/>
 *     &lt;enumeration value="DEF"/>
 *     &lt;enumeration value="EVN"/>
 *     &lt;enumeration value="EVN.CRT"/>
 *     &lt;enumeration value="GOL"/>
 *     &lt;enumeration value="INT"/>
 *     &lt;enumeration value="PRMS"/>
 *     &lt;enumeration value="PRP"/>
 *     &lt;enumeration value="RQO"/>
 *     &lt;enumeration value="RSK"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "x_ClinicalStatementObservationMood")
@XmlEnum
public enum XClinicalStatementObservationMood {

    APT("APT"),
    ARQ("ARQ"),
    CRT("CRT"),
    DEF("DEF"),
    EVN("EVN"),
    @XmlEnumValue("EVN.CRT")
    EVN_CRT("EVN.CRT"),
    GOL("GOL"),
    INT("INT"),
    PRMS("PRMS"),
    PRP("PRP"),
    RQO("RQO"),
    RSK("RSK");
    private final String value;

    XClinicalStatementObservationMood(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static XClinicalStatementObservationMood fromValue(String v) {
        for (XClinicalStatementObservationMood c: XClinicalStatementObservationMood.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
