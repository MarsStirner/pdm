package ru.korus.tmis.pdm.repositories;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.korus.tmis.pdm.entities.PrivateKey;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        07.10.2014, 12:33 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
@NoRepositoryBean
public interface PrivateKeyRepository <T extends PrivateKey> extends PagingAndSortingRepository<T, String> {

    T findByPrivateKey(byte[] privateKey);

}
