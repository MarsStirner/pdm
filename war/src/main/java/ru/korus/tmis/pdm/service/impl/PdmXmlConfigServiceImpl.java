package ru.korus.tmis.pdm.service.impl;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.korus.tmis.pdm.service.PdmXmlConfigService;
import ru.korus.tmis.pdm.service.impl.xml.ObjectFactory;
import ru.korus.tmis.pdm.service.impl.xml.PdmConfig;
import ru.korus.tmis.pdm.utilities.Crypting;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.*;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        09.10.2014, 15:18 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
@Service
@Scope("singleton")
public class PdmXmlConfigServiceImpl implements PdmXmlConfigService {

    public static final String PDM_CONFIG_FILE = "pdm.config.file";

    public static final int KEY_SIZE = 128;

    private PdmConfig pdmConfig;

    private Map<String, Object> objectByOid = new HashMap<>();

    private Map<String, PdmConfig.Docs.Doc> docsByName = new HashMap<>();

    private Map<String, List<Byte>> systemsPassKeyDbByOid = new HashMap<>();

    private Map<String, PdmConfig.Docs.Doc> docsByAttrOid = new HashMap<>();

    static private final ru.korus.tmis.pdm.service.impl.xml.ObjectFactory pdmXlmFactory = new ObjectFactory();
    public static final String PDM_INTERNAL_PASSWORD = "X4k7PXQVgmcwjvQ5";

    @PostConstruct
    void loadXml() {
        File fileConf = new File(getCfgFileName());
        loadXml(fileConf);
    }

    private boolean loadXml(File fileConf) {
        boolean res = false;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(PdmConfig.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            pdmConfig = (PdmConfig) jaxbUnmarshaller.unmarshal(fileConf);
            initObjectMap();
            res = true;
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new IllegalStateException("Cannot unmarshal config file: " + fileConf == null ? "null" : fileConf.getName());
        }
        return res;
    }

    @Override
    public void initObjectMap() {
        objectByOid.clear();
        for (PdmConfig.Systems.System s : pdmConfig.getSystems().getSystem()) {
            objectByOid.put(s.getOid(), s);
        }
        for (PdmConfig.Files.File f : pdmConfig.getFiles().getFile()) {
            objectByOid.put(f.getOid(), f);
        }
        docsByName.clear();
        for (PdmConfig.Docs.Doc doc : pdmConfig.getDocs().getDoc()) {
            docsByName.put(doc.getName(), doc);
            for (PdmConfig.Docs.Doc.Attribute attribute : doc.getAttribute()) {
                String oid = attribute.getOid();
                if (objectByOid.get(oid) == null) {
                    objectByOid.put(oid, attribute);
                    docsByAttrOid.put(oid, doc);
                } else {
                    throw new IllegalStateException("Oid " + oid + "  is already used for " + objectByOid.get(oid));
                }
            }
        }
    }

    @Override
    public String getUserName() {
        return pdmConfig.getAdmin().getLogin();
    }

    @Override
    public String getPasswordKey() {
        return pdmConfig.getAdmin().getPasswordKey();
    }

    @Override
    public boolean checkSystemPasswordKey(String password, String oid) {
        Object system = getObjectByOid(oid);
        if (system == null) {
            throw new RuntimeException("Unknown system OID: " + oid);
        }
        return checkSystemPasswordKey(password, (PdmConfig.Systems.System) system);
    }

