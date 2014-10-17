package ru.korus.tmis.pdm.model;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        14.10.2014, 16:53 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class PdmMessage {

    public static enum PdmMsgType {
        INFO("success"),
        ERROR("danger");

        final private String alertName;

        PdmMsgType(String alertName) {
            this.alertName = alertName;
        }

        public String getAlertName() {
            return alertName;
        }
    }

    private String msg;

    private PdmMsgType type;

    public String getMsg() {
        return msg;
    }

    public String getAlertName() {
        return type == null ? null : type.getAlertName();
    }

    public PdmMessage() {

    }

    public PdmMessage(String msg, PdmMsgType type) {
        setMessage(msg, type);
    }

    public void setMessage(String msg, PdmMsgType type) {
        this.msg = msg;
        this.type = type;
    }

}
