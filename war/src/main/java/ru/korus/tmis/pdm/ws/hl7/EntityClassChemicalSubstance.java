
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EntityClassChemicalSubstance.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EntityClassChemicalSubstance">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="CHEM"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EntityClassChemicalSubstance")
@XmlEnum
public enum EntityClassChemicalSubstance {

    CHEM;

    public String value() {
        return name();
    }

    public static EntityClassChemicalSubstance fromValue(String v) {
        return valueOf(v);
    }

}