    private boolean checkSystemPasswordKey(String password, PdmConfig.Systems.System system) {
        try {
            String key = Base64.encode(genSystemPasswordKey(password, system.getSalt1()));
            return key.equals(system.getPasswordKey());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Access denied");
    }

    @Override
    public boolean updateSystemPasswordKey(String newPassword, PdmConfig.Systems.System system) {
        boolean res = false;
        try {
            byte[] salt1 = Crypting.getSecureRandomBytes(64);
            system.setSalt1(Base64.encode(salt1));
            system.setSalt2(Base64.encode(Crypting.getSecureRandomBytes(64)));
            system.setPasswordKey(Base64.encode(genSystemPasswordKey(newPassword, system.getSalt1())));
            res = true;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public byte[] getSystemDbKey(String senderId) {
        byte res[] = null;
        List<Byte> keyList = systemsPassKeyDbByOid.get(senderId);
        if (keyList != null) {
            res = new byte[keyList.size()];
            for (int i = 0; i < keyList.size(); ++i) {
                res[i] = keyList.get(i);
            }
        }
        return res;
    }

    @Override
    public boolean logout(String oid) {
        return systemsPassKeyDbByOid.remove(oid) != null;
    }


    @Override
    public byte[] login(String oid, String password) {
        if ( checkSystemPasswordKey(password, oid) ) {
            List<Byte> token = systemsPassKeyDbByOid.get(oid);
            if (token != null) {
                return Crypting.toByteArray(token);
            }
            PdmConfig.Systems.System system = (PdmConfig.Systems.System) objectByOid.get(oid);
            try {
                byte[] key = genSystemPasswordKey(password, system.getSalt2());
                systemsPassKeyDbByOid.put(oid, Crypting.toListByte(key));
                return key;
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (InvalidKeySpecException e) {
                e.printStackTrace();
            }
        }
        throw new RuntimeException("Unknown system OID: " + oid);
    }

    @Override
    public java.util.List<PdmConfig.Systems.System> getSystems() {
        return pdmConfig.getSystems().getSystem();
    }

    @Override
    public java.util.List<PdmConfig.Docs.Doc> getDocs() {
        return pdmConfig.getDocs().getDoc();
    }


    @Override
    public String getCfgFileName() {
        return System.getProperty(PDM_CONFIG_FILE, "/etc/pdm/pdm_config.xml");
    }

    @Override
    public boolean setNewLogin(String newLogin, String newPassword) {
        boolean res = false;
        try {
            pdmConfig.getAdmin().setSalt1(Base64.encode(Crypting.getSecureRandomBytes(64)));
            pdmConfig.getAdmin().setSalt2(Base64.encode(Crypting.getSecureRandomBytes(64)));
            pdmConfig.getAdmin().setPasswordKey(getAdminKeyByPassword(newPassword));
            pdmConfig.getAdmin().setLogin(newLogin);
            saveXml();
            res = true;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public void saveXml() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(PdmConfig.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(pdmConfig, new File(getCfgFileName()));
    }

    @Override
    public String getAdminKeyByPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        final byte salt[] = pdmConfig.getAdmin().getSalt1() == null ? "nu6AgUBdR6Djwphx".getBytes() : Base64.decode(pdmConfig.getAdmin().getSalt1());
        return Base64.encode(Crypting.genKey(password, salt, KEY_SIZE));
    }

    @Override
    public byte[] getInternalKey() throws NoSuchAlgorithmException, InvalidKeySpecException {
        final byte salt[] = pdmConfig.getAdmin().getSalt2() == null ? "9U4vD8fuwbyRC5Wz".getBytes() : Base64.decode(pdmConfig.getAdmin().getSalt2());
        return Crypting.genKey(PDM_INTERNAL_PASSWORD, salt, KEY_SIZE);
    }


    private byte[] genSystemPasswordKey(String password, String salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return Crypting.genKey(password, Base64.decode(salt), KEY_SIZE);
    }

    @Override
    public boolean setNewCfgFile(String newLogin) {
        boolean res = false;
        if (loadXml(new File(newLogin))) {
            System.setProperty(PDM_CONFIG_FILE, newLogin);
            res = true;
        }
        return res;
    }

    @Override
    public <T> T getObjectByOid(String oid) {
        Object system = objectByOid.get(oid);
        try {
            return system == null ? null : (T) system;
        } catch (ClassCastException ex) {
            return null;
        }
    }

    @Override
    public PdmConfig.Docs.Doc getDocByName(String name) {
        return docsByName.get(name);
    }

    @Override
    public boolean saveIfNeeded(boolean isUpdate) {
        if (isUpdate) {
            try {
                saveXml();
            } catch (JAXBException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    @Override
    public List<PdmConfig.Files.File> getFiles() {
        return pdmConfig.getFiles().getFile();
    }

    @Override
    public String getDocsNameByAttrOid(String root) {
        PdmConfig.Docs.Doc doc = getDocByAttrOid(root);
        if (doc == null) {
            return null;
        }
        return doc.getName();
    }

    private PdmConfig.Docs.Doc getDocByAttrOid(String oid) {
        return docsByAttrOid.get(oid);
    }

    static public ObjectFactory getPdmXlmFactory() {
        return pdmXlmFactory;
    }


}
