
package ru.korus.tmis.pdm.test.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ContextControlOverridingNon-propagating.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ContextControlOverridingNon-propagating">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="ON"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ContextControlOverridingNon-propagating")
@XmlEnum
public enum ContextControlOverridingNonPropagating {

    ON;

    public String value() {
        return name();
    }

    public static ContextControlOverridingNonPropagating fromValue(String v) {
        return valueOf(v);
    }

}
