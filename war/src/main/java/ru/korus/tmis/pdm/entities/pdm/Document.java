package ru.korus.tmis.pdm.entities.pdm;

import javax.persistence.*;
import java.util.List;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        31.10.2014, 17:35 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
@Entity(name = "document")
public class Document extends PrivateKeyAndHistory<Document> {

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Attr> attribute;

    public List<Attr> getAttribute()
    {
        return attribute;
    }

    public void setAttribute(List<Attr> attribute) {
        this.attribute = attribute;
    }
}
