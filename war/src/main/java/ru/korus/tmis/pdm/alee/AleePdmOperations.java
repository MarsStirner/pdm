package ru.korus.tmis.pdm.alee;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import ru.korus.tmis.pdm.PersonalData;
import ru.korus.tmis.pdm.StorageOperations;
import ru.korus.tmis.pdm.utilities.Xml;
import ru.korus.tmis.pdm.ws.PostalAddressUse;
import ru.korus.tmis.pdm.ws.TelecommunicationAddressUse;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.net.*;
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

    private static final String BASE_URL = "10.129.188.20";

    private static final String TMIS_SID = "1";
    private static final String REQ_CREATE_OBJECT = "/create/object";
    private static final String REQ_UPDATE_OBJECT = "/update/object";
    private static final String REQ_SEARCH_SELECTED = "/search/selected";
    private static final String REQ_OBTAIN = "/obtain";
    private static final String ROOT_EL = "root";
    private static final String XPATH_CARD = "/" + ROOT_EL + "/card/";

    private AttrMap config = null;

    public AleePdmOperations() {
        loadPrms();
    }

    @Override
    public void save(PersonalData personalData) {
        try {
            final String req = personalData.getId() == null ? REQ_CREATE_OBJECT : REQ_UPDATE_OBJECT;
            URIBuilder uriBuilder = createBaseUrl(new URIBuilder(), req);
            uriBuilder = toCreateParamList(uriBuilder, personalData, null);
            final URI uri = uriBuilder.build();
            final String path =  uri.getPath();
            final String query = uri.getQuery();
            System.out.println("Create/Update person request: " + uri);
            String res = getResponse(uri);
            if(personalData.getId() == null) {
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
            System.out.println("Find person by id request: " + uri);
            String res = getXmlResponse(uri);
            return createPersonalData(Xml.loadString(res));
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
            URIBuilder uriBuilder = createBaseUrl(new URIBuilder(), REQ_OBTAIN)
                    .addParameter("attributes", "true");
            final URI uri = uriBuilder.build();
            uriBuilder = toCreateParamList(uriBuilder, person, "eq");
            System.out.println("Find person by personal information: " + uri);
            String res = getXmlResponse(uri);
            return createPersonalDataList(Xml.loadString(res));
        } catch (URISyntaxException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }


    private String getResponse(URI uri) throws IOException {
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

    private URIBuilder  createBaseUrl(URIBuilder uriBuilder, String reqType) {
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
        //TODO ....
        return null;
    }

    private PersonalData createPersonalData(final Document aleeDoc) {
        PersonalData res = new PersonalData();
        res.setId(Xml.getElementValue(aleeDoc, XPATH_CARD + "id"));
        initAttrs(aleeDoc, res);
        initDocs(aleeDoc, res);
        initAddrs(aleeDoc, res);
        initTelecoms(aleeDoc, res);
        return res;
    }

    private void initTelecoms(Document aleeDoc, PersonalData res) {
        for (Map.Entry<TelecommunicationAddressUse, String> telCode : config.getTelecomMap().entrySet()) {
            String value = Xml.getElementValue(aleeDoc, getXpathForPrm(telCode.getValue()));
            if (value != null) {
                PersonalData.Telecom tel = new PersonalData.Telecom();
                tel.setValue(value);
                tel.setUse(telCode.getKey().name());
                res.getTelecoms().add(tel);
            }
        }
    }

    private void initAddrs(Document aleeDoc, PersonalData res) {
        for (Map.Entry<PostalAddressUse, String> addrCode : config.getAddrMap().entrySet()) {
            String value = Xml.getElementValue(aleeDoc, getXpathForPrm(addrCode.getValue()));
            if (value != null) {
                res.getAddress().add(PersonalData.Addr.fromJson(value));
                res.getAddress().lastElement().setUse(addrCode.getKey().name());
            }
        }
    }

    private void initDocs(Document aleeDoc, PersonalData res) {
        for (Map.Entry<String, String> docCode : config.getDocsMap().entrySet()) {
            String value = Xml.getElementValue(aleeDoc, getXpathForPrm(docCode.getValue()));
            if (value != null) {
                res.getDocs().put(PersonalData.codeOID(docCode.getKey()), value);
            }
        }
    }

    private void initAttrs(Document aleeDoc, final PersonalData res) {
        res.setGiven(Xml.getElementValue(aleeDoc, getXpathForPrm(config.getGivenCode())));
        res.setMiddleName(Xml.getElementValue(aleeDoc, getXpathForPrm(config.getMiddleNameCode())));
        res.setFamily(Xml.getElementValue(aleeDoc, getXpathForPrm(config.getFamilyCode())));
        String genderCode = Xml.getElementValue(aleeDoc, getXpathForPrm(config.getGenderCode()));
        if (genderCode != null) {
            res.setGender(PersonalData.Term.newInstance(genderCode, PersonalData.OID_DEFAULT_GENDER_CODE_SYSTEM));
        }
        res.setBirthData(Xml.getElementValue(aleeDoc, getXpathForPrm(config.getBirthDataCode())));
        final String addrJson = Xml.getElementValue(aleeDoc, getXpathForPrm(config.getBirthPlaceCode()));
        if (addrJson != null) {
            res.setBirthPlace(PersonalData.Addr.fromJson(addrJson));
        }

        String email = Xml.getElementValue(aleeDoc, getXpathForPrm(config.getEmailCode()));
        if (email != null) {
            PersonalData.Telecom telecomEmail = new PersonalData.Telecom();
            telecomEmail.setValue("mailto:" + email);
            res.getTelecoms().add(telecomEmail);
        }
    }

    private String getXpathForPrm(String code) {
        final String xpathAttrTpl = XPATH_CARD + "attributes/attribute/type[text()='%s']/parent::node()/value";
        return String.format(xpathAttrTpl, code);
    }


    private String getResponseData(CloseableHttpResponse response) throws IOException {
        System.out.println("Output from Server ...");
        final String res = EntityUtils.toString(response.getEntity());
        System.out.println(res);
        return res;
    }


    private void loadPrms() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(AttrMap.class);
            try {
                config = (AttrMap) jaxbContext.createUnmarshaller().unmarshal(new File(System.getProperty("pdm.ConfigFile", "pdm_config.xml")));
            } catch (JAXBException e) { //если файла настройки нет, то используем параметры по-умолчанию
                config = new AttrMap();
            }
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(config, System.out);
        } catch (JAXBException e) { //если файла настройки нет, то используем параметры по-умолчанию
            config = new AttrMap();
        }
    }

    private URIBuilder toCreateParamList(URIBuilder uriBuilder, PersonalData personalData, String compareType) {
        addAttrs(uriBuilder, personalData, compareType);
        addDocs(uriBuilder, personalData, compareType);
        addAddrs(uriBuilder, personalData, compareType);
        addTelecoms(uriBuilder, personalData, compareType);
        return uriBuilder;
    }

    private void addTelecoms(URIBuilder uriBuilder, PersonalData personalData, String compareType) {
        for (PersonalData.Telecom tel : personalData.getTelecoms()) {
            try {
                URL uri = new URL(tel.getValue());
                if (uri.getProtocol().equals("tel")) {
                    String code = config.getTelecomMap().get(TelecommunicationAddressUse.valueOf(tel.getUse()));
                    if (code == null) {
                        throw new RuntimeException("The Alee code not found for telecom type: " + tel.getUse());
                    }
                    addPrm(uriBuilder, code, uri.getPath(), compareType);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
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
            final String code = config.getDocsMap().get(PersonalData.decodeOID(doc.getKey()));
            if (code == null) {
                throw new RuntimeException("The Alee code not found for document OID: " + doc.getKey());
            }
            addPrm(res, code, doc.getValue(), compareType);
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
        addPrm(uriBuilder, config.getBirthDataCode(), personalData.getBirthData(), compareType);
        final PersonalData.Addr birthPlace = personalData.getBirthPlace();
        if (birthPlace != null) {
            addPrm(uriBuilder, config.getBirthPlaceCode(), birthPlace.toJson(), compareType);
        }
        addPrm(uriBuilder, config.getEmailCode(), getEmail(personalData.getTelecoms()), compareType);
    }

    private String getEmail(Vector<PersonalData.Telecom> telecoms) {
        for (PersonalData.Telecom tel : telecoms) {
            try {
                URL uri = new URL(tel.getValue());
                if (uri.getProtocol().equals("mailto")) {
                    return uri.getPath();
                }
            } catch (MalformedURLException e) {

            }
        }
        return null;
    }

    private void addPrm(URIBuilder uriBuilder, String param, String value, String compareType) {
        if (value != null && param != null) {
            uriBuilder.setParameter(param, compareType == null ? value : String.format("%s[%s]", compareType, value));
        }
    }

}
