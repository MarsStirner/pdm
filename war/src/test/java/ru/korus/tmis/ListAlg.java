package ru.korus.tmis;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class ListAlg {
    
    static String IV = "AAAAAAAAAAAAAAAA";
  static String plaintext = "testtext12345678"; /*Note null padding*/
  static String encryptionKey = "0123456789abcdef";
  public static void main(String [] args) {
    try {
      
      System.out.println("==Java==");
      System.out.println("plain:   " + plaintext);
 
      byte[] cipher = encrypt(plaintext, encryptionKey);
 
      System.out.print("cipher:  ");
      for (int i=0; i<cipher.length; i++)
        System.out.print(new Integer(cipher[i])+" ");
      System.out.println("");
 
      String decrypted = decrypt(cipher, encryptionKey);
 
      System.out.println("decrypt: " + decrypted);
 
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
 
  public static byte[] encrypt(String plainText, String encryptionKey) throws Exception {
    Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding", "SunJCE");
    SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes("UTF-8"), "AES");
    cipher.init(Cipher.ENCRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
    return cipher.doFinal(plainText.getBytes("UTF-8"));
  }
 
  public static String decrypt(byte[] cipherText, String encryptionKey) throws Exception{
    Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding", "SunJCE");
    SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes("UTF-8"), "AES");
    cipher.init(Cipher.DECRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
    return new String(cipher.doFinal(cipherText),"UTF-8");
  }

    public static void main1(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException {

        // get an array containing all the installed providers
        Provider[] providers = Security.getProviders();

//        Security.addProvider(new BouncyCastleProvider());

String data = "hello world";

MessageDigest mda = MessageDigest.getInstance("SHA-512");
byte [] digesta = mda.digest(data.getBytes());

MessageDigest mdb = MessageDigest.getInstance("SHA-512");
byte [] digestb = mdb.digest(data.getBytes());

System.out.println(MessageDigest.isEqual(digesta, digestb));

System.out.println(digesta.toString());
//System.out.println(Hex.encodeHex(digesta));

        for (int i = 0; i < providers.length; i++) {

            // get a view of the property keys contained in this provider
            Set<Object> keys = providers[i].keySet();

            for (Iterator<Object> it = keys.iterator(); it.hasNext();) {

                String key = it.next().toString();

                key = key.split(" ")[0];

                if (key.startsWith("Alg.Alias.")) {

                    // strip the alias
                    key = key.substring(10);
                }
                int index = key.indexOf('.');

                String serviceType = key.substring(0, index);

                Set<String> algorithms = getAlgorithms(serviceType);
                System.out.println(serviceType);
                for (Iterator<String> iter = algorithms.iterator(); iter.hasNext();) {
                    System.out.println("t" + iter.next());
                }
            }
        }
    }

    private static Set<String> getAlgorithms(String serviceType) {

        Set<String> algorithms = new TreeSet<String>();

        // get an array containing all the installed providers
        Provider[] providers = Security.getProviders();

        for (int i = 0; i < providers.length; i++) {

            // get a view of the property keys contained in this provider
            Set<Object> keys = providers[i].keySet();
            for (Iterator<Object> it = keys.iterator(); it.hasNext();) {
                String key = it.next().toString();
                key = key.split(" ")[0];
                if (key.startsWith(serviceType + ".")) {
                    algorithms.add(key.substring(serviceType.length() + 1));
                } else if (key.startsWith("Alg.Alias." + serviceType + ".")) {
                    algorithms.add(key.substring(serviceType.length() + 11));

                }

            }
        }
        return algorithms;
    }
}