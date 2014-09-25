
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassContainerRegistration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassContainerRegistration">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="CONTREG"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActClassContainerRegistration")
@XmlEnum
public enum ActClassContainerRegistration {

    CONTREG;

    public String value() {
        return name();
    }

    public static ActClassContainerRegistration fromValue(String v) {
        return valueOf(v);
    }

}
