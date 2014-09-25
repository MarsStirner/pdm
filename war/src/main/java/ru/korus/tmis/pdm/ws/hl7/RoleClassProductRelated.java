
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassProductRelated.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassProductRelated">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="DST"/>
 *     &lt;enumeration value="MANU"/>
 *     &lt;enumeration value="RET"/>
 *     &lt;enumeration value="RGPR"/>
 *     &lt;enumeration value="THER"/>
 *     &lt;enumeration value="WRTE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleClassProductRelated")
@XmlEnum
public enum RoleClassProductRelated {

    DST,
    MANU,
    RET,
    RGPR,
    THER,
    WRTE;

    public String value() {
        return name();
    }

    public static RoleClassProductRelated fromValue(String v) {
        return valueOf(v);
    }

}
