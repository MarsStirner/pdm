package ru.korus.tmis.pdm.model;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        13.10.2014, 13:28 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class ConfigInfo {

    private String version;

    private String domainPath;

    private String login;

    private String cfgFileName;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDomainPath() {
        return domainPath;
    }

    public void setDomainPath(String domainPath) {
        this.domainPath = domainPath;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCfgFileName() {
        return cfgFileName;
    }

    public void setCfgFileName(String cfgFileName) {
        this.cfgFileName = cfgFileName;
    }

}
