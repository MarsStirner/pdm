package ru.korus.tmis.pdm.model.api;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        31.10.2014, 12:28 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class ErrorStatus {

    public static final ErrorStatus NO_ERROR = new ErrorStatus(0 , "success");

    public static final ErrorStatus ACCESS_DENIED = new ErrorStatus(1 , "access denied");

    public static final ErrorStatus CRYPT_ERROR = new ErrorStatus(2 , "cryptographic algorithm error: %s");

    private final int errorNumber;

    private final String msg;

    public ErrorStatus() {
        msg = null;
        errorNumber = -1;
    }

    public ErrorStatus(int errorNumber, String msg) {
        this.msg = msg;
        this.errorNumber = errorNumber;
    }

    public int getErrorNumber() {
        return errorNumber;
    }

    public String getMsg() {
        return msg;
    }

    public ErrorStatus format(Object... args) {
        return new ErrorStatus(errorNumber, String.format(msg, args));
    }


}
