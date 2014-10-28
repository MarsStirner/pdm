package ru.korus.tmis.pdm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.korus.tmis.pdm.model.*;
import ru.korus.tmis.pdm.service.PdmFilesService;
import ru.korus.tmis.pdm.service.PdmFilesService;

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
@RequestMapping(value = "files")
@Scope("session")
public class PdmFilesController implements Serializable {


    @Autowired
    PdmFilesService pdmFilesService;

    private Map<String, PdmMessage> lastMsg = new HashMap<>();
    private PdmMessage msgNewFile = null;
    private boolean isClearMsg = true;

    @RequestMapping(method = RequestMethod.GET)
    public String get(Map<String, Object> model) {
        model.put("state", ViewState.FILES);
        PdmFiles filesInfo = pdmFilesService.getFilesInfo();
        //TODO remove (use AJAX)
        if(isClearMsg ) {
            clearMsg();
        } else {
            isClearMsg = true;
        }
        for(PdmFileInfo pdmFileInfo : filesInfo.getFiles()) {
            PdmMessage msg = lastMsg.get(pdmFileInfo.getOid());
            if(msg != null) {
                pdmFileInfo.setMessage(msg);
            }
        }
        model.put("pdmFiles", filesInfo);
        model.put("msgNewFile", msgNewFile);

        return ConfigController.MAIN_JSP;
    }


    private void clearMsg() {
        lastMsg.clear();
        msgNewFile = null;
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public String addFile(@ModelAttribute PdmFiles pdmFiles, Map<String, Object> model, HttpServletRequest request) {
        if (pdmFilesService.addFile(pdmFiles.getNewFile())) {
            msgNewFile = new PdmMessage("Тип файлов '" + pdmFiles.getNewFile().getNewName() + "' успешно добавлен",
                    PdmMessage.PdmMsgType.INFO);
        } else {
            msgNewFile = new PdmMessage("Ошибка: Не удалось добавить тип файлов '" + pdmFiles.getNewFile().getNewName() + "'",
                    PdmMessage.PdmMsgType.ERROR);
        }
        isClearMsg = false;
        return ViewState.FILES.redirect();
    }


    @RequestMapping(value = "update/{index}", method = RequestMethod.POST)
    public String updateFile(@PathVariable Integer index,
                               @ModelAttribute PdmFiles pdmFiles,
                               Map<String, Object> model,
                               HttpServletRequest request) {
        PdmFileInfo pdmFileInfo = pdmFiles.getFiles().get(index);

        if (pdmFilesService.updateFile(pdmFileInfo)) {
            lastMsg.put(pdmFileInfo.getNewOid(), new PdmMessage("Новые параметры успешно сохранены",
                    PdmMessage.PdmMsgType.INFO));
        } else {
            lastMsg.put(pdmFileInfo.getOid(), new PdmMessage("Ошибка: Не удалось обновить параметры файла",
                    PdmMessage.PdmMsgType.ERROR));
        }
        isClearMsg = false;
        return ViewState.FILES.redirect();
    }


    @RequestMapping(value = "delete/{index}", method = RequestMethod.POST)
    public String deleteFile(@PathVariable Integer index, @ModelAttribute PdmFiles pdmFiles, Map<String, Object> model, HttpServletRequest request) {
        PdmFileInfo pdmFileInfo = pdmFiles.getFiles().get(index);
        if (!pdmFilesService.deleteFile(pdmFileInfo))  {
            lastMsg.put(pdmFileInfo.getOid(),
                    new PdmMessage("Ошибка: Не удалось удалить тип файлов",
                            PdmMessage.PdmMsgType.ERROR));
        }
        isClearMsg = false;
        return ViewState.FILES.redirect();
    }

}
