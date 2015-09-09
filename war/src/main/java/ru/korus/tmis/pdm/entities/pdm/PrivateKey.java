package ru.korus.tmis.pdm.entities.pdm;

import ru.korus.tmis.pdm.utilities.Crypting;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.xml.bind.DatatypeConverter;
import java.util.List;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        31.10.2014, 16:29 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
@MappedSuperclass
public class PrivateKey<T> {

    public static final int PRIVATE_KEY_SIZE = 32;

    @Id
    private String id = null;

    /**
     * Уникальный идентификатор субъекта ПДн в ЗХПД
     */
    @Column(length = PrivateKey.PRIVATE_KEY_SIZE)
    private byte[] privateKey = null;

    public String getId() {
        if (id == null) {
            id = DatatypeConverter.printBase64Binary(Crypting.getSecureRandomBytes(PRIVATE_KEY_SIZE));
        }
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static int getPrivateKeySize() {
        return PRIVATE_KEY_SIZE;
    }

    public byte[] getPrivateKey() {
        if ( privateKey == null ) {
            privateKey = Crypting.getSecureRandomBytes(PrivateKey.PRIVATE_KEY_SIZE);
        }
        return privateKey;
    }

    public void setPrivateKey(byte[] privateKey) {
        this.privateKey = privateKey;
    }

    public void setPrivateKey(List<Byte> privateKey) {
        this.privateKey = Crypting.toByteArray(privateKey);
    }

}
