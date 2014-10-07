package ru.korus.tmis.pdm.entities;

import javax.persistence.*;

/**
* Author:      Sergey A. Zagrebelny <br>
* Date:        06.10.2014, 17:03 <br>
* Company:     Korus Consulting IT<br>
* Description:  <br>
*/
//TODO REMOVE!
@Entity
public class Term {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

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
