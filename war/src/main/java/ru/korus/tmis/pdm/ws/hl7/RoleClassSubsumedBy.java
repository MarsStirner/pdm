
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassSubsumedBy.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassSubsumedBy">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="SUBY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleClassSubsumedBy")
@XmlEnum
public enum RoleClassSubsumedBy {

    SUBY;

    public String value() {
        return name();
    }

    public static RoleClassSubsumedBy fromValue(String v) {
        return valueOf(v);
    }

}
