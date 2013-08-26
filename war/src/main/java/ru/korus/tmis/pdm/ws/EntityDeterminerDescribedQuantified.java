
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EntityDeterminerDescribedQuantified.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EntityDeterminerDescribedQuantified">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="QUANTIFIED_KIND"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EntityDeterminerDescribedQuantified")
@XmlEnum
public enum EntityDeterminerDescribedQuantified {

    QUANTIFIED_KIND;

    public String value() {
        return name();
    }

    public static EntityDeterminerDescribedQuantified fromValue(String v) {
        return valueOf(v);
    }

}
