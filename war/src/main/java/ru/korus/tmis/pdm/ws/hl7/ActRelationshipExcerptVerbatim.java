
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipExcerptVerbatim.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipExcerptVerbatim">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="VRXCRPT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipExcerptVerbatim")
@XmlEnum
public enum ActRelationshipExcerptVerbatim {

    VRXCRPT;

    public String value() {
        return name();
    }

    public static ActRelationshipExcerptVerbatim fromValue(String v) {
        return valueOf(v);
    }

}
