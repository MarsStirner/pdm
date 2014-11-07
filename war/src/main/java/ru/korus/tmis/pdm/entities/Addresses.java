package ru.korus.tmis.pdm.entities;


import javax.persistence.Entity;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        06.11.2014, 17:53 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
@Entity(name="addresses")
public class Addresses extends EntityList {

    public Addresses() { super();}

    public Addresses(byte[] privateKey) {
        setPrivateKey(privateKey);
    }
}
