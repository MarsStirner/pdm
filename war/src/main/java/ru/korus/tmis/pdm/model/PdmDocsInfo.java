package ru.korus.tmis.pdm.model;

import java.util.List;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        20.10.2014, 18:50 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class PdmDocsInfo extends PdmMessage {

    private String name;

    private String description;

    private List<PdmAttrInfo> attrs;

    private String newName;

    private String newDescription;

    private PdmAttrInfo newAttr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PdmAttrInfo> getAttrs() {
        return attrs;
    }

    public void setAttrs(List<PdmAttrInfo> attrs) {
        this.attrs = attrs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getNewDescription() {
        return newDescription;
    }

    public void setNewDescription(String newDescription) {
        this.newDescription = newDescription;
    }

    public PdmAttrInfo getNewAttr() {
        return newAttr;
    }

    public void setNewAttr(PdmAttrInfo newAttr) {
        this.newAttr = newAttr;
    }
}
