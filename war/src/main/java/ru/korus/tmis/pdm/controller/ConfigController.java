package ru.korus.tmis.pdm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.korus.tmis.pdm.model.Info;
import ru.korus.tmis.pdm.service.ConfigService;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Map;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        10.10.2014, 16:34 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
*/
@Controller
@RequestMapping(value = "config")
@Scope("session")
public class ConfigController implements Serializable {

    public final static String MAIN_JSP = "main";

    @Autowired
    private ConfigService configService;

    @RequestMapping(method = RequestMethod.GET)
    public String get(Map<String, Object> model) {
        model.put("state", ViewState.MAIN);
        Info info = configService.getInfo();
        model.put("info", info);
        model.put("infoAdmin", info);
        return MAIN_JSP;
    }

    @RequestMapping(value = "user/update", method = RequestMethod.POST )
    public String updateAdminInfo(@ModelAttribute Info infoAdmin, Map<String, Object> model, HttpServletRequest request) {
        configService.updateAdminInfo(infoAdmin);
        return ViewState.MAIN.redirect();
    }
}
