package ru.korus.tmis.pdm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.korus.tmis.pdm.model.api.FindQuery;
import ru.korus.tmis.pdm.model.api.*;
import ru.korus.tmis.pdm.service.AuthService;
import ru.korus.tmis.pdm.service.PdmDocsService;
import ru.korus.tmis.pdm.service.PdmService;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        31.10.2014, 12:02 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
@Controller
@RequestMapping(value = "api")
@Scope("session")
public class PdmRestApiController  implements Serializable, PdmRestApi {

    @Autowired
    AuthService authService;

    @Autowired
    PdmService pdmService;

    @Autowired
    PdmDocsService pdmDocsService;

    /**
     *
     * @param personInfoReq
     * @return
     */
    @Override
    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public Identifiers create(@RequestBody PersonInfoReq personInfoReq) {
        Identifiers res = new Identifiers();
        String senderOid = checkSenderOid(personInfoReq, res);
        if (senderOid != null) {
            res.setPublicKeyList(new ArrayList<String>(personInfoReq.getPersonalInfo().size()));
            for(PersonalInfo personalInfo : personInfoReq.getPersonalInfo()) {
                Identifier newPersonId = pdmService.add(personalInfo, senderOid);
                String id = newPersonId == null ? null : newPersonId.getId();
                res.getPublicKeyList().add(id);
            }
        }
        return res;
    }

    private String checkSenderOid(PersonInfoReq personInfoReq, WithErrorStatus res) {
        String senderOid = authService.checkToken(personInfoReq.getToken());
        if (senderOid == null) {
            res.setStatus(ErrorStatus.ACCESS_DENIED);
        }
        else if (personInfoReq.getPersonalInfo().isEmpty()){
            res.setStatus(ErrorStatus.WRONG_PARAMETERS);
        }
        return senderOid;
    }

    @Override
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public Identifier login(@RequestBody SystemLogin systemLogin,  HttpServletResponse response) {
        Identifier res = new Identifier();
        res.setId(pdmService.login(systemLogin.getOid(), systemLogin.getPassword()));
        if (res.getId() == null) {
            res.setStatus(ErrorStatus.ACCESS_DENIED);
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
        return res;
    }

    @Override
    @RequestMapping(value = "persons", method = RequestMethod.GET)
    @ResponseBody
    public Persons persons(@RequestParam String token) {
        String senderOid = authService.checkToken(token);
        Persons res = new Persons();
        if (senderOid == null) {
            res.setStatus(ErrorStatus.ACCESS_DENIED);
        } else {
            res.setPersonList(pdmService.getPersons(senderOid));
        }
        return res;
    }

    @Override
    @RequestMapping(value = "get", method = RequestMethod.GET)
    @ResponseBody
    public PersonalInfo get(@RequestParam String token,
                            @RequestParam String publicKey) {
        String senderOid = authService.checkToken(token);
        WithHistory withHistory = new WithHistory();
        withHistory.setIsHistory(false);
        return pdmService.getPerson(publicKey, senderOid, withHistory);
    }

    @Override
    @RequestMapping(value = "getList", method = RequestMethod.POST)
    @ResponseBody
    public Persons getList(@RequestBody PersonInfoReq personInfoReq) {
        Persons res = new Persons();
        String senderOid = checkSenderOid(personInfoReq, res);
        if (senderOid != null) {
            res = pdmService.getPersonList(personInfoReq.getPersonalInfo(), senderOid, personInfoReq.getWithHistory());
        }
        return res;
    }


    @Override
    @RequestMapping(value = "file", method = RequestMethod.GET, headers = "Accept=image/jpeg, image/jpg, image/png, image/gif")
    @ResponseBody
    public byte[] getFile(@RequestParam String token,
                          @RequestParam String publicKey) {
        String senderOid = authService.checkToken(token);
        byte[] res = DatatypeConverter.parseBase64Binary(new String(pdmService.getFile(publicKey, senderOid)));
        return res;
    }


    @Override
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    @ResponseBody
    public Persons update(@RequestBody PersonInfoReq personInfoReq) {
        String senderOid = authService.checkToken(personInfoReq.getToken());
        Persons res = new Persons();
        res.setPersonList(new ArrayList<PersonalInfo>(personInfoReq.getPersonalInfo().size()));
        for(PersonalInfo personalInfo : personInfoReq.getPersonalInfo()) {
            Identifier newPersonId = pdmService.add(personalInfo, senderOid);
            String id = newPersonId == null ? null : newPersonId.getId();
            res.getPersonList().add(pdmService.update(personalInfo, senderOid));
        }
        return res;
    }

    @Override
    @RequestMapping(value = "find", method = RequestMethod.POST)
    @ResponseBody
    public Persons find(@RequestBody FindQuery findQuery) {
        String senderOid = authService.checkToken(findQuery.getToken());
        Persons res = new Persons();
        if (senderOid == null) {
            res.setStatus(ErrorStatus.ACCESS_DENIED);
        } else {
            res.setPersonList(pdmService.find(findQuery, senderOid));
        }
        return res;
    }

    //pdmDocsService.getDocsInfo();

    @Override
    @RequestMapping(value = "docs/meta", method = RequestMethod.GET)
    @ResponseBody
    public ru.korus.tmis.pdm.model.PdmDocs getDocsMeta() {
        return pdmDocsService.getDocsInfo();
    }
}
