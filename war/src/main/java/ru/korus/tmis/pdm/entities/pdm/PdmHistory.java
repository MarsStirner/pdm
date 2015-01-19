package ru.korus.tmis.pdm.entities.pdm;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        11.11.2014, 15:19 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public interface PdmHistory<T> {

    T getNext();

    T getPrev();

    HistoryState getHistoryState();
}
