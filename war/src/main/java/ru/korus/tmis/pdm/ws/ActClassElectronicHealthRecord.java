
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassElectronicHealthRecord.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassElectronicHealthRecord">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="EHR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActClassElectronicHealthRecord")
@XmlEnum
public enum ActClassElectronicHealthRecord {

    EHR;

    public String value() {
        return name();
    }

    public static ActClassElectronicHealthRecord fromValue(String v) {
        return valueOf(v);
    }

}
