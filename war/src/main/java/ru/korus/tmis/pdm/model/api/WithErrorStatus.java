package ru.korus.tmis.pdm.model.api;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        08.11.2014, 11:48 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class WithErrorStatus {
    private ErrorStatus status;

    public ErrorStatus getStatus() {
        return status;
    }

    public void setStatus(ErrorStatus status) {
        this.status = status;
    }
}
