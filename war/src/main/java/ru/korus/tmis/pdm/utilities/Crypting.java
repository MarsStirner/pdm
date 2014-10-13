package ru.korus.tmis.pdm.utilities;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        09.10.2014, 14:40 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class Crypting {

    public static byte[] getKey256Bit(String pass, String salt, int size) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        PBEKeySpec spec = new PBEKeySpec(pass.toCharArray(), salt.getBytes(), 1, size);
        SecretKey secretKey = factory.generateSecret(spec);
        return secretKey.getEncoded();
    }

    public static byte[] getSecureRandomBytes(int privateKeySize) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] privateKey =  new byte[privateKeySize];
        secureRandom.nextBytes(privateKey);
        return privateKey;
    }
}
