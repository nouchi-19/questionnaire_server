package jp.ac.dendai.sie.usd.mytest;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

public class PersonDAO extends BasicDAO<Person, ObjectId> {
    public PersonDAO(Class<Person> entityClass, Datastore ds) {
        super(entityClass, ds);
    }


//    public PersonDAO(Class<Person> entityClass, MongoClient mongoClient, Morphia morphia, String dbName) {
//        super(entityClass, mongoClient, morphia, dbName);
//    }
}
