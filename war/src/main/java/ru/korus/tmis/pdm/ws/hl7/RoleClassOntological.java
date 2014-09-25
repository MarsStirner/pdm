
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassOntological.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassOntological">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="EQUIV"/>
 *     &lt;enumeration value="SAME"/>
 *     &lt;enumeration value="SUBY"/>
 *     &lt;enumeration value="GEN"/>
 *     &lt;enumeration value="GRIC"/>
 *     &lt;enumeration value="INST"/>
 *     &lt;enumeration value="SUBS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleClassOntological")
@XmlEnum
public enum RoleClassOntological {

    EQUIV,
    SAME,
    SUBY,
    GEN,
    GRIC,
    INST,
    SUBS;

    public String value() {
        return name();
    }

    public static RoleClassOntological fromValue(String v) {
        return valueOf(v);
    }

}
