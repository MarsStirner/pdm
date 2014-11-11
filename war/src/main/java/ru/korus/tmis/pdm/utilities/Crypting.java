package ru.korus.tmis.pdm.utilities;

import ru.korus.tmis.pdm.model.api.ErrorStatus;
import ru.korus.tmis.pdm.model.api.Identifier;
import ru.korus.tmis.pdm.service.impl.PdmServiceImpl;

import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        09.10.2014, 14:40 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class Crypting {

    public static byte[] genKey(String pass, byte[] salt, int size) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        PBEKeySpec spec = new PBEKeySpec(pass.toCharArray(), salt, 1, size);
        SecretKey secretKey = factory.generateSecret(spec);
        return secretKey.getEncoded();
    }

    public static byte[] getSecureRandomBytes(int privateKeySize) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] privateKey = new byte[privateKeySize];
        secureRandom.nextBytes(privateKey);
        return privateKey;
    }

    public static List<Byte> getSecureRandomByteList(int privateKeySize) {
        return toListByte(getSecureRandomBytes(privateKeySize));
    }

    public static byte[] crypt(byte[] key, byte[] text) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Key aesKey = new SecretKeySpec(key, PdmServiceImpl.CRYPT_TYPE);
        Cipher cipher = Cipher.getInstance(PdmServiceImpl.CRYPT_TYPE);
        cipher.init(Cipher.ENCRYPT_MODE, aesKey);
        return cipher.doFinal(text);
    }

    public static byte[] decrypt(byte[] key, byte[] privateKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Key aesKey = new SecretKeySpec(key, PdmServiceImpl.CRYPT_TYPE);
        Cipher cipher = Cipher.getInstance(PdmServiceImpl.CRYPT_TYPE);
        cipher.init(Cipher.DECRYPT_MODE, aesKey);
        return cipher.doFinal(privateKey);
    }

    public static List<Byte> cryptToList(byte[] key, List<Byte> text) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] txt = toByteArray(text);
        return toListByte(crypt(key, txt));
    }


    public static List<Byte> decryptToList(byte[] key, List<Byte> text) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] txt = toByteArray(text);
        return toListByte(decrypt(key, txt));
    }

    public static List<Byte> toListByte(byte[] byteArray) {
        List<Byte> res = new ArrayList(byteArray.length);
        for (byte b : byteArray) {
            res.add(b);
        }
        return res;
    }

    public static byte[] toByteArray(List<Byte> bytes) {
        byte[] res = new byte[bytes.size()];
        int i = 0;
        for (Byte b : bytes) {
            res[i++] = b;
        }
        return res;
    }

    public static Identifier toPublicKey(List<Byte> privateKey, byte[] key) {
        Identifier res = new Identifier();
        try {
            if (key != null) {
                List<Byte> encrypted = cryptToList(key, privateKey);
                res.setId(DatatypeConverter.printBase64Binary(toByteArray(encrypted)));
            }
        } catch (NoSuchAlgorithmException
                | NoSuchPaddingException
                | IllegalBlockSizeException
                | BadPaddingException
                | InvalidKeyException e) {
            res.setStatus(ErrorStatus.CRYPT_ERROR.format(e.getMessage()));
        }

        return res;
    }

    public static String decodeOID(String root) {
        if(root == null) {
            return null;
        }
        return root.replace(PdmServiceImpl.DOT_CH, '.').substring(PdmServiceImpl.OID_PREFIX.length());
    }

    public static String codeOID(String root) {
        if(root == null) {
            return null;
        }
        return PdmServiceImpl.OID_PREFIX + root.replace('.', PdmServiceImpl.DOT_CH);
    }
}
