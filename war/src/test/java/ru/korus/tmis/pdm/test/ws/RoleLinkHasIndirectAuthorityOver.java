
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleLinkHasIndirectAuthorityOver.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleLinkHasIndirectAuthorityOver">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="INDAUTH"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleLinkHasIndirectAuthorityOver")
@XmlEnum
public enum RoleLinkHasIndirectAuthorityOver {

    INDAUTH;

    public String value() {
        return name();
    }

    public static RoleLinkHasIndirectAuthorityOver fromValue(String v) {
        return valueOf(v);
    }

}
