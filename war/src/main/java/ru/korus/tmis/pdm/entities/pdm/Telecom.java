package ru.korus.tmis.pdm.entities.pdm;

import javax.persistence.Entity;

/**
* Author:      Sergey A. Zagrebelny <br>
* Date:        06.10.2014, 17:13 <br>
* Company:     Korus Consulting IT<br>
* Description:  <br>
*/
@Entity(name = "telecom")
public class Telecom extends Use<Telecom> {

    private String value;

    static public Telecom newInstance(String value, String use) {
        Telecom res = new Telecom();
        res.value = value;
        res.setUse(use);
        return res;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
