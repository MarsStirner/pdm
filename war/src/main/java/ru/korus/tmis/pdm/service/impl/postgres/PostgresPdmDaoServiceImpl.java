package ru.korus.tmis.pdm.service.impl.postgres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.korus.tmis.pdm.config.PdmSpringConfiguration;
import ru.korus.tmis.pdm.entities.pdm.*;
import ru.korus.tmis.pdm.entities.pdmfiles.PdmFiles;
import ru.korus.tmis.pdm.model.AddrInfo;
import ru.korus.tmis.pdm.model.DocsInfo;
import ru.korus.tmis.pdm.model.api.PersonalInfo;
import ru.korus.tmis.pdm.model.api.UpdateInfo;
import ru.korus.tmis.pdm.model.api.ValueInfo;
import ru.korus.tmis.pdm.repositories.pdm.*;
import ru.korus.tmis.pdm.repositories.pdmfiles.PdmFilesRepository;
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
import java.util.Collection;
import java.util.LinkedList;
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
    TelecomRepository telecomRepository;

    @Autowired
    AddrRepository addrRepository;

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    PersonalDataBuilderService personalDataBuilderService;

    @Autowired
    private PdmXmlConfigService pdmXmlConfigService;

    @Autowired
    private PdmFilesRepository pdmFilesRepository;

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
    public byte[] findFileById(byte[] privateKey, String senderId) throws InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException {
        PdmFiles personalData = pdmFilesRepository.findByPrivateKeyAndPrevIsNull(privateKey);
        if(personalData == null || personalData.getData() == null || personalData.getData().length == 0) {
            return null;
        } else {
            return  Crypting.decrypt(pdmXmlConfigService.getInternalFileKey(), personalData.getData());
        }
    }


    @Override
    public List<PersonalInfo> find(PersonalInfo person, String senderId) {
        return null;
    }

    @Override
    public List<PersonalInfo> find(String query, String senderOid) throws InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException {
        List<Person> persons = null;
        if(PdmSpringConfiguration.dataBaseType ==  PdmSpringConfiguration.DataBaseType.MYSQL) {
            persons = personDataRepository.findByNamesFullTextMySQL(query);
            persons.addAll(getPersonsByDocAttr(documentRepository.findFullTextMySQL(query)));
            persons.addAll(getPersonsByAddr(addrRepository.findFullTextMySQL(query)));
            persons.addAll(getPersonsByAddr(addrRepository.findFullTextMySQLExt(query)));
            persons.addAll(getPersonsByTelecom(telecomRepository.findFullTextMySQL(query)));
            return personalDataBuilderService.createPersonalInfoShort(persons, senderOid);
        } else if (PdmSpringConfiguration.dataBaseType ==  PdmSpringConfiguration.DataBaseType.POSTGRESQL) {
            persons = personDataRepository.findByNamesFullTextPostgres(query);
            persons.addAll(getPersonsByDocAttr(documentRepository.findFullTextPostgres(query)));
            persons.addAll(getPersonsByAddr(addrRepository.findFullTextPostgres(query)));
            persons.addAll(getPersonsByTelecom(telecomRepository.findFullTextPostgres(query)));
        }
        return personalDataBuilderService.createPersonalInfoShort(persons, senderOid);
    }

    private Collection<? extends Person> getPersonsByTelecom(List<Telecom> telecomList) throws InvalidKeySpecException, NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
        List<Person> res = new LinkedList<>();
        final byte[] key = pdmXmlConfigService.getInternalKey();
        for(Telecom d : telecomList) {
            List<Person> personByTelecom = personDataRepository.findPersonByTelecom(Crypting.crypt(key, d.getPrivateKey()));
            res.addAll(personByTelecom);
        }
        return res;
    }

    private List<Person> getPersonsByDocAttr(List<Document> documentList) throws InvalidKeySpecException, NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
        List<Person> res = new LinkedList<>();
        final byte[] key = pdmXmlConfigService.getInternalKey();
        for(Document d : documentList) {
            List<Person> personByDoc = personDataRepository.findPersonByDoc(Crypting.crypt(key, d.getPrivateKey()));
            res.addAll(personByDoc);
        }
        return res;
    }

    private List<Person> getPersonsByAddr(List<Addr> addrList) throws InvalidKeySpecException, NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
        List<Person> res = new LinkedList<>();
        final byte[] key = pdmXmlConfigService.getInternalKey();
        for(Addr addr : addrList) {
            List<Person> personByAddr = personDataRepository.findPersonByAddr(Crypting.crypt(key, addr.getPrivateKey()));
            res.addAll(personByAddr);
        }
        return res;
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

    @Override
    public void updateTelecom(byte[] privateKeyTelecom, ValueInfo telecomInfo) {
        Telecom telecomTop = telecomRepository.findByPrivateKeyAndPrevIsNull(privateKeyTelecom).top();
        UpdateInfo updateInfo = telecomInfo.getUpdateInfo();
        HistoryState historyState = HistoryState.valueOf(updateInfo.getType());
        Telecom telecomNew = historyState == HistoryState.DELETED ? null :
                personalDataBuilderService.createTelecom(telecomInfo);
        telecomTop.initNextPrev(telecomNew, updateInfo.getBegDate());
        if(telecomNew != null) {
            telecomRepository.save(telecomNew);
        }
        telecomTop.setHistoryState(historyState);
        telecomRepository.save(telecomTop);
    }

    @Override
    public void addTelecom(byte[] privateKey, ValueInfo telecomInfo) throws InvalidKeySpecException, NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
        Telecom telecom = personalDataBuilderService.createTelecom(telecomInfo);
        telecomRepository.save(telecom);
        final byte[] key = pdmXmlConfigService.getInternalKey();
        Person personalData = personDataRepository.findByPrivateKeyAndPrevIsNull(privateKey);
        personalData.getTelecoms().add(new Telecoms(Crypting.crypt(key, telecom.getPrivateKey())));
        personDataRepository.save(personalData);
    }

    @Override
    public void updateAddr(byte[] privateKeyAddr, AddrInfo addrInfo) {
        Addr addrTop = addrRepository.findByPrivateKeyAndPrevIsNull(privateKeyAddr).top();
        UpdateInfo updateInfo = addrInfo.getUpdateInfo();
        HistoryState historyState = HistoryState.valueOf(updateInfo.getType());
        Addr addrNew = historyState == HistoryState.DELETED ? null : personalDataBuilderService.createAddr(addrInfo);
        addrTop.initNextPrev(addrNew, updateInfo.getBegDate());
        if(addrNew != null) {
            addrRepository.save(addrNew);
        }
        addrTop.setHistoryState(historyState);
        addrRepository.save(addrTop);
    }

    @Override
    public void addAddr(byte[] privateKey, AddrInfo addrInfo) throws InvalidKeySpecException, NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
        Addr addr = personalDataBuilderService.createAddr(addrInfo);
        addrRepository.save(addr);
        final byte[] key = pdmXmlConfigService.getInternalKey();
        Person personalData = personDataRepository.findByPrivateKeyAndPrevIsNull(privateKey);
        personalData.getAddress().add(new Addresses(Crypting.crypt(key, addr.getPrivateKey())));
        personDataRepository.save(personalData);
    }

    @Override
    public void updateDoc(byte[] privateKeyDoc, DocsInfo docsInfo) {
        Document docTop = documentRepository.findByPrivateKeyAndPrevIsNull(privateKeyDoc).top();
        UpdateInfo updateInfo = docsInfo.getUpdateInfo();
        HistoryState historyState = HistoryState.valueOf(updateInfo.getType());
        Document docNew = historyState == HistoryState.DELETED ? null : personalDataBuilderService.createDocument(docsInfo);
        docTop.initNextPrev(docNew, updateInfo.getBegDate());
        if(docNew != null) {
            documentRepository.save(docNew);
        }
        docTop.setHistoryState(historyState);
        documentRepository.save(docTop);
    }

    @Override
    public void addDocs(byte[] privateKey, DocsInfo docsInfo) throws InvalidKeySpecException, NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
        Document doc = personalDataBuilderService.createDocument(docsInfo);
        documentRepository.save(doc);
        final byte[] key = pdmXmlConfigService.getInternalKey();
        Person personalData = personDataRepository.findByPrivateKeyAndPrevIsNull(privateKey);
        personalData.getDocs().add(new Docs(Crypting.crypt(key, doc.getPrivateKey())));
        personDataRepository.save(personalData);
    }


}
