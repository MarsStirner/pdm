
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipIsManifestationOf.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipIsManifestationOf">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="MFST"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipIsManifestationOf")
@XmlEnum
public enum ActRelationshipIsManifestationOf {

    MFST;

    public String value() {
        return name();
    }

    public static ActRelationshipIsManifestationOf fromValue(String v) {
        return valueOf(v);
    }

}
