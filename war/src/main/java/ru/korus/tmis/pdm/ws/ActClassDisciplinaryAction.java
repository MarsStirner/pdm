
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassDisciplinaryAction.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassDisciplinaryAction">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="DISPACT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActClassDisciplinaryAction")
@XmlEnum
public enum ActClassDisciplinaryAction {

    DISPACT;

    public String value() {
        return name();
    }

    public static ActClassDisciplinaryAction fromValue(String v) {
        return valueOf(v);
    }

}
