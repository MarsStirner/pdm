package ru.korus.tmis.pdm.model.api;

import java.util.List;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        10.11.2014, 12:01 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */

/**
 * Входные данные для CRUD операций
 */
public class PersonInfoReq {

    /**
     * Токен авторизации подсистемы (см. /api/login)
     */
    private String token;

    private WithHistory withHistory;
    /**
     * Персональный данные
     */
    private List<PersonalInfo> personalInfo;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<PersonalInfo> getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(List<PersonalInfo> personalInfo) {
        this.personalInfo = personalInfo;
    }

    public WithHistory getWithHistory() {
        return withHistory;
    }

    public void setWithHistory(WithHistory withHistory) {
        this.withHistory = withHistory;
    }
}
