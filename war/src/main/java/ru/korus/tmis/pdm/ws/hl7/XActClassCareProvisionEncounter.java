
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for x_ActClassCareProvisionEncounter.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="x_ActClassCareProvisionEncounter">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="ENC"/>
 *     &lt;enumeration value="PCPR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "x_ActClassCareProvisionEncounter")
@XmlEnum
public enum XActClassCareProvisionEncounter {

    ENC,
    PCPR;

    public String value() {
        return name();
    }

    public static XActClassCareProvisionEncounter fromValue(String v) {
        return valueOf(v);
    }

}
