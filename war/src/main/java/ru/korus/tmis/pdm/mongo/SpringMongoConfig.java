package ru.korus.tmis.pdm.mongo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
 
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
 
@Configuration
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
}