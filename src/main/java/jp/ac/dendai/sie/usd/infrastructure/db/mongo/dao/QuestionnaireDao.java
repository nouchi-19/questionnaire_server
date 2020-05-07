package jp.ac.dendai.sie.usd.infrastructure.db.mongo.dao;

import com.mongodb.MongoClient;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity.MongoQuestionnaire;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

public class QuestionnaireDao extends BasicDAO<MongoQuestionnaire, Long> {
    public QuestionnaireDao(Class<MongoQuestionnaire> entityClass, Datastore ds) {
        super(entityClass, ds);
    }
}
