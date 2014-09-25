
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassFinancialAdjudication.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassFinancialAdjudication">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="ADJUD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActClassFinancialAdjudication")
@XmlEnum
public enum ActClassFinancialAdjudication {

    ADJUD;

    public String value() {
        return name();
    }

    public static ActClassFinancialAdjudication fromValue(String v) {
        return valueOf(v);
    }

}
