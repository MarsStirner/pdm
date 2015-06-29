package ru.korus.tmis.pdm.model;

import org.springframework.data.annotation.Transient;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        14.10.2014, 16:53 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class PdmMessage {

    @Transient
    private transient  final Format formatter = new SimpleDateFormat("HH:mm:ss");

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

    private transient  String msg;

    private transient  PdmMsgType type;

    public String getMsg() {
        return msg;
    }

    public String getAlertName() {
        return type == null ? null : type.getAlertName();
    }

    public PdmMessage() {

    }

    public PdmMessage(String msg, PdmMsgType type) {
        setMessage(formatter.format(new Date()) + ": " + msg, type);
    }

    public void setMessage(PdmMessage msg) {
        setMessage(msg.msg, msg.type);
    }


    public void setMessage(String msg, PdmMsgType type) {
        this.msg = msg;
        this.type = type;
    }

}
