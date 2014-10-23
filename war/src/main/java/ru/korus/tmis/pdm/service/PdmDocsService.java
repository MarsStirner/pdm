package ru.korus.tmis.pdm.service;

import ru.korus.tmis.pdm.model.PdmDocs;
import ru.korus.tmis.pdm.model.PdmDocsInfo;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        20.10.2014, 18:44 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public interface PdmDocsService {

    PdmDocs getDocsInfo();

    boolean addDoc(PdmDocsInfo newDoc);

    boolean updateDocs(PdmDocsInfo pdmDocsInfo);

    boolean deleteDoc(String name);

    boolean updateAttr(PdmDocsInfo pdmDocsInfo, Integer attrIndex);

    boolean deleteAttr(String docName, Integer attrIndex);

    boolean addAttr(PdmDocsInfo pdmDocsInfo);
}
