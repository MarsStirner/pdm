
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipInstantiatesMaster.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipInstantiatesMaster">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="INST"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipInstantiatesMaster")
@XmlEnum
public enum ActRelationshipInstantiatesMaster {

    INST;

    public String value() {
        return name();
    }

    public static ActRelationshipInstantiatesMaster fromValue(String v) {
        return valueOf(v);
    }

}
