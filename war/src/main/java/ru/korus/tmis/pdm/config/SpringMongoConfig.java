package ru.korus.tmis.pdm.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories
public class SpringMongoConfig extends AbstractMongoConfiguration {

    @Override
    public String getDatabaseName() {
        return "dbPdm";
    }

    @Override
    @Bean
    public Mongo mongo() throws Exception {
        return new MongoClient("127.0.0.1");
    }

    @Override
    protected String getMappingBasePackage() {
        return "ru.korus.tmis.pdm.service.impl.mongo";
    }
}