
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassLeftLateralDecubitus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassLeftLateralDecubitus">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="LLD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActClassLeftLateralDecubitus")
@XmlEnum
public enum ActClassLeftLateralDecubitus {

    LLD;

    public String value() {
        return name();
    }

    public static ActClassLeftLateralDecubitus fromValue(String v) {
        return valueOf(v);
    }

}
