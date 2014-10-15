package ru.korus.tmis.pdm.service;

import ru.korus.tmis.pdm.service.impl.xml.PdmConfig;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        09.10.2014, 14:32 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public interface PdmXmlConfigService {
    String getUserName();

    String getPasswordKey();

    String getSystemPasswordKey(String oid);

    java.util.List<PdmConfig.Systems.System> getSystems();

    String getCfgFileName();

    boolean setNewLogin(String newLogin, String newPassword);

    String getKeyByPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException;

    boolean setNewCfgFile(String newLogin);
}
