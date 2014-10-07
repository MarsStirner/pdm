package ru.korus.tmis.pdm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.korus.tmis.pdm.service.PdmDaoService;
import ru.korus.tmis.pdm.service.PdmDaoServiceLocator;
import ru.korus.tmis.pdm.ws.PdmSysProperties;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        06.10.2014, 11:30 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
@Service
public class PdmDaoServiceLocatorImpl implements PdmDaoServiceLocator {

    @Autowired
    @Qualifier("mongoPdmDaoServiceImpl")
    private PdmDaoService mongoPdmDaoService;

    @Autowired
    @Qualifier("postgresPdmDaoServiceImpl")
    private PdmDaoService postgresPdmDaoServiceImpl;

    public PdmDaoService getPdmDaoService() {
        PdmDaoService res = mongoPdmDaoService;
        if (PdmSysProperties.getPdmStorageType().equals(PdmSysProperties.Value.STORAGE_TYPE_POSTGRESQL)) {
            res = postgresPdmDaoServiceImpl;
        }
        return res;
    }
}
