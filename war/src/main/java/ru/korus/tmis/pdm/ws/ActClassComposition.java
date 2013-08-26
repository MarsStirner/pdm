
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassComposition.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassComposition">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="COMPOSITION"/>
 *     &lt;enumeration value="DOC"/>
 *     &lt;enumeration value="DOCCLIN"/>
 *     &lt;enumeration value="CDALVLONE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActClassComposition")
@XmlEnum
public enum ActClassComposition {

    COMPOSITION,
    DOC,
    DOCCLIN,
    CDALVLONE;

    public String value() {
        return name();
    }

    public static ActClassComposition fromValue(String v) {
        return valueOf(v);
    }

}
