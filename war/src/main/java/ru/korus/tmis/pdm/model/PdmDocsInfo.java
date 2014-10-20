package ru.korus.tmis.pdm.model;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        20.10.2014, 18:50 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class PdmDocsInfo extends PdmMessage {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
