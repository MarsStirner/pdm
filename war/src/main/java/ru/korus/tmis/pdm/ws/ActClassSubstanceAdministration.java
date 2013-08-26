
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassSubstanceAdministration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassSubstanceAdministration">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="SBADM"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActClassSubstanceAdministration")
@XmlEnum
public enum ActClassSubstanceAdministration {

    SBADM;

    public String value() {
        return name();
    }

    public static ActClassSubstanceAdministration fromValue(String v) {
        return valueOf(v);
    }

}
