
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleClassActiveIngredientReferenceBasis.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleClassActiveIngredientReferenceBasis">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="ACTIR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleClassActiveIngredientReferenceBasis")
@XmlEnum
public enum RoleClassActiveIngredientReferenceBasis {

    ACTIR;

    public String value() {
        return name();
    }

    public static RoleClassActiveIngredientReferenceBasis fromValue(String v) {
        return valueOf(v);
    }

}
