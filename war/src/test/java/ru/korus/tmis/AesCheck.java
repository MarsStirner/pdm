package ru.korus.tmis;


import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        08.10.2014, 15:28 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class AesCheck {
    public void run() {
        try {
            String text = "Hello Worldwwewew";
            String key = "Bar12345Bar12345"; // 128 bit key

            // Create key and cipher
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");

            // encrypt the text
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(text.getBytes());
            System.err.println(new String(encrypted));

            // decrypt the text
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            String decrypted = new String(cipher.doFinal(encrypted));
            System.err.println(decrypted);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AesCheck app = new AesCheck();
        app.run();
    }
}
