package ru.korus.tmis.pdm.repositories.pdm;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.korus.tmis.pdm.entities.pdm.Document;

import java.util.List;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        07.10.2014, 12:33 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public interface DocumentRepository extends PrivateKeyAndHistoryRepository<Document> {

    @Query(value = "SELECT DISTINCT `document`.* FROM `document` " +
            "INNER JOIN `document_attr` ON `document`.id = `document_attr`.document_id " +
            "INNER JOIN `attr` ON `attr`.id = `document_attr`.attribute_id  " +
            "WHERE MATCH(`value`) AGAINST(:query  IN BOOLEAN MODE)", nativeQuery=true)
    List<Document> findFullTextMySQL(@Param("query") String query);

    @Query(value = "SELECT DISTINCT document.* FROM document " +
            "INNER JOIN document_attr ON document.id = document_attr.document_id " +
            "INNER JOIN attr ON attr.id = document_attr.attribute_id  " +
            "WHERE fulltext_attr @@ plainto_tsquery(:query)", nativeQuery=true)
    List<Document> findFullTextPostgres(@Param("query") String query);
}
