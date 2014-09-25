
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IdentifierScope.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IdentifierScope">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="BUSN"/>
 *     &lt;enumeration value="OBJ"/>
 *     &lt;enumeration value="VER"/>
 *     &lt;enumeration value="VW"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "IdentifierScope")
@XmlEnum
public enum IdentifierScope {

    BUSN,
    OBJ,
    VER,
    VW;

    public String value() {
        return name();
    }

    public static IdentifierScope fromValue(String v) {
        return valueOf(v);
    }

}
