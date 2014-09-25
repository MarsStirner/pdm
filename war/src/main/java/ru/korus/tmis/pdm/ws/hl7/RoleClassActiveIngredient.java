
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassActiveIngredient.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassActiveIngredient">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="ACTI"/>
 *     &lt;enumeration value="ACTIB"/>
 *     &lt;enumeration value="ACTIM"/>
 *     &lt;enumeration value="ACTIR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleClassActiveIngredient")
@XmlEnum
public enum RoleClassActiveIngredient {

    ACTI,
    ACTIB,
    ACTIM,
    ACTIR;

    public String value() {
        return name();
    }

    public static RoleClassActiveIngredient fromValue(String v) {
        return valueOf(v);
    }

}
