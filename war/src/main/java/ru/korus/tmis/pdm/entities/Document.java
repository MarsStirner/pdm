package ru.korus.tmis.pdm.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        31.10.2014, 17:35 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
@Entity(name = "document")
public class Document extends PrivateKeyAndHistory<Document> {

    @OneToMany(fetch = FetchType.EAGER)
    private List<Attr> attribute;

    public List<Attr> getAttribute()
    {
        return attribute;
    }

    public void setAttribute(List<Attr> attribute) {
        this.attribute = attribute;
    }
}
