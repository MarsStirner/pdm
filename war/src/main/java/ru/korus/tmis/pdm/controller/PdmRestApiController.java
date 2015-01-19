package ru.korus.tmis.pdm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.korus.tmis.pdm.model.api.FindQuery;
import ru.korus.tmis.pdm.model.api.*;
import ru.korus.tmis.pdm.service.AuthService;
import ru.korus.tmis.pdm.service.PdmService;

import javax.xml.bind.DatatypeConverter;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        31.10.2014, 12:02 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
@Controller
@RequestMapping(value = "api")
@Scope("session")
public class PdmRestApiController {

    @Autowired
    AuthService authService;

    @Autowired
    PdmService pdmService;

    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public Identifier create(@RequestBody PersonalInfo personalInfo) {
        Identifier res = new Identifier();
        String senderOid = authService.checkToken(personalInfo.getToken());
        if (senderOid == null) {
            res.setStatus(ErrorStatus.ACCESS_DENIED);
        } else {
            res = pdmService.add(personalInfo, senderOid);
        }
        return res;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public Identifier login(@RequestBody SystemLogin systemLogin) {
        Identifier res = new Identifier();
        res.setId(pdmService.login(systemLogin.getOid(), systemLogin.getPassword()));
        if (res.getId() == null) {
            res.setStatus(ErrorStatus.ACCESS_DENIED);
        }
        return res;
    }

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

    @RequestMapping(value = "get", method = RequestMethod.GET)
    @ResponseBody
    public PersonalInfo get(@RequestParam String token,
                            @RequestParam String publicKey) {
        String senderOid = authService.checkToken(token);
        return pdmService.getPerson(publicKey, senderOid);
    }

    @RequestMapping(value = "file", method = RequestMethod.GET, headers = "Accept=image/jpeg, image/jpg, image/png, image/gif")
    @ResponseBody
    public byte[] getFile(@RequestParam String token,
                            @RequestParam String publicKey) {
        String senderOid = authService.checkToken(token);
        byte[] res = DatatypeConverter.parseBase64Binary(new String(pdmService.getFile(publicKey, senderOid)));
        return res;
    }


    @RequestMapping(value = "update", method = RequestMethod.PUT)
    @ResponseBody
    public PersonalInfo update(@RequestBody PersonalInfo personalInfo ) {
        String senderOid = authService.checkToken(personalInfo.getToken());
        return pdmService.update(personalInfo, senderOid);
    }

    @RequestMapping(value = "find", method = RequestMethod.POST)
    @ResponseBody
    public Persons find(@RequestBody FindQuery findQuery ) {
        String senderOid = authService.checkToken(findQuery.getToken());
        Persons res = new Persons();
        if (senderOid == null) {
            res.setStatus(ErrorStatus.ACCESS_DENIED);
        } else {
            res.setPersonList(pdmService.find(findQuery, senderOid));
        }
        return res;
    }

}
