package com.viniciuschioratto.product.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.UuidRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Collection;
import java.util.Collections;

@Configuration
@EnableMongoRepositories(basePackages = "com.viniciuschioratto.product.repository")
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Value("${mongoDB.url}")
    private String url;

    @Value("${mongoDB.port}")
    private Integer port;

    @Value("${mongoDB.dataBase}")
    private String dataBase;

    @Value("${mongoDB.collection}")
    private String collection;

    @Override
    protected String getDatabaseName() {
        return dataBase;
    }

    @Override
    public MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString("mongodb://" + url + ":" + port + "/" + dataBase);
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .uuidRepresentation(UuidRepresentation.STANDARD)
                .build();
        return MongoClients.create(mongoClientSettings);
    }

    @Override
    public Collection getMappingBasePackages() {
        return Collections.singleton(collection);
    }

}
