package ru.korus.tmis.pdm;

import java.util.List;
import java.util.Map;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        15.10.13, 12:59 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public interface StorageOperations {
    void save(PersonalData personalData);

    void find(Map.Entry<String, String> doc);

    PersonalData findById(String id);

    List<PersonalData> find(PersonalData person);

    List<PersonalData> findPersonLike(PersonalData person);
}
