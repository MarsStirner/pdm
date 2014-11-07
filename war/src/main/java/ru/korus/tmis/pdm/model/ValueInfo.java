package ru.korus.tmis.pdm.model;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        27.10.2014, 15:33 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class ValueInfo implements UseInfo {

    private String description;

    private String value;

    public ValueInfo() {

    }

    public ValueInfo(String description, String value) {
        this.description = description;
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getUse() {
        return description;
    }
}