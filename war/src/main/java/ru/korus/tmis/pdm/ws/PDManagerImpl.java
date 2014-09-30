package ru.korus.tmis.pdm.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.korus.tmis.pdm.alee.AleePdmOperations;
import ru.korus.tmis.pdm.mongo.MongoPdmOperations;
import ru.korus.tmis.pdm.service.PdmService;
import ru.korus.tmis.pdm.ws.hl7.*;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * Author: Sergey A. Zagrebelny <br>
 * Date: 02.07.2013, 12:07:21 <br>
 * Company: Korus Consulting IT<br>
 * Description: <br>
 */

@Service
@WebService(endpointInterface = "ru.korus.tmis.pdm.ws.hl7.PDManager", targetNamespace = "http://www.korusconsulting.ru/PDManager/",
        serviceName = "tmis-pdm", portName = "portPdm", name = "PDManager")
public class PDManagerImpl implements PDManager {


    @Autowired
    PdmService pdmService;

    /**
     * @see ru.korus.tmis.pdm.ws.hl7.PDManager#add(ru.korus.tmis.pdm.ws.hl7.PRPAIN101311UV02)
     */
    @Override
    @WebMethod(action = "http://www.korusconsulting.ru/PDManager/new")
    @WebResult(name = "PRPA_IN101312UV02", targetNamespace = "urn:hl7-org:v3", partName = "parameters")
    public PRPAIN101312UV02 add(PRPAIN101311UV02 parameters) {
        return pdmService.add(parameters);
    }

    /**
     * @see ru.korus.tmis.pdm.ws.hl7.PDManager#findCandidates(ru.korus.tmis.pdm.ws.hl7.PRPAIN101305UV02)
     */
    @Override
    @WebMethod(action = "http://www.korusconsulting.ru/PDManager/findCandidates")
    @WebResult(name = "PRPA_IN101306UV02", targetNamespace = "urn:hl7-org:v3", partName = "result")
    public PRPAIN101306UV02 findCandidates(PRPAIN101305UV02 parameters) {
        return pdmService.findCandidates(parameters);
    }

    /**
     * @see ru.korus.tmis.pdm.ws.hl7.PDManager#getDemographics(ru.korus.tmis.pdm.ws.hl7.PRPAIN101307UV02)
     */
    @Override
    @WebMethod(action = "http://www.korusconsulting.ru/PDManager/getDemographics")
    @WebResult(name = "PRPA_IN101308UV02", targetNamespace = "urn:hl7-org:v3", partName = "result")
    public PRPAIN101308UV02 getDemographics(PRPAIN101307UV02 parameters) {
        return pdmService.getDemographics(parameters);
    }

    /**
     * @see ru.korus.tmis.pdm.ws.hl7.PDManager#update(ru.korus.tmis.pdm.ws.hl7.PRPAIN101314UV02)
     */
    @Override
    @WebMethod(action = "http://www.korusconsulting.ru/PDManager/new")
    @WebResult(name = "PRPA_IN101315UV02", targetNamespace = "urn:hl7-org:v3", partName = "result")
    public PRPAIN101315UV02 update(
            @WebParam(name = "PRPA_IN101314UV02", targetNamespace = "urn:hl7-org:v3", partName = "parameters")
            PRPAIN101314UV02 parameters) {
        return pdmService.update(parameters);
    }

    @Override
    @WebMethod(action = "http://www.korusconsulting.ru/PDManager/findLike")
    @WebResult(name = "PRPA_IN101306UV02", targetNamespace = "urn:hl7-org:v3", partName = "result")
    public PRPAIN101306UV02 findLike(
            @WebParam(name = "PRPA_IN101305UV02", targetNamespace = "urn:hl7-org:v3", partName = "parameters")
            PRPAIN101305UV02 parameters) {
        return pdmService.findLike(parameters);
    }


}
