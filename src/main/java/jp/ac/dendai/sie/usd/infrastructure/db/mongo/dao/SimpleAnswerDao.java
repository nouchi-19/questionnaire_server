package jp.ac.dendai.sie.usd.infrastructure.db.mongo.dao;

import jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity.MongoSimpleAnswer;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity.MongoSimpleQuestion;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

public class SimpleAnswerDao extends BasicDAO<MongoSimpleAnswer, Long> {
    public SimpleAnswerDao(Class<MongoSimpleAnswer> entityClass, Datastore ds) {
        super(entityClass, ds);
    }
}
