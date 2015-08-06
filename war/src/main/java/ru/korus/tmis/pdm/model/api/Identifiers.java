package ru.korus.tmis.pdm.model.api;

import java.util.List;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        02.08.2015, 16:08 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class Identifiers  extends WithErrorStatus {

    private List<String> publicKeyList;

    public List<String> getPublicKeyList() {
        return publicKeyList;
    }

    public void setPublicKeyList(List<String> publicKeyList) {
        this.publicKeyList = publicKeyList;
    }
}
