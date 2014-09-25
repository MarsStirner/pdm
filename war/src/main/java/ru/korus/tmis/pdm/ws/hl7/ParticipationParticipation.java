
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ParticipationParticipation.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ParticipationParticipation">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="PART"/>
 *     &lt;enumeration value="ADM"/>
 *     &lt;enumeration value="ATND"/>
 *     &lt;enumeration value="CALLBCK"/>
 *     &lt;enumeration value="CON"/>
 *     &lt;enumeration value="DIS"/>
 *     &lt;enumeration value="ESC"/>
 *     &lt;enumeration value="REF"/>
 *     &lt;enumeration value="AUT"/>
 *     &lt;enumeration value="INF"/>
 *     &lt;enumeration value="TRANS"/>
 *     &lt;enumeration value="ENT"/>
 *     &lt;enumeration value="WIT"/>
 *     &lt;enumeration value="CST"/>
 *     &lt;enumeration value="DIR"/>
 *     &lt;enumeration value="ALY"/>
 *     &lt;enumeration value="BBY"/>
 *     &lt;enumeration value="CAT"/>
 *     &lt;enumeration value="CSM"/>
 *     &lt;enumeration value="DEV"/>
 *     &lt;enumeration value="NRD"/>
 *     &lt;enumeration value="RDV"/>
 *     &lt;enumeration value="DON"/>
 *     &lt;enumeration value="EXPAGNT"/>
 *     &lt;enumeration value="EXPART"/>
 *     &lt;enumeration value="EXPTRGT"/>
 *     &lt;enumeration value="EXSRC"/>
 *     &lt;enumeration value="PRD"/>
 *     &lt;enumeration value="SBJ"/>
 *     &lt;enumeration value="SPC"/>
 *     &lt;enumeration value="IND"/>
 *     &lt;enumeration value="BEN"/>
 *     &lt;enumeration value="CAGNT"/>
 *     &lt;enumeration value="COV"/>
 *     &lt;enumeration value="GUAR"/>
 *     &lt;enumeration value="HLD"/>
 *     &lt;enumeration value="RCT"/>
 *     &lt;enumeration value="RCV"/>
 *     &lt;enumeration value="IRCP"/>
 *     &lt;enumeration value="NOT"/>
 *     &lt;enumeration value="PRCP"/>
 *     &lt;enumeration value="REFB"/>
 *     &lt;enumeration value="REFT"/>
 *     &lt;enumeration value="TRC"/>
 *     &lt;enumeration value="LOC"/>
 *     &lt;enumeration value="DST"/>
 *     &lt;enumeration value="ELOC"/>
 *     &lt;enumeration value="ORG"/>
 *     &lt;enumeration value="RML"/>
 *     &lt;enumeration value="VIA"/>
 *     &lt;enumeration value="PRF"/>
 *     &lt;enumeration value="DIST"/>
 *     &lt;enumeration value="PPRF"/>
 *     &lt;enumeration value="SPRF"/>
 *     &lt;enumeration value="RESP"/>
 *     &lt;enumeration value="VRF"/>
 *     &lt;enumeration value="AUTHEN"/>
 *     &lt;enumeration value="LA"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ParticipationParticipation")
@XmlEnum
public enum ParticipationParticipation {

    PART,
    ADM,
    ATND,
    CALLBCK,
    CON,
    DIS,
    ESC,
    REF,
    AUT,
    INF,
    TRANS,
    ENT,
    WIT,
    CST,
    DIR,
    ALY,
    BBY,
    CAT,
    CSM,
    DEV,
    NRD,
    RDV,
    DON,
    EXPAGNT,
    EXPART,
    EXPTRGT,
    EXSRC,
    PRD,
    SBJ,
    SPC,
    IND,
    BEN,
    CAGNT,
    COV,
    GUAR,
    HLD,
    RCT,
    RCV,
    IRCP,
    NOT,
    PRCP,
    REFB,
    REFT,
    TRC,
    LOC,
    DST,
    ELOC,
    ORG,
    RML,
    VIA,
    PRF,
    DIST,
    PPRF,
    SPRF,
    RESP,
    VRF,
    AUTHEN,
    LA;

    public String value() {
        return name();
    }

    public static ParticipationParticipation fromValue(String v) {
        return valueOf(v);
    }

}
