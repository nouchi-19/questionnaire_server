package jp.ac.dendai.sie.usd.infrastructure.db.mongo.dao;

import com.mongodb.MongoClient;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity.MongoSubject;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

public class SubjectDao extends BasicDAO<MongoSubject, Long> {
    public SubjectDao(Class<MongoSubject> entityClass, Datastore ds) {
        super(entityClass, ds);
    }
}
