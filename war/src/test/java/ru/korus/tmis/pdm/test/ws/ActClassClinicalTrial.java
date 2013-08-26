
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassClinicalTrial.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassClinicalTrial">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="CLNTRL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActClassClinicalTrial")
@XmlEnum
public enum ActClassClinicalTrial {

    CLNTRL;

    public String value() {
        return name();
    }

    public static ActClassClinicalTrial fromValue(String v) {
        return valueOf(v);
    }

}
