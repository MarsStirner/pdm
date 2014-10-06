package ru.korus.tmis.pdm.service.impl.postgre;

import org.springframework.stereotype.Service;
import ru.korus.tmis.pdm.service.PdmDaoService;
import ru.korus.tmis.pdm.entities.PersonalData;

import java.util.List;
import java.util.Map;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        06.10.2014, 15:24 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
@Service
public class PostgresPdmDaoServiceImpl implements PdmDaoService {

    @Override
    public void save(PersonalData personalData) {

    }

    @Override
    public boolean find(Map.Entry<String, String> doc) {
        return false;
    }

    @Override
    public PersonalData findById(String id) {
        return null;
    }

    @Override
    public List<PersonalData> find(PersonalData person) {
        return null;
    }

    @Override
    public List<PersonalData> findPersonLike(PersonalData person) {
        return null;
    }
}
