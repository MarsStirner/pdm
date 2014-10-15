package ru.korus.tmis.pdm.model;

import ru.korus.tmis.pdm.ws.hl7.ST;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        15.10.2014, 16:40 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class PdmSystemInfo extends PdmMessage {

    private String name;

    private String oid;

    private String curPassword;

    private String newName;

    private String newPassword;

    private String newOid;

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

    public String getCurPassword() {
        return curPassword;
    }

    public void setCurPassword(String curPassword) {
        this.curPassword = curPassword;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewOid() {
        return newOid;
    }

    public void setNewOid(String newOid) {
        this.newOid = newOid;
    }
}
