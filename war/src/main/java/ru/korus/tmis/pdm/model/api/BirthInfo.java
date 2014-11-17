package ru.korus.tmis.pdm.model.api;

import ru.korus.tmis.pdm.model.AddrInfo;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        12.11.2014, 13:34 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class BirthInfo implements PdmUpdateble {

    private String birthDate;

    private AddrInfo birthPlace;

    private UpdateInfo updateInfo;

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public AddrInfo getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(AddrInfo birthPlace) {
        this.birthPlace = birthPlace;
    }

    public UpdateInfo getUpdateInfo() {
        return updateInfo;
    }

    public void setUpdateInfo(UpdateInfo updateInfo) {
        this.updateInfo = updateInfo;
    }

    public boolean isNeedUpdate(BirthInfo birthInfo) {
        if(birthInfo == null || birthInfo.getUpdateInfo() == null) {
            return false;
        }
        Object[][] ar = { {birthDate, birthInfo.birthDate}, {birthPlace, birthInfo.birthPlace} };
        return birthInfo.getUpdateInfo().isForceUpdate() || PersonalInfo.isNeedUpdate(ar);
    }
}
