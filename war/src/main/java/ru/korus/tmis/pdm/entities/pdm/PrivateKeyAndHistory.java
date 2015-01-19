package ru.korus.tmis.pdm.entities.pdm;

import javax.persistence.*;
import java.util.Date;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        31.10.2014, 16:29 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
@MappedSuperclass
public class PrivateKeyAndHistory<T extends PrivateKeyAndHistory> extends PrivateKey<T> {

    /**
     * Текущий статус в истории изменений
     */
    @Enumerated(EnumType.STRING)
    private HistoryState historyState = HistoryState.ACTIVE;

    @OneToOne
    private T next;

    @OneToOne
    private T prev;

    private Date begDate;

    private Date endDate;

    public PrivateKeyAndHistory() {
        super();
    }

    public PrivateKeyAndHistory(byte[] privateKey) {
        setPrivateKey(privateKey);
    }

    public T getNext() {
        return next;
    }

    public void setNext(T next) {
        this.next = next;
    }

    public T getPrev() {
        return prev;
    }

    public void setPrev(T prev) {
        this.prev = prev;
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

    public HistoryState getHistoryState() {
        return historyState;
    }

    public void setHistoryState(HistoryState historyState) {
        this.historyState = historyState;
    }

    public T top() {
        if (next == null) {
            return (T) this;
        }
        return (T) ((PrivateKeyAndHistory) next).top();
    }

    public void initNextPrev(T entityNext, Date updateDate) {
        Date date = updateDate == null ? new Date() : updateDate;
        if(entityNext != null) {
            entityNext.setPrev(this);
            entityNext.setBegDate(date);
        }
        setNext(entityNext);
        setEndDate(date);
    }
}
