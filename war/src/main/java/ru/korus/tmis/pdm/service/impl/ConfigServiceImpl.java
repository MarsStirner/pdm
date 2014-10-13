package ru.korus.tmis.pdm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.korus.tmis.pdm.model.Info;
import ru.korus.tmis.pdm.service.ConfigService;
import ru.korus.tmis.pdm.service.PdmConfigService;

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
    PdmConfigService pdmConfigService;

    @Override
    public Info getInfo() {
        Info res = new Info();
        res.setVersion("//TODO");
        res.setDomainPath(getDomainPath());
        res.setLogin(pdmConfigService.getUserName());
        res.setCfgFileName(pdmConfigService.getCfgFileName());
        return res;
    }

    @Override
    public boolean updateAdminInfo(Info info) {
        return false;
    }

    public String getDomainPath() {
        if (domainPath == null) {
            domainPath = initDomainPath();
        }
        return domainPath;
    }

    private String initDomainPath() {
        final String path = this.getClass().getResource("").getPath();
        /*final Integer indexEnd = Math.max(path.indexOf("/applications/admin-panel"), path.indexOf("/applications/tmis-server"));
        if (indexEnd > 0) {
            return path.substring(0, indexEnd);
        }*/
        return path;
    }
}
