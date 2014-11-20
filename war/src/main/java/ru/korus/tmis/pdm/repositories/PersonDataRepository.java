package ru.korus.tmis.pdm.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.korus.tmis.pdm.entities.Person;

import java.util.List;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        07.10.2014, 12:33 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public interface PersonDataRepository extends PrivateKeyAndHistoryRepository<Person> {

    List<Person> findByPrevIsNull();

    @Query(value = "SELECT * FROM `person` WHERE MATCH(`given`, `middleName`, `family`) AGAINST(:query  IN BOOLEAN MODE)", nativeQuery=true)
    List<Person> findByNamesFullTextMySQL(@Param("query") String query);

    @Query(value = "SELECT DISTINCT `person`.* FROM `person` " +
            "INNER JOIN `person_docs` ON `person`.`id` = `person_docs`.`person_id` " +
            "INNER JOIN `docs` ON `docs`.id = `person_docs`.`docs_id` " +
            "WHERE `docs`.`privateKey` = :docId", nativeQuery=true)
    List<Person> findPersonByDoc(@Param("docId") byte[] docId);

    @Query(value = "SELECT DISTINCT `person`.* FROM `person` " +
            "INNER JOIN `person_addresses` ON `person`.`id` = `person_addresses`.`person_id` " +
            "INNER JOIN `addresses` ON `addresses`.id = `person_addresses`.`address_id` " +
            "WHERE `addresses`.`privateKey` = :addrId", nativeQuery=true)
    List<Person> findPersonByAddr(@Param("addrId") byte[] addrId);

    @Query(value = "SELECT DISTINCT `person`.* FROM `person` " +
            "INNER JOIN `person_telecoms` ON `person`.`id` = `person_telecoms`.`person_id` " +
            "INNER JOIN `telecoms` ON `telecoms`.id = `person_telecoms`.`telecoms_id` " +
            "WHERE `telecoms`.`privateKey` = :telecomId", nativeQuery=true)
    List<Person> findPersonByTelecom(@Param("telecomId") byte[] telecomId);
}
