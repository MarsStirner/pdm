
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassReverseTrendelenburg.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassReverseTrendelenburg">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="RTRD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActClassReverseTrendelenburg")
@XmlEnum
public enum ActClassReverseTrendelenburg {

    RTRD;

    public String value() {
        return name();
    }

    public static ActClassReverseTrendelenburg fromValue(String v) {
        return valueOf(v);
    }

}
