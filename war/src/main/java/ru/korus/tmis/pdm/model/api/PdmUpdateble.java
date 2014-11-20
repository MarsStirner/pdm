package ru.korus.tmis.pdm.model.api;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        17.11.2014, 13:31 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public interface PdmUpdateble {

    UpdateInfo getUpdateInfo();

    void setUpdateInfo(UpdateInfo updateInfo);
}