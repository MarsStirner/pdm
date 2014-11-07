package ru.korus.tmis.pdm.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        31.10.2014, 16:27 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
@Entity(name = "birth")
public class Birth extends PrivateKey {
    /**
     * Дата рождения в фомате yyyyMMdd
     */
    private String birthDate;

    /**
     * Место рождения
     */
    @ManyToOne(cascade = {CascadeType.ALL})
    private Addr birthPlace;

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Addr getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(Addr birthPlace) {
        this.birthPlace = birthPlace;
    }
}
