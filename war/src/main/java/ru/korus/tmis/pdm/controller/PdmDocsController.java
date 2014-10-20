package ru.korus.tmis.pdm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.korus.tmis.pdm.model.*;
import ru.korus.tmis.pdm.service.PdmDocsService;

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
@RequestMapping(value = "docs")
@Scope("session")
public class PdmDocsController implements Serializable {

    @Autowired
    PdmDocsService pdmDocsService;

    private Map<String, PdmMessage> lastMsg = new HashMap<>();
    private PdmMessage msgNewDocs = null;
    private boolean isClearMsg = true;

    @RequestMapping(method = RequestMethod.GET)
    public String get(Map<String, Object> model) {
        model.put("state", ViewState.SYSTEMS);
        PdmDocs docsInfo = pdmDocsService.getDocsInfo();
        //TODO remove (use AJAX)
        if(isClearMsg ) {
            clearMsg();
        } else {
            isClearMsg = true;
        }
        for(PdmDocsInfo pdmDocsInfo : docsInfo.getDocs()) {
            PdmMessage msg = lastMsg.get(pdmDocsInfo.getName());
            if(msg != null) {
                pdmDocsInfo.setMessage(msg);
            }
        }
        model.put("pdmDocs", docsInfo);
        model.put("msgNewDocs", msgNewDocs);
        return ConfigController.MAIN_JSP;
    }

    private void clearMsg() {
        lastMsg.clear();
        msgNewDocs = null;
    }

   /* @RequestMapping(value = "update/{index}", method = RequestMethod.POST)
    public String updateSystem(@PathVariable Integer index,
                               @ModelAttribute PdmSystems pdmSystems,
                               Map<String, Object> model,
                               HttpServletRequest request) {
        PdmSystemInfo pdmSystemInfo = pdmSystems.getSystems().get(index);

        if (pdmDocsService.updateSystem(pdmSystemInfo)) {
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
        if (pdmDocsService.addSystem(pdmSystems.getNewSystem())) {
            msgNewDocs = new PdmMessage("Подсистема '" + pdmSystems.getNewSystem().getNewName() + "' успешно добавлена",
                    PdmMessage.PdmMsgType.INFO);
        } else {
            msgNewDocs = new PdmMessage("Ошибка: Не удалось добавить подсистему '" + pdmSystems.getNewSystem().getNewName() + "'",
                            PdmMessage.PdmMsgType.ERROR);
        }
        isClearMsg = false;
        return ViewState.SYSTEMS.redirect();
    }

    @RequestMapping(value = "delete/{index}", method = RequestMethod.POST)
    public String deleteSystem(@PathVariable Integer index, @ModelAttribute PdmSystems pdmSystems, Map<String, Object> model, HttpServletRequest request) {
        PdmSystemInfo pdmSystemInfo = pdmSystems.getSystems().get(index);
        if (!pdmDocsService.deleteSystem(pdmSystemInfo))  {
            lastMsg.put(pdmSystemInfo.getOid(),
                    new PdmMessage("Ошибка: Не удалось удалить подсистему",
                            PdmMessage.PdmMsgType.ERROR));
        }
        isClearMsg = false;
        return ViewState.SYSTEMS.redirect();
    }*/
}
