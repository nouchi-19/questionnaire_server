package jp.ac.dendai.sie.usd.infrastructure.db.mongo.dao;

import com.mongodb.MongoClient;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity.MongoResult;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

public class ResultDao extends BasicDAO<MongoResult, Long> {
    public ResultDao(Class<MongoResult> entityClass, Datastore ds) {
        super(entityClass, ds);
    }
}
