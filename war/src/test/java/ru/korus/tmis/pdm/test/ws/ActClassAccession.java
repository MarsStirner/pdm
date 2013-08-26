
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassAccession.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassAccession">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="ACSN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActClassAccession")
@XmlEnum
public enum ActClassAccession {

    ACSN;

    public String value() {
        return name();
    }

    public static ActClassAccession fromValue(String v) {
        return valueOf(v);
    }

}
