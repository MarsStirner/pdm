
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassAcquisitionExposure.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassAcquisitionExposure">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="AEXPOS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActClassAcquisitionExposure")
@XmlEnum
public enum ActClassAcquisitionExposure {

    AEXPOS;

    public String value() {
        return name();
    }

    public static ActClassAcquisitionExposure fromValue(String v) {
        return valueOf(v);
    }

}
