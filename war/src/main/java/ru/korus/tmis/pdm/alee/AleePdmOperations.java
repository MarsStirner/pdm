package ru.korus.tmis.pdm.alee;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import ru.korus.tmis.pdm.PdmSysProperties;
import ru.korus.tmis.pdm.PersonalData;
import ru.korus.tmis.pdm.StorageOperations;
import ru.korus.tmis.pdm.utilities.Xml;
import ru.korus.tmis.pdm.ws.PDManager;
import ru.korus.tmis.pdm.ws.PostalAddressUse;
import ru.korus.tmis.pdm.ws.TelecommunicationAddressUse;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.net.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;


/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        15.10.13, 14:08 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class AleePdmOperations implements StorageOperations {

    private static final Logger logger = LoggerFactory.getLogger(AleePdmOperations.class);

    private static final String BASE_URL;

    private static final String TMIS_SID = "1";
    private static final String REQ_CREATE_OBJECT = "/create/object";
    private static final String REQ_UPDATE_OBJECT = "/update/object";
    private static final String REQ_SEARCH_SELECTED = "/search/selected";
    private static final String REQ_OBTAIN = "/obtain";
    private static final String ROOT_EL = "root";
    private static final String XPATH_CARD = "/" + ROOT_EL + "/card";
    private static final String XPATH_CARDS = "/" + ROOT_EL + "/cards";
    private static final String ALEE_COMPARE_TYPE_EQ = "eq";
    private static final String ALEE_COMPARE_TYPE_LIKE = "lk";

    private static AttrConfig config = null;

    static {
        BASE_URL = PdmSysProperties.getAleeUrl();
    }


    public AleePdmOperations() {
        loadPrms();
    }

    @Override
    public void save(PersonalData personalData) {
        try {
            final String req = personalData.getId() == null ? REQ_CREATE_OBJECT : REQ_UPDATE_OBJECT;
            URIBuilder uriBuilder = createBaseUrl(new URIBuilder(), req);
            uriBuilder = toParamList(uriBuilder, personalData, null);
            final URI uri = uriBuilder.build();
            logger.info("Create/Update person request: {}", uri);
            String res = getResponse(uri);
            if (personalData.getId() == null) {
                personalData.setId(getId(res));
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public PersonalData findById(String id) {
        try {
            URIBuilder uriBuilder = createBaseUrl(new URIBuilder(), REQ_OBTAIN)
                    .addParameter("attributes", "true")
                    .addParameter("id", id);
            final URI uri = uriBuilder.build();
            logger.info("Find person by id request: " + uri);
            String res = getXmlResponse(uri);
            return createPersonalData(Xml.loadString(res), null);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    private String getXmlResponse(URI uri) throws IOException {
        return String.format("<?xml version='1.0' encoding='UTF-8'?><%s>%s</%s>", ROOT_EL, getResponse(uri), ROOT_EL);
    }

    @Override
    public void find(Map.Entry<String, String> doc) {
        //TODO Does it need to add a check that the document is already registered? (see MongoPdmOperations.find(Map.Entry<String, String> doc))
    }

    @Override
    public List<PersonalData> find(PersonalData person) {
        try {
            return findPersonalDatas(person, ALEE_COMPARE_TYPE_EQ);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    private List<PersonalData> findPersonalDatas(PersonalData person, String compareType) throws URISyntaxException, IOException {
        URIBuilder uriBuilder = createBaseUrl(new URIBuilder(), REQ_SEARCH_SELECTED)
                .addParameter("attributes", "true");
        uriBuilder = toParamList(uriBuilder, person, compareType);
        final URI uri = uriBuilder.build();
        logger.info("Find person by personal information: " + uri);
        String res = getXmlResponse(uri);
        return createPersonalDataList(Xml.loadString(res));
    }

    @Override
    public List<PersonalData> findPersonLike(PersonalData person) {
        List<PersonalData> personList = addAttrs(person);

        for (Map.Entry<String, String> doc : person.getDocs().entrySet()) {
            PersonalData personData = new PersonalData();
            personData.getDocs().put(doc.getKey(), doc.getValue());
            personList.add(personData);
        }

        for (PersonalData.Addr addr : person.getAddress()) {
            PersonalData personData = new PersonalData();
            personData.getAddress().add(addr);
            personList.add(personData);
        }

        for(PersonalData.Telecom tel :person.getTelecoms() ) {
            PersonalData personalData = new PersonalData();
            personalData.getTelecoms().add(tel);
            personList.add(personalData);
        }

        List<PersonalData> res = new LinkedList<PersonalData>();
        for (PersonalData curPerson : personList) {
            try {
                res.addAll(findPersonalDatas(curPerson, ALEE_COMPARE_TYPE_LIKE));
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return res;

    }

    private List<PersonalData> addAttrs(PersonalData person) {
        List<PersonalData> personList = new LinkedList<PersonalData>();
        if (person.getGiven() != null) {
            personList.add((new PersonalData()).setGiven(person.getGiven()));
        }
        if (person.getMiddleName() != null) {
            personList.add((new PersonalData()).setMiddleName(person.getMiddleName()));
        }
        if (person.getFamily() != null) {
            personList.add((new PersonalData()).setFamily(person.getFamily()));
        }
        if (person.getGender() != null) {
            personList.add((new PersonalData()).setGender(person.getGender()));
        }
        if (person.getBirthData() != null) {
            personList.add((new PersonalData()).setBirthData(person.getBirthData()));
        }
        if (person.getBirthPlace() != null) {
            personList.add((new PersonalData()).setBirthPlace(person.getBirthPlace()));
        }

        String email = getEmail(person.getTelecoms());
        if (email != null) {
            final PersonalData personalData = new PersonalData();
            personalData.getTelecoms().addAll(person.getTelecoms());
            personList.add(personalData);
        }
        return personList;
    }


    public static String getResponse(URI uri) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(uri);
        httpget.setHeader("Content-Type", "text/plain");
        CloseableHttpResponse response = httpclient.execute(httpget);
        try {
            int responseCode = response.getStatusLine().getStatusCode();
            String res = getResponseData(response);
            if (responseCode != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Bad http status code: " + responseCode + "; http response: " + res);
            }
            return res;

        } finally {
            response.close();
        }
    }

    private URIBuilder createBaseUrl(URIBuilder uriBuilder, String reqType) {
        return uriBuilder.setScheme("http").setHost(BASE_URL).setPath("/api/v1" + reqType).setParameter("sid", TMIS_SID);
    }

    private String getId(String res) {
        final String begStr = "<id>";
        final String endStr = "</id>";
        final String resTrim = res.trim();
        if (resTrim.startsWith(begStr) && resTrim.endsWith(endStr)) {
            return resTrim.substring(begStr.length(), resTrim.length() - endStr.length());
        }
        throw new RuntimeException("Cannot create new person. Wrong response format: " + res);
    }

    private List<PersonalData> createPersonalDataList(Document document) {
        List<PersonalData> res = new LinkedList<PersonalData>();
        Element cards = (Element) document.getDocumentElement().getFirstChild();
        final NodeList cardList = cards.getElementsByTagName("card");
        for (Integer i = 0; i < cardList.getLength(); ++i) {
            Element card = (Element) cardList.item(i);
            final NodeList idList = card.getElementsByTagName("id");
            if (idList.getLength() > 0) {
                res.add(createPersonalData(document, idList.item(0).getTextContent()));
            }

        }
        return res;
    }

    private PersonalData createPersonalData(final Document aleeDoc, String id) {
        PersonalData res = new PersonalData();
        final String idFormResponse = Xml.getElementValue(aleeDoc, XPATH_CARD + "/id");
        res.setId(idFormResponse == null ? id : idFormResponse);
        initAttrs(aleeDoc, res, id);
        initDocs(aleeDoc, res, id);
        initAddrs(aleeDoc, res, id);
        initTelecoms(aleeDoc, res, id);
        return res;
    }

    private void initTelecoms(Document aleeDoc, PersonalData res, String id) {
        for (Map.Entry<TelecommunicationAddressUse, String> telCode : config.getTelecomMap().entrySet()) {
            String value = Xml.getElementValue(aleeDoc, getXpathForPrm(telCode.getValue(), id));
            if (value != null) {
                PersonalData.Telecom tel = new PersonalData.Telecom();
                tel.setValue(value);
                tel.setUse(telCode.getKey().name());
                res.getTelecoms().add(tel);
            }
        }
    }

    private void initAddrs(Document aleeDoc, PersonalData res, String id) {
        for (Map.Entry<PostalAddressUse, String> addrCode : config.getAddrMap().entrySet()) {
            String value = Xml.getElementValue(aleeDoc, getXpathForPrm(addrCode.getValue(), id));
            if (value != null) {
                res.getAddress().add(PersonalData.Addr.fromJson(value));
                res.getAddress().lastElement().setUse(addrCode.getKey().name());
            }
        }
    }

    private void initDocs(Document aleeDoc, PersonalData res, String id) {
        for (Map.Entry<String, AleeCode> docCode : config.getDocsMap().entrySet()) {
            String value = Xml.getElementValue(aleeDoc, getXpathForPrm(docCode.getValue().getCode(), id));
            if (value != null) {
                res.getDocs().put(PersonalData.codeOID(docCode.getKey()), value);
            }
        }
    }

    private void initAttrs(Document aleeDoc, final PersonalData res, String id) {
        res.setGiven(Xml.getElementValue(aleeDoc, getXpathForPrm(config.getGivenCode(), id)));
        res.setMiddleName(Xml.getElementValue(aleeDoc, getXpathForPrm(config.getMiddleNameCode(), id)));
        res.setFamily(Xml.getElementValue(aleeDoc, getXpathForPrm(config.getFamilyCode(), id)));
        String genderCode = Xml.getElementValue(aleeDoc, getXpathForPrm(config.getGenderCode(), id));
        if (genderCode != null) {
            res.setGender(PersonalData.Term.newInstance(genderCode, PersonalData.OID_DEFAULT_GENDER_CODE_SYSTEM));
        }
        res.setBirthData(Xml.getElementValue(aleeDoc, getXpathForPrm(config.getBirthDataCode(), id)));
        final String addrJson = Xml.getElementValue(aleeDoc, getXpathForPrm(config.getBirthPlaceCode(), id));
        if (addrJson != null) {
            res.setBirthPlace(PersonalData.Addr.fromJson(addrJson));
        }

        String email = Xml.getElementValue(aleeDoc, getXpathForPrm(config.getEmailCode(), id));
        if (email != null) {
            PersonalData.Telecom telecomEmail = new PersonalData.Telecom();
            telecomEmail.setValue("mailto:" + email);
            res.getTelecoms().add(telecomEmail);
        }
    }

    private String getXpathForPrm(String code, String id) {
        final String pathToValue = "/attributes/attribute/type[text()='%s']/parent::node()/value";
        if (id == null) {
            final String xpathAttrTpl = XPATH_CARD + pathToValue;
            return String.format(xpathAttrTpl, code);
        }
        final String xpathAttrTpl = XPATH_CARDS + "/card/id[text()='%s']/parent::node()" + pathToValue;
        return String.format(xpathAttrTpl, id, code);
    }


    private static String getResponseData(CloseableHttpResponse response) throws IOException {
        logger.info("Output from Server ...");
        final String res = EntityUtils.toString(response.getEntity(), "UTF-8");
        logger.info(res);
        return res;
    }


    private static void loadPrms() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(AttrConfig.class);
            try {
                config = (AttrConfig) jaxbContext.createUnmarshaller().unmarshal(new File(PdmSysProperties.getConfigFileName()));
            } catch (JAXBException e) { //если файла настройки нет, то используем параметры по-умолчанию
                config = new AttrConfig();
            }
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(config, System.out);
        } catch (JAXBException e) { //если файла настройки нет, то используем параметры по-умолчанию
            config = new AttrConfig();
        }
    }

    private URIBuilder toParamList(URIBuilder uriBuilder, PersonalData personalData, String compareType) {
        addAttrs(uriBuilder, personalData, compareType);
        addDocs(uriBuilder, personalData, compareType);
        addAddrs(uriBuilder, personalData, compareType);
        addTelecoms(uriBuilder, personalData, compareType);
        return uriBuilder;
    }

    private void addTelecoms(URIBuilder uriBuilder, PersonalData personalData, String compareType) {
        for (PersonalData.Telecom tel : personalData.getTelecoms()) {
            if (tel.getValue().startsWith("tel:")) {
                String code = config.getTelecomMap().get(TelecommunicationAddressUse.valueOf(tel.getUse()));
                if (code == null) {
                    throw new RuntimeException("The Alee code not found for telecom type: " + tel.getUse());
                }
                final String telNumber = tel.getValue().substring("tel:".length());
                addPrm(uriBuilder, code, telNumber, compareType);
            }
        }
    }


    private void addAddrs(URIBuilder uriBuilder, PersonalData personalData, String compareType) {
        for (PersonalData.Addr addr : personalData.getAddress()) {
            if (addr.getUse() == null) {
                throw new RuntimeException("The address type is null! address: " + addr.toJson());
            }
            String code = config.getAddrMap().get(PostalAddressUse.valueOf(addr.getUse()));
            if (code == null) {
                throw new RuntimeException("The Alee code not found for address type: " + addr.getUse());
            }
            addPrm(uriBuilder, code, addr.toJson(), compareType);
        }
    }

    private void addDocs(URIBuilder res, PersonalData personalData, String compareType) {
        for (Map.Entry<String, String> doc : personalData.getDocs().entrySet()) {
            final AleeCode code = config.getDocsMap().get(PersonalData.decodeOID(doc.getKey()));
            if (code == null) {
                throw new RuntimeException("The Alee code not found for document OID: " + doc.getKey());
            }
            String compare = ALEE_COMPARE_TYPE_EQ; // метод сравнения для не строковых атрибутов - "eq"
            if(compareType == null) { // если метод сравнение не используетися
                compare = null;
            } else if (!code.getType().equals(AttrConfig.ALEE_TYPE_STRING)) { // для строковых атрибута используем переданный метод сравнения
                compare = compareType;
            }
            addPrm(res, code.getCode(), doc.getValue(), compare);
        }
    }

    private void addAttrs(URIBuilder uriBuilder, PersonalData personalData, String compareType) {
        addPrm(uriBuilder, "id", personalData.getId(), compareType);
        addPrm(uriBuilder, config.getGivenCode(), personalData.getGiven(), compareType);
        addPrm(uriBuilder, config.getMiddleNameCode(), personalData.getMiddleName(), compareType);
        addPrm(uriBuilder, config.getFamilyCode(), personalData.getFamily(), compareType);
        final PersonalData.Term gender = personalData.getGender();
        if (gender != null) {
            addPrm(uriBuilder, config.getGenderCode(), gender.getCode(), compareType);
        }
        addPrm(uriBuilder, config.getBirthDataCode(), personalData.getBirthData(), compareType == null ? null : ALEE_COMPARE_TYPE_EQ);
        final PersonalData.Addr birthPlace = personalData.getBirthPlace();
        if (birthPlace != null) {
            addPrm(uriBuilder, config.getBirthPlaceCode(), birthPlace.toJson(), compareType);
        }
        addPrm(uriBuilder, config.getEmailCode(), getEmail(personalData.getTelecoms()), compareType);
    }

    private String getEmail(Vector<PersonalData.Telecom> telecoms) {
        for (PersonalData.Telecom tel : telecoms) {
            try {
                String res = emailToString(tel);
                if (res != null) {
                    return res;
                }
            } catch (MalformedURLException e) {

            }
        }
        return null;
    }

    public static String emailToString(PersonalData.Telecom tel) throws MalformedURLException {
        String res = null;
        URL uri = new URL(tel.getValue());
        if (uri.getProtocol().equals("mailto")) {
            res = uri.getPath();
        }
        return res;
    }

    private void addPrm(URIBuilder uriBuilder, String param, String value, String compareType) {
        if (value != null && param != null) {
            uriBuilder.setParameter(param, compareType == null ? value : String.format("%s[%s]", compareType, value));
        }
    }

    public static AttrConfig getConfig() {
        if (config == null) {
            loadPrms();
        }
        return config;
    }
}
