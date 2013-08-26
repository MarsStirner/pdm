
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassActiveIngredientMoietyBasis.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassActiveIngredientMoietyBasis">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="ACTIM"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleClassActiveIngredientMoietyBasis")
@XmlEnum
public enum RoleClassActiveIngredientMoietyBasis {

    ACTIM;

    public String value() {
        return name();
    }

    public static RoleClassActiveIngredientMoietyBasis fromValue(String v) {
        return valueOf(v);
    }

}
