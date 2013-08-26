
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleLinkHasDirectAuthorityOver.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleLinkHasDirectAuthorityOver">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="DIRAUTH"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleLinkHasDirectAuthorityOver")
@XmlEnum
public enum RoleLinkHasDirectAuthorityOver {

    DIRAUTH;

    public String value() {
        return name();
    }

    public static RoleLinkHasDirectAuthorityOver fromValue(String v) {
        return valueOf(v);
    }

}
