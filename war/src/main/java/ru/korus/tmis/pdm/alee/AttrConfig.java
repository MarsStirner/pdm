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
public class AttrConfig {

    public static final String ALEE_TYPE_DATE = "date";
    public static final String ALEE_TYPE_STRING = "string";
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
    private  Map<String, AleeCode> docsMap = new HashMap<String, AleeCode>();

    /**
     *  Значение 'use' для телефонов / Код в Алее
     */
    private  Map<TelecommunicationAddressUse, String> telecomMap = new HashMap<TelecommunicationAddressUse, String>();

    /**
     *  Значение 'use' для адресов / Код в Алее
     */
    private  Map<PostalAddressUse, String> addrMap = new HashMap<PostalAddressUse, String>();

    public AttrConfig() {
        docsMap.put(PersonalData.OID_DOC_PASSPORTNUMBER, new AleeCode("passportnumber", "Номер и серия паспорта", ALEE_TYPE_STRING));
        docsMap.put(PersonalData.OID_DOC_PASSPORT_DATE, new AleeCode("dateofissue", "Дата выдачи паспорта", ALEE_TYPE_DATE));
        docsMap.put(PersonalData.OID_DOC_PASSPORT_CREATER, new AleeCode("placeissue", "Место выдачи паспорта", ALEE_TYPE_STRING));
        docsMap.put(PersonalData.OID_DOC_ACTBIRTH_NUMBER, new AleeCode("actbirth", "Номер акта свидетельства о рождении", ALEE_TYPE_STRING));
        docsMap.put(PersonalData.OID_DOC_ACTBIRTH_DATE, new AleeCode("datecertificate", "Дата выдачи свидетельства о рождении", ALEE_TYPE_DATE));
        docsMap.put(PersonalData.OID_DOC_INN, new AleeCode("inn", "Номер ИНН", "numeric"));
        docsMap.put(PersonalData.OID_DOC_SNILS, new AleeCode("snils", "Номер СНИЛС", ALEE_TYPE_STRING));
        docsMap.put(PersonalData.OID_DOC_INSURANCE_ID, new AleeCode("policynumber", "Номер страхового медицинского полиса", ALEE_TYPE_STRING));
        docsMap.put(PersonalData.OID_DOC_INSURANCE_ID_EXT, new AleeCode("seriespolicy", "Серия страхового медицинского полиса", ALEE_TYPE_STRING));
        docsMap.put(PersonalData.OID_DOC_INSURANCE_END_DATE, new AleeCode("periodfrom", "Срок действия полиса с:", ALEE_TYPE_DATE));
        docsMap.put(PersonalData.OID_DOC_INSURANCE_BEG_DATE, new AleeCode("periodupto", "Срок действия полиса по:", ALEE_TYPE_DATE));
        docsMap.put(PersonalData.OID_DOC_INSURANCE_COMPANY, new AleeCode("insurancecompany", "Страховая компания", ALEE_TYPE_STRING));

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

    public Map<String, AleeCode> getDocsMap() {
        return docsMap;
    }

    public Map<TelecommunicationAddressUse, String> getTelecomMap() {
        return telecomMap;
    }

    public Map<PostalAddressUse, String> getAddrMap() {
        return addrMap;
    }
}
