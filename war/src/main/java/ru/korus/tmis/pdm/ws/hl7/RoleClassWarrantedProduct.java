
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassWarrantedProduct.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassWarrantedProduct">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="WRTE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleClassWarrantedProduct")
@XmlEnum
public enum RoleClassWarrantedProduct {

    WRTE;

    public String value() {
        return name();
    }

    public static RoleClassWarrantedProduct fromValue(String v) {
        return valueOf(v);
    }

}
