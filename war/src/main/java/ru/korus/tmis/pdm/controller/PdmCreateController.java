package ru.korus.tmis.pdm.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.korus.tmis.pdm.model.*;

import java.io.Serializable;
import java.util.Map;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        10.10.2014, 16:34 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
@Controller
@RequestMapping(value = "create")
@Scope("session")
public class PdmCreateController implements Serializable {

    private PersonalInfo personalInfo = new PersonalInfo();

    @RequestMapping(method = RequestMethod.GET)
    public String get(Map<String, Object> model) {
        model.put("state", ViewState.CREATE);
        model.put("newPerson", personalInfo);
        //model.put("pdmFiles", filesInfo);
        //model.put("msgNewFile", msgNewSFile);
        return ConfigController.MAIN_JSP;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(@RequestBody PersonalInfo personalInfo, Map<String, Object> model) {
        model.put("state", ViewState.CREATE);
        //model.put("newPerson", personalInfo);
        //model.put("pdmFiles", filesInfo);
        //model.put("msgNewFile", msgNewSFile);
        return ConfigController.MAIN_JSP;
    }

    @RequestMapping(value = "add/telecom",method = RequestMethod.POST)
    public String addAttr(@ModelAttribute PersonalInfo personalInfo, Map<String, Object> model) {
        model.put("state", ViewState.CREATE);
        this.personalInfo.getTelecoms().add(personalInfo.getNewTelecom());
        model.put("newPerson", this.personalInfo);
        //model.put("pdmFiles", filesInfo);
        //model.put("msgNewFile", msgNewSFile);
        return ViewState.CREATE.redirect();
    }

}
