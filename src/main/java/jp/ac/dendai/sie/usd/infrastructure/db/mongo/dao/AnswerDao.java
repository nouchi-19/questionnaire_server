package jp.ac.dendai.sie.usd.infrastructure.db.mongo.dao;

import com.mongodb.MongoClient;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.config.MongoConfig;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity.MongoAnswer;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

public class AnswerDao extends BasicDAO<MongoAnswer, Long> {
    public AnswerDao(Class<MongoAnswer> entityClass, Datastore ds) {
        super(entityClass, ds);
    }
}