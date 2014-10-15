package ru.korus.tmis.pdm.model;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        14.10.2014, 13:05 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class UpdateLoginInfo extends PdmMessage {

    private String curPassword;

    private String newLogin;

    private String newPassword;

    public String getCurPassword() {
        return curPassword;
    }

    public void setCurPassword(String curPassword) {
        this.curPassword = curPassword;
    }

    public String getNewLogin() {
        return newLogin;
    }

    public void setNewLogin(String newLogin) {
        this.newLogin = newLogin;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
