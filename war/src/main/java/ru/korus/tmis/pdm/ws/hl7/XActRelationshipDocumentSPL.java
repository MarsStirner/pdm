
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for x_ActRelationshipDocumentSPL.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="x_ActRelationshipDocumentSPL">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="APND"/>
 *     &lt;enumeration value="DRIV"/>
 *     &lt;enumeration value="RPLC"/>
 *     &lt;enumeration value="XCRPT"/>
 *     &lt;enumeration value="XFRM"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "x_ActRelationshipDocumentSPL")
@XmlEnum
public enum XActRelationshipDocumentSPL {

    APND,
    DRIV,
    RPLC,
    XCRPT,
    XFRM;

    public String value() {
        return name();
    }

    public static XActRelationshipDocumentSPL fromValue(String v) {
        return valueOf(v);
    }

}
