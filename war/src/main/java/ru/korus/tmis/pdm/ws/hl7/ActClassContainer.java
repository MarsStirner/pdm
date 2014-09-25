
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassContainer.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassContainer">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="CONTAINER"/>
 *     &lt;enumeration value="CATEGORY"/>
 *     &lt;enumeration value="DOCBODY"/>
 *     &lt;enumeration value="DOCSECT"/>
 *     &lt;enumeration value="TOPIC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActClassContainer")
@XmlEnum
public enum ActClassContainer {

    CONTAINER,
    CATEGORY,
    DOCBODY,
    DOCSECT,
    TOPIC;

    public String value() {
        return name();
    }

    public static ActClassContainer fromValue(String v) {
        return valueOf(v);
    }

}
