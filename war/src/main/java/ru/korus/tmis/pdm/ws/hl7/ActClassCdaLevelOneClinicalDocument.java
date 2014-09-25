
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassCdaLevelOneClinicalDocument.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassCdaLevelOneClinicalDocument">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="CDALVLONE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActClassCdaLevelOneClinicalDocument")
@XmlEnum
public enum ActClassCdaLevelOneClinicalDocument {

    CDALVLONE;

    public String value() {
        return name();
    }

    public static ActClassCdaLevelOneClinicalDocument fromValue(String v) {
        return valueOf(v);
    }

}
