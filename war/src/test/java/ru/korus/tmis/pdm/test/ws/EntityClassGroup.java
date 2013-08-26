
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EntityClassGroup.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EntityClassGroup">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="RGRP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EntityClassGroup")
@XmlEnum
public enum EntityClassGroup {

    RGRP;

    public String value() {
        return name();
    }

    public static EntityClassGroup fromValue(String v) {
        return valueOf(v);
    }

}
