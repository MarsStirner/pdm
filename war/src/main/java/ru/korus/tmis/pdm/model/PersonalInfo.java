package ru.korus.tmis.pdm.model;

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

    private String given;

    private String family;

    private String middleName;

    private String sex;

    private Date birthDate;

    private String birthPlace;

    private List<ValueInfo> telecoms;

    private List<ValueInfo> addressList;

    private List<DocsInfo> docs;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
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

    public List<ValueInfo> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<ValueInfo> addressList) {
        this.addressList = addressList;
    }

    public List<DocsInfo> getDocs() {
        return docs;
    }

    public void setDocs(List<DocsInfo> docs) {
        this.docs = docs;
    }

}
