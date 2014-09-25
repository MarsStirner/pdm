
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipPertains.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipPertains">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="PERT"/>
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
 *     &lt;enumeration value="CHRG"/>
 *     &lt;enumeration value="COST"/>
 *     &lt;enumeration value="CHRG"/>
 *     &lt;enumeration value="COST"/>
 *     &lt;enumeration value="CREDIT"/>
 *     &lt;enumeration value="DEBIT"/>
 *     &lt;enumeration value="CREDIT"/>
 *     &lt;enumeration value="DEBIT"/>
 *     &lt;enumeration value="CHRG"/>
 *     &lt;enumeration value="COST"/>
 *     &lt;enumeration value="CHRG"/>
 *     &lt;enumeration value="COST"/>
 *     &lt;enumeration value="CREDIT"/>
 *     &lt;enumeration value="DEBIT"/>
 *     &lt;enumeration value="CREDIT"/>
 *     &lt;enumeration value="DEBIT"/>
 *     &lt;enumeration value="AUTH"/>
 *     &lt;enumeration value="CAUS"/>
 *     &lt;enumeration value="COVBY"/>
 *     &lt;enumeration value="DRIV"/>
 *     &lt;enumeration value="ELNK"/>
 *     &lt;enumeration value="EVID"/>
 *     &lt;enumeration value="EXACBY"/>
 *     &lt;enumeration value="EXPL"/>
 *     &lt;enumeration value="ITEMSLOC"/>
 *     &lt;enumeration value="LIMIT"/>
 *     &lt;enumeration value="META"/>
 *     &lt;enumeration value="MFST"/>
 *     &lt;enumeration value="NAME"/>
 *     &lt;enumeration value="PREV"/>
 *     &lt;enumeration value="REFR"/>
 *     &lt;enumeration value="USE"/>
 *     &lt;enumeration value="REFV"/>
 *     &lt;enumeration value="RELVBY"/>
 *     &lt;enumeration value="SPRT"/>
 *     &lt;enumeration value="SPRTBND"/>
 *     &lt;enumeration value="SUBJ"/>
 *     &lt;enumeration value="SUMM"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipPertains")
@XmlEnum
public enum ActRelationshipPertains {

    PERT,
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
    OVERLAP,
    CHRG,
    COST,
    CREDIT,
    DEBIT,
    AUTH,
    CAUS,
    COVBY,
    DRIV,
    ELNK,
    EVID,
    EXACBY,
    EXPL,
    ITEMSLOC,
    LIMIT,
    META,
    MFST,
    NAME,
    PREV,
    REFR,
    USE,
    REFV,
    RELVBY,
    SPRT,
    SPRTBND,
    SUBJ,
    SUMM;

    public String value() {
        return name();
    }

    public static ActRelationshipPertains fromValue(String v) {
        return valueOf(v);
    }

}
