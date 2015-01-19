package ru.korus.tmis.pdm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.korus.tmis.pdm.model.api.PersonalInfo;
import ru.korus.tmis.pdm.service.PdmDocsService;

import java.io.Serializable;
import java.util.Map;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        10.10.2014, 16:34 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
@Controller
@RequestMapping(value = "file")
@Scope("session")
public class PdmFileController implements Serializable {


    @RequestMapping(method = RequestMethod.GET)
    public String get(@RequestParam String publicKey,
                      @RequestParam String systemOid,
                      @RequestParam String token,
                      Map<String, Object> model) {
        model.put("publicKey", publicKey);
        model.put("systemOid", systemOid);
        model.put("token", token);
        return ConfigController.FILE_JSP;
    }


}
