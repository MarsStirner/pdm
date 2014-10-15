package ru.korus.tmis.pdm.service.impl;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
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
import java.util.HashMap;
import java.util.Map;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        09.10.2014, 15:18 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
@Service
public class PdmXmlConfigServiceImpl implements PdmXmlConfigService {


    public static final String PDM_CONFIG_FILE = "pdm.config.file";
    private PdmConfig pdmConfig;

    private Map<String, String> systemsOid = new HashMap<String, String>();

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
                systemsOid.put(s.getOid(), s.getPasswordKey());
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
    public String getSystemPasswordKey(String oid) {
        String passwordKey = systemsOid.get(oid);
        if (passwordKey == null) {
            throw new RuntimeException("Unknown system OID: " + oid);
        }
        return passwordKey;
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
            pdmConfig.getAdmin().setPasswordKey(getKeyByPassword(newPassword));
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

    private void saveXml() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(PdmConfig.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(pdmConfig, new File(getCfgFileName()));
    }

    @Override
    public String getKeyByPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return Base64.encode(Crypting.getKey256Bit(password, "admin_pass", 64));
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

}
