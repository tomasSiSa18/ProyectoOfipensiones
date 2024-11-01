package com.chipichipi.ProyectoOfipensiones.mongoconfig;

import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoConfiguration {

    @Primary
    @Bean(name = "principalDBProperties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.principal")
    public MongoProperties getPrincipalProps() throws Exception {
        return new MongoProperties();
    }

    @Bean(name = "secundariaDBProperties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.secundaria")
    public MongoProperties getSecundariaProps() throws Exception {
        return new MongoProperties();
    }

    @Primary
    @Bean(name = "principalMongoTemplate")
    public MongoTemplate principalMongoTemplate() throws Exception {
        return new MongoTemplate(principalMongoDatabaseFactory(getPrincipalProps()));
    }

    @Bean(name ="secundariaMongoTemplate")
    public MongoTemplate secundariaMongoTemplate() throws Exception {
        return new MongoTemplate(secundariaMongoDatabaseFactory(getSecundariaProps()));
    }

    @Primary
    @Bean
    public MongoDatabaseFactory principalMongoDatabaseFactory(MongoProperties mongo) throws Exception {
        return new SimpleMongoClientDatabaseFactory(
                mongo.getUri()
        );
    }

    @Bean
    public MongoDatabaseFactory secundariaMongoDatabaseFactory(MongoProperties mongo) throws Exception {
        return new SimpleMongoClientDatabaseFactory(
                mongo.getUri()
        );
    }
}

