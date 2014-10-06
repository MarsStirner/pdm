package ru.korus.tmis.pdm.service;

import ru.korus.tmis.pdm.entities.PersonalData;

import java.util.List;
import java.util.Map;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        15.10.13, 12:59 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
//TODO Move too repositories!
public interface PdmDaoService {

    void save(PersonalData personalData);

    boolean find(Map.Entry<String, String> doc);

    PersonalData findById(String id);

    List<PersonalData> find(PersonalData person);

    List<PersonalData> findPersonLike(PersonalData person);
}
