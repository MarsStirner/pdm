package ru.korus.tmis.pdm.service;

import ru.korus.tmis.pdm.model.PdmSystemInfo;
import ru.korus.tmis.pdm.model.PdmSystems;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        15.10.2014, 17:09 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public interface PdmSystemsService {

    PdmSystems getSystemsInfo();

    boolean updateSystem(PdmSystemInfo pdmSystemInfo);

    boolean addSystem(PdmSystemInfo newSystem);

    boolean deleteSystem(PdmSystemInfo pdmSystemInfo);
}
