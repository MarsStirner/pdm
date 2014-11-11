package ru.korus.tmis.pdm.model.api;

import org.springframework.format.annotation.DateTimeFormat;
import ru.korus.tmis.pdm.entities.Term;
import ru.korus.tmis.pdm.model.AddrInfo;
import ru.korus.tmis.pdm.model.DocsInfo;
import ru.korus.tmis.pdm.model.ValueInfo;
import ru.korus.tmis.pdm.ws.PdmSysProperties;

import java.util.Date;
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

    private String birthDate;

    private AddrInfo birthPlace;

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
}
