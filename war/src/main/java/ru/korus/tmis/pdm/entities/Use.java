package ru.korus.tmis.pdm.entities;

import ru.korus.tmis.pdm.entities.enums.UseType;

import javax.persistence.*;

/**
* Author:      Sergey A. Zagrebelny <br>
* Date:        06.10.2014, 17:03 <br>
* Company:     Korus Consulting IT<br>
* Description:  <br>
*/
@MappedSuperclass
public class Use<T extends Use> extends PrivateKeyAndHistory<T> {

    @Enumerated(value = EnumType.STRING)
    private UseType use;

    public void setUse(UseType use) {
        this.use = use;
    }

    public void setUse(String use) {
        if(use == null || use.trim().isEmpty()) {
            use = null;
        } else {
            this.use = UseType.valueOf(use);
        }
    }

    public String getUse() {
        return use== null ? null : use.name();
    }
}
