package jp.ac.dendai.sie.usd.teacher.infrastructure.repository.db.mongo;

import com.mongodb.Mongo;
import jp.ac.dendai.sie.usd.domain.model.Questionnaire;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.config.MongoDBHelper;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.dao.IdStoreDao;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.dao.QuestionnaireDao;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.dao.RegistrationDao;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.dao.SubjectDao;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity.MongoManagementId;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity.MongoQuestionnaire;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity.MongoRegistration;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity.MongoSubject;
import jp.ac.dendai.sie.usd.teacher.usecase.repository.QuestionnaireRepository;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MongoQuestionnaireRepositoryImp implements QuestionnaireRepository {

    private IdStoreDao idStoreDao;

    private QuestionnaireDao questionnaireDao;

    private SubjectDao subjectDao;

    private Datastore datastore = MongoDBHelper.getDatastore();

    public MongoQuestionnaireRepositoryImp() {
        questionnaireDao = new QuestionnaireDao(MongoQuestionnaire.class, this.datastore);
        subjectDao = new SubjectDao(MongoSubject.class, this.datastore);
        idStoreDao = new IdStoreDao(MongoManagementId.class, this.datastore);
    }

    @Override
    public Long insert(Questionnaire questionnaire) {
        questionnaire.setQuestionnaireId(idStoreDao.create("questionnaireId"));
        questionnaireDao.save(MongoQuestionnaire.fromDomain(questionnaire));
        return questionnaire.getQuestionnaireId();
    }


    @Override
    public void delete(Long questionnaireId) {
        questionnaireDao.deleteById(questionnaireId);
    }

    @Override
    public void deleteBySubjectId(Long subjectId) {
        Query<MongoQuestionnaire> query = questionnaireDao.createQuery().filter("subjectId", subjectId);
        List<MongoQuestionnaire> questionnaireList = Optional.ofNullable(questionnaireDao.find(query).asList()).orElse(new ArrayList<>());
        for(MongoQuestionnaire mongoQuestionnaire :questionnaireList) {
            questionnaireDao.delete(mongoQuestionnaire);
        }
    }

    @Override
    public Long updateRelease(Long questionnaireId, Boolean release) {
        Query<MongoQuestionnaire> query = questionnaireDao.createQuery().filter("questionnaireId", questionnaireId);
        MongoQuestionnaire mongoQuestionnaire = Optional.ofNullable(questionnaireDao.find(query).get()).orElseThrow(() -> new NotFoundException("指定されたquestionnaireIdが存在しません"));
        mongoQuestionnaire.setRelease(release);

        questionnaireDao.save(mongoQuestionnaire);
        return mongoQuestionnaire.getQuestionnaireId();
    }

    @Override
    public Optional<Questionnaire> findByQuestionnaireId(Long questionnaireId) {
        Query<MongoQuestionnaire> query = questionnaireDao.createQuery().filter("questionnaireId", questionnaireId);
        Questionnaire questionnaire = questionnaireDao.find(query).get().toDomain();
        return Optional.ofNullable(questionnaire);
    }

    @Override
    public List<Questionnaire> findAnyBySubjectId(Long subjectId) {
        Query<MongoQuestionnaire> query = questionnaireDao.createQuery().filter("subjectId", subjectId);
        return questionnaireDao.find(query).asList().stream().map(MongoQuestionnaire::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Questionnaire> findAnyByTeacherId(String teacherId) {
        Query<MongoSubject> querySubject = subjectDao.createQuery().filter("teacher.userId", teacherId);
        List<Long> subjectIdList = subjectDao.find(querySubject).asList().stream().map(MongoSubject::getSubjectId).collect(Collectors.toList());
        List<Query<MongoQuestionnaire>> queryQuestionnaireList = subjectIdList.stream().map(subjectId -> questionnaireDao.createQuery().filter("subjectId", subjectId)).collect(Collectors.toList());
        List<Questionnaire> questionnaireList = new ArrayList<>();
        for(Query<MongoQuestionnaire> queryQuestionnaire: queryQuestionnaireList) {
            questionnaireList.addAll(questionnaireDao.find(queryQuestionnaire).asList().stream().map(MongoQuestionnaire::toDomain).collect(Collectors.toList()));
        }
        return questionnaireList;
    }
}
