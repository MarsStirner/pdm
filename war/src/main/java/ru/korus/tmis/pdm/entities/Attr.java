package ru.korus.tmis.pdm.entities;

import ru.korus.tmis.pdm.utilities.Crypting;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.DatatypeConverter;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        31.10.2014, 17:37 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
@Entity(name = "attr")
public class Attr {

    @Id
    @GeneratedValue
    private Integer id;

    private String oid;

    private String value;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
