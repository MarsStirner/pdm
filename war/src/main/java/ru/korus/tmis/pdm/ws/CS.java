
package ru.korus.tmis.pdm.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *             Coded data, consists of a code, display name, code system,
 *             and original text. Used when a single code value must be sent.
 *          
 * 
 * <p>Java class for CS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CS">
 *   &lt;complexContent>
 *     &lt;restriction base="{urn:hl7-org:v3}CV">
 *       &lt;attribute name="code" type="{urn:hl7-org:v3}cs" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CS")
@XmlSeeAlso({
    PRPAMT101302UV02ContactPartyStatusCode.class,
    PRPAMT101302UV02GuardianStatusCode.class,
    PRPAMT101302UV02StudentStatusCode.class,
    PRPAMT101302UV02EmployeeStatusCode.class,
    PRPAMT101302UV02OtherIDsStatusCode.class,
    PRPAMT101302UV02PersonalRelationshipStatusCode.class,
    PRPAMT101302UV02IdentifiedPersonStatusCode.class
})
public class CS
    extends CV
{


}
