package ru.korus.tmis.pdm.entities;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
* Author:      Sergey A. Zagrebelny <br>
* Date:        06.10.2014, 17:03 <br>
* Company:     Korus Consulting IT<br>
* Description:  <br>
*/
@Embeddable
public class Use {

    private UseType use;

    public void setUse(UseType use) {
        this.use = use;
    }

    public void setUse(String use) {
        this.use = UseType.valueOf(use);
    }

    public String getUse() {
        return use.name();
    }
}
