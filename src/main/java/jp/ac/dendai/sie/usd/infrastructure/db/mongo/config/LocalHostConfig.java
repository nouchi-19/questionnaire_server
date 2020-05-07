package jp.ac.dendai.sie.usd.infrastructure.db.mongo.config;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Morphia;

public class LocalHostConfig implements MongoConfig{
    private final String host = "localhost";
    private final int port = 27017;

    private final String databaseName = "questionnaire_server";

    private final Morphia morphia = new Morphia();

    @Override
    public MongoClient getClient() {
        return new MongoClient(host, port);
    }

    @Override
    public String getDatabaseName() {
        return databaseName;
    }

    @Override
    public Morphia getMorphia() {
        return morphia;
    }
}
