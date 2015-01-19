package ru.korus.tmis.pdm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.korus.tmis.pdm.model.CfgFileUpdateInfo;
import ru.korus.tmis.pdm.model.ConfigInfo;
import ru.korus.tmis.pdm.model.PdmMessage;
import ru.korus.tmis.pdm.model.UpdateLoginInfo;
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
    public final static String FILE_JSP = "file";

    @Autowired
    private ConfigService configService;

    private UpdateLoginInfo updateLoginInfo = new UpdateLoginInfo();

    private CfgFileUpdateInfo cfgFileUpdateInfo = new CfgFileUpdateInfo();

    @RequestMapping(method = RequestMethod.GET)
    public String get(Map<String, Object> model) {
        model.put("state", ViewState.MAIN);
        ConfigInfo info = configService.getInfo();
        model.put("info", info);
        model.put("updateLoginInfo", updateLoginInfo);
        cfgFileUpdateInfo.setCfgFilePath(info.getCfgFileName());
        model.put("cfgFileUpdateInfo", cfgFileUpdateInfo);
        return MAIN_JSP;
    }

    @RequestMapping(value = "user/update", method = RequestMethod.POST)
    public String updateAdminInfo(@ModelAttribute UpdateLoginInfo updateLoginInfo, Map<String, Object> model, HttpServletRequest request) {
        if (configService.updateAdminInfo(updateLoginInfo)) {
            this.updateLoginInfo.setMessage("Новые параметры учетной записи администратора успешно сохранены", PdmMessage.PdmMsgType.INFO);
        } else {
            this.updateLoginInfo.setMessage("Ошибка: Не удалось обновить параметры учетной записи администратора ЗХПД", PdmMessage.PdmMsgType.ERROR);
        }

        return ViewState.MAIN.redirect();
    }

    @RequestMapping(value = "path/update", method = RequestMethod.POST)
    public String updateAdminInfo(@ModelAttribute CfgFileUpdateInfo cfgFileUpdateInfo, Map<String, Object> model, HttpServletRequest request) {
        if (configService.updateCfgFileInfo(cfgFileUpdateInfo)) {
            this.cfgFileUpdateInfo.setMessage("Новый файл конфигурации успешно сохранен", PdmMessage.PdmMsgType.INFO);
        } else {
            this.cfgFileUpdateInfo.setMessage("Ошибка: Не удалось сохранить файл конфигурации", PdmMessage.PdmMsgType.ERROR);
        }

        return ViewState.MAIN.redirect();
    }
}
