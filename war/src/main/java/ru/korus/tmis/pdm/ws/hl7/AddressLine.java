
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AddressLine.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AddressLine">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="AL"/>
 *     &lt;enumeration value="DAL"/>
 *     &lt;enumeration value="SAL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AddressLine")
@XmlEnum
public enum AddressLine {

    AL,
    DAL,
    SAL;

    public String value() {
        return name();
    }

    public static AddressLine fromValue(String v) {
        return valueOf(v);
    }

}
