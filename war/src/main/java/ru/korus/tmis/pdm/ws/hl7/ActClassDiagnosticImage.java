
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassDiagnosticImage.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassDiagnosticImage">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="DGIMG"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActClassDiagnosticImage")
@XmlEnum
public enum ActClassDiagnosticImage {

    DGIMG;

    public String value() {
        return name();
    }

    public static ActClassDiagnosticImage fromValue(String v) {
        return valueOf(v);
    }

}
