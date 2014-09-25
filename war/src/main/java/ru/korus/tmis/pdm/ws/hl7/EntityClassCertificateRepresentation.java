
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EntityClassCertificateRepresentation.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EntityClassCertificateRepresentation">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="CER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EntityClassCertificateRepresentation")
@XmlEnum
public enum EntityClassCertificateRepresentation {

    CER;

    public String value() {
        return name();
    }

    public static EntityClassCertificateRepresentation fromValue(String v) {
        return valueOf(v);
    }

}
