package jp.ac.dendai.sie.usd.infrastructure.db.mongo.dao;

import com.mongodb.MongoClient;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity.MongoManagementId;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;

public class IdStoreDao extends BasicDAO<MongoManagementId, ObjectId> {
    public IdStoreDao(Class<MongoManagementId> entityClass, Datastore ds) {
        super(entityClass, ds);
    }

    public Long create(String name) {
        Query<MongoManagementId> query = this.createQuery().filter("name", name);
        MongoManagementId mongoManagementId = this.find(query).get();
        Long id = mongoManagementId.getIdNumber();
        Long newId = mongoManagementId.getIdNumber() + 1;
        mongoManagementId.setIdNumber(newId);
//        System.out.println(id);
//        System.out.println(newId);
//        this.update(query, this.createUpdateOperations().addToSet("idNumber", newId));
        this.save(mongoManagementId);
        return id;
    }
}
