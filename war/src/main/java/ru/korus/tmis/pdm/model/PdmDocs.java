package ru.korus.tmis.pdm.model;

import java.util.List;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        20.10.2014, 18:49 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class PdmDocs {
    private List<PdmDocsInfo> docs;

    public List<PdmDocsInfo> getDocs() {
        return docs;
    }

    public void setDocs(List<PdmDocsInfo> docs) {
        this.docs = docs;
    }
}
