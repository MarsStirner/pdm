package ru.korus.tmis.pdm.model.api;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        10.11.2014, 12:01 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class PersonInfoReq {

    private String token;

    private String publicKey;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }
}
