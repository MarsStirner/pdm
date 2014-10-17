package ru.korus.tmis.pdm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.korus.tmis.pdm.model.*;
import ru.korus.tmis.pdm.service.PdmSystemsService;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        10.10.2014, 16:34 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
@Controller
@RequestMapping(value = "systems")
@Scope("session")
public class PdmSystemsController implements Serializable {

    @Autowired
    PdmSystemsService pdmSystemsService;
    private PdmMessage lastMsg = null;

    @RequestMapping(method = RequestMethod.GET)
    public String get(Map<String, Object> model) {
        model.put("state", ViewState.SYSTEMS);
        PdmSystems systemsInfo = pdmSystemsService.getSystemsInfo();
        model.put("pdmSystems", systemsInfo);
        return ConfigController.MAIN_JSP;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String updateSystem(@ModelAttribute PdmSystems pdmSystems, Map<String, Object> model, HttpServletRequest request) {
        if (pdmSystemsService.updateSystem(pdmSystems.getCurOid(), pdmSystems.getSystems().get(pdmSystems.getIndex()))) {
            lastMsg = new PdmMessage("Новые параметры подсистемы успешно сохранены", PdmMessage.PdmMsgType.INFO);
        } else {
            lastMsg = new PdmMessage("Ошибка: Не удалось обновить параметры подсистемы", PdmMessage.PdmMsgType.ERROR);
        }

        return ViewState.SYSTEMS.redirect();
    }


}
