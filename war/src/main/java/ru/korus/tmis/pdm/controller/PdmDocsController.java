package ru.korus.tmis.pdm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.korus.tmis.pdm.model.PdmDocs;
import ru.korus.tmis.pdm.model.PdmDocsInfo;
import ru.korus.tmis.pdm.model.PdmMessage;
import ru.korus.tmis.pdm.model.rbm.RbmResponse;
import ru.korus.tmis.pdm.service.PdmDocsService;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBException;
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
    private String urlPdm = "http://10.1.2.11:5005/";


    @RequestMapping(method = RequestMethod.GET)
    public String get(Map<String, Object> model) {
        model.put("state", ViewState.DOCS);
        PdmDocs docsInfo = pdmDocsService.getDocsInfo();
        //TODO remove (use AJAX)
        if (isClearMsg) {
            clearMsg();
        } else {
            isClearMsg = true;
        }
        for (PdmDocsInfo pdmDocsInfo : docsInfo.getDocs()) {
            PdmMessage msg = lastMsg.get(pdmDocsInfo.getName());
            if (msg != null) {
                pdmDocsInfo.setMessage(msg);
            }
        }
        model.put("pdmDocs", docsInfo);
        model.put("msgNewDocs", msgNewDocs);
        model.put("rbmUrl", urlPdm);
        return ConfigController.MAIN_JSP;
    }

    private void clearMsg() {
        lastMsg.clear();
        msgNewDocs = null;
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public String addDoc(@ModelAttribute PdmDocs pdmDocs, Map<String, Object> model, HttpServletRequest request) {
        if (pdmDocsService.addDoc(pdmDocs.getNewDoc())) {
            msgNewDocs = new PdmMessage("Документ '" + pdmDocs.getNewDoc().getName() + "' успешно добавлен",
                    PdmMessage.PdmMsgType.INFO);
        } else {
            msgNewDocs = new PdmMessage("Ошибка: Не удалось добавить документ '" + pdmDocs.getNewDoc().getName() + "'",
                    PdmMessage.PdmMsgType.ERROR);
        }
        isClearMsg = false;
        return ViewState.DOCS.redirect();
    }

    @RequestMapping(value = "update/{index}", method = RequestMethod.POST)
    public String updateDoc(@PathVariable Integer index,
                            @ModelAttribute PdmDocs pdmDocs,
                            Map<String, Object> model,
                            HttpServletRequest request) {
        PdmDocsInfo pdmDocsInfo = pdmDocs.getDocs().get(index);

        if (pdmDocsService.updateDocs(pdmDocsInfo)) {
            lastMsg.put(pdmDocsInfo.getName(), new PdmMessage("Документ успешно сохранены",
                    PdmMessage.PdmMsgType.INFO));
        } else {
            lastMsg.put(pdmDocsInfo.getName(), new PdmMessage("Ошибка: Не удалось обновить документ",
                    PdmMessage.PdmMsgType.ERROR));
        }
        isClearMsg = false;
        return ViewState.DOCS.redirect();
    }

    //TODO change to DELETE
    @RequestMapping(value = "delete/{name}", method = RequestMethod.GET)
    public String deleteDoc(@PathVariable String name,
                            Map<String, Object> model,
                            HttpServletRequest request) {
        if (!pdmDocsService.deleteDoc(name)) {
            lastMsg.put(name,
                    new PdmMessage("Ошибка: Не удалось удалить документ",
                            PdmMessage.PdmMsgType.ERROR));
        }
        isClearMsg = false;
        return ViewState.DOCS.redirect();
    }

    @RequestMapping(value = "{docIndex}/update/attr/{attrIndex}", method = RequestMethod.POST)
    public String updateDoc(@PathVariable Integer docIndex,
                            @PathVariable Integer attrIndex,
                            @ModelAttribute PdmDocs pdmDocs,
                            Map<String, Object> model,
                            HttpServletRequest request) {
        PdmDocsInfo pdmDocsInfo = pdmDocs.getDocs().get(docIndex);

        if (pdmDocsService.updateAttr(pdmDocsInfo, attrIndex)) {
            lastMsg.put(pdmDocsInfo.getName(), new PdmMessage("Атрибут успешно сохранены",
                    PdmMessage.PdmMsgType.INFO));
        } else {
            lastMsg.put(pdmDocsInfo.getName(), new PdmMessage("Ошибка: Не удалось обновить атрибут",
                    PdmMessage.PdmMsgType.ERROR));
        }
        isClearMsg = false;
        return ViewState.DOCS.redirect();
    }

    //TODO change to DELETE
    @RequestMapping(value = "{docName}/delete/attr/{attrIndex}", method = RequestMethod.GET)
    public String deleteAttr(@PathVariable String docName,
                             @PathVariable Integer attrIndex,
                             @ModelAttribute PdmDocs pdmDocs,
                             Map<String, Object> model,
                             HttpServletRequest request) {
        if (!pdmDocsService.deleteAttr(docName, attrIndex)) {
            lastMsg.put(docName,
                    new PdmMessage("Ошибка: Не удалось удалить атрибут",
                            PdmMessage.PdmMsgType.ERROR));
        }
        isClearMsg = false;
        return ViewState.DOCS.redirect();
    }

    @RequestMapping(value = "{docIndex}/new/attr", method = RequestMethod.POST)
    public String addAttr(@PathVariable Integer docIndex,
                          @ModelAttribute PdmDocs pdmDocs,
                          Map<String, Object> model,
                          HttpServletRequest request) {
        PdmDocsInfo pdmDocsInfo = pdmDocs.getDocs().get(docIndex);
        if (pdmDocsService.addAttr(pdmDocsInfo)) {
            msgNewDocs = new PdmMessage("Атрибут  успешно добавлен",
                    PdmMessage.PdmMsgType.INFO);
        } else {
            msgNewDocs = new PdmMessage("Ошибка: Не удалось добавить атрибут",
                    PdmMessage.PdmMsgType.ERROR);
        }
        isClearMsg = false;
        return ViewState.DOCS.redirect();
    }

    @RequestMapping(value = "updateOidList", method = RequestMethod.GET)
    public String updateOidList(@RequestParam String url,
                               Map<String, Object> model,
                            HttpServletRequest request) throws JAXBException {
        urlPdm = url;
        RestTemplate restTemplate = new RestTemplate();
        RbmResponse rbmResponse = restTemplate.getForObject(url + "/api/v1/rbPspdDocumentClass/", RbmResponse.class);
        if( "ok".equals(rbmResponse.getMeta().getStatus()) ){
            pdmDocsService.addDocs(rbmResponse.getData());
        }

        return ViewState.DOCS.redirect();
    }
}
