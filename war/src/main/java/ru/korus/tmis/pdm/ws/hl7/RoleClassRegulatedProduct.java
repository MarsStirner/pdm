
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassRegulatedProduct.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassRegulatedProduct">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="RGPR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleClassRegulatedProduct")
@XmlEnum
public enum RoleClassRegulatedProduct {

    RGPR;

    public String value() {
        return name();
    }

    public static RoleClassRegulatedProduct fromValue(String v) {
        return valueOf(v);
    }

}
