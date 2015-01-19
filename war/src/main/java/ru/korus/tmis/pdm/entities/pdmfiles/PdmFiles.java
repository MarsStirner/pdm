package ru.korus.tmis.pdm.entities.pdmfiles;

import ru.korus.tmis.pdm.entities.pdm.PrivateKeyAndHistory;

import javax.persistence.Entity;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        15.01.2015, 14:21 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
@Entity(name = "pdmfiles")
public class PdmFiles extends PrivateKeyAndHistory<PdmFiles> {

    private byte[] data;

    private String oid;

    public byte[] getData() {
        return data;
    }

    public void setData( byte[] data) {
        this.data = data;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }
}
