package ru.korus.tmis.pdm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.korus.tmis.pdm.model.PdmSystemInfo;
import ru.korus.tmis.pdm.model.PdmSystems;
import ru.korus.tmis.pdm.service.PdmSystemsService;
import ru.korus.tmis.pdm.service.PdmXmlConfigService;
import ru.korus.tmis.pdm.service.impl.xml.PdmConfig;

import javax.xml.bind.JAXBException;
import java.util.LinkedList;
import java.util.List;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        15.10.2014, 17:10 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
@Service
public class PdmSystemsServiceImpl implements PdmSystemsService {

    @Autowired
    PdmXmlConfigService pdmXmlConfigService;

    @Override
    public PdmSystems getSystemsInfo() {
        List<PdmConfig.Systems.System> systems = pdmXmlConfigService.getSystems();
        PdmSystems res = new PdmSystems();
        res.setSystems(new LinkedList<PdmSystemInfo>());
        for (PdmConfig.Systems.System system : systems) {
            PdmSystemInfo pdmSystemInfo = new PdmSystemInfo();
            pdmSystemInfo.setName(system.getName());
            pdmSystemInfo.setOid(system.getOid());
            pdmSystemInfo.setNewName(system.getName());
            pdmSystemInfo.setNewOid(system.getOid());
            res.getSystems().add(pdmSystemInfo);
        }
        return res;
    }

    @Override
    public boolean updateSystem(String curOid, PdmSystemInfo pdmSystemInfo) {
        boolean isUpadate = false;
        PdmConfig.Systems.System system = pdmXmlConfigService.getSystemByOid(curOid);
        if ( pdmSystemInfo.getNewPassword() != null && !pdmSystemInfo.getNewPassword().isEmpty() ){
            if (!updateSystemPassword(system, pdmSystemInfo)) {
                return false;
            }
        }
        if (pdmSystemInfo.getNewOid() != null && !pdmSystemInfo.getNewOid().isEmpty()) {
            system.setOid(pdmSystemInfo.getNewOid());
            isUpadate = true;
        }
        if(pdmSystemInfo.getNewName() != null && !pdmSystemInfo.getNewOid().isEmpty()) {
            system.setName(pdmSystemInfo.getNewName());
            isUpadate = true;
        }
        if(isUpadate) {
            try {
                pdmXmlConfigService.saveXml();
            } catch (JAXBException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    private boolean updateSystemPassword(PdmConfig.Systems.System system, PdmSystemInfo pdmSystemInfo) {
        if (pdmXmlConfigService.checkSystemPasswordKey(pdmSystemInfo.getCurPassword(), system.getOid()) )
        {
            return pdmXmlConfigService.updateSystemPasswordKey(pdmSystemInfo.getNewPassword(), system);
        }
        return false;
    }

}
