
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleLinkIdentification.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleLinkIdentification">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="IDENT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleLinkIdentification")
@XmlEnum
public enum RoleLinkIdentification {

    IDENT;

    public String value() {
        return name();
    }

    public static RoleLinkIdentification fromValue(String v) {
        return valueOf(v);
    }

}
