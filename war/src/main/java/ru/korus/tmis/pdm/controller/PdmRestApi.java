package ru.korus.tmis.pdm.controller;

import org.springframework.web.bind.annotation.*;
import ru.korus.tmis.pdm.model.api.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        03.08.2015, 11:04 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public interface PdmRestApi {

    /**
     * Авторизация
     * @param systemLogin - логин и пароль подсистемы
     * @return в случае успеха, токен авторизации, HTTP Status 200 OK
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    Identifier login(@RequestBody SystemLogin systemLogin,  HttpServletResponse response);

    /**
     * Создание персон
     * @param personInfoReq - токен авторизации и персональные данные, создаваемых персон
     * @return в случае успеха, набор публичных ключей, соответствующие новым записям, HTTP Status 200 OK
     */
    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    Identifiers create(@RequestBody PersonInfoReq personInfoReq);

    /**
     * Изменение персональных данных
     * @param personInfoReq токен авторизации и персональные данные
     * @return в случае успеха, обновленные персональные данные, HTTP Status 200 OK
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    @ResponseBody
    Persons update(@RequestBody PersonInfoReq personInfoReq);

    /**
     * Получение персональных данных по публичному ключу
     * @param token - токен авторизации
     * @param publicKey - публичный ключ персоны
     * @returnв случае успеха, персональные данные, соответствующие присланному публичному ключу, HTTP Status 200 OK
     */
    @RequestMapping(value = "get", method = RequestMethod.GET)
    @ResponseBody
    PersonalInfo get(@RequestParam String token,
                     @RequestParam String publicKey);

    /**
     * Получение краткой информации по всем персональным данным
     * @param token - токен авторизации
     * @return в случае успеха, основные персональные данные по всем персонам, HTTP Status 200 OK
     */
    @RequestMapping(value = "persons", method = RequestMethod.GET)
    @ResponseBody
    Persons persons(@RequestParam String token);

    /**
     * Получение персональных данных по списку публичных ключей
     * @param personInfoReq - токен авторизации, параметры запроса и список публичных ключей
     * @return в случае успеха, персональные данные, соответствующие присланному публичным ключам, HTTP Status 200 OK
     */
    @RequestMapping(value = "getList", method = RequestMethod.POST)
    @ResponseBody
    public Persons getList(@RequestBody PersonInfoReq personInfoReq);

    /**
     * Поиск
     * @param findQuery - запрос, для полнотекстового поиска
     * @return в случае успеха, персональные данные, соответствующие релевантные поисковому запросу, HTTP Status 200 OK
     */
    @RequestMapping(value = "find", method = RequestMethod.POST)
    @ResponseBody
    Persons find(@RequestBody FindQuery findQuery);

    @RequestMapping(value = "file", method = RequestMethod.GET, headers = "Accept=image/jpeg, image/jpg, image/png, image/gif")
    @ResponseBody
    byte[] getFile(@RequestParam String token,
                   @RequestParam String publicKey);

    /**
     *
     * @return  информация о структуре и типах, поддерживаемых ЗХПД документов
     */
    @RequestMapping(value = "docs/meta", method = RequestMethod.GET)
    @ResponseBody
    ru.korus.tmis.pdm.model.PdmDocs getDocsMeta();
}
