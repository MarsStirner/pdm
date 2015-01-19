package ru.korus.tmis.pdm.repositories.pdm;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.korus.tmis.pdm.entities.pdm.Person;

import java.util.List;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        07.10.2014, 12:33 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public interface PersonDataRepository extends PrivateKeyAndHistoryRepository<Person> {

    List<Person> findByPrevIsNull();

    @Query(value = "SELECT * FROM `person` WHERE MATCH(`given`, `middleName`, `family`) AGAINST(:query  IN BOOLEAN MODE)", nativeQuery = true)
    List<Person> findByNamesFullTextMySQL(@Param("query") String query);

    @Query(value = "SELECT * FROM person WHERE fulltext_names @@ plainto_tsquery(:query)", nativeQuery = true)
    List<Person> findByNamesFullTextPostgres(@Param("query") String query);

    @Query(value = "SELECT p FROM person p JOIN p.docs d WHERE d.privateKey = :docId")
    List<Person> findPersonByDoc(@Param("docId") byte[] docId);

    @Query(value = "SELECT p FROM person p JOIN p.address a WHERE a.privateKey = :addrId")
    List<Person> findPersonByAddr(@Param("addrId") byte[] addrId);

    @Query(value = "SELECT p FROM person p JOIN p.telecoms t WHERE t.privateKey = :telecomId")
    List<Person> findPersonByTelecom(@Param("telecomId") byte[] telecomId);
}
