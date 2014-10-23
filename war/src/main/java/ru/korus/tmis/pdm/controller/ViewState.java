package ru.korus.tmis.pdm.controller;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        02.09.14, 12:50 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public enum ViewState {

    ROOT("/", ""),
    MAIN("/config", "Настройки"),
    AUTH("/auth", "Авторизация"),
    SYSTEMS("/systems", "Подсистемы"),
    DOCS("/docs", "Документы"),
    FILES("/files", "Файлы");
    /*CREATE("/create", "Новая запись"),
    FIND("/find", "Поиск и редактирование");*/

    private final String path;

    private final String title;

    private final Boolean isShowTitle;

    ViewState(String path, String title) {
        this(path, title, true);
    }

    ViewState(String path, String title, Boolean isShowTitle) {
        this.path = path;
        this.title = title;
        this.isShowTitle = isShowTitle;
    }

    public Boolean isShowTitle() {
        return isShowTitle;
    }

    public String getPath() {
        return path;
    }

    public String getJspPath() {
        return path.replace('/', '-');
    }

    public String redirect() {
        return "redirect:" + path;
    }

    public String getTitle() {
        return title;
    }

}
