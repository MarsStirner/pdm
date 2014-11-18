package ru.korus.tmis.pdm.model;

import ru.korus.tmis.pdm.model.api.PdmUpdateble;
import ru.korus.tmis.pdm.model.api.PublicKeyInfo;
import ru.korus.tmis.pdm.model.api.UpdateInfo;
import ru.korus.tmis.pdm.model.api.ValueInfo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        27.10.2014, 15:39 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class DocsInfo implements PdmUpdateble, PublicKeyInfo {

    private String description;

    private String name;

    private List<ValueInfo> attrs;

    private UpdateInfo updateInfo;

    private String publicKey;

    public List<ValueInfo> getAttrs() {
        if(attrs == null) {
            attrs = new LinkedList<>();
        }
        return attrs;
    }

    public UpdateInfo getUpdateInfo() {
        return updateInfo;
    }

    public void setUpdateInfo(UpdateInfo updateInfo) {
        this.updateInfo = updateInfo;
    }

    public void setAttrs(List<ValueInfo> attrs) {
        this.attrs = attrs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public boolean isNeedUpdate(DocsInfo docsInfo) {
        if(docsInfo == null) {
            return false;
        }
        Map<String, ValueInfo> attrByOidNew = new HashMap<>();
        for(ValueInfo attr : docsInfo.getAttrs()) {
            attrByOidNew.put(attr.getOid(), attr);
        }

        Map<String, ValueInfo> attrByOid = new HashMap<>();
        for(ValueInfo attr : getAttrs()) {
            if(attrByOidNew.get(attr.getOid()) == null) { //the attribute has been removed
                return true;
            }
            attrByOid.put(attr.getOid(), attr);
        }
        for(ValueInfo attr : docsInfo.getAttrs()) {
            ValueInfo attrOld = attrByOid.get(attr.getOid());
            if(attrOld == null) { //the attribute has been added
                return true;
            } else if (attrOld.isNeedUpdateValue(attr)) { //the attribute has been modified
                return true;
            }
        }

        return false;
    }
}
