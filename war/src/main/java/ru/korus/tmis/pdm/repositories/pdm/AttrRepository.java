package ru.korus.tmis.pdm.repositories.pdm;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.korus.tmis.pdm.entities.pdm.Attr;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        07.10.2014, 12:33 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public interface AttrRepository extends PagingAndSortingRepository<Attr, String> {

}
