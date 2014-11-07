package ru.korus.tmis.pdm.model.api;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        31.10.2014, 12:26 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class Identifier {

    private String id;

    private ErrorStatus status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ErrorStatus getStatus() {
        return status;
    }

    public void setStatus(ErrorStatus status) {
        this.status = status;
    }
}
