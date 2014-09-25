
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassAdjacency.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassAdjacency">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="ADJY"/>
 *     &lt;enumeration value="CONC"/>
 *     &lt;enumeration value="BOND"/>
 *     &lt;enumeration value="CONY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleClassAdjacency")
@XmlEnum
public enum RoleClassAdjacency {

    ADJY,
    CONC,
    BOND,
    CONY;

    public String value() {
        return name();
    }

    public static RoleClassAdjacency fromValue(String v) {
        return valueOf(v);
    }

}
