package ru.korus.tmis.pdm.model;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        20.10.2014, 19:10 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class PdmAttrInfo {

    private String name;

    private String description;

    private String oid;

    private transient String newDescription;

    private transient String newOid;

    private transient String newName;

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

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getNewDescription() {
        return newDescription;
    }

    public void setNewDescription(String newDescription) {
        this.newDescription = newDescription;
    }

    public String getNewOid() {
        return newOid;
    }

    public void setNewOid(String newOid) {
        this.newOid = newOid;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }
}
