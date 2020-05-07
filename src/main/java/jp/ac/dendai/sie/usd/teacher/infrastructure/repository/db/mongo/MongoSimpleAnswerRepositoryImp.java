package jp.ac.dendai.sie.usd.teacher.infrastructure.repository.db.mongo;

import jp.ac.dendai.sie.usd.domain.model.SimpleAnswer;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.config.MongoDBHelper;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.dao.IdStoreDao;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.dao.SimpleAnswerDao;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity.MongoManagementId;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity.MongoSimpleAnswer;
import jp.ac.dendai.sie.usd.teacher.usecase.repository.SimpleAnswerRepository;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import java.util.List;
import java.util.stream.Collectors;

public class MongoSimpleAnswerRepositoryImp implements SimpleAnswerRepository {
    private IdStoreDao idStoreDao;

    private Datastore datastore = MongoDBHelper.getDatastore();

    private SimpleAnswerDao simpleAnswerDao;

    public MongoSimpleAnswerRepositoryImp() {
        idStoreDao = new IdStoreDao(MongoManagementId.class, this.datastore);
        simpleAnswerDao = new SimpleAnswerDao(MongoSimpleAnswer.class, datastore);
    }

//    @Override
//    public List<SimpleAnswer> findAnyBySimpleQuestionId(Long simpleQuestionId, String studentId) {
//        Query<MongoSimpleAnswer> query = simpleAnswerDao.createQuery().filter("simpleQuestionId", simpleQuestionId).filter("student.userId", studentId);
//        return  simpleAnswerDao.find(query).asList().stream().map(MongoSimpleAnswer::toDomain).collect(Collectors.toList());
//    }

//    @Override
//    public Long insert(SimpleAnswer simpleAnswer) {
//        simpleAnswer.setSimpleAnswerId(idStoreDao.create("simpleAnswerId"));
//        simpleAnswerDao.save(MongoSimpleAnswer.fromDomain(simpleAnswer));
//        return simpleAnswer.getSimpleAnswerId();
//    }

//    @Override
//    public List<SimpleAnswer> findAnyByQuestionnaireIdAndStudentId(Long questionnaireId, String studentId) {
//        Query<MongoSimpleAnswer> query = simpleAnswerDao.createQuery().filter("student.userId", studentId).filter("questionnaireId", questionnaireId);
//        return  simpleAnswerDao.find(query).asList().stream().map(MongoSimpleAnswer::toDomain).collect(Collectors.toList());
//    }

    @Override
    public List<SimpleAnswer> findAnuByQuestionnaireIdNewAnswers(Long questionnaireId) {
        Query<MongoSimpleAnswer> query = simpleAnswerDao.createQuery().filter("questionnaireId", questionnaireId);
        return  simpleAnswerDao.find(query).asList().stream().map(MongoSimpleAnswer::toDomain).collect(Collectors.toList());
    }
}
