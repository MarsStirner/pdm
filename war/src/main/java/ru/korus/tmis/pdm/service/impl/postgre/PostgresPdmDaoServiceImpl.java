package ru.korus.tmis.pdm.service.impl.postgre;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.korus.tmis.pdm.repositories.PersonDataRepository;
import ru.korus.tmis.pdm.service.PdmDaoService;
import ru.korus.tmis.pdm.entities.PersonalData;

import java.security.SecureRandom;
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

    @Autowired
    PersonDataRepository personDataRepository;

    @Override
    public void save(PersonalData personalData) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] privateKey =  new byte[PersonalData.PRIVATE_KEY_SIZE];
        secureRandom.nextBytes(privateKey);
        personalData.setPrivateKey(privateKey);
        personDataRepository.save(personalData);
    }

    @Override
    public boolean find(Map.Entry<String, String> doc) {
        return false;
    }

    @Override
    public PersonalData findById(byte[] privateKey) {
        return personDataRepository.findByPrivateKey(privateKey);
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
