package ru.korus.tmis.pdm.alee;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        13.11.13, 18:11 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class AleeCode {

    private String code;

    private String description;

    private String type;

    public AleeCode(String code, String description, String type) {
        this.code = code;
        this.description = description;
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }
}