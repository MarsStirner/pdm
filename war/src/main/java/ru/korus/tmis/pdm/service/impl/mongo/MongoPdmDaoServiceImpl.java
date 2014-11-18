package ru.korus.tmis.pdm.service.impl.mongo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;
import ru.korus.tmis.pdm.config.SpringMongoConfig;
import ru.korus.tmis.pdm.model.AddrInfo;
import ru.korus.tmis.pdm.model.DocsInfo;
import ru.korus.tmis.pdm.model.api.PersonalInfo;
import ru.korus.tmis.pdm.model.api.ValueInfo;
import ru.korus.tmis.pdm.service.PdmDaoService;

import java.util.List;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        15.10.13, 14:01 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
@Service
public class MongoPdmDaoServiceImpl implements PdmDaoService {

    static private ApplicationContext ctx = null;
    static private MongoOperations mongoOperation = null;

    public MongoPdmDaoServiceImpl() {
        if(ctx == null || mongoOperation == null) {
            init();
        }
    }

    private void init() {
        ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
        mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
    }

    @Override
    public List<Byte> save(PersonalInfo personalData) {
        //mongoOperation.save(personalData);
        //TODO implement!
        throw new RuntimeException("TODO!!");
    }

    @Override
    public boolean find(DocsInfo docsInfo) {
        //TODO implement!
        /*BasicQuery query = new BasicQuery(String.format("{docs: { $elemMatch: {code:'%s' , codeSystem : '%s'}}}", doc.getValue(), doc.getKey()));
        if (!mongoOperation.find(query, PersonalData.class).isEmpty()){
            throw new RuntimeException("The person already added");
        }*/
        throw new RuntimeException("TODO!!");
    }

    @Override
    public PersonalInfo findById(byte[] privateKey, String senderId) {
        throw new RuntimeException("TODO!!");
        /*PersonalData person = mongoOperation.findById(id, PersonalData.class);
        if( person == null ) {
            throw new RuntimeException("The person with id'" + id + "' not found");
        }
        return person;*/
    }

    @Override
    public List<PersonalInfo> find(PersonalInfo person, String senderId) {
      /*  String query = "";
        query += addFindPrm("given", person.getGiven());
        query += addFindPrm("middleName", person.getMiddleName());
        query += addFindPrm("family", person.getFamily());
        if(person.getGender() != null ) {
            //TODO add codeSystem check
            query +=  addFindPrm("gender.code", person.getGender().getCode());
        }
        query += addFindPrm("birthData", person.getBirthData());

        String docsQuery = "";
        for(Map.Entry<String, String> doc : person.getDocs().entrySet()) {
            docsQuery +=  addFindPrm("docs." + doc.getKey(), doc.getValue());
        }
        query = mongoOr(query, docsQuery);
        System.out.println("findPerson mogo query: " + query);
        BasicQuery basicQuery = new BasicQuery(query);
        return mongoOperation.find(basicQuery, PersonalData.class);*/
        throw new RuntimeException("TODO!!");
    }

    @Override
    public List<PersonalInfo> findPersonLike(PersonalInfo person, String senderId) {
       throw new RuntimeException("Not implemented");  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<PersonalInfo> getPersons(String senderOid) {
        throw new RuntimeException("TODO!!");
    }

    @Override
    public void updateNames(byte[] privateKey, PersonalInfo personalInfo) {
        throw new RuntimeException("TODO!!");
    }

    @Override
    public void updateGender(byte[] privateKey, PersonalInfo personalInfo) {
            throw new RuntimeException("TODO!!");
    }

    @Override
    public void updateBirth(byte[] privateKey, PersonalInfo personalInfo) {
        throw new RuntimeException("Not implemented");  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void updateTelecom(byte[] privateKeyTelecom, ValueInfo telecom) {
        throw new RuntimeException("Not implemented");  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void addTelecom(byte[] privateKey, ValueInfo telecom) {
        throw new RuntimeException("Not implemented");  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void updateAddr(byte[] privateKeyAddr, AddrInfo addrInfo) {
        throw new RuntimeException("Not implemented");  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void addAddr(byte[] privateKey, AddrInfo addrInfo) {
        throw new RuntimeException("Not implemented");  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void addDocs(byte[] privateKey, DocsInfo docsInfo) {
        throw new RuntimeException("Not implemented");  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void updateDoc(byte[] privateKeyDoc, DocsInfo docsInfo) {
        throw new RuntimeException("Not implemented");  //To change body of implemented methods use File | Settings | File Templates.
    }


    private String mongoOr(String... values) {
        String res = "{$or:[";
        boolean isAdded = false;
        for(String val : values) {
            if( val != null && !val.isEmpty()) {
                res += "{" + val + "},";
                isAdded = true;
            }
        }
        if (isAdded) {
            res = res.substring(0,res.length() - 1);
        }
        return res + "]}";
    }

    private String newLevel(String s) {
        if(s == null || "".equals(s)) {
            return "";
        }
        return String.format("{ %s }  ", s);
    }

    private String addFindPrm(String name, String value) {
        if(value == null || "".equals(value)) {
            return "";
        }
        return String.format("'%s': '%s', ", name, value);
    }

}
