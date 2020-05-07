package jp.ac.dendai.sie.usd.infrastructure.db.mongo.dao;

import com.mongodb.MongoClient;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity.MongoRegistration;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

public class RegistrationDao extends BasicDAO<MongoRegistration, ObjectId> {
    public RegistrationDao(Class<MongoRegistration> entityClass, Datastore ds) {
        super(entityClass, ds);
    }
}
