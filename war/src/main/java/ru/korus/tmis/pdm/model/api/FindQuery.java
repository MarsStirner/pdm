package ru.korus.tmis.pdm.model.api;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        19.11.2014, 14:06 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class FindQuery {

    private String query;

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
