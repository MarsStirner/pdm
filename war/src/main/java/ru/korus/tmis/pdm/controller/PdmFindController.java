package ru.korus.tmis.pdm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@RequestMapping(value = "find")
@Scope("session")
public class PdmFindController implements Serializable {

    @Autowired
    PdmDocsService pdmDocsService;

    private PersonalInfo personalInfo = new PersonalInfo();

    @RequestMapping(method = RequestMethod.GET)
    public String get(Map<String, Object> model) {
        model.put("state", ViewState.FIND);
       /* model.put("newPerson", personalInfo);
        model.put("pdmDocs", pdmDocsService.getDocsInfo());*/
        return ConfigController.MAIN_JSP;
    }


}
