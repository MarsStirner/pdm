package ru.korus.tmis.pdm.service;

import ru.korus.tmis.pdm.entities.pdm.*;
import ru.korus.tmis.pdm.entities.pdmfiles.PdmFiles;
import ru.korus.tmis.pdm.model.AddrInfo;
import ru.korus.tmis.pdm.model.DocsInfo;
import ru.korus.tmis.pdm.model.api.PersonalInfo;
import ru.korus.tmis.pdm.model.api.ValueInfo;

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

    ValueInfo createFileInfo(PdmFiles file, String senderId);

    DocsInfo createDocsInfo(Document doc, String senderOid);

    ValueInfo createValueInfo(Attr attr);

    ValueInfo createValueInfo(Telecom telecom, String senderId);

    AddrInfo createAddrInfo(Addr addr, String senderOid);

    Document createDocument(DocsInfo docsInfo);

    PdmFiles createFile(byte[] keyFile, ValueInfo fileInfo) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException;

    Attr createAttr(ValueInfo attr);

    Telecom createTelecom(ValueInfo telecomInfo);

    Term createGender(ValueInfo gender);

    Birth createBirth(PersonalInfo personalInfo);

    Addr createAddr(AddrInfo addrInfo);

    List<PersonalInfo> createPersonalInfoShort(Iterable<Person> persons, String senderOid);
}
