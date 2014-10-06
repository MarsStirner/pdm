package ru.korus.tmis.pdm.entities;

/**
* Author:      Sergey A. Zagrebelny <br>
* Date:        06.10.2014, 17:03 <br>
* Company:     Korus Consulting IT<br>
* Description:  <br>
*/
public class Term {
    private String code;
    private String codeSystem;

    static public Term newInstance(String code, String codeSystem) {
        Term res = new Term();
        res.code = code;
        res.codeSystem = codeSystem;
        return res;
    }

    public String getCode() {
        return code;
    }

    public String getCodeSystem() {
        return codeSystem;
    }
}
