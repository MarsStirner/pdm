package ru.korus.tmis.pdm.service.impl;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.korus.tmis.pdm.service.PdmXmlConfigService;
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
    public static final int KEY_SIZE = 64;
    private PdmConfig pdmConfig;

    private Map<String, PdmConfig.Systems.System> systemsByOid = new HashMap<>();

    private Map<String, List<Byte>> systemsPassKeyDbByOid = new HashMap<>();

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
            for(PdmConfig.Systems.System s : pdmConfig.getSystems().getSystem()) {
                systemsByOid.put(s.getOid(), s);
            }
            res = true;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return res;
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
        PdmConfig.Systems.System passwordKey = systemsByOid.get(oid);
        if (passwordKey == null) {
            throw new RuntimeException("Unknown system OID: " + oid);
        }
        return checkSystemPasswordKey(password, passwordKey);
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
        if(keyList != null) {
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
    public void initSystemByOid() {
        for(PdmConfig.Systems.System s : pdmConfig.getSystems().getSystem()) {
            String oid = s.getOid();
            if(systemsByOid.get(oid) == null) {
                systemsByOid.put(oid, s);
            }
        }
    }

    @Override
    public byte[] login(String oid, String password) {
        if(systemsPassKeyDbByOid.get(oid) != null) {
            throw new RuntimeException("Access denied: oid " + oid);
        }
        PdmConfig.Systems.System system = systemsByOid.get(oid);
        if (system == null || checkSystemPasswordKey(password, system)) {
            throw new RuntimeException("Unknown system OID: " + oid);
        }
        try {
            byte[] key = genSystemPasswordKey(password, system.getSalt2());
            ArrayList keyByte = new ArrayList(key.length);
            for(byte b : key) {
                keyByte.add(b);
            }
            systemsPassKeyDbByOid.put(oid, keyByte);
            return key;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Unknown system OID: " + oid);
    }

    @Override
    public java.util.List<PdmConfig.Systems.System> getSystems() {
        return pdmConfig.getSystems().getSystem();
    }

    @Override
    public String getCfgFileName() {
        return System.getProperty(PDM_CONFIG_FILE, "/etc/pdm/pdm_config.xml");
    }

    @Override
    public boolean setNewLogin(String newLogin, String newPassword) {
        boolean res = false;
        try {
            pdmConfig.getAdmin().setSalt(Base64.encode(Crypting.getSecureRandomBytes(64)));
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
        final byte salt[] = pdmConfig.getAdmin().getSalt() == null ? "admin_pass".getBytes() : Base64.decode(pdmConfig.getAdmin().getSalt());
        return Base64.encode(Crypting.genKey(password, salt, KEY_SIZE));
    }

    private byte[] genSystemPasswordKey(String password, String salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return Crypting.genKey(password, Base64.decode(salt), KEY_SIZE);
    }

    @Override
    public boolean setNewCfgFile(String newLogin) {
        boolean res = false;
        if(loadXml(new File(newLogin))) {
            System.setProperty(PDM_CONFIG_FILE, newLogin);
            res = true;
        }
        return res;
    }

    @Override
    public PdmConfig.Systems.System getSystemByOid(String oid) {
        return systemsByOid.get(oid);
    }


}
