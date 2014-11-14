package ru.korus.tmis.pdm.repositories;

import org.springframework.data.repository.NoRepositoryBean;
import ru.korus.tmis.pdm.entities.EntityList;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        07.10.2014, 12:33 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
@NoRepositoryBean
public interface ListByteRepository<T extends EntityList<T>> extends PrivateKeyRepository<T> {

}
