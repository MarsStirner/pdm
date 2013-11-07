package ru.korus.tmis.pdm.alee;

import ru.korus.tmis.pdm.PersonalData;
import ru.korus.tmis.pdm.ws.PostalAddressUse;
import ru.korus.tmis.pdm.ws.TelecommunicationAddressUse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.Map;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        30.10.13, 12:20 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
@XmlRootElement(name = "config")
@XmlAccessorType(XmlAccessType.FIELD)
public class AttrMap {

    /**
     * Имя
     */
    private String givenCode = "name";

    /**
     * Отчество
     */
    private String middleNameCode = "3name";

    /**
     * Фамилия
     */
    private String familyCode = "surname";

    /**
     * Пол
     */
    private String genderCode = "sex";

    /**
     * Дата рождения
     */
    private String birthDataCode = "datebirth";

    /**
     * Место рождения
     */
    private String birthPlaceCode = "placebirth";

    /**
     * e-mail
     */
    private String emailCode = null;

    /**
     *  OID документа / Код в Алее
     */
    private  Map<String, String> docsMap = new HashMap<String, String>();

    /**
     *  Значение 'use' для телефонов / Код в Алее
     */
    private  Map<TelecommunicationAddressUse, String> telecomMap = new HashMap<TelecommunicationAddressUse, String>();

    /**
     *  Значение 'use' для адресов / Код в Алее
     */
    private  Map<PostalAddressUse, String> addrMap = new HashMap<PostalAddressUse, String>();

    public AttrMap() {
        docsMap.put(PersonalData.OID_DOC_PASSPORTNUMBER, "passportnumber");
        docsMap.put(PersonalData.OID_DOC_PASSPORT_DATE, "dateofissue");
        docsMap.put(PersonalData.OID_DOC_PASSPORT_CREATER, "placeissue");
        docsMap.put(PersonalData.OID_DOC_ACTBIRTH_NUMBER, "actbirth");
        docsMap.put(PersonalData.OID_DOC_ACTBIRTH_DATE, "datecertificate");
        docsMap.put(PersonalData.OID_DOC_INN, "inn");
        docsMap.put(PersonalData.OID_DOC_SNILS, "snils");
        docsMap.put(PersonalData.OID_DOC_INSURANCE_ID, "policynumber");
        docsMap.put(PersonalData.OID_DOC_INSURANCE_ID_EXT, "seriespolicy");
        docsMap.put(PersonalData.OID_DOC_INSURANCE_END_DATE, "periodfrom");
        docsMap.put(PersonalData.OID_DOC_INSURANCE_BEG_DATE, "periodupto");
        docsMap.put(PersonalData.OID_DOC_INSURANCE_COMPANY, "insurancecompany");

        addrMap.put(PostalAddressUse.HP, "regaddress");
        addrMap.put(PostalAddressUse.H, "realaddress");

        telecomMap.put(TelecommunicationAddressUse.HP, "homephone");
        telecomMap.put(TelecommunicationAddressUse.WP, "workphone");
        telecomMap.put(TelecommunicationAddressUse.MC, "mobilephone");

    }

    public String getGivenCode() {
        return givenCode;
    }

    public String getMiddleNameCode() {
        return middleNameCode;
    }

    public String getFamilyCode() {
        return familyCode;
    }

    public String getGenderCode() {
        return genderCode;
    }

    public String getBirthDataCode() {
        return birthDataCode;
    }

    public String getBirthPlaceCode() {
        return birthPlaceCode;
    }

    public String getEmailCode() {
        return emailCode;
    }

    public Map<String, String> getDocsMap() {
        return docsMap;
    }

    public Map<TelecommunicationAddressUse, String> getTelecomMap() {
        return telecomMap;
    }

    public Map<PostalAddressUse, String> getAddrMap() {
        return addrMap;
    }
}
