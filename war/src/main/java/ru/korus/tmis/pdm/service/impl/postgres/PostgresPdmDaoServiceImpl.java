package ru.korus.tmis.pdm.service.impl.postgres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.korus.tmis.pdm.entities.Person;
import ru.korus.tmis.pdm.model.DocsInfo;
import ru.korus.tmis.pdm.model.api.PersonalInfo;
import ru.korus.tmis.pdm.repositories.PersonDataRepository;
import ru.korus.tmis.pdm.service.PdmDaoService;
import ru.korus.tmis.pdm.service.PdmXmlConfigService;
import ru.korus.tmis.pdm.service.PersonalDataBuilderService;
import ru.korus.tmis.pdm.utilities.Crypting;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

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

    @Autowired
    PersonalDataBuilderService personalDataBuilderService;

    @Autowired
    private PdmXmlConfigService pdmXmlConfigService;

    @Override
    public List<Byte> save(PersonalInfo personalInfo) throws BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        Person personalData = personalDataBuilderService.createPersonalData(personalInfo);
        personDataRepository.save(personalData);
        return Crypting.toListByte(personalData.getPrivateKey());
    }

    @Override
    public boolean find(DocsInfo docInfo) {
        return false;
    }

    @Override
    public PersonalInfo findById(byte[] privateKey, String senderId) throws InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException {
        Person personalData = personDataRepository.findByPrivateKey(privateKey);
        return personalDataBuilderService.createPersonalInfo(personalData, senderId);
    }

    @Override
    public List<PersonalInfo> find(PersonalInfo person, String senderId) {
        return null;
    }

    @Override
    public List<PersonalInfo> findPersonLike(PersonalInfo person, String senderId) {
        return null;
    }

    @Override
    public List<PersonalInfo> getPersons(String senderOid) {
        return personalDataBuilderService.createPersonalInfoShort(personDataRepository.findAll(), senderOid);
    }

}
