package ru.korus.tmis.pdm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.korus.tmis.pdm.model.PdmFileInfo;
import ru.korus.tmis.pdm.model.PdmFiles;
import ru.korus.tmis.pdm.service.PdmFilesService;
import ru.korus.tmis.pdm.service.PdmXmlConfigService;
import ru.korus.tmis.pdm.service.impl.PdmXmlConfigServiceImpl;
import ru.korus.tmis.pdm.service.impl.xml.PdmConfig;

import java.util.LinkedList;
import java.util.List;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        15.10.2014, 17:10 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
@Service
public class PdmFilesServiceImpl implements PdmFilesService {

    @Autowired
    PdmXmlConfigService pdmXmlConfigService;

    @Override
    public PdmFiles getFilesInfo() {
        List<PdmConfig.Files.File> Files = pdmXmlConfigService.getFiles();
        PdmFiles res = new PdmFiles();
        res.setFiles(new LinkedList<PdmFileInfo>());
        for (PdmConfig.Files.File file : Files) {
            PdmFileInfo pdmFileInfo = new PdmFileInfo();
            pdmFileInfo.setName(file.getName());
            pdmFileInfo.setOid(file.getOid());
            pdmFileInfo.setDescription(file.getDescription());
            pdmFileInfo.setNewName(file.getName());
            pdmFileInfo.setNewOid(file.getOid());
            pdmFileInfo.setNewDescription(file.getDescription());
            res.getFiles().add(pdmFileInfo);
        }
        return res;
    }

    @Override
    public boolean updateFile(PdmFileInfo pdmFileInfo) {
        final String curOid = pdmFileInfo.getOid();
        boolean isUpdate = false;
        PdmConfig.Files.File file = pdmXmlConfigService.getObjectByOid(curOid);

        if (pdmFileInfo.getNewOid() != null && !pdmFileInfo.getNewOid().isEmpty()) {
            file.setOid(pdmFileInfo.getNewOid());
            isUpdate = true;
        }
        if (pdmFileInfo.getNewName() != null && !pdmFileInfo.getNewOid().isEmpty()) {
            file.setName(pdmFileInfo.getNewName());
            isUpdate = true;
        }

        if (pdmFileInfo.getNewDescription() != null && !pdmFileInfo.getNewDescription().isEmpty()) {
            file.setDescription(pdmFileInfo.getNewDescription());
            isUpdate = true;
        }

        return pdmXmlConfigService.saveIfNeeded(isUpdate);
    }


    @Override
    public boolean addFile(PdmFileInfo newFile) {
        if ((PdmConfig.Files.File)pdmXmlConfigService.getObjectByOid(newFile.getNewOid()) == null ) {
            PdmConfig.Files.File file = PdmXmlConfigServiceImpl.getPdmXlmFactory().createPdmConfigFilesFile();
            pdmXmlConfigService.getFiles().add(file);
            file.setOid(newFile.getNewOid());
            file.setName(newFile.getNewName());
            file.setDescription(newFile.getNewDescription());
            pdmXmlConfigService.initObjectMap();
            return pdmXmlConfigService.saveIfNeeded(true);
        }
        return false;
    }

    @Override
    public boolean deleteFile(PdmFileInfo pdmFileInfo) {
        final String curOid = pdmFileInfo.getOid();
        boolean isUpadate = false;
        PdmConfig.Files.File File = pdmXmlConfigService.getObjectByOid(curOid);
        if (pdmXmlConfigService.getFiles().remove(File) ) {
            return pdmXmlConfigService.saveIfNeeded(true);
        }
        return false;
    }


}
