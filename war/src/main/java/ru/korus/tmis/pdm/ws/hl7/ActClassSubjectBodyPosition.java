
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassSubjectBodyPosition.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassSubjectBodyPosition">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="LLD"/>
 *     &lt;enumeration value="PRN"/>
 *     &lt;enumeration value="RLD"/>
 *     &lt;enumeration value="SFWL"/>
 *     &lt;enumeration value="SIT"/>
 *     &lt;enumeration value="STN"/>
 *     &lt;enumeration value="SUP"/>
 *     &lt;enumeration value="RTRD"/>
 *     &lt;enumeration value="TRD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActClassSubjectBodyPosition")
@XmlEnum
public enum ActClassSubjectBodyPosition {

    LLD,
    PRN,
    RLD,
    SFWL,
    SIT,
    STN,
    SUP,
    RTRD,
    TRD;

    public String value() {
        return name();
    }

    public static ActClassSubjectBodyPosition fromValue(String v) {
        return valueOf(v);
    }

}
