
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassRightLateralDecubitus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassRightLateralDecubitus">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="RLD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActClassRightLateralDecubitus")
@XmlEnum
public enum ActClassRightLateralDecubitus {

    RLD;

    public String value() {
        return name();
    }

    public static ActClassRightLateralDecubitus fromValue(String v) {
        return valueOf(v);
    }

}
