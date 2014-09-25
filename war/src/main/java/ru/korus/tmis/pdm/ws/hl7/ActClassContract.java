
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassContract.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassContract">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="CNTRCT"/>
 *     &lt;enumeration value="FCNTRCT"/>
 *     &lt;enumeration value="COV"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActClassContract")
@XmlEnum
public enum ActClassContract {

    CNTRCT,
    FCNTRCT,
    COV;

    public String value() {
        return name();
    }

    public static ActClassContract fromValue(String v) {
        return valueOf(v);
    }

}
