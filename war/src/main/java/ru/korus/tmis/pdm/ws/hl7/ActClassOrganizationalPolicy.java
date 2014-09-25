
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassOrganizationalPolicy.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassOrganizationalPolicy">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="ORGPOL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActClassOrganizationalPolicy")
@XmlEnum
public enum ActClassOrganizationalPolicy {

    ORGPOL;

    public String value() {
        return name();
    }

    public static ActClassOrganizationalPolicy fromValue(String v) {
        return valueOf(v);
    }

}
