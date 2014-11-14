package ru.korus.tmis.pdm.service.impl.postgres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.korus.tmis.pdm.entities.Birth;
import ru.korus.tmis.pdm.entities.HistoryState;
import ru.korus.tmis.pdm.entities.Person;
import ru.korus.tmis.pdm.entities.Term;
import ru.korus.tmis.pdm.model.DocsInfo;
import ru.korus.tmis.pdm.model.api.PersonalInfo;
import ru.korus.tmis.pdm.model.api.UpdateInfo;
import ru.korus.tmis.pdm.repositories.BirthRepository;
import ru.korus.tmis.pdm.repositories.PersonDataRepository;
import ru.korus.tmis.pdm.repositories.TermRepository;
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
    TermRepository termRepository;

    @Autowired
    BirthRepository birthRepository;


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
        Person personalData = personDataRepository.findByPrivateKeyAndPrevIsNull(privateKey);
        return personalData == null ? null : personalDataBuilderService.createPersonalInfo(personalData, senderId);
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
        return personalDataBuilderService.createPersonalInfoShort(personDataRepository.findByPrevIsNull(), senderOid);
    }

    @Override
    public void updateNames(byte[] privateKey, PersonalInfo personalInfo) {
        Person personalData = personDataRepository.findByPrivateKeyAndPrevIsNull(privateKey).top();
        HistoryState historyState = HistoryState.valueOf(personalInfo.getUpdateInfo().getType());
        Person person = historyState == HistoryState.DELETED ? null : initPerson(personalInfo);
        personalData.initNextPrev(person, personalInfo.getUpdateInfo().getBegDate());
        if(person != null) {
            personDataRepository.save(person);
        }
        personalData.setHistoryState(historyState);
        personDataRepository.save(personalData);
    }

    private Person initPerson(PersonalInfo personalInfo) {
        Person person;
        person = new Person();
        person.setFamily(personalInfo.getFamily());
        person.setGiven(personalInfo.getGiven());
        person.setMiddleName(personalInfo.getMiddleName());
        person.setBegDate(personalInfo.getUpdateInfo().getBegDate());
        person.setHistoryState(HistoryState.ACTIVE);
        return person;
    }

    @Override
    public void updateGender(byte[] privateKey, PersonalInfo personalInfo) throws InvalidKeySpecException, NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
        Person personalData = personDataRepository.findByPrivateKeyAndPrevIsNull(privateKey);
        UpdateInfo updateInfo = personalInfo.getGender().getUpdateInfo();
        HistoryState historyState = HistoryState.valueOf(updateInfo.getType());
        final byte[] key = pdmXmlConfigService.getInternalKey();
        byte[] genderPrivateKey = personalData.getGender();
        Term genderNew = historyState == HistoryState.DELETED ? null :
                personalDataBuilderService.createGender(personalInfo.getGender());

        if(genderPrivateKey != null && genderPrivateKey.length > 0) { //если пол был ранее установлен
            Term genderTop = termRepository.findByPrivateKeyAndPrevIsNull(Crypting.decrypt(key, genderPrivateKey)).top();
            genderTop.initNextPrev(genderNew, updateInfo.getBegDate());
            if (genderNew != null) {
                termRepository.save(genderNew);
            }
            genderTop.setHistoryState(historyState);
            termRepository.save(genderTop);
        } else if (genderNew != null){
            termRepository.save(genderNew);
            personalData.setGender(Crypting.crypt(key, genderNew.getPrivateKey()));
            personDataRepository.save(personalData);
        }
    }

    @Override
    public void updateBirth(byte[] privateKey, PersonalInfo personalInfo) throws InvalidKeySpecException, NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
        Person personalData = personDataRepository.findByPrivateKeyAndPrevIsNull(privateKey);
        UpdateInfo updateInfo = personalInfo.getBirthInfo().getUpdateInfo();
        HistoryState historyState = HistoryState.valueOf(updateInfo.getType());
        final byte[] key = pdmXmlConfigService.getInternalKey();
        byte[] birthPrivateKey = personalData.getBirthInfo();
        Birth birthNew = historyState == HistoryState.DELETED ? null :
                personalDataBuilderService.createBirth(personalInfo);
        if(birthPrivateKey != null && birthPrivateKey.length > 0) { //если информация о дате/месте рождения была ранее установлена
            Birth birthTop = birthRepository.findByPrivateKeyAndPrevIsNull(Crypting.decrypt(key, birthPrivateKey)).top();
            birthTop.initNextPrev(birthNew, updateInfo.getBegDate());
            if (birthNew != null) {
                birthRepository.save(birthNew);
            }
            birthTop.setHistoryState(historyState);
            birthRepository.save(birthTop);
        } else if (birthNew != null){
            birthRepository.save(birthNew);
            personalData.setBirthInfo(Crypting.crypt(key, birthNew.getPrivateKey()));
            personDataRepository.save(personalData);
        }
    }

}
