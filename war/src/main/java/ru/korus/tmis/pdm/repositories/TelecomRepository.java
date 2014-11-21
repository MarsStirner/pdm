package ru.korus.tmis.pdm.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.korus.tmis.pdm.entities.Telecom;

import java.util.List;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        07.10.2014, 12:33 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public interface TelecomRepository extends PrivateKeyAndHistoryRepository<Telecom> {

    @Query(value = "SELECT DISTINCT `telecom`.* FROM `telecom` " +
            "WHERE MATCH(`value`) " +
            "AGAINST(:query IN BOOLEAN MODE)", nativeQuery=true)
    List<Telecom> findFullTextMySQL(@Param("query") String query);

    @Query(value = "SELECT DISTINCT telecom.* FROM telecom WHERE fulltext_telecom @@ plainto_tsquery(:query)", nativeQuery=true)
    List<Telecom> findFullTextPostgres(@Param("query") String query);
}
