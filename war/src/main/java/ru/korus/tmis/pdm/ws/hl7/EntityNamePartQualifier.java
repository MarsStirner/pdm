
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EntityNamePartQualifier.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EntityNamePartQualifier">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="AC"/>
 *     &lt;enumeration value="AD"/>
 *     &lt;enumeration value="BR"/>
 *     &lt;enumeration value="CL"/>
 *     &lt;enumeration value="CON"/>
 *     &lt;enumeration value="DEV"/>
 *     &lt;enumeration value="FRM"/>
 *     &lt;enumeration value="IN"/>
 *     &lt;enumeration value="INV"/>
 *     &lt;enumeration value="LS"/>
 *     &lt;enumeration value="NB"/>
 *     &lt;enumeration value="PR"/>
 *     &lt;enumeration value="SCI"/>
 *     &lt;enumeration value="SP"/>
 *     &lt;enumeration value="STR"/>
 *     &lt;enumeration value="TITLE"/>
 *     &lt;enumeration value="TMK"/>
 *     &lt;enumeration value="USE"/>
 *     &lt;enumeration value="VV"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EntityNamePartQualifier")
@XmlEnum
public enum EntityNamePartQualifier {

    AC,
    AD,
    BR,
    CL,
    CON,
    DEV,
    FRM,
    IN,
    INV,
    LS,
    NB,
    PR,
    SCI,
    SP,
    STR,
    TITLE,
    TMK,
    USE,
    VV;

    public String value() {
        return name();
    }

    public static EntityNamePartQualifier fromValue(String v) {
        return valueOf(v);
    }

}
