package jp.ac.dendai.sie.usd.teacher.infrastructure.repository.db.mongo;

import jp.ac.dendai.sie.usd.domain.model.Result;
import jp.ac.dendai.sie.usd.domain.model.Subject;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.config.MongoDBHelper;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.dao.*;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity.*;
import jp.ac.dendai.sie.usd.teacher.usecase.repository.ResultRepository;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MongoResultRepositoryImp implements ResultRepository {

    private IdStoreDao idStoreDao;

    private ResultDao resultDao;

    private QuestionnaireDao questionnaireDao;

    private RegistrationDao registrationDao;

    private SubjectDao subjectDao;

    private Datastore datastore = MongoDBHelper.getDatastore();

    public MongoResultRepositoryImp() {
        idStoreDao = new IdStoreDao(MongoManagementId.class, this.datastore);
        resultDao = new ResultDao(MongoResult.class, this.datastore);
        subjectDao = new SubjectDao(MongoSubject.class, this.datastore);
        questionnaireDao = new QuestionnaireDao(MongoQuestionnaire.class, this.datastore);
        registrationDao = new RegistrationDao(MongoRegistration.class, this.datastore);
    }

//    @Override
//    public Long insert(Result result) {
//        result.setResultId(idStoreDao.create("resultId"));
//        resultDao.save(MongoResult.fromDomain(result));
//        return result.getResultId();
//    }

    @Override
    public Optional<Result> findByResultId(Long resultId) {
        Query<MongoResult> query = resultDao.createQuery().filter("resultId", resultId);
        Result result = resultDao.find(query).get().toDomain();
        return Optional.ofNullable(result);
    }

    @Override
    public List<Result> findAnyByQuestionnaireId(Long questionnaireId) {
        Query<MongoResult> query = resultDao.createQuery().filter("questionnaireId", questionnaireId);
        return resultDao.find(query).asList().stream().map(MongoResult::toDomain).collect(Collectors.toList());
    }

//    @Override
//    public List<Result> findAnyByQuestionnaireIdAndTeacherId(Long questionnaireId, String teacherId) {
//        Query<MongoResult> query = resultDao.createQuery().filter("questionnaireId", questionnaireId).filter("student.userId", studentId);
//        return resultDao.find(query).asList().stream().map(MongoResult::toDomain).collect(Collectors.toList());
//    }

//    @Override
//    public List<Result> findAnyBySubjectIdAndTeacherId(Long subjectId, String teacherId) {
//        Query<MongoSubject> querySubject = subjectDao.createQuery().filter("teacher.userId", teacherId);
//        List<Long> subjectIdList = subjectDao.find(querySubject).asList().stream().map(MongoSubject::getSubjectId).collect(Collectors.toList());
//
//        Query<MongoQuestionnaire> queryQuestionnaire = questionnaireDao.createQuery().filter("subjectId", subjectId);
//        List<Long> questionnaireIdList = questionnaireDao.find(queryQuestionnaire).asList().stream().map(MongoQuestionnaire::getQuestionnaireId).collect(Collectors.toList());
//        List<Result> resultList = new ArrayList<>();
//        for(Long questionnaireId : questionnaireIdList) {
//            Query<MongoResult> query = resultDao.createQuery().filter("questionnaireId", questionnaireId).filter("student.userId", studentId);
//            resultList.addAll(resultDao.find(query).asList().stream().map(MongoResult::toDomain).collect(Collectors.toList()));
//        }
//        return resultList;
//
//    }

    @Override
    public List<Result> findAnyByTeacherId(String teacherId) {
        Query<MongoSubject> querySubject = subjectDao.createQuery().filter("teacher.userId", teacherId);
        List<Long> subjectIdList = subjectDao.find(querySubject).asList().stream().map(MongoSubject::getSubjectId).collect(Collectors.toList());
        List<Query<MongoQuestionnaire>> queryQuestionnaireList = subjectIdList.stream().map(subjectId -> questionnaireDao.createQuery().filter("subjectId", subjectId)).collect(Collectors.toList());
        List<Long> questionnaireIdList = new ArrayList<>();
        for(Query<MongoQuestionnaire> queryQuestionnaire: queryQuestionnaireList) {
            questionnaireIdList.addAll(questionnaireDao.find(queryQuestionnaire).asList().stream().map(MongoQuestionnaire::getQuestionnaireId).collect(Collectors.toList()));
        }
        List<Result> resultList = new ArrayList<>();
        for(Long questionnaireId : questionnaireIdList) {
            Query<MongoResult> query = resultDao.createQuery().filter("questionnaireId", questionnaireId);
            resultList.addAll(resultDao.find(query).asList().stream().map(MongoResult::toDomain).collect(Collectors.toList()));
        }
        return resultList;
    }
}
