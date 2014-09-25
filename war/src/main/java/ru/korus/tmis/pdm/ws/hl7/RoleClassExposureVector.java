
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassExposureVector.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassExposureVector">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="EXPVECTOR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleClassExposureVector")
@XmlEnum
public enum RoleClassExposureVector {

    EXPVECTOR;

    public String value() {
        return name();
    }

    public static RoleClassExposureVector fromValue(String v) {
        return valueOf(v);
    }

}
