
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActClassRoot.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ActClassRoot">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="ACT"/>
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
 *     &lt;enumeration value="ACCM"/>
 *     &lt;enumeration value="ACCT"/>
 *     &lt;enumeration value="ACSN"/>
 *     &lt;enumeration value="ADJUD"/>
 *     &lt;enumeration value="CACT"/>
 *     &lt;enumeration value="ACTN"/>
 *     &lt;enumeration value="INFO"/>
 *     &lt;enumeration value="STC"/>
 *     &lt;enumeration value="CNTRCT"/>
 *     &lt;enumeration value="FCNTRCT"/>
 *     &lt;enumeration value="COV"/>
 *     &lt;enumeration value="CONS"/>
 *     &lt;enumeration value="CONTREG"/>
 *     &lt;enumeration value="CTTEVENT"/>
 *     &lt;enumeration value="DISPACT"/>
 *     &lt;enumeration value="EXPOS"/>
 *     &lt;enumeration value="AEXPOS"/>
 *     &lt;enumeration value="TEXPOS"/>
 *     &lt;enumeration value="INC"/>
 *     &lt;enumeration value="INFRM"/>
 *     &lt;enumeration value="INVE"/>
 *     &lt;enumeration value="LIST"/>
 *     &lt;enumeration value="MPROT"/>
 *     &lt;enumeration value="OBS"/>
 *     &lt;enumeration value="ROIBND"/>
 *     &lt;enumeration value="ROIOVL"/>
 *     &lt;enumeration value="LLD"/>
 *     &lt;enumeration value="PRN"/>
 *     &lt;enumeration value="RLD"/>
 *     &lt;enumeration value="SFWL"/>
 *     &lt;enumeration value="SIT"/>
 *     &lt;enumeration value="STN"/>
 *     &lt;enumeration value="SUP"/>
 *     &lt;enumeration value="RTRD"/>
 *     &lt;enumeration value="TRD"/>
 *     &lt;enumeration value="ALRT"/>
 *     &lt;enumeration value="BATTERY"/>
 *     &lt;enumeration value="CLNTRL"/>
 *     &lt;enumeration value="CNOD"/>
 *     &lt;enumeration value="CONC"/>
 *     &lt;enumeration value="COND"/>
 *     &lt;enumeration value="CASE"/>
 *     &lt;enumeration value="OUTB"/>
 *     &lt;enumeration value="DGIMG"/>
 *     &lt;enumeration value="GEN"/>
 *     &lt;enumeration value="DETPOL"/>
 *     &lt;enumeration value="EXP"/>
 *     &lt;enumeration value="LOC"/>
 *     &lt;enumeration value="PHN"/>
 *     &lt;enumeration value="POL"/>
 *     &lt;enumeration value="SEQ"/>
 *     &lt;enumeration value="SEQVAR"/>
 *     &lt;enumeration value="INVSTG"/>
 *     &lt;enumeration value="OBSSER"/>
 *     &lt;enumeration value="OBSCOR"/>
 *     &lt;enumeration value="POS"/>
 *     &lt;enumeration value="POSACC"/>
 *     &lt;enumeration value="POSCOORD"/>
 *     &lt;enumeration value="SPCOBS"/>
 *     &lt;enumeration value="VERIF"/>
 *     &lt;enumeration value="PCPR"/>
 *     &lt;enumeration value="ENC"/>
 *     &lt;enumeration value="POLICY"/>
 *     &lt;enumeration value="JURISPOL"/>
 *     &lt;enumeration value="ORGPOL"/>
 *     &lt;enumeration value="SCOPOL"/>
 *     &lt;enumeration value="STDPOL"/>
 *     &lt;enumeration value="PROC"/>
 *     &lt;enumeration value="SBADM"/>
 *     &lt;enumeration value="SBEXT"/>
 *     &lt;enumeration value="SPECCOLLECT"/>
 *     &lt;enumeration value="REG"/>
 *     &lt;enumeration value="REV"/>
 *     &lt;enumeration value="SPCTRT"/>
 *     &lt;enumeration value="SPLY"/>
 *     &lt;enumeration value="DIET"/>
 *     &lt;enumeration value="STORE"/>
 *     &lt;enumeration value="SUBST"/>
 *     &lt;enumeration value="TRFR"/>
 *     &lt;enumeration value="TRNS"/>
 *     &lt;enumeration value="XACT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ActClassRoot")
@XmlEnum
public enum ActClassRoot {

    ACT,
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
    CLUSTER,
    ACCM,
    ACCT,
    ACSN,
    ADJUD,
    CACT,
    ACTN,
    INFO,
    STC,
    CNTRCT,
    FCNTRCT,
    COV,
    CONS,
    CONTREG,
    CTTEVENT,
    DISPACT,
    EXPOS,
    AEXPOS,
    TEXPOS,
    INC,
    INFRM,
    INVE,
    LIST,
    MPROT,
    OBS,
    ROIBND,
    ROIOVL,
    LLD,
    PRN,
    RLD,
    SFWL,
    SIT,
    STN,
    SUP,
    RTRD,
    TRD,
    ALRT,
    BATTERY,
    CLNTRL,
    CNOD,
    CONC,
    COND,
    CASE,
    OUTB,
    DGIMG,
    GEN,
    DETPOL,
    EXP,
    LOC,
    PHN,
    POL,
    SEQ,
    SEQVAR,
    INVSTG,
    OBSSER,
    OBSCOR,
    POS,
    POSACC,
    POSCOORD,
    SPCOBS,
    VERIF,
    PCPR,
    ENC,
    POLICY,
    JURISPOL,
    ORGPOL,
    SCOPOL,
    STDPOL,
    PROC,
    SBADM,
    SBEXT,
    SPECCOLLECT,
    REG,
    REV,
    SPCTRT,
    SPLY,
    DIET,
    STORE,
    SUBST,
    TRFR,
    TRNS,
    XACT;

    public String value() {
        return name();
    }

    public static ActClassRoot fromValue(String v) {
        return valueOf(v);
    }

}
