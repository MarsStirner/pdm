
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassDocumentBody.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassDocumentBody">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="DOCBODY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActClassDocumentBody")
@XmlEnum
public enum ActClassDocumentBody {

    DOCBODY;

    public String value() {
        return name();
    }

    public static ActClassDocumentBody fromValue(String v) {
        return valueOf(v);
    }

}
