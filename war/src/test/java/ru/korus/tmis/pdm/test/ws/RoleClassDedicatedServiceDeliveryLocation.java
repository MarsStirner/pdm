
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassDedicatedServiceDeliveryLocation.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassDedicatedServiceDeliveryLocation">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="DSDLOC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleClassDedicatedServiceDeliveryLocation")
@XmlEnum
public enum RoleClassDedicatedServiceDeliveryLocation {

    DSDLOC;

    public String value() {
        return name();
    }

    public static RoleClassDedicatedServiceDeliveryLocation fromValue(String v) {
        return valueOf(v);
    }

}
