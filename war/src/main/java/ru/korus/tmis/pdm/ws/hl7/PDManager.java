
package ru.korus.tmis.pdm.ws.hl7;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-2b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PDManager", targetNamespace = "http://www.korusconsulting.ru/PDManager/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PDManager {


    /**
     * 
     * @param parameters
     * @return
     *     returns ru.korus.tmis.pdm.ws.PRPAIN101312UV02
     */
    @WebMethod(action = "http://www.korusconsulting.ru/PDManager/new")
    @WebResult(name = "PRPA_IN101312UV02", targetNamespace = "urn:hl7-org:v3", partName = "result")
    public PRPAIN101312UV02 add(
        @WebParam(name = "PRPA_IN101311UV02", targetNamespace = "urn:hl7-org:v3", partName = "parameters")
        PRPAIN101311UV02 parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns ru.korus.tmis.pdm.ws.PRPAIN101306UV02
     */
    @WebMethod(action = "http://www.korusconsulting.ru/PDManager/findCandidates")
    @WebResult(name = "PRPA_IN101306UV02", targetNamespace = "urn:hl7-org:v3", partName = "result")
    public PRPAIN101306UV02 findCandidates(
        @WebParam(name = "PRPA_IN101305UV02", targetNamespace = "urn:hl7-org:v3", partName = "parameters")
        PRPAIN101305UV02 parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns ru.korus.tmis.pdm.ws.PRPAIN101308UV02
     */
    @WebMethod(action = "http://www.korusconsulting.ru/PDManager/getDemographics")
    @WebResult(name = "PRPA_IN101308UV02", targetNamespace = "urn:hl7-org:v3", partName = "result")
    public PRPAIN101308UV02 getDemographics(
        @WebParam(name = "PRPA_IN101307UV02", targetNamespace = "urn:hl7-org:v3", partName = "parameters")
        PRPAIN101307UV02 parameters);

    /**
     * 
     * @param parameters
     * @return
     *     returns ru.korus.tmis.pdm.ws.PRPAIN101315UV02
     */
    @WebMethod(action = "http://www.korusconsulting.ru/PDManager/update")
    @WebResult(name = "PRPA_IN101315UV02", targetNamespace = "urn:hl7-org:v3", partName = "result")
    public PRPAIN101315UV02 update(
        @WebParam(name = "PRPA_IN101314UV02", targetNamespace = "urn:hl7-org:v3", partName = "parameters")
        PRPAIN101314UV02 parameters);

    /**
     *
     * @param parameters
     * @return
     *     returns ru.korus.tmis.pdm.ws.PRPAIN101306UV02
     */
    @WebMethod(action = "http://www.korusconsulting.ru/PDManager/findLike")
    @WebResult(name = "PRPA_IN101306UV02", targetNamespace = "urn:hl7-org:v3", partName = "result")
    public PRPAIN101306UV02 findLike(
            @WebParam(name = "PRPA_IN101305UV02", targetNamespace = "urn:hl7-org:v3", partName = "parameters")
            PRPAIN101305UV02 parameters);


    @WebMethod(action = "http://www.korusconsulting.ru/PDManager/login")
    @WebResult(targetNamespace = "urn:hl7-org:v3", partName = "result")
    public String login(@WebParam String oid, @WebParam String password);

    @WebMethod(action = "http://www.korusconsulting.ru/PDManager/logout")
    @WebResult(targetNamespace = "urn:hl7-org:v3", partName = "result")
    public Boolean logout(@WebParam String token);

}
