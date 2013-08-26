
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IdentifierReliability.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IdentifierReliability">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="ISS"/>
 *     &lt;enumeration value="UNV"/>
 *     &lt;enumeration value="VER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "IdentifierReliability")
@XmlEnum
public enum IdentifierReliability {

    ISS,
    UNV,
    VER;

    public String value() {
        return name();
    }

    public static IdentifierReliability fromValue(String v) {
        return valueOf(v);
    }

}
