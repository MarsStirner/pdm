
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EntityClassMaterial.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EntityClassMaterial">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="MAT"/>
 *     &lt;enumeration value="CHEM"/>
 *     &lt;enumeration value="FOOD"/>
 *     &lt;enumeration value="MMAT"/>
 *     &lt;enumeration value="CONT"/>
 *     &lt;enumeration value="HOLD"/>
 *     &lt;enumeration value="DEV"/>
 *     &lt;enumeration value="CER"/>
 *     &lt;enumeration value="MODDV"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EntityClassMaterial")
@XmlEnum
public enum EntityClassMaterial {

    MAT,
    CHEM,
    FOOD,
    MMAT,
    CONT,
    HOLD,
    DEV,
    CER,
    MODDV;

    public String value() {
        return name();
    }

    public static EntityClassMaterial fromValue(String v) {
        return valueOf(v);
    }

}
