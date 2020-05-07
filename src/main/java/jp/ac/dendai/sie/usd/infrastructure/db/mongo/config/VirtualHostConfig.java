package jp.ac.dendai.sie.usd.infrastructure.db.mongo.config;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Morphia;

public class VirtualHostConfig implements MongoConfig{
//    private final String host = "take.miyakawalab.ml";
    private final String host = "take-mongo";
//    private final int port = 27013;
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
