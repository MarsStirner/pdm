package ru.korus.tmis.pdm.entities.pdm;

import javax.persistence.MappedSuperclass;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        06.11.2014, 16:26 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
@MappedSuperclass
public class EntityList<T> extends PrivateKey<T> {

    public EntityList() {
        super();
    }

    public EntityList(byte[] privateKey) {
        setPrivateKey(privateKey);
    }
}
