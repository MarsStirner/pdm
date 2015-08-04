package ru.korus.tmis.pdm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.korus.tmis.pdm.entities.pdm.*;
import ru.korus.tmis.pdm.entities.pdmfiles.PdmFiles;
import ru.korus.tmis.pdm.model.AddrInfo;
import ru.korus.tmis.pdm.model.DocsInfo;
import ru.korus.tmis.pdm.model.api.*;
import ru.korus.tmis.pdm.repositories.pdm.*;
import ru.korus.tmis.pdm.repositories.pdmfiles.PdmFilesRepository;
import ru.korus.tmis.pdm.service.PdmXmlConfigService;
import ru.korus.tmis.pdm.service.PersonalDataBuilderService;
import ru.korus.tmis.pdm.service.impl.xml.PdmConfig;
import ru.korus.tmis.pdm.utilities.Crypting;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        05.11.2014, 18:24 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
@Service
public class PersonalDataBuilderServiceImpl implements PersonalDataBuilderService {

    @Autowired
    TermRepository termRepository;

    @Autowired
    PdmXmlConfigService pdmXmlConfigService;

    @Autowired
    private BirthRepository birthInfoRepository;

    @Autowired
    private AddrRepository addrRepository;

    @Autowired
    private TelecomRepository telecomRepository;

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private AttrRepository attrRepository;

    @Autowired
    private PdmFilesRepository pdmFilesRepository;


    @Override
    public Person createPersonalData(PersonalInfo personalInfo) throws InvalidKeySpecException, NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
        Person res = new Person();
        final byte[] key = pdmXmlConfigService.getInternalKey();

        final byte[] keyFile = pdmXmlConfigService.getInternalFileKey();


        initPersonName(personalInfo, res);

        Term gender = createGender(personalInfo.getGender());
        termRepository.save(gender);
        res.setGender(Crypting.crypt(key, gender.getPrivateKey()));

        Birth birthInfo = createBirth(personalInfo);
        birthInfoRepository.save(birthInfo);
        res.setBirthInfo(Crypting.crypt(key, birthInfo.getPrivateKey()));

        for (AddrInfo addrInfo : personalInfo.getAddressList()) {
            Addr addr = createAddr(addrInfo);
            addrRepository.save(addr);
            res.getAddress().add(new Addresses(Crypting.crypt(key, addr.getPrivateKey())));
        }

        for (ValueInfo telecomInfo : personalInfo.getTelecoms()) {
            Telecom telecom = createTelecom(telecomInfo);
            telecomRepository.save(telecom);
            res.getTelecoms().add(new Telecoms(Crypting.crypt(key, telecom.getPrivateKey())));
        }

        for (DocsInfo docsInfo : personalInfo.getDocuments()) {
            Document document = createDocument(docsInfo);
            for (Attr attr : document.getAttribute()) {
                attrRepository.save(attr);
            }
            documentRepository.save(document);
            res.getDocs().add(new Docs(Crypting.crypt(key, document.getPrivateKey())));
        }

        for (ValueInfo fileInfo : personalInfo.getFiles()) {
            PdmFiles pdmFile = createFile(keyFile, fileInfo);
            pdmFilesRepository.save(pdmFile);
            res.getFiles().add(new Files(Crypting.crypt(key, pdmFile.getPrivateKey())));
        }

