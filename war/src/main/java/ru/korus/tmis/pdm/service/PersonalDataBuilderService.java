package ru.korus.tmis.pdm.service;

import ru.korus.tmis.pdm.entities.*;
import ru.korus.tmis.pdm.model.AddrInfo;
import ru.korus.tmis.pdm.model.DocsInfo;
import ru.korus.tmis.pdm.model.api.PersonalInfo;
import ru.korus.tmis.pdm.model.ValueInfo;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        05.11.2014, 18:22 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public interface PersonalDataBuilderService {

    Person createPersonalData(PersonalInfo personalInfo) throws InvalidKeySpecException, NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException;

    PersonalInfo createPersonalInfo(Person personalData, String senderId) throws InvalidKeySpecException, NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException;

    DocsInfo createDocsInfo(Document doc);

    ValueInfo createValueInfo(Attr attr);

    ValueInfo createValueInfo(Telecom telecom);

    AddrInfo createAddrInfo(Addr addr);

    Document createDocument(DocsInfo docsInfo);

    Attr createAttr(ValueInfo attr);

    Telecom createTelecom(ValueInfo telecomInfo);

    Term createGender(ValueInfo gender);

    Birth createBirthInfo(PersonalInfo personalInfo);

    Addr createAddr(AddrInfo addrInfo);

    List<PersonalInfo> createPersonalInfoShort(Iterable<Person> persons, String senderOid);
}
