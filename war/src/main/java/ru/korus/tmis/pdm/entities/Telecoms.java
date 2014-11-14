package ru.korus.tmis.pdm.entities;


import javax.persistence.Entity;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        06.11.2014, 17:53 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
@Entity(name="telecoms" )
public class Telecoms extends EntityList<Telecoms> {

    public Telecoms() { super();}

    public Telecoms(byte[] privateKey) {
        super(privateKey);
    }
}
