
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassSemiFowlers.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassSemiFowlers">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="SFWL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActClassSemiFowlers")
@XmlEnum
public enum ActClassSemiFowlers {

    SFWL;

    public String value() {
        return name();
    }

    public static ActClassSemiFowlers fromValue(String v) {
        return valueOf(v);
    }

}
