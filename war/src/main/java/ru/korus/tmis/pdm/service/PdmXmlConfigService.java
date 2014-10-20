package ru.korus.tmis.pdm.service;

import ru.korus.tmis.pdm.service.impl.xml.PdmConfig;

import javax.xml.bind.JAXBException;
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

    boolean checkSystemPasswordKey(String password, String oid);

    byte[] login(String oid, String password);

    java.util.List<PdmConfig.Systems.System> getSystems();

    String getCfgFileName();

    boolean setNewLogin(String newLogin, String newPassword);

    void saveXml() throws JAXBException;

    String getAdminKeyByPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException;

    boolean setNewCfgFile(String newLogin);

    PdmConfig.Systems.System getSystemByOid(String oid);

    boolean updateSystemPasswordKey(String newPassword, PdmConfig.Systems.System system);

    byte[] getSystemDbKey(String senderId);

    boolean logout(String oid);

    void initSystemByOid();
}
