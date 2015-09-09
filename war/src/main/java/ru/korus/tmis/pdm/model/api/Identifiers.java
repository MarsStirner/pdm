package ru.korus.tmis.pdm.model.api;

import java.util.List;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        02.08.2015, 16:08 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class Identifiers  extends WithErrorStatus {

    private List<PersonalInfo> personalInfoList;

    public List<PersonalInfo> getPersonalInfoList() {
        return personalInfoList;
    }

    public void setPersonalInfoList(List<PersonalInfo> personalInfoList) {
        this.personalInfoList = personalInfoList;
    }
}
