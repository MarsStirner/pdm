
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleLinkReplaces.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleLinkReplaces">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="REPL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleLinkReplaces")
@XmlEnum
public enum RoleLinkReplaces {

    REPL;

    public String value() {
        return name();
    }

    public static RoleLinkReplaces fromValue(String v) {
        return valueOf(v);
    }

}
