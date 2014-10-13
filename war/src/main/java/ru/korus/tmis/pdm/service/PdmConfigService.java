package ru.korus.tmis.pdm.service;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        09.10.2014, 14:32 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public interface PdmConfigService {
    String getUserName();

    String getPasswordKey();

    String getSystemPasswordKey(String oid);

    String getCfgFileName();
}
