
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipTemporallyPertains.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipTemporallyPertains">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="EAE"/>
 *     &lt;enumeration value="EAS"/>
 *     &lt;enumeration value="EDU"/>
 *     &lt;enumeration value="EBS"/>
 *     &lt;enumeration value="ECW"/>
 *     &lt;enumeration value="CONCURRENT"/>
 *     &lt;enumeration value="EAE"/>
 *     &lt;enumeration value="EAS"/>
 *     &lt;enumeration value="EDU"/>
 *     &lt;enumeration value="EBS"/>
 *     &lt;enumeration value="ECW"/>
 *     &lt;enumeration value="CONCURRENT"/>
 *     &lt;enumeration value="SAE"/>
 *     &lt;enumeration value="SAS"/>
 *     &lt;enumeration value="SDU"/>
 *     &lt;enumeration value="SBS"/>
 *     &lt;enumeration value="SCW"/>
 *     &lt;enumeration value="CONCURRENT"/>
 *     &lt;enumeration value="SAE"/>
 *     &lt;enumeration value="SAS"/>
 *     &lt;enumeration value="SDU"/>
 *     &lt;enumeration value="SBS"/>
 *     &lt;enumeration value="SCW"/>
 *     &lt;enumeration value="CONCURRENT"/>
 *     &lt;enumeration value="DURING"/>
 *     &lt;enumeration value="DURING"/>
 *     &lt;enumeration value="OVERLAP"/>
 *     &lt;enumeration value="OVERLAP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipTemporallyPertains")
@XmlEnum
public enum ActRelationshipTemporallyPertains {

    EAE,
    EAS,
    EDU,
    EBS,
    ECW,
    CONCURRENT,
    SAE,
    SAS,
    SDU,
    SBS,
    SCW,
    DURING,
    OVERLAP;

    public String value() {
        return name();
    }

    public static ActRelationshipTemporallyPertains fromValue(String v) {
        return valueOf(v);
    }

}
