
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassInvoicePayor.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassInvoicePayor">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="PAYOR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleClassInvoicePayor")
@XmlEnum
public enum RoleClassInvoicePayor {

    PAYOR;

    public String value() {
        return name();
    }

    public static RoleClassInvoicePayor fromValue(String v) {
        return valueOf(v);
    }

}
