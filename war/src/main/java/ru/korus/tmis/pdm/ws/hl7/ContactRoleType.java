
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ContactRoleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ContactRoleType">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="ECON"/>
 *     &lt;enumeration value="NOK"/>
 *     &lt;enumeration value="BILL"/>
 *     &lt;enumeration value="ORG"/>
 *     &lt;enumeration value="PAYOR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ContactRoleType")
@XmlEnum
public enum ContactRoleType {

    ECON,
    NOK,
    BILL,
    ORG,
    PAYOR;

    public String value() {
        return name();
    }

    public static ContactRoleType fromValue(String v) {
        return valueOf(v);
    }

}
