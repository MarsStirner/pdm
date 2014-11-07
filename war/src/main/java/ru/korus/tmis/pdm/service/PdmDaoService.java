package ru.korus.tmis.pdm.service;

import ru.korus.tmis.pdm.model.DocsInfo;
import ru.korus.tmis.pdm.model.PersonalInfo;

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

    PersonalInfo findById(byte[] privateKey) throws InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException;

    /**
     * Поиск по персональным данным
     * @param person – набор персональных данных
     * @return список подходящих персон
     */
    List<PersonalInfo> find(PersonalInfo person, String senderId);

    List<PersonalInfo> findPersonLike(PersonalInfo person, String senderId);
}
