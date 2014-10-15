package ru.korus.tmis.pdm.service;

import ru.korus.tmis.pdm.model.CfgFileUpdateInfo;
import ru.korus.tmis.pdm.model.ConfigInfo;
import ru.korus.tmis.pdm.model.UpdateLoginInfo;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        13.10.2014, 13:40 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public interface ConfigService {
    ConfigInfo getInfo();

    boolean updateAdminInfo(UpdateLoginInfo updateLoginInfo);

    boolean updateCfgFileInfo(CfgFileUpdateInfo cfgFileUpdateInfo);
}
