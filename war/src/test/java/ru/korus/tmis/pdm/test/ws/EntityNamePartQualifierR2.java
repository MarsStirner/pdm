
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EntityNamePartQualifierR2.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EntityNamePartQualifierR2">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="AC"/>
 *     &lt;enumeration value="AD"/>
 *     &lt;enumeration value="BR"/>
 *     &lt;enumeration value="CL"/>
 *     &lt;enumeration value="CON"/>
 *     &lt;enumeration value="DEV"/>
 *     &lt;enumeration value="FRM"/>
 *     &lt;enumeration value="HOM"/>
 *     &lt;enumeration value="IN"/>
 *     &lt;enumeration value="INV"/>
 *     &lt;enumeration value="LS"/>
 *     &lt;enumeration value="MID"/>
 *     &lt;enumeration value="NB"/>
 *     &lt;enumeration value="PFX"/>
 *     &lt;enumeration value="PR"/>
 *     &lt;enumeration value="SCI"/>
 *     &lt;enumeration value="SFX"/>
 *     &lt;enumeration value="SP"/>
 *     &lt;enumeration value="STR"/>
 *     &lt;enumeration value="TMK"/>
 *     &lt;enumeration value="USE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EntityNamePartQualifierR2")
@XmlEnum
public enum EntityNamePartQualifierR2 {

    AC,
    AD,
    BR,
    CL,
    CON,
    DEV,
    FRM,
    HOM,
    IN,
    INV,
    LS,
    MID,
    NB,
    PFX,
    PR,
    SCI,
    SFX,
    SP,
    STR,
    TMK,
    USE;

    public String value() {
        return name();
    }

    public static EntityNamePartQualifierR2 fromValue(String v) {
        return valueOf(v);
    }

}
