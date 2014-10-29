package ru.korus.tmis.pdm.model;

import ru.korus.tmis.pdm.service.impl.xml.PdmConfig;

import java.util.List;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        27.10.2014, 15:39 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class DocsInfo {

    private String name;

    private List<ValueInfo> attrs;

    public String getDescription() {
        return name;
    }

    public void setDescription(String name) {
        this.name = name;
    }

    public List<ValueInfo> getAttrs() {
        return attrs;
    }

    public void setAttrs(List<ValueInfo> attrs) {
        this.attrs = attrs;
    }
}
