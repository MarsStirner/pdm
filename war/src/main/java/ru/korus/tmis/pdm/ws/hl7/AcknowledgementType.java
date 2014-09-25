
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AcknowledgementType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AcknowledgementType">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="AA"/>
 *     &lt;enumeration value="AE"/>
 *     &lt;enumeration value="AR"/>
 *     &lt;enumeration value="CA"/>
 *     &lt;enumeration value="CE"/>
 *     &lt;enumeration value="CR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AcknowledgementType")
@XmlEnum
public enum AcknowledgementType {

    AA,
    AE,
    AR,
    CA,
    CE,
    CR;

    public String value() {
        return name();
    }

    public static AcknowledgementType fromValue(String v) {
        return valueOf(v);
    }

}
