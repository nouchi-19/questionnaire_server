package jp.ac.dendai.sie.usd.infrastructure.db.mongo.dao;

import jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity.MongoSimpleQuestion;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

public class SimpleQuestionDao extends BasicDAO<MongoSimpleQuestion, Long> {
    public SimpleQuestionDao(Class<MongoSimpleQuestion> entityClass, Datastore ds) {
        super(entityClass, ds);
    }
}
