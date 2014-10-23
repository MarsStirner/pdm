package ru.korus.tmis.pdm.model;

import java.util.List;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        23.10.2014, 13:20 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class PdmFiles {
    private List<PdmFileInfo> Files;

    private PdmFileInfo newFile;

    public List<PdmFileInfo> getFiles() {
        return Files;
    }

    public void setFiles(List<PdmFileInfo> Files) {
        this.Files = Files;
    }

    public PdmFileInfo getNewFile() {
        return newFile;
    }

    public void setNewFile(PdmFileInfo newFile) {
        this.newFile = newFile;
    }
}
