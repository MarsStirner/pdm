package ru.korus.tmis.pdm.model.api;

import ru.korus.tmis.pdm.entities.HistoryState;

import java.util.Date;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        12.11.2014, 15:06 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class UpdateInfo {

    private String type;

    private Date begDate;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getBegDate() {
        return begDate;
    }

    public void setBegDate(Date begDate) {
        this.begDate = begDate;
    }

    public boolean isForceUpdate() {
        return getType().equals(HistoryState.DELETED.name());
    }
}
