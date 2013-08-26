
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActRelationshipType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActRelationshipType">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="APND"/>
 *     &lt;enumeration value="ARR"/>
 *     &lt;enumeration value="AUTH"/>
 *     &lt;enumeration value="BLOCK"/>
 *     &lt;enumeration value="BSLN"/>
 *     &lt;enumeration value="CAUS"/>
 *     &lt;enumeration value="CHRG"/>
 *     &lt;enumeration value="CIND"/>
 *     &lt;enumeration value="COMP"/>
 *     &lt;enumeration value="COMPLY"/>
 *     &lt;enumeration value="CONCURRENT"/>
 *     &lt;enumeration value="COST"/>
 *     &lt;enumeration value="COVBY"/>
 *     &lt;enumeration value="CREDIT"/>
 *     &lt;enumeration value="CTRLV"/>
 *     &lt;enumeration value="CURE"/>
 *     &lt;enumeration value="CURE.ADJ"/>
 *     &lt;enumeration value="DEBIT"/>
 *     &lt;enumeration value="DEP"/>
 *     &lt;enumeration value="DIAG"/>
 *     &lt;enumeration value="DOC"/>
 *     &lt;enumeration value="DRIV"/>
 *     &lt;enumeration value="DURING"/>
 *     &lt;enumeration value="EAE"/>
 *     &lt;enumeration value="EAS"/>
 *     &lt;enumeration value="EBS"/>
 *     &lt;enumeration value="ECW"/>
 *     &lt;enumeration value="EDU"/>
 *     &lt;enumeration value="ELNK"/>
 *     &lt;enumeration value="EVID"/>
 *     &lt;enumeration value="EXACBY"/>
 *     &lt;enumeration value="EXPL"/>
 *     &lt;enumeration value="FLFS"/>
 *     &lt;enumeration value="GEN"/>
 *     &lt;enumeration value="GEVL"/>
 *     &lt;enumeration value="GOAL"/>
 *     &lt;enumeration value="INST"/>
 *     &lt;enumeration value="ITEMSLOC"/>
 *     &lt;enumeration value="LIMIT"/>
 *     &lt;enumeration value="META"/>
 *     &lt;enumeration value="MFST"/>
 *     &lt;enumeration value="MITGT"/>
 *     &lt;enumeration value="MOD"/>
 *     &lt;enumeration value="MTCH"/>
 *     &lt;enumeration value="MTGT.ADJ"/>
 *     &lt;enumeration value="NAME"/>
 *     &lt;enumeration value="OBJC"/>
 *     &lt;enumeration value="OBJF"/>
 *     &lt;enumeration value="OCCR"/>
 *     &lt;enumeration value="OPTN"/>
 *     &lt;enumeration value="OREF"/>
 *     &lt;enumeration value="OUTC"/>
 *     &lt;enumeration value="OVERLAP"/>
 *     &lt;enumeration value="PERT"/>
 *     &lt;enumeration value="PRCN"/>
 *     &lt;enumeration value="PREV"/>
 *     &lt;enumeration value="RCHAL"/>
 *     &lt;enumeration value="RCVY"/>
 *     &lt;enumeration value="REFR"/>
 *     &lt;enumeration value="REFV"/>
 *     &lt;enumeration value="RELVBY"/>
 *     &lt;enumeration value="REV"/>
 *     &lt;enumeration value="RISK"/>
 *     &lt;enumeration value="RPLC"/>
 *     &lt;enumeration value="RSON"/>
 *     &lt;enumeration value="SAE"/>
 *     &lt;enumeration value="SAS"/>
 *     &lt;enumeration value="SBS"/>
 *     &lt;enumeration value="SCH"/>
 *     &lt;enumeration value="SCW"/>
 *     &lt;enumeration value="SDU"/>
 *     &lt;enumeration value="SEQL"/>
 *     &lt;enumeration value="SPRT"/>
 *     &lt;enumeration value="SPRTBND"/>
 *     &lt;enumeration value="SUBJ"/>
 *     &lt;enumeration value="SUCC"/>
 *     &lt;enumeration value="SUMM"/>
 *     &lt;enumeration value="SYMP"/>
 *     &lt;enumeration value="TRIG"/>
 *     &lt;enumeration value="UPDT"/>
 *     &lt;enumeration value="USE"/>
 *     &lt;enumeration value="VRXCRPT"/>
 *     &lt;enumeration value="XCRPT"/>
 *     &lt;enumeration value="XFRM"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActRelationshipType")
@XmlEnum
public enum ActRelationshipType {

    APND("APND"),
    ARR("ARR"),
    AUTH("AUTH"),
    BLOCK("BLOCK"),
    BSLN("BSLN"),
    CAUS("CAUS"),
    CHRG("CHRG"),
    CIND("CIND"),
    COMP("COMP"),
    COMPLY("COMPLY"),
    CONCURRENT("CONCURRENT"),
    COST("COST"),
    COVBY("COVBY"),
    CREDIT("CREDIT"),
    CTRLV("CTRLV"),
    CURE("CURE"),
    @XmlEnumValue("CURE.ADJ")
    CURE_ADJ("CURE.ADJ"),
    DEBIT("DEBIT"),
    DEP("DEP"),
    DIAG("DIAG"),
    DOC("DOC"),
    DRIV("DRIV"),
    DURING("DURING"),
    EAE("EAE"),
    EAS("EAS"),
    EBS("EBS"),
    ECW("ECW"),
    EDU("EDU"),
    ELNK("ELNK"),
    EVID("EVID"),
    EXACBY("EXACBY"),
    EXPL("EXPL"),
    FLFS("FLFS"),
    GEN("GEN"),
    GEVL("GEVL"),
    GOAL("GOAL"),
    INST("INST"),
    ITEMSLOC("ITEMSLOC"),
    LIMIT("LIMIT"),
    META("META"),
    MFST("MFST"),
    MITGT("MITGT"),
    MOD("MOD"),
    MTCH("MTCH"),
    @XmlEnumValue("MTGT.ADJ")
    MTGT_ADJ("MTGT.ADJ"),
    NAME("NAME"),
    OBJC("OBJC"),
    OBJF("OBJF"),
    OCCR("OCCR"),
    OPTN("OPTN"),
    OREF("OREF"),
    OUTC("OUTC"),
    OVERLAP("OVERLAP"),
    PERT("PERT"),
    PRCN("PRCN"),
    PREV("PREV"),
    RCHAL("RCHAL"),
    RCVY("RCVY"),
    REFR("REFR"),
    REFV("REFV"),
    RELVBY("RELVBY"),
    REV("REV"),
    RISK("RISK"),
    RPLC("RPLC"),
    RSON("RSON"),
    SAE("SAE"),
    SAS("SAS"),
    SBS("SBS"),
    SCH("SCH"),
    SCW("SCW"),
    SDU("SDU"),
    SEQL("SEQL"),
    SPRT("SPRT"),
    SPRTBND("SPRTBND"),
    SUBJ("SUBJ"),
    SUCC("SUCC"),
    SUMM("SUMM"),
    SYMP("SYMP"),
    TRIG("TRIG"),
    UPDT("UPDT"),
    USE("USE"),
    VRXCRPT("VRXCRPT"),
    XCRPT("XCRPT"),
    XFRM("XFRM");
    private final String value;

    ActRelationshipType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ActRelationshipType fromValue(String v) {
        for (ActRelationshipType c: ActRelationshipType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
