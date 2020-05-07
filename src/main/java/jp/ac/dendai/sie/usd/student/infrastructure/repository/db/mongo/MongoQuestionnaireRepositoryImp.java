package jp.ac.dendai.sie.usd.student.infrastructure.repository.db.mongo;

import jp.ac.dendai.sie.usd.domain.model.Questionnaire;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.config.MongoDBHelper;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.dao.QuestionnaireDao;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.dao.RegistrationDao;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity.MongoQuestionnaire;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity.MongoRegistration;
import jp.ac.dendai.sie.usd.student.usecase.repository.QuestionnaireRepository;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MongoQuestionnaireRepositoryImp implements QuestionnaireRepository {

    private QuestionnaireDao questionnaireDao;

    private RegistrationDao registrationDao;

    private Datastore datastore = MongoDBHelper.getDatastore();

    public MongoQuestionnaireRepositoryImp() {
        questionnaireDao = new QuestionnaireDao(MongoQuestionnaire.class, this.datastore);
        registrationDao = new RegistrationDao(MongoRegistration.class, this.datastore);
    }

    @Override
    public Optional<Questionnaire> findByQuestionnaireId(Long questionnaireId) {
        Query<MongoQuestionnaire> query = questionnaireDao.createQuery().filter("questionnaireId", questionnaireId).filter("release",true);

//        Questionnaire questionnaire = questionnaireDao.find(query).get().toDomain();
        Questionnaire questionnaire = Optional.ofNullable(questionnaireDao.find(query).get()).map(MongoQuestionnaire::toDomain).orElseThrow(() -> new NotFoundException("questionnaireIdが存在しないか非公開です"));
        return Optional.ofNullable(questionnaire);
    }

    @Override
    public List<Questionnaire> findAnyBySubjectId(Long subjectId) {
        Query<MongoQuestionnaire> query = questionnaireDao.createQuery().filter("subjectId", subjectId).filter("release",true);
        return questionnaireDao.find(query).asList().stream().map(MongoQuestionnaire::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Questionnaire> findAnyByStudentId(String studentId) {
        Query<MongoRegistration> queryRegistration = registrationDao.createQuery().filter("userList.userId", studentId);
        List<Long> subjectIdList = registrationDao.find(queryRegistration).asList().stream().map(MongoRegistration::getSubjectId).collect(Collectors.toList());
        List<Query<MongoQuestionnaire>> queryQuestionnaireList = subjectIdList.stream().map(subjectId -> questionnaireDao.createQuery().filter("subjectId", subjectId).filter("release",true)).collect(Collectors.toList());
        List<Questionnaire> questionnaireList = new ArrayList<>();
        for(Query<MongoQuestionnaire> queryQuestionnaire: queryQuestionnaireList) {
            questionnaireList.addAll(questionnaireDao.find(queryQuestionnaire).asList().stream().map(MongoQuestionnaire::toDomain).collect(Collectors.toList()));
        }
        return questionnaireList;
    }
}
