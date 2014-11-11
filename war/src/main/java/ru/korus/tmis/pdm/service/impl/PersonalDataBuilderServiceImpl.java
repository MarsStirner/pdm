package ru.korus.tmis.pdm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.korus.tmis.pdm.entities.*;
import ru.korus.tmis.pdm.model.AddrInfo;
import ru.korus.tmis.pdm.model.DocsInfo;
import ru.korus.tmis.pdm.model.api.PersonalInfo;
import ru.korus.tmis.pdm.model.ValueInfo;
import ru.korus.tmis.pdm.model.api.Identifier;
import ru.korus.tmis.pdm.repositories.*;
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
    private BirthInfoRepository birthInfoRepository;

    @Autowired
    private AddrRepository addrRepository;

    @Autowired
    private TelecomRepository telecomRepository;

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private AttrRepository attrRepository;

    @Override
    public Person createPersonalData(PersonalInfo personalInfo) throws InvalidKeySpecException, NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
        Person res = new Person();
        final byte[] key = pdmXmlConfigService.getInternalKey();

        initPersonName(personalInfo, res);

        Term gender = createGender(personalInfo.getGender());
        termRepository.save(gender);
        res.setGender(Crypting.crypt(key, gender.getPrivateKey()));

        Birth birthInfo = createBirthInfo(personalInfo);
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

        for (DocsInfo docsInfo : personalInfo.getDocs()) {
            Document document = createDocument(docsInfo);
            for (Attr attr : document.getAttribute()) {
                attrRepository.save(attr);
            }
            documentRepository.save(document);
            res.getDocs().add(new Docs(Crypting.crypt(key, document.getPrivateKey())));
        }

        return res;

    }

    @Override
    public PersonalInfo createPersonalInfo(Person personalData, String senderId) throws InvalidKeySpecException, NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
        if(personalData == null) {
            return null;
        }
        PersonalInfo res = new PersonalInfo();
        final byte[] key = pdmXmlConfigService.getInternalKey();
        final byte[] keySystem = pdmXmlConfigService.getSystemDbKey(senderId);

        Identifier identifier = Crypting.toPublicKey(Crypting.toListByte(personalData.getPrivateKey()), keySystem);
        res.setPublicKey(identifier == null ? null :identifier.getId());

        res.setGiven(personalData.getGiven());
        res.setFamily(personalData.getFamily());
        res.setMiddleName(personalData.getMiddleName());

        byte[] privateKey = Crypting.decrypt(key, personalData.getGender());
        Term gender = termRepository.findByPrivateKey(privateKey);
        if (gender != null) {
            res.setGender(createValueInfo(gender));
        }

        privateKey = Crypting.decrypt(key, personalData.getBirthInfo());
        Birth birthInfo = birthInfoRepository.findByPrivateKey(privateKey);
        if (birthInfo != null) {
            res.setBirthDate(birthInfo.getBirthDate());
            res.setBirthPlace(createAddrInfo(birthInfo.getBirthPlace()));
        }

        res.setAddressList(new ArrayList<AddrInfo>(personalData.getAddress().size()));
        for (EntityList internalKeyAddr : personalData.getAddress()) {
            privateKey = Crypting.decrypt(key, internalKeyAddr.getPrivateKey());
            Addr addr = addrRepository.findByPrivateKey(privateKey);
            res.getAddressList().add(createAddrInfo(addr));
        }

        res.setTelecoms(new ArrayList<ValueInfo>(personalData.getTelecoms().size()));
        for (EntityList internalKeyTel : personalData.getTelecoms()) {
            privateKey = Crypting.decrypt(key, internalKeyTel.getPrivateKey());
            Telecom telecom = telecomRepository.findByPrivateKey(privateKey);
            res.getTelecoms().add(createValueInfo(telecom));
        }

        res.setDocuments(new ArrayList<DocsInfo>(personalData.getDocs().size()));
        for (EntityList internalKeyDoc : personalData.getDocs()) {
            privateKey = Crypting.decrypt(key, internalKeyDoc.getPrivateKey());
            Document doc = documentRepository.findByPrivateKey(privateKey);
            res.getDocuments().add(createDocsInfo(doc));
        }
        return res;
    }

    private ValueInfo createValueInfo(Term gender) {
        ValueInfo res = new ValueInfo();
        res.setValue(gender.getCode());
        res.setDescription(gender.getCodeSystem());
        return res;
    }

    @Override
    public DocsInfo createDocsInfo(Document doc) {
        if (doc == null) {
            return null;
        }
        DocsInfo res = new DocsInfo();
        res.setAttrs(new ArrayList<ValueInfo>(doc.getAttribute().size()));
        for (Attr attr : doc.getAttribute()) {
            res.getAttrs().add(createValueInfo(attr));
        }

        for (Attr attr : doc.getAttribute()) {
            if (attr.getOid() != null) {
                PdmConfig.Docs.Doc docConfig = pdmXmlConfigService.getDocsNameByAttrOid(Crypting.decodeOID(attr.getOid()));
                if (docConfig != null) {
                    res.setName(docConfig.getName());
                    res.setDescription(docConfig.getDescription());
                    break;
                }
            }

        }

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
        if(attrXml != null) {
            res.setDescription(attrXml.getDescription());
        }
        return res;
    }

    @Override
    public ValueInfo createValueInfo(Telecom telecom) {
        if (telecom == null) {
            return null;
        }
        ValueInfo res = new ValueInfo();
        res.setValue(telecom.getValue());
        res.setDescription(telecom.getUse());
        return res;
    }

    @Override
    public AddrInfo createAddrInfo(Addr addr) {
        if (addr == null) {
            return null;
        }
        AddrInfo res = new AddrInfo();
        res.setDescription(addr.getUse());
        res.setAdditionalLocator(addr.getAdditionalLocator());
        res.setBuildingNumberSuffix(addr.getBuildingNumberSuffix());
        res.setCity(addr.getCity());
        res.setCountry(addr.getCountry());
        res.setCounty(addr.getCounty());
        res.setHouseNumber(addr.getHouseNumber());
        res.setPostalCode(addr.getPostalCode());
        res.setPrecinct(addr.getPrecinct());
        res.setState(addr.getState());
        res.setStreetAddressLine(addr.getStreetAddressLine());
        res.setStreetName(addr.getStreetName());
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
        return res;
    }

    @Override
    public Term createGender(ValueInfo gender) {
        if (gender == null) {
            return null;
        }
        Term res = new Term();
        res.setCode(gender.getValue());
        res.setCodeSystem(gender.getDescription());
        return res;
    }

    @Override
    public Birth createBirthInfo(PersonalInfo personalInfo) {
        if (personalInfo == null) {
            return null;
        }
        Birth res = new Birth();
        res.setBirthDate(personalInfo.getBirthDate());
        res.setBirthPlace(createAddr(personalInfo.getBirthPlace()));
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
        return res;
    }

    @Override
    public List<PersonalInfo> createPersonalInfoShort(Iterable<Person> persons, String senderOid) {
        List<PersonalInfo> res = new LinkedList<>();
        final byte[] keySystem = pdmXmlConfigService.getSystemDbKey(senderOid);
        if(keySystem != null) {
            for (Person p : persons) {
                PersonalInfo personalInfo = new PersonalInfo();
                personalInfo.setFamily(p.getFamily());
                personalInfo.setGiven(p.getGiven());
                personalInfo.setMiddleName(p.getMiddleName());
                Identifier identifier = Crypting.toPublicKey(Crypting.toListByte(p.getPrivateKey()), keySystem);
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
