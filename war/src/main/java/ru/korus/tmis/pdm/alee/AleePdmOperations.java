package ru.korus.tmis.pdm.alee;

import com.google.gson.Gson;
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
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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

    private static final String BASE_URL = "http://10.129.188.20";

    private static final String API_V1 = "/api/v1";
    private static final String BASE_URL_CREATE = API_V1 + "/create/object";
    private static final String TMIS_SID = "sid=1";
    private static final String START_PRM = "?";
    private static final String REQ_CREATE_OBJECT = "/create/object";
    private static final String REQ_OBTAIN = "/obtain";
    private static final String ROOT_EL = "root";
    private static final String XPATH_CARD = "/" + ROOT_EL + "/card/";
    private static final String XPATH_ATTR = XPATH_CARD + "/attrinutes/attribute/";

    private AttrMap config = null;

    public AleePdmOperations() {
        loadPrms();
    }

    @Override
    public void save(PersonalData personalData) {
        try {
            final String queryParamList = toCreateParamList(personalData);
            HttpURLConnection conn = (HttpURLConnection) (new URL(createBaseUrl(REQ_CREATE_OBJECT) + queryParamList)).openConnection();
            String res = getResponse(conn);
            personalData.setId(getId(res));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public PersonalData findById(String id) {
        try {
            String queryParamList = String.format("attributes=true&id=%s");
            HttpURLConnection conn = (HttpURLConnection) (new URL(createBaseUrl(REQ_OBTAIN) + queryParamList)).openConnection();
            String res = String.format("<?xml version='1.0' encoding='UTF-8'?><%s>%s</%s>", ROOT_EL, getResponse(conn), ROOT_EL);
            return createPersonalData(Xml.load(res));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void find(Map.Entry<String, String> doc) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<PersonalData> find(PersonalData person) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    private String getResponse(HttpURLConnection conn) throws IOException {
        conn.setDoOutput(true);
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "text/plain");
        int responseCode = conn.getResponseCode();
        String res = getResponseData(conn, conn.getResponseCode());
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new RuntimeException("Bad http status code: " + responseCode + "; http response: " + res);
        }
        return res;
    }

    private String createBaseUrl(String reqType) {
        return BASE_URL + API_V1 + reqType + START_PRM + TMIS_SID;
    }

    private String getId(String res) {
        final String begStr = "<id>";
        final String endStr = "</id>";
        final String resTrim = res.trim();
        if (resTrim.startsWith(begStr) && resTrim.endsWith(endStr)) {
            return resTrim.substring(begStr.length(), resTrim.length() - endStr.length());
        }
        throw new RuntimeException("Cannot create new object: " + res);
    }


    private PersonalData createPersonalData(final Document aleeDoc) {
        PersonalData res = new PersonalData();
        res.setId(Xml.getAttrValue(aleeDoc, XPATH_CARD + "id"));
        initAttrs(aleeDoc, res);
        initDocs(aleeDoc, res);
        initAddrs(aleeDoc, res);
        initTelecoms(aleeDoc, res);
        return res;
    }

    private void initTelecoms(Document aleeDoc, PersonalData res) {
        for (Map.Entry<TelecommunicationAddressUse, String> telCode : config.getTelecomMap().entrySet()) {
            String value = Xml.getAttrValue(aleeDoc, XPATH_ATTR + telCode.getValue());
            if(value != null) {
                PersonalData.Telecom tel = new PersonalData.Telecom();
                tel.setValue(value);
                tel.setUse(telCode.getKey().name());
                res.getTelecoms().add(tel);
            }
        }
    }

    private void initAddrs(Document aleeDoc, PersonalData res) {
        for (Map.Entry<PostalAddressUse, String> addrCode : config.getAddrMap().entrySet()) {
            String value = Xml.getAttrValue(aleeDoc, XPATH_ATTR + addrCode.getValue());
            if(value != null) {
                res.getAddress().add(PersonalData.Addr.fromJson(value));
                res.getAddress().lastElement().setUse(addrCode.getKey().name());
            }
        }
    }

    private void initDocs(Document aleeDoc, PersonalData res) {
        for (Map.Entry<String, String> docCode : config.getDocsMap().entrySet()) {
            String value = Xml.getAttrValue(aleeDoc, XPATH_ATTR + docCode.getValue());
            if(value != null) {
                res.getDocs().put(docCode.getKey(), value);
            }
        }
    }

    private void initAttrs(Document aleeDoc, final PersonalData res) {
        final String xpathBase = XPATH_ATTR;
        res.setGiven(Xml.getAttrValue(aleeDoc, XPATH_ATTR + config.getGivenCode()));
        res.setMiddleName(Xml.getAttrValue(aleeDoc, XPATH_ATTR + config.getMiddleNameCode()));
        res.setFamily(Xml.getAttrValue(aleeDoc, XPATH_ATTR + config.getFamilyCode()));
        String genderCode = Xml.getAttrValue(aleeDoc, XPATH_ATTR + config.getGenderCode());
        if(genderCode != null) {
            res.setGender(PersonalData.Term.newInstance(genderCode,PersonalData.OID_DEFAULT_GENDER_CODE_SYSTEM));
        }
        res.setBirthData(Xml.getAttrValue(aleeDoc, XPATH_ATTR + config.getBirthDataCode()));
        final String addrJson = Xml.getAttrValue(aleeDoc, XPATH_ATTR + config.getBirthPlaceCode());
        if(addrJson != null) {
            res.setBirthPlace(PersonalData.Addr.fromJson(addrJson));
        }

        String email = Xml.getAttrValue(aleeDoc, XPATH_ATTR + config.getEmailCode());
        if(email != null) {
            PersonalData.Telecom telecomEmail = new PersonalData.Telecom();
            telecomEmail.setValue("mailto:" + email);
            res.getTelecoms().add(telecomEmail);
        }
    }


    private String getResponseData(HttpURLConnection conn, int code) throws IOException {
        final InputStream inputStream = code == 200 ? conn.getInputStream() : conn.getErrorStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        String output;
        System.out.println("Output from Server .... \n");
        String res = "";
        while ((output = br.readLine()) != null) {
            System.out.println(output);
            res += output;
        }
        br.close();
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

    private String toCreateParamList(PersonalData personalData) {
        StringBuilder res = new StringBuilder();
        addAttrs(res, personalData);
        addDocs(res, personalData);
        addAddrs(res, personalData);
        addTelecoms(res, personalData);
        return res.toString();
    }

    private void addTelecoms(StringBuilder res, PersonalData personalData) {
        for (PersonalData.Telecom tel : personalData.getTelecoms()) {
            try {
                URL uri = new URL(tel.getValue());
                if (uri.getProtocol().equals("tel")) {
                    String code = config.getTelecomMap().get(TelecommunicationAddressUse.valueOf(tel.getUse()));
                    if (code == null) {
                        throw new RuntimeException("The Alee code not found for telecom type: " + tel.getUse());
                    }
                    addPrm(res, code, uri.getPath());
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }


    private void addAddrs(StringBuilder res, PersonalData personalData) {
        for (PersonalData.Addr addr : personalData.getAddress()) {
            String code = config.getAddrMap().get(PostalAddressUse.valueOf(addr.getUse()));
            if (code == null) {
                throw new RuntimeException("The Alee code not found for address type: " + addr.getUse());
            }
            addPrm(res, code, addr.toJson());
        }
    }

    private void addDocs(StringBuilder res, PersonalData personalData) {
        for (Map.Entry<String, String> doc : personalData.getDocs().entrySet()) {
            final String code = config.getDocsMap().get(PersonalData.decodeOID(doc.getKey()));
            if (code == null) {
                throw new RuntimeException("The Alee code not found for document OID: " + doc.getKey());
            }
            addPrm(res, code, doc.getValue());
        }
    }

    private void addAttrs(StringBuilder res, PersonalData personalData) {
        addPrm(res, config.getGivenCode(), personalData.getGiven());
        addPrm(res, config.getMiddleNameCode(), personalData.getMiddleName());
        addPrm(res, config.getFamilyCode(), personalData.getFamily());
        final PersonalData.Term gender = personalData.getGender();
        if (gender != null) {
            addPrm(res, config.getGenderCode(), gender.getCode());
        }
        addPrm(res, config.getBirthDataCode(), personalData.getBirthData());
        final PersonalData.Addr birthPlace = personalData.getBirthPlace();
        if (birthPlace != null) {
            addPrm(res, config.getBirthPlaceCode(), birthPlace.toJson());
        }
        addPrm(res, config.getEmailCode(), getEmail(personalData.getTelecoms()));
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

    private void addPrm(StringBuilder res, String code, String value) {
        if (value != null && code != null) {
            res.append(String.format("%s%s=%s", res.length() > 0 ? "&" : "", code, value));
        }
    }

}
