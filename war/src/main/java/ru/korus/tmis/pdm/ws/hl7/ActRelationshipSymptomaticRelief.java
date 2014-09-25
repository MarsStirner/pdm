
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipSymptomaticRelief.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipSymptomaticRelief">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="SYMP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipSymptomaticRelief")
@XmlEnum
public enum ActRelationshipSymptomaticRelief {

    SYMP;

    public String value() {
        return name();
    }

    public static ActRelationshipSymptomaticRelief fromValue(String v) {
        return valueOf(v);
    }

}
