package ru.korus.tmis.pdm.model.api;

import ru.korus.tmis.pdm.model.AddrInfo;
import ru.korus.tmis.pdm.model.DocsInfo;

import java.util.LinkedList;
import java.util.List;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        27.10.2014, 15:16 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class PersonalInfo {

    private String token;

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

    public BirthInfo getBirthInfo() {
        if(birthInfo == null) {
            birthInfo = new BirthInfo();
        }
        return birthInfo;
    }

    public void setBirthInfo(BirthInfo birthInfo) {
        this.birthInfo = birthInfo;
    }

    public List<ValueInfo> getTelecoms() {
        if(telecoms == null) {
            telecoms = new LinkedList<>();
        }
        return telecoms;
    }

    public void setTelecoms(List<ValueInfo> telecoms) {
        this.telecoms = telecoms;
    }

    public List<AddrInfo> getAddressList() {
        if(addressList == null) {
            addressList = new LinkedList<>();
        }
        return addressList;
    }

    public void setAddressList(List<AddrInfo> addressList) {
        this.addressList = addressList;
    }

    public List<DocsInfo> getDocs() {
        if(documents == null) {
            documents = new LinkedList<>();
        }
        return documents;
    }

    public void setDocs(List<DocsInfo> docs) {
        this.documents = docs;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<DocsInfo> getDocuments() {
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
        if(that == null || that.getUpdateInfo() == null) {
            return false;
        }
        Object ar[][] = { {family, that.family}, {given, that.given}, {middleName, that.middleName} };
        return that.updateInfo.isForceUpdate() || isNeedUpdate(ar);
    }

    public static boolean isNeedUpdate(Object[][] objects) {
        boolean res = false;
        boolean allObjIsNull = true;
        for (Object obj : objects) {
            Object o1 = ((Object[])obj)[0];
            Object o2 = ((Object[])obj)[1];
            allObjIsNull &= o2 == null;
            res |= (o1 == null ? o2 != null : !o1.equals(o2) );
        }
        return !allObjIsNull && res;
    }

}
