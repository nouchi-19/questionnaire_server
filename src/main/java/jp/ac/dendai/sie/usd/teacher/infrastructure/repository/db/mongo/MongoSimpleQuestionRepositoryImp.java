package jp.ac.dendai.sie.usd.teacher.infrastructure.repository.db.mongo;

import jp.ac.dendai.sie.usd.domain.model.SimpleQuestion;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.config.MongoDBHelper;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.dao.IdStoreDao;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.dao.SimpleQuestionDao;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity.MongoManagementId;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity.MongoSimpleQuestion;
import jp.ac.dendai.sie.usd.teacher.usecase.repository.SimpleQuestionRepository;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import java.util.List;
import java.util.stream.Collectors;

public class MongoSimpleQuestionRepositoryImp implements SimpleQuestionRepository {
    private SimpleQuestionDao simpleQuestionDao;

    private Datastore datastore = MongoDBHelper.getDatastore();

    private IdStoreDao idStoreDao;

    public MongoSimpleQuestionRepositoryImp() {
        simpleQuestionDao = new SimpleQuestionDao(MongoSimpleQuestion.class, datastore);
        idStoreDao = new IdStoreDao(MongoManagementId.class, datastore);
    }

    @Override
    public Long insert(SimpleQuestion simpleQuestion) {
        simpleQuestion.setSimpleQuestionId(idStoreDao.create("simpleQuestionId"));
        simpleQuestionDao.save(MongoSimpleQuestion.fromDomain(simpleQuestion));
        return simpleQuestion.getSimpleQuestionId();
    }

    @Override
    public List<SimpleQuestion> findAnyByQuestionnaireId(Long questionnaireId) {
        Query<MongoSimpleQuestion> query = simpleQuestionDao.createQuery().filter("questionnaireId", questionnaireId);
        return simpleQuestionDao.find(query).asList().stream().map(MongoSimpleQuestion::toDomain).collect(Collectors.toList());
    }
}
