
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassTherapeuticAgent.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassTherapeuticAgent">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="THER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleClassTherapeuticAgent")
@XmlEnum
public enum RoleClassTherapeuticAgent {

    THER;

    public String value() {
        return name();
    }

    public static RoleClassTherapeuticAgent fromValue(String v) {
        return valueOf(v);
    }

}