        return res;
    }

    @Override
    public PdmFiles createFile(byte[] keyFile, ValueInfo fileInfo) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        PdmFiles res = new PdmFiles();
        res.setData(Crypting.crypt(keyFile, fileInfo.getValue().getBytes()));
        res.setOid(fileInfo.getOid());
        return res;
    }

    @Override
    public PersonalInfo createPersonalInfo(Person personalData, String senderId) throws InvalidKeySpecException, NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
        if (personalData == null) {
            return null;
        }
        Person personNames = personalData.top();
        PersonalInfo res = new PersonalInfo();
        final byte[] key = pdmXmlConfigService.getInternalKey();
        final byte[] keyFile = pdmXmlConfigService.getInternalFileKey();
        final byte[] keySystem = pdmXmlConfigService.getSystemDbKey(senderId);

        Identifier identifier = Crypting.toPublicKey(Crypting.toListByte(personalData.getPrivateKey()), keySystem);
        res.setPublicKey(identifier == null ? null : identifier.getId());

        res.setGiven(personNames.getGiven());
        res.setFamily(personNames.getFamily());
        res.setMiddleName(personNames.getMiddleName());

        byte[] privateKey = Crypting.decrypt(key, personalData.getGender());
        Term gender = termRepository.findByPrivateKeyAndPrevIsNull(privateKey);
        if (gender != null) {
            res.setGender(createValueInfo(gender.top()));
        }

        privateKey = Crypting.decrypt(key, personalData.getBirthInfo()); Birth birthInfo = birthInfoRepository.findByPrivateKeyAndPrevIsNull(privateKey); if (birthInfo != null) {
            Birth birth = birthInfo.top();
            res.getBirthInfo().setBirthDate(birth.getBirthDate());
            res.getBirthInfo().setBirthPlace(createAddrInfo(birth.getBirthPlace(), senderId));
        }

        res.setAddressList(new ArrayList<AddrInfo>(personalData.getAddress().size()));
        for (EntityList internalKeyAddr : personalData.getAddress()) {
            privateKey = Crypting.decrypt(key, internalKeyAddr.getPrivateKey());
            Addr addr = addrRepository.findByPrivateKeyAndPrevIsNull(privateKey);
            if (addr != null) {
                res.getAddressList().add(createAddrInfo(addr, senderId));
            }
        }

        res.setTelecoms(new ArrayList<ValueInfo>(personalData.getTelecoms().size()));
        for (EntityList internalKeyTel : personalData.getTelecoms()) {
            privateKey = Crypting.decrypt(key, internalKeyTel.getPrivateKey());
            Telecom telecom = telecomRepository.findByPrivateKeyAndPrevIsNull(privateKey);
            if(telecom != null) {
                ValueInfo telecomInfo = createValueInfo(telecom, senderId);
                if (telecomInfo != null) {
                    res.getTelecoms().add(telecomInfo);
                }
            }
        }

        res.setDocuments(new ArrayList<DocsInfo>(personalData.getDocs().size()));
        for (EntityList internalKeyDoc : personalData.getDocs()) {
            privateKey = Crypting.decrypt(key, internalKeyDoc.getPrivateKey());
            Document doc = documentRepository.findByPrivateKeyAndPrevIsNull(privateKey);
            if(doc != null) {
                res.getDocuments().add(createDocsInfo(doc, senderId));
            }
        }

        res.setFiles(new ArrayList<ValueInfo>(personalData.getFiles().size()));
        for (EntityList internalKeyDoc : personalData.getFiles()) {
            privateKey = Crypting.decrypt(key, internalKeyDoc.getPrivateKey());
            PdmFiles file = pdmFilesRepository.findByPrivateKeyAndPrevIsNull(privateKey);
            if(file != null) {
                res.getFiles().add(createFileInfo(file, senderId));
            }
        }
        return res;
    }

    @Override
    public ValueInfo createFileInfo(PdmFiles file, String senderId) {
        ValueInfo res = new ValueInfo();
        res.setOid(file.getOid());
        initPublicKey(file, senderId, res);
        return res;
    }

    private ValueInfo createValueInfo(Term gender) {
        ValueInfo res = new ValueInfo();
        res.setValue(gender.getCode());
        res.setDescription(gender.getCodeSystem());
        return res;
    }

    @Override
    public DocsInfo createDocsInfo(Document doc, String senderOid) {
        if (doc == null) {
            return null;
        }
        Document docTop = doc.top();
        DocsInfo res = new DocsInfo();
        res.setAttrs(new ArrayList<ValueInfo>(docTop.getAttribute().size()));
        for (Attr attr : docTop.getAttribute()) {
            res.getAttrs().add(createValueInfo(attr));
        }

        for (Attr attr : docTop.getAttribute()) {
            if (attr.getOid() != null) {
                PdmConfig.Docs.Doc docConfig = pdmXmlConfigService.getDocsNameByAttrOid(Crypting.decodeOID(attr.getOid()));
                if (docConfig != null) {
                    res.setName(docConfig.getName());
                    res.setDescription(docConfig.getDescription());
                    break;
                }
            }
        }

        initPublicKey(doc, senderOid, res);

        return res;
    }

    @Override
    public ValueInfo createValueInfo(Attr attr) {
        if (attr == null) {
            return null;
        }
        ValueInfo res = new ValueInfo();
        res.setValue(attr.getValue());
        String oid = Crypting.decodeOID(attr.getOid());
        res.setOid(oid);
        PdmConfig.Docs.Doc.Attribute attrXml = pdmXmlConfigService.getObjectByOid(oid);
        if (attrXml != null) {
            res.setDescription(attrXml.getDescription());
            res.setName(attrXml.getName());
        }
        return res;
    }

    @Override
    public ValueInfo createValueInfo(Telecom telecom, String senderOid) {
        if (telecom == null) {
            return null;
        }
        Telecom telecomTop = telecom.top();
        if (telecomTop.getHistoryState() == HistoryState.DELETED ) {
            return null;
        }
        ValueInfo res = new ValueInfo();
        initPublicKey(telecom, senderOid, res);
        res.setValue(telecomTop.getValue());
        res.setDescription(telecomTop.getUse());
        return res;
    }

    private <T extends PrivateKey> void initPublicKey(PrivateKey<T> privateKeyEntity, String senderOid, PublicKeyInfo res) {
        final byte[] keySystem = pdmXmlConfigService.getSystemDbKey(senderOid);
        Identifier identifier = Crypting.toPublicKey(Crypting.toListByte(privateKeyEntity.getPrivateKey()), keySystem);
        res.setPublicKey(identifier.getId());
    }

    @Override
    public AddrInfo createAddrInfo(Addr addr, String senderOid) {
        if (addr == null) {
            return null;
        }
        Addr addrTop = addr.top();
        AddrInfo res = new AddrInfo();
        res.setDescription(addrTop.getUse());
        res.setAdditionalLocator(addrTop.getAdditionalLocator());
        res.setBuildingNumberSuffix(addrTop.getBuildingNumberSuffix());
        res.setCity(addrTop.getCity());
        res.setCountry(addrTop.getCountry());
        res.setCounty(addrTop.getCounty());
        res.setHouseNumber(addrTop.getHouseNumber());
        res.setPostalCode(addrTop.getPostalCode());
        res.setPrecinct(addrTop.getPrecinct());
        res.setState(addrTop.getState());
        res.setStreetAddressLine(addrTop.getStreetAddressLine());
        res.setStreetName(addrTop.getStreetName());
        res.setKladr(addr.getKladr());
        res.setKladrCity(addr.getKladrCity());
        res.setIsCity(addr.isCity());
        initPublicKey(addr, senderOid, res);
        return res;
    }

    @Override
    public Document createDocument(DocsInfo docsInfo) {
        if (docsInfo == null) {
            return null;
        }
        Document res = new Document();
        res.setAttribute(new ArrayList<Attr>(docsInfo.getAttrs().size()));
        for (ValueInfo attr : docsInfo.getAttrs()) {
            res.getAttribute().add(createAttr(attr));
        }
        initBegDate(docsInfo, res);
        return res;
    }

    @Override
    public Attr createAttr(ValueInfo attr) {
        if (attr == null) {
            return null;
        }
        Attr res = new Attr();
        res.setValue(attr.getValue());
        res.setOid(Crypting.codeOID(attr.getOid()));
        return res;
    }

    @Override
    public Telecom createTelecom(ValueInfo telecomInfo) {
        if (telecomInfo == null) {
            return null;
        }
        Telecom res = new Telecom();
        res.setValue(telecomInfo.getValue());
        res.setUse(telecomInfo.getUse());
        initBegDate(telecomInfo, res);
        return res;
    }

    private<T> void initBegDate(PdmUpdateble pdmUpdateble, PrivateKeyAndHistory res) {
        UpdateInfo updateInfo = pdmUpdateble.getUpdateInfo();
        res.setBegDate((updateInfo == null || updateInfo.getBegDate() == null ) ? new Date() : updateInfo.getBegDate());
    }

    @Override
    public Term createGender(ValueInfo gender) {
        if (gender == null) {
            return null;
        }
        Term res = new Term();
        res.setCode(gender.getValue());
        res.setCodeSystem(gender.getDescription());
        initBegDate(gender, res);
        return res;
    }

    @Override
    public Birth createBirth(PersonalInfo personalInfo) {
        if (personalInfo == null) {
            return null;
        }
        Birth res = new Birth();
        BirthInfo birthInfo = personalInfo.getBirthInfo();
        res.setBirthDate(birthInfo.getBirthDate());
        res.setBirthPlace(createAddr(birthInfo.getBirthPlace()));
        initBegDate(birthInfo, res);
        return res;
    }

    @Override
    public Addr createAddr(AddrInfo addrInfo) {
        if (addrInfo == null) {
            return null;
        }
        Addr res = new Addr();
        res.setUse(addrInfo.getDescription());
        res.setAdditionalLocator(addrInfo.getAdditionalLocator());
        res.setBuildingNumberSuffix(addrInfo.getBuildingNumberSuffix());
        res.setCity(addrInfo.getCity());
        res.setCountry(addrInfo.getCountry());
        res.setCounty(addrInfo.getCounty());
        res.setHouseNumber(addrInfo.getHouseNumber());
        res.setPostalCode(addrInfo.getPostalCode());
        res.setPrecinct(addrInfo.getPrecinct());
        res.setState(addrInfo.getState());
        res.setStreetAddressLine(addrInfo.getStreetAddressLine());
        res.setStreetName(addrInfo.getStreetName());
        res.setKladr(addrInfo.getKladr());
        initBegDate(addrInfo, res);
        return res;
    }

    @Override
    public List<PersonalInfo> createPersonalInfoShort(Iterable<Person> persons, String senderOid) {
        List<PersonalInfo> res = new LinkedList<>();
        final byte[] keySystem = pdmXmlConfigService.getSystemDbKey(senderOid);
        if (keySystem != null && persons != null) {
            for (Person person: persons) {
                Person personTop = person.top();
                PersonalInfo personalInfo = new PersonalInfo();
                personalInfo.setFamily(personTop.getFamily());
                personalInfo.setGiven(personTop.getGiven());
                personalInfo.setMiddleName(personTop.getMiddleName());
                Identifier identifier = Crypting.toPublicKey(Crypting.toListByte(person.getPrivateKey()), keySystem);
                personalInfo.setPublicKey(identifier == null ? null : identifier.getId());
                res.add(personalInfo);
            }
        }
        return res;
    }

    private void initPersonName(PersonalInfo personalInfo, Person res) {
        res.setGiven(personalInfo.getGiven());
        res.setFamily(personalInfo.getFamily());
        res.setMiddleName(personalInfo.getMiddleName());
    }
}
