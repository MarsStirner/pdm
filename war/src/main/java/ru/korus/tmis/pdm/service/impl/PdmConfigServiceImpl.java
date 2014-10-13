package ru.korus.tmis.pdm.service.impl;

import org.springframework.stereotype.Service;
import ru.korus.tmis.pdm.service.PdmConfigService;
import ru.korus.tmis.pdm.service.impl.xml.PdmConfig;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        09.10.2014, 15:18 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
@Service
public class PdmConfigServiceImpl implements PdmConfigService {

    private PdmConfig pdmConfig;

    private Map<String, String> systemsOid = new HashMap<String, String>();

    static private String cfgFileName;

    @PostConstruct
    void loadXml() {
        try {
            cfgFileName = System.getProperty("pdm.config.file", "/etc/pdm/pdm_config.xml");
            File fileConf = new File(cfgFileName);
            JAXBContext jaxbContext = JAXBContext.newInstance(PdmConfig.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            pdmConfig = (PdmConfig) jaxbUnmarshaller.unmarshal(fileConf);
            for(PdmConfig.Systems.System s : pdmConfig.getSystems().getSystem()) {
                systemsOid.put(s.getOid(), s.getPasswordKey());
            }

        } catch (JAXBException e) {
            e.printStackTrace();
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
    public String getSystemPasswordKey(String oid) {
        String passwordKey = systemsOid.get(oid);
        if (passwordKey == null) {
            throw new RuntimeException("Unknown system OID: " + oid);
        }
        return passwordKey;
    }

    @Override
    public String getCfgFileName() {
        return cfgFileName;
    }
}
