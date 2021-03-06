
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OrganizationNamePartQualifier.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OrganizationNamePartQualifier">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="AC"/>
 *     &lt;enumeration value="AD"/>
 *     &lt;enumeration value="BR"/>
 *     &lt;enumeration value="CL"/>
 *     &lt;enumeration value="IN"/>
 *     &lt;enumeration value="LS"/>
 *     &lt;enumeration value="NB"/>
 *     &lt;enumeration value="PR"/>
 *     &lt;enumeration value="SP"/>
 *     &lt;enumeration value="TITLE"/>
 *     &lt;enumeration value="VV"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "OrganizationNamePartQualifier")
@XmlEnum
public enum OrganizationNamePartQualifier {

    AC,
    AD,
    BR,
    CL,
    IN,
    LS,
    NB,
    PR,
    SP,
    TITLE,
    VV;

    public String value() {
        return name();
    }

    public static OrganizationNamePartQualifier fromValue(String v) {
        return valueOf(v);
    }

}
