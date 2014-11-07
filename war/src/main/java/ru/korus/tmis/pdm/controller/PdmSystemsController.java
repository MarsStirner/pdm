package ru.korus.tmis.pdm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.korus.tmis.pdm.model.PdmMessage;
import ru.korus.tmis.pdm.model.PdmSystemInfo;
import ru.korus.tmis.pdm.model.PdmSystems;
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


    private Map<String, PdmMessage> lastMsg = new HashMap<>();
    private PdmMessage msgNewSystem = null;
    private boolean isClearMsg = true;


    @RequestMapping(method = RequestMethod.GET)
    public String get(Map<String, Object> model) {
        model.put("state", ViewState.SYSTEMS);
        PdmSystems systemsInfo = pdmSystemsService.getSystemsInfo();
        //TODO remove (use AJAX)
        if(isClearMsg ) {
            clearMsg();
        } else {
            isClearMsg = true;
        }
        for(PdmSystemInfo pdmSystemInfo : systemsInfo.getSystems()) {
            PdmMessage msg = lastMsg.get(pdmSystemInfo.getOid());
            if(msg != null) {
                pdmSystemInfo.setMessage(msg);
            }
        }
        model.put("pdmSystems", systemsInfo);
        model.put("msgNewSystem", msgNewSystem);
        return ConfigController.MAIN_JSP;
    }

    private void clearMsg() {
        lastMsg.clear();
        msgNewSystem = null;
    }

    @RequestMapping(value = "update/{index}", method = RequestMethod.POST)
    public String updateSystem(@PathVariable Integer index,
                               @ModelAttribute PdmSystems pdmSystems,
                               Map<String, Object> model,
                               HttpServletRequest request) {
        PdmSystemInfo pdmSystemInfo = pdmSystems.getSystems().get(index);

        if (pdmSystemsService.updateSystem(pdmSystemInfo)) {
            lastMsg.put(pdmSystemInfo.getNewOid(), new PdmMessage("Новые параметры подсистемы успешно сохранены",
                    PdmMessage.PdmMsgType.INFO));
        } else {
            lastMsg.put(pdmSystemInfo.getOid(), new PdmMessage("Ошибка: Не удалось обновить параметры подсистемы",
                    PdmMessage.PdmMsgType.ERROR));
        }
        isClearMsg = false;
        return ViewState.SYSTEMS.redirect();
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public String addSystem(@ModelAttribute PdmSystems pdmSystems, Map<String, Object> model, HttpServletRequest request) {
        if (pdmSystemsService.addSystem(pdmSystems.getNewSystem())) {
            msgNewSystem = new PdmMessage("Подсистема '" + pdmSystems.getNewSystem().getNewName() + "' успешно добавлена",
                    PdmMessage.PdmMsgType.INFO);
        } else {
            msgNewSystem = new PdmMessage("Ошибка: Не удалось добавить подсистему '" + pdmSystems.getNewSystem().getNewName() + "'",
                            PdmMessage.PdmMsgType.ERROR);
        }
        isClearMsg = false;
        return ViewState.SYSTEMS.redirect();
    }

    @RequestMapping(value = "delete/{index}", method = RequestMethod.POST)
    public String deleteSystem(@PathVariable Integer index, @ModelAttribute PdmSystems pdmSystems, Map<String, Object> model, HttpServletRequest request) {
        PdmSystemInfo pdmSystemInfo = pdmSystems.getSystems().get(index);
        if (!pdmSystemsService.deleteSystem(pdmSystemInfo))  {
            lastMsg.put(pdmSystemInfo.getOid(),
                    new PdmMessage("Ошибка: Не удалось удалить подсистему",
                            PdmMessage.PdmMsgType.ERROR));
        }
        isClearMsg = false;
        return ViewState.SYSTEMS.redirect();
    }
}
