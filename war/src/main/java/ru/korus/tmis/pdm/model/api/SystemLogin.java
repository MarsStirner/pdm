package ru.korus.tmis.pdm.model.api;

import java.io.Serializable;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        07.11.2014, 15:11 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class SystemLogin {

    private String oid;

    private String password;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
