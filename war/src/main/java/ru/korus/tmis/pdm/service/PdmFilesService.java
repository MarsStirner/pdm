package ru.korus.tmis.pdm.service;

import ru.korus.tmis.pdm.model.PdmFileInfo;
import ru.korus.tmis.pdm.model.PdmFiles;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        23.10.2014, 13:20 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public interface PdmFilesService {
    PdmFiles getFilesInfo();

    boolean updateFile(PdmFileInfo pdmFileInfo);

    boolean addFile(PdmFileInfo newFile);

    boolean deleteFile(PdmFileInfo pdmFileInfo);
}
