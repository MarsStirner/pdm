package ru.korus.tmis.pdm.repositories.pdm;

import org.springframework.data.repository.NoRepositoryBean;
import ru.korus.tmis.pdm.entities.pdm.PrivateKeyAndHistory;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        07.10.2014, 12:33 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
@NoRepositoryBean
public interface PrivateKeyAndHistoryRepository<T extends PrivateKeyAndHistory<T>> extends PrivateKeyRepository<T> {

    T findByPrivateKeyAndPrevIsNull(byte[] privateKey);

}
