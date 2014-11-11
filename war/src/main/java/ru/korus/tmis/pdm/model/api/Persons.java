package ru.korus.tmis.pdm.model.api;

import java.util.LinkedList;
import java.util.List;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        08.11.2014, 11:47 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class Persons extends WithErrorStatus {

    List<PersonalInfo> personList;

    public List<PersonalInfo> getPersonList() {
        if(personList == null) {
            personList = new LinkedList<>();
        }
        return personList;
    }

    public void setPersonList(List<PersonalInfo> personList) {
        this.personList = personList;
    }
}
