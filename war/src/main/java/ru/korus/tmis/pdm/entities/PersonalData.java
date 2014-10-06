package ru.korus.tmis.pdm.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.korus.tmis.pdm.service.impl.PdmServiceImpl;
import ru.korus.tmis.pdm.ws.hl7.*;

import javax.xml.bind.JAXBElement;
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
@Document(collection = "users")
public class PersonalData {

    /**
     * Уникальный идентификатор субъекта ПДн в ЗХПД
     */
    @Id
    private String id;

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
    //TODO fix: javax.xml.ws.soap.SOAPFaultException: Map key 3.0.0.2 contains dots but no replacement was configured!
    private Map<String, String> docs = new HashMap<String, String>();

    /**
     * Контактные телефоны и электронные адреса
     */
    private Vector<Telecom> telecoms = new Vector<Telecom>();

    /**
     * Домашний/рабочий и др. адреса.
     * Возможные значения атрибута use:
     * "H" - home address; "HP" - primary home; "HV" - vacation home,
     * "WP" - work place, "DIR" - direct, "PUB" - public, "BAD" - bad address, "TMP"
     */
    private Vector<Addr> address = new Vector<Addr>();

    /**
     * Место рождения
     */
    private Addr birthPlace;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Vector<Telecom> getTelecoms() {
        if(telecoms == null) {
            telecoms = new Vector<Telecom>();
        }
        return telecoms;
    }

    public Vector<Addr> getAddress() {
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
