package jp.ac.dendai.sie.usd.infrastructure.db.mongo.config;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public class MongoDBHelper {
    private static MongoDBHelper mongoDBHelper = new MongoDBHelper();
    private MongoDatabase mongoDatabase;
    private Datastore datastore;

//    private final String host = "take-mongo";
//    private final int port = 27017;

//    private final String host = "mongo";
//    private final int port = 27017;

//    private final String host = "localhost";
    private final String host = "mongodb";
    private final int port = 27017;


    private final String databaseName = "questionnaire_server";

    private MongoDBHelper() {
        MongoClient mongoClient = new MongoClient(host,port);
        this.mongoDatabase = mongoClient.getDatabase(databaseName);

        Morphia morphia = new Morphia();

        this.datastore = morphia.createDatastore(mongoClient, databaseName);
    }


    public static MongoDatabase getMongoDatabase() {
        return mongoDBHelper.mongoDatabase;
    }

    public static Datastore getDatastore() {
        return mongoDBHelper.datastore;
    }
}
