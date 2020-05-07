package jp.ac.dendai.sie.usd.infrastructure.db.mongo.config;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Morphia;

public interface MongoConfig {
    MongoClient getClient();
    String getDatabaseName();
    Morphia getMorphia();
}
