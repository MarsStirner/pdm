package ru.korus.tmis.pdm.model.api;

import ru.korus.tmis.pdm.entities.pdm.HistoryState;

import java.util.Date;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        05.08.2015, 22:53 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class History<T> {

    private T prev;

    private HistoryState historyState = HistoryState.ACTIVE;

    private Date begDate;

    private Date endDate;

    public T getPrev() {
        return prev;
    }

    public void setPrev(T prev) {
        this.prev = prev;
    }

    public HistoryState getHistoryState() {
        return historyState;
    }

    public void setHistoryState(HistoryState historyState) {
        this.historyState = historyState;
    }

    public Date getBegDate() {
        return begDate;
    }

    public void setBegDate(Date begDate) {
        this.begDate = begDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
