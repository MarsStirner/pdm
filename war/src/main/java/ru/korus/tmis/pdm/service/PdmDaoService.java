package ru.korus.tmis.pdm.service;

import ru.korus.tmis.pdm.model.AddrInfo;
import ru.korus.tmis.pdm.model.DocsInfo;
import ru.korus.tmis.pdm.model.api.PersonalInfo;
import ru.korus.tmis.pdm.model.api.ValueInfo;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        15.10.13, 12:59 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
//TODO Move too repositories!
public interface PdmDaoService {

    /**
     * Сохранение ПД новой персоны
     * @param personalData - ПД
     * @return - private key
     */
    List<Byte> save(PersonalInfo personalData) throws BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;

    /**
     * Проверка наличия документа в хранилище
     * @param docInfo – наименование и атрибуты документа
     * @return true - если документ уже зарегистрирован в ЗХПД
     */
    boolean find(DocsInfo docInfo);

    PersonalInfo findById(byte[] privateKey, String senderId) throws InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException;

    /**
     * Поиск по персональным данным
     * @param person – набор персональных данных
     * @return список подходящих персон
     */
    List<PersonalInfo> find(PersonalInfo person, String senderId);

    /**
     * Полнотекстовый поиск
     * @param query - поисковый запрос
     * @param senderOid - OID подсистемы
     * @return
     */
    List<PersonalInfo> find(String query, String senderOid) throws InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException;

    List<PersonalInfo> findPersonLike(PersonalInfo person, String senderId);

    List<PersonalInfo> getPersons(String senderOid);

    void updateNames(byte[] privateKey, PersonalInfo personalInfo);

    void updateGender(byte[] privateKey, PersonalInfo personalInfo) throws InvalidKeySpecException, NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException;

    void updateBirth(byte[] privateKey, PersonalInfo personalInfo) throws InvalidKeySpecException, NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException;

    void updateTelecom(byte[] privateKeyTelecom, ValueInfo telecom);

    void addTelecom(byte[] privateKey, ValueInfo telecom) throws InvalidKeySpecException, NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException;

    void updateAddr(byte[] privateKeyAddr, AddrInfo addrInfo);

    void addAddr(byte[] privateKey, AddrInfo addrInfo) throws InvalidKeySpecException, NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException;

    void updateDoc(byte[] privateKeyDoc, DocsInfo docsInfo);

    void addDocs(byte[] privateKey, DocsInfo docsInfo) throws InvalidKeySpecException, NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException;

}
