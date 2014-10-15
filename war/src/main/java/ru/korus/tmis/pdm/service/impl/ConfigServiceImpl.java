package ru.korus.tmis.pdm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.korus.tmis.pdm.model.CfgFileUpdateInfo;
import ru.korus.tmis.pdm.model.ConfigInfo;
import ru.korus.tmis.pdm.model.UpdateLoginInfo;
import ru.korus.tmis.pdm.service.AuthService;
import ru.korus.tmis.pdm.service.ConfigService;
import ru.korus.tmis.pdm.service.PdmXmlConfigService;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        13.10.2014, 13:42 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
@Service
public class ConfigServiceImpl implements ConfigService {

    private String domainPath = null;

    @Autowired
    private PdmXmlConfigService pdmXmlConfigService;

    @Autowired
    private AuthService authService;

    @Override
    public ConfigInfo getInfo() {
        ConfigInfo res = new ConfigInfo();
        res.setVersion("//TODO");
        res.setDomainPath(getDomainPath());
        res.setLogin(pdmXmlConfigService.getUserName());
        res.setCfgFileName(pdmXmlConfigService.getCfgFileName());
        return res;
    }

    @Override
    public boolean updateAdminInfo(UpdateLoginInfo updateLoginInfo) {
        boolean res = false;
        String newLogin = updateLoginInfo.getNewLogin();
        if(!newLogin.isEmpty() && authService.checkAdminPassword(updateLoginInfo.getCurPassword())) {
            res = pdmXmlConfigService.setNewLogin(newLogin, updateLoginInfo.getNewPassword());

        }
        return res;
    }

    @Override
    public boolean updateCfgFileInfo(CfgFileUpdateInfo cfgFileUpdateInfo) {
        boolean res = false;
        String newLogin = cfgFileUpdateInfo.getCfgFilePath();
        if(!newLogin.isEmpty()) {
            res = pdmXmlConfigService.setNewCfgFile(newLogin);

        }
        return res;
    }

    public String getDomainPath() {
        if (domainPath == null) {
            domainPath = initDomainPath();
        }
        return domainPath;
    }

    private String initDomainPath() {
        final String path = this.getClass().getResource("").getPath();
        final Integer indexEnd =path.indexOf("/pdm-war");
        if (indexEnd > 0) {
            return path.substring(0, indexEnd);
        }
        return path;
    }
}
