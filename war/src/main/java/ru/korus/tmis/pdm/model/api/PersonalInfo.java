package ru.korus.tmis.pdm.model.api;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ru.korus.tmis.pdm.entities.pdm.HistoryState;
import ru.korus.tmis.pdm.model.AddrInfo;
import ru.korus.tmis.pdm.model.DocsInfo;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        27.10.2014, 15:16 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class PersonalInfo extends History<PersonalInfo> {

    private String publicKey;

    private String given;

    private String family;

    private String middleName;

    private ValueInfo gender;

    private BirthInfo birthInfo;

    private UpdateInfo updateInfo;

    private List<ValueInfo> telecoms;

    private List<AddrInfo> addressList;

    private List<DocsInfo> documents;

    private List<ValueInfo> files;

    public String getGiven() {
        return given;
    }

    public void setGiven(String given) {
        this.given = given;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public ValueInfo getGender() {
        return gender;
    }

    public void setGender(ValueInfo gender) {
        this.gender = gender;
    }

    public PersonalInfo() {
        super();
    }

    public BirthInfo getBirthInfo() {
        if (birthInfo == null) {
            birthInfo = new BirthInfo();
        }
        return birthInfo;
    }

    public void setBirthInfo(BirthInfo birthInfo) {
        this.birthInfo = birthInfo;
    }

    public List<ValueInfo> getTelecoms() {
        if (telecoms == null) {
            telecoms = new LinkedList<>();
        }
        return telecoms;
    }

    public void setTelecoms(List<ValueInfo> telecoms) {
        this.telecoms = telecoms;
    }

    public List<AddrInfo> getAddressList() {
        if (addressList == null) {
            addressList = new LinkedList<>();
        }
        return addressList;
    }

    public void setAddressList(List<AddrInfo> addressList) {
        this.addressList = addressList;
    }

    public List<DocsInfo> getDocuments() {
        if (documents == null) {
            documents = new LinkedList<>();
        }
        return documents;
    }

    public void setDocuments(List<DocsInfo> documents) {
        this.documents = documents;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public UpdateInfo getUpdateInfo() {
        return updateInfo;
    }

    public void setUpdateInfo(UpdateInfo updateInfo) {
        this.updateInfo = updateInfo;
    }

    public boolean isNeedUpdateNames(PersonalInfo that) {
        if (that == null || that.getUpdateInfo() == null) {
            return false;
        }
        Object ar[][] = {{family, that.family}, {given, that.given}, {middleName, that.middleName}};
        return that.updateInfo.isForceUpdate() || isNeedUpdate(ar);
    }

    public static boolean isNeedUpdate(Object[][] objects) {
        boolean res = false;
        boolean allObjIsNull = true;
        for (Object obj : objects) {
            Object o1 = ((Object[]) obj)[0];
            Object o2 = ((Object[]) obj)[1];
            allObjIsNull &= o2 == null;
            res |= (o1 == null ? o2 != null : !o1.equals(o2));
        }
        return !allObjIsNull && res;
    }

    public String toQuery() {
        String res = " ";
        res += given == null ? "" : (given + " ");
        res += middleName == null ? "" : (middleName + " ");
        res += family == null ? "" : family;
        return res.trim();
    }

    public List<ValueInfo> getFiles() {
        if (files == null) {
            return new LinkedList<ValueInfo>();
        }
        return files;
    }

    public void setFiles(List<ValueInfo> files) {
        this.files = files;
    }
}
