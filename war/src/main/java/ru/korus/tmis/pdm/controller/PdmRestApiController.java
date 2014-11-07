package ru.korus.tmis.pdm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.korus.tmis.pdm.model.PersonalInfo;
import ru.korus.tmis.pdm.model.api.ErrorStatus;
import ru.korus.tmis.pdm.model.api.Identifier;
import ru.korus.tmis.pdm.model.api.SystemLogin;
import ru.korus.tmis.pdm.service.AuthService;
import ru.korus.tmis.pdm.service.PdmService;
import ru.korus.tmis.pdm.service.impl.xml.PdmConfig;

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

}
