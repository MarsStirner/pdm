package ru.korus.tmis.pdm.entities;


import javax.persistence.Entity;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        06.11.2014, 17:53 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
@Entity(name = "docs")
public class Docs extends EntityList {

    public Docs() { super();}

    public Docs(byte[] privateKey) {
        super(privateKey);
    }
}
