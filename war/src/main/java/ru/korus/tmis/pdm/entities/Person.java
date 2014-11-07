package ru.korus.tmis.pdm.entities;


import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.util.List;
import java.util.Vector;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        02.07.2013, 12:35:19 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */

/**
 *
 */
//@Document(collection = "users")
@Entity(name = "person")
public class Person extends PrivateKey {


    /**
     * Имя
     */
    private String given;

    /**
     * Отчество
     */
    private String middleName;

    /**
     * Фамилия
     */
    private String family;

    /**
     * Пол
     */
    private byte[] gender;

    /**
     * Информация о дате и месте рождения
     */
    private byte[] birthInfo;

    /**
     * Документы:
     * Документ, удостоверяющий личность;
     * ИНН;
     * Номер полиса обязательного медицинского страхования;
     * Документ, удостоверяющий временную нетрудоспособность;
     * Документ об образовании
     */
    //TODO fix: javax.xml.ws.soap.SOAPFaultException: Map privateKey 3.0.0.2 contains dots but no replacement was configured!
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Docs> docs = new Vector<Docs>();

    /**
     * Контактные телефоны и электронные адреса
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Telecoms> telecoms = new Vector<Telecoms>();

    /**
     * Домашний/рабочий и др. адреса.
     * Возможные значения атрибута use:
     * "H" - home address; "HP" - primary home; "HV" - vacation home,
     * "WP" - work place, "DIR" - direct, "PUB" - public, "BAD" - bad address, "TMP"
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Addresses> address = new Vector<Addresses>();

    public String getGiven() {
        return given;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getFamily() {
        return family;
    }

    public byte[] getGender() {
        return gender;
    }

    public byte[] getBirthInfo() {
        return birthInfo;
    }

    public List<Docs> getDocs() {
        if(docs == null) {
            docs = new Vector<>();
        }
        return docs;
    }

    public List<Telecoms> getTelecoms() {
        if(telecoms == null) {
            telecoms = new Vector<>();
        }
        return telecoms;
    }

    public List<Addresses> getAddress() {
        if(address == null) {
            address = new Vector<>();
        }
        return address;
    }

    public String toCreateParamList() {
        StringBuilder res = new StringBuilder("?");
        return res.toString();
    }

    public Person setGiven(String given) {
        this.given = given;
        return this;
    }

    public Person setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public Person setFamily(String family) {
        this.family = family;
        return this;
    }

    public Person setGender(byte[] gender) {
        this.gender = gender;
        return this;
    }

    public Person setBirthInfo(byte[] birthInfo) {
        this.birthInfo = birthInfo;
        return this;
    }

    public Person setDocs(List<Docs> docs) {
        this.docs = docs;
        return this;
    }

}
