
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassScopeOfPracticePolicy.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassScopeOfPracticePolicy">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="SCOPOL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActClassScopeOfPracticePolicy")
@XmlEnum
public enum ActClassScopeOfPracticePolicy {

    SCOPOL;

    public String value() {
        return name();
    }

    public static ActClassScopeOfPracticePolicy fromValue(String v) {
        return valueOf(v);
    }

}
