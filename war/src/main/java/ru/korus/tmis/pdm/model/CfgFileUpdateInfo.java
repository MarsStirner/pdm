package ru.korus.tmis.pdm.model;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        14.10.2014, 18:08 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class CfgFileUpdateInfo extends PdmMessage {

    private String cfgFilePath;

    public String getCfgFilePath() {
        return cfgFilePath;
    }

    public void setCfgFilePath(String cfgFilePath) {
        this.cfgFilePath = cfgFilePath;
    }
}
