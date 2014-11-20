package ru.korus.tmis.pdm.service;

import ru.korus.tmis.pdm.model.api.FindQuery;
import ru.korus.tmis.pdm.model.api.PersonalInfo;
import ru.korus.tmis.pdm.model.api.Identifier;
import ru.korus.tmis.pdm.ws.hl7.*;

import java.util.List;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        30.09.2014, 9:25 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public interface PdmService {

    PRPAIN101312UV02 add(PRPAIN101311UV02 parameters);

    Identifier add(PersonalInfo personalInfo, String senderOid);

    PRPAIN101306UV02 findCandidates(PRPAIN101305UV02 parameters);

    PRPAIN101308UV02 getDemographics(PRPAIN101307UV02 parameters);

    PRPAIN101315UV02 update(PRPAIN101314UV02 parameters);

    PRPAIN101306UV02 findLike(PRPAIN101305UV02 parameters);

    String login(String oid, String password);

    boolean logout(String token);

    List<PersonalInfo> getPersons(String senderOid);

    PersonalInfo getPerson(String publicKey, String senderOid);

    PersonalInfo update(PersonalInfo personalInfo, String type);

    List<PersonalInfo> find(FindQuery findQuery, String senderOid);
}
