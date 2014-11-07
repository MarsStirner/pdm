package ru.korus.tmis.pdm.entities;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        06.11.2014, 16:26 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
@MappedSuperclass
public class EntityList extends PrivateKey {

    public EntityList() {
        super();
    }

    public EntityList(byte[] privateKey) {
        setPrivateKey(privateKey);
    }
}
