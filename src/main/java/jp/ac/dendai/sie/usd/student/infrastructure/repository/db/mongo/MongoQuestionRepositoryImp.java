package jp.ac.dendai.sie.usd.student.infrastructure.repository.db.mongo;

import jp.ac.dendai.sie.usd.domain.model.Question;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.config.MongoDBHelper;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.dao.QuestionDao;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.dao.QuestionnaireDao;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.dao.RegistrationDao;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity.MongoQuestion;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity.MongoQuestionnaire;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity.MongoRegistration;
import jp.ac.dendai.sie.usd.student.usecase.repository.QuestionRepository;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MongoQuestionRepositoryImp implements QuestionRepository {

    private QuestionDao questionDao;

    private QuestionnaireDao questionnaireDao;

    private RegistrationDao registrationDao;

    private Datastore datastore = MongoDBHelper.getDatastore();

    public MongoQuestionRepositoryImp() {
        questionDao = new QuestionDao(MongoQuestion.class, this.datastore);
        questionnaireDao = new QuestionnaireDao(MongoQuestionnaire.class, this.datastore);
        registrationDao = new RegistrationDao(MongoRegistration.class, this.datastore);
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
    public List<Question> findAnyByStudentId(String studentId) {
        Query<MongoRegistration> queryRegistration = registrationDao.createQuery().filter("userList.userId", studentId);
        List<Long> subjectIdList = registrationDao.find(queryRegistration).asList().stream().map(MongoRegistration::getSubjectId).collect(Collectors.toList());
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
