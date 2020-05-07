package jp.ac.dendai.sie.usd.infrastructure.db.mongo.dao;

import com.mongodb.MongoClient;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity.MongoQuestion;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

public class QuestionDao extends BasicDAO<MongoQuestion, Long> {
    public QuestionDao(Class<MongoQuestion> entityClass, Datastore ds) {
        super(entityClass, ds);
    }
}
