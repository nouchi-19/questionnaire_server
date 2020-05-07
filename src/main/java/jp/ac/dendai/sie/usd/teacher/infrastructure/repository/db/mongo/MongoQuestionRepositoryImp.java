package jp.ac.dendai.sie.usd.teacher.infrastructure.repository.db.mongo;

import jp.ac.dendai.sie.usd.domain.model.Question;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.config.MongoDBHelper;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.dao.*;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity.*;
import jp.ac.dendai.sie.usd.teacher.usecase.repository.QuestionRepository;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MongoQuestionRepositoryImp implements QuestionRepository {

    private IdStoreDao idStoreDao;

    private QuestionDao questionDao;

    private QuestionnaireDao questionnaireDao;

    private SubjectDao subjectDao;

    private Datastore datastore = MongoDBHelper.getDatastore();

    public MongoQuestionRepositoryImp() {
        questionDao = new QuestionDao(MongoQuestion.class, this.datastore);
        questionnaireDao = new QuestionnaireDao(MongoQuestionnaire.class, this.datastore);
        subjectDao = new SubjectDao(MongoSubject.class, this.datastore);
        idStoreDao = new IdStoreDao(MongoManagementId.class, this.datastore);
    }

    @Override
    public List<Long> insertMany(List<Question> questionList) {
        List<Long> idList = new ArrayList<>();
        for(Question question: questionList) {
            question.setQuestionId(idStoreDao.create("questionId"));
            questionDao.save(MongoQuestion.fromDomain(question));
            idList.add(question.getQuestionId());
        }
        return idList;
    }

    @Override
    public List<Question> findAnyByQuestionnaireId(Long questionnaireId) {
        Query<MongoQuestion> query = questionDao.createQuery().filter("questionnaireId", questionnaireId);
        return questionDao.find(query).asList().stream().map(MongoQuestion::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Question> findAnyBySubjectId(Long subjectId) {
        Query<MongoQuestionnaire> queryMongoQuestionnaire = questionnaireDao.createQuery().filter("subjectId", subjectId);
        List<Long> questionnaireIdList = questionnaireDao.find(queryMongoQuestionnaire).asList().stream().map(MongoQuestionnaire::getQuestionnaireId).collect(Collectors.toList());
        List<Question> questionList = new ArrayList<>();
        for(Long questionnaireId: questionnaireIdList) {
            Query<MongoQuestion> query = questionDao.createQuery().filter("questionnaireId", questionnaireId);
            questionList.addAll(questionDao.find(query).asList().stream().map(MongoQuestion::toDomain).collect(Collectors.toList()));
        }
        return questionList;
    }

    @Override
    public List<Question> findAnyByTeacherId(String teacherId) {
        Query<MongoSubject> querySubject = subjectDao.createQuery().filter("teacher.userId", teacherId);
        List<Long> subjectIdList = subjectDao.find(querySubject).asList().stream().map(MongoSubject::getSubjectId).collect(Collectors.toList());
        List<Long> questionnaireIdList = new ArrayList<>();
        for(Long subjectId : subjectIdList) {
            Query<MongoQuestionnaire> queryMongoQuestionnaire = questionnaireDao.createQuery().filter("subjectId", subjectId);
            questionnaireIdList.addAll(questionnaireDao.find(queryMongoQuestionnaire).asList().stream().map(MongoQuestionnaire::getQuestionnaireId).collect(Collectors.toList()));
        }
        List<Question> questionList = new ArrayList<>();
        for(Long questionnaireId: questionnaireIdList) {
            Query<MongoQuestion> query = questionDao.createQuery().filter("questionnaireId", questionnaireId);
            questionList.addAll(questionDao.find(query).asList().stream().map(MongoQuestion::toDomain).collect(Collectors.toList()));
        }
        return questionList;
    }
}
