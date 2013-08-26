
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassRecordOrganizer.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassRecordOrganizer">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="COMPOSITION"/>
 *     &lt;enumeration value="DOC"/>
 *     &lt;enumeration value="DOCCLIN"/>
 *     &lt;enumeration value="CDALVLONE"/>
 *     &lt;enumeration value="CONTAINER"/>
 *     &lt;enumeration value="CATEGORY"/>
 *     &lt;enumeration value="DOCBODY"/>
 *     &lt;enumeration value="DOCSECT"/>
 *     &lt;enumeration value="TOPIC"/>
 *     &lt;enumeration value="EXTRACT"/>
 *     &lt;enumeration value="EHR"/>
 *     &lt;enumeration value="FOLDER"/>
 *     &lt;enumeration value="GROUPER"/>
 *     &lt;enumeration value="CLUSTER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActClassRecordOrganizer")
@XmlEnum
public enum ActClassRecordOrganizer {

    COMPOSITION,
    DOC,
    DOCCLIN,
    CDALVLONE,
    CONTAINER,
    CATEGORY,
    DOCBODY,
    DOCSECT,
    TOPIC,
    EXTRACT,
    EHR,
    FOLDER,
    GROUPER,
    CLUSTER;

    public String value() {
        return name();
    }

    public static ActClassRecordOrganizer fromValue(String v) {
        return valueOf(v);
    }

}
