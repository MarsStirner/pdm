
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassDeterminantPeptide.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassDeterminantPeptide">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="DETPOL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActClassDeterminantPeptide")
@XmlEnum
public enum ActClassDeterminantPeptide {

    DETPOL;

    public String value() {
        return name();
    }

    public static ActClassDeterminantPeptide fromValue(String v) {
        return valueOf(v);
    }

}
