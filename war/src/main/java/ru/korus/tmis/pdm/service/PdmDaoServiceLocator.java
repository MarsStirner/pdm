package ru.korus.tmis.pdm.service;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        06.10.2014, 11:36 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public interface PdmDaoServiceLocator {
    PdmDaoService getMongoPdmDaoService();
}
