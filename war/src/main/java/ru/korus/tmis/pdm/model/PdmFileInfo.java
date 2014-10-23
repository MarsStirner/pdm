package ru.korus.tmis.pdm.model;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        23.10.2014, 13:22 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class PdmFileInfo extends PdmMessage {

    private String name;

    private String oid;

    private String description;

    private String newName;

    private String newOid;

    private String newDescription;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getNewOid() {
        return newOid;
    }

    public void setNewOid(String newOid) {
        this.newOid = newOid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNewDescription() {
        return newDescription;
    }

    public void setNewDescription(String newDescription) {
        this.newDescription = newDescription;
    }
}
