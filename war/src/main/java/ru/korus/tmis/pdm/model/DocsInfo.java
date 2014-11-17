package ru.korus.tmis.pdm.model;

import ru.korus.tmis.pdm.model.api.PdmUpdateble;
import ru.korus.tmis.pdm.model.api.UpdateInfo;
import ru.korus.tmis.pdm.model.api.ValueInfo;

import java.util.LinkedList;
import java.util.List;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        27.10.2014, 15:39 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class DocsInfo implements PdmUpdateble {

    private String description;

    private String name;

    private List<ValueInfo> attrs;

    private UpdateInfo updateInfo;

    public List<ValueInfo> getAttrs() {
        if(attrs == null) {
            attrs = new LinkedList<>();
        }
        return attrs;
    }

    public UpdateInfo getUpdateInfo() {
        return updateInfo;
    }

    public void setUpdateInfo(UpdateInfo updateInfo) {
        this.updateInfo = updateInfo;
    }

    public void setAttrs(List<ValueInfo> attrs) {
        this.attrs = attrs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
