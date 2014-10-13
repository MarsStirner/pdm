package ru.korus.tmis.pdm.service;

import ru.korus.tmis.pdm.model.Info;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        13.10.2014, 13:40 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public interface ConfigService {
    Info getInfo();

    boolean updateAdminInfo(Info info);
}
