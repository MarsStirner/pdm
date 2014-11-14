package ru.korus.tmis.pdm.model.api;

import ru.korus.tmis.pdm.model.UseInfo;
import ru.korus.tmis.pdm.model.api.UpdateInfo;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        27.10.2014, 15:33 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class ValueInfo implements UseInfo {

    private String description;

    private String value;

    private String oid;

    private UpdateInfo updateInfo;

    public ValueInfo() {

    }

    public ValueInfo(String description, String value, String oid) {
        this.oid = oid;
        this.description = description;
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getUse() {
        return description;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public UpdateInfo getUpdateInfo() {
        return updateInfo;
    }

    public void setUpdateInfo(UpdateInfo updateInfo) {
        this.updateInfo = updateInfo;
    }

    public boolean isNeedUpdate(ValueInfo valueInfo) {
        if(valueInfo == null || valueInfo.getUpdateInfo() == null) {
            return false;
        }
        Object[][] ar = { {description, valueInfo.description}, {value, valueInfo.value}, {oid, valueInfo.oid}};
        return valueInfo.getUpdateInfo().isForceUpdate() || PersonalInfo.isNeedUpdate(ar);
    }
}
