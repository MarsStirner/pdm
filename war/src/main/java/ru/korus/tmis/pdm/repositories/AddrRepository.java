package ru.korus.tmis.pdm.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.korus.tmis.pdm.entities.Addr;
import ru.korus.tmis.pdm.entities.Document;

import java.util.List;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        07.10.2014, 12:33 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public interface AddrRepository extends PrivateKeyAndHistoryRepository<Addr> {

    @Query(value = "SELECT DISTINCT `addr`.* FROM `addr` " +
            "WHERE MATCH(`additionalLocator`, " +
            "`buildingNumberSuffix`, " +
            "`careOf`, " +
            "`censusTract`, " +
            "`city`, " +
            "`country`, " +
            "`county`, " +
            "`delimiter`, " +
            "`deliveryAddressLine`, " +
            "`deliveryInstallationArea`, " +
            "`deliveryInstallationQualifier`, " +
            "`deliveryInstallationType`, " +
            "`deliveryMode`, " +
            "`deliveryModeIdentifier`, " +
            "`direction`, " +
            "`houseNumber`) " +
            "AGAINST(:query  IN BOOLEAN MODE)", nativeQuery=true)
    List<Addr> findFullTextMySQL(@Param("query") String query);

    @Query(value = "SELECT DISTINCT `addr`.* FROM `addr` " +
            "WHERE MATCH(`houseNumberNumeric`, " +
            "`postBox`, " +
            "`postalCode`, " +
            "`precinct`, " +
            "`state`, " +
            "`streetAddressLine`, " +
            "`streetName`, " +
            "`streetNameBase`, " +
            "`unitID`, " +
            "`unitType`) " +
            "AGAINST(:query  IN BOOLEAN MODE)", nativeQuery=true)
    List<Addr> findFullTextMySQLExt(@Param("query") String query);
}
