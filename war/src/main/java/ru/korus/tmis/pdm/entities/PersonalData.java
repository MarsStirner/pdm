package ru.korus.tmis.pdm.entities;


import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
@Entity
public class PersonalData {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Уникальный идентификатор субъекта ПДн в ЗХПД
     */
    private String privateKey;

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
    @ManyToOne(cascade = {CascadeType.ALL})
    private Term gender;

    /**
     * Дата рождения в фомате yyyyMMdd
     */
    private String birthData;

    /**
     * Документы:
     * Документ, удостоверяющий личность;
     * ИНН;
     * Номер полиса обязательного медицинского страхования;
     * Документ, удостоверяющий временную нетрудоспособность;
     * Документ об образовании
     */
    //TODO fix: javax.xml.ws.soap.SOAPFaultException: Map privateKey 3.0.0.2 contains dots but no replacement was configured!
    @ElementCollection
    private Map<String, String> docs = new HashMap<String, String>();

    /**
     * Контактные телефоны и электронные адреса
     */
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Telecom> telecoms = new Vector<Telecom>();

    /**
     * Домашний/рабочий и др. адреса.
     * Возможные значения атрибута use:
     * "H" - home address; "HP" - primary home; "HV" - vacation home,
     * "WP" - work place, "DIR" - direct, "PUB" - public, "BAD" - bad address, "TMP"
     */
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Addr> address = new Vector<Addr>();

    /**
     * Место рождения
     */
    @ManyToOne(cascade = {CascadeType.ALL})
    private Addr birthPlace;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getGiven() {
        return given;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getFamily() {
        return family;
    }

    public Term getGender() {
        return gender;
    }

    public String getBirthData() {
        return birthData;
    }

    public Map<String, String> getDocs() {
        return docs;
    }

    public List<Telecom> getTelecoms() {
        if(telecoms == null) {
            telecoms = new Vector<Telecom>();
        }
        return telecoms;
    }

    public List<Addr> getAddress() {
        if(address == null) {
            address = new Vector<Addr>();
        }
        return address;
    }

    public Addr getBirthPlace() {
        return birthPlace;
    }

    public String toCreateParamList() {
        StringBuilder res = new StringBuilder("?");
        return res.toString();
    }

    public PersonalData setGiven(String given) {
        this.given = given;
        return this;
    }

    public PersonalData setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public PersonalData setFamily(String family) {
        this.family = family;
        return this;
    }

    public PersonalData setGender(Term gender) {
        this.gender = gender;
        return this;
    }

    public PersonalData setBirthData(String birthData) {
        this.birthData = birthData;
        return this;
    }

    public PersonalData setDocs(Map<String, String> docs) {
        this.docs = docs;
        return this;
    }


    public PersonalData setBirthPlace(Addr birthPlace) {
        this.birthPlace = birthPlace;
        return this;
    }

}
