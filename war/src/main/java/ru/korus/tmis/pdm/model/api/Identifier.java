package ru.korus.tmis.pdm.model.api;

import java.io.Serializable;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        31.10.2014, 12:26 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class Identifier extends WithErrorStatus {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
