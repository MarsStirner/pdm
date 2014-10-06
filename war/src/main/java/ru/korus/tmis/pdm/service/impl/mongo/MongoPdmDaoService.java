package ru.korus.tmis.pdm.service.impl.mongo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.stereotype.Service;
import ru.korus.tmis.pdm.config.SpringMongoConfig;
import ru.korus.tmis.pdm.service.PdmDaoService;
import ru.korus.tmis.pdm.ws.PersonalData;

import java.util.List;
import java.util.Map;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        15.10.13, 14:01 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
@Service
public class MongoPdmDaoService implements PdmDaoService {

    static private ApplicationContext ctx = null;
    static private MongoOperations mongoOperation = null;

    public MongoPdmDaoService() {
        if(ctx == null || mongoOperation == null) {
            init();
        }
    }

    private void init() {
        ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
        mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
    }

    @Override
    public void save(PersonalData personalData) {
        mongoOperation.save(personalData);
    }

    @Override
    public boolean find(Map.Entry<String, String> doc) {
        BasicQuery query = new BasicQuery(String.format("{docs: { $elemMatch: {code:'%s' , codeSystem : '%s'}}}", doc.getValue(), doc.getKey()));
        if (!mongoOperation.find(query, PersonalData.class).isEmpty()){
            throw new RuntimeException("The person already added");
        }
        return true;
    }

    @Override
    public PersonalData findById(String id) {
        PersonalData person = mongoOperation.findById(id, PersonalData.class);
        if( person == null ) {
            throw new RuntimeException("The person with id'" + id + "' not found");
        }
        return person;
    }

    @Override
    public List<PersonalData> find(PersonalData person) {
        String query = "";
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
        return mongoOperation.find(basicQuery, PersonalData.class);
    }

    @Override
    public List<PersonalData> findPersonLike(PersonalData person) {
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