package ru.korus.tmis.pdm.model.api;

import java.util.Date;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        05.08.2015, 23:42 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class WithHistory {

    private Boolean isHistory;

    private Date date;

    public Boolean getIsHistory() {
        return isHistory == null ? false : isHistory;
    }

    public void setIsHistory(Boolean isHistory) {
        this.isHistory = isHistory;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
