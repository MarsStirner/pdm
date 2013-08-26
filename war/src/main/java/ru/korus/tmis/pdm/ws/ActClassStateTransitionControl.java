
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassStateTransitionControl.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassStateTransitionControl">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="STC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActClassStateTransitionControl")
@XmlEnum
public enum ActClassStateTransitionControl {

    STC;

    public String value() {
        return name();
    }

    public static ActClassStateTransitionControl fromValue(String v) {
        return valueOf(v);
    }

}
