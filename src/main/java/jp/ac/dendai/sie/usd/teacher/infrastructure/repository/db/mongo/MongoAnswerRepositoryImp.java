package jp.ac.dendai.sie.usd.teacher.infrastructure.repository.db.mongo;

import jp.ac.dendai.sie.usd.domain.model.Answer;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.config.MongoDBHelper;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.dao.AnswerDao;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.dao.IdStoreDao;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.dao.ResultDao;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity.MongoAnswer;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity.MongoManagementId;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity.MongoResult;
import jp.ac.dendai.sie.usd.teacher.usecase.repository.AnswerRepository;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MongoAnswerRepositoryImp implements AnswerRepository {

    private IdStoreDao idStoreDao;

    private AnswerDao answerDao;

    private ResultDao resultDao;

    private Datastore datastore = MongoDBHelper.getDatastore();
    public MongoAnswerRepositoryImp() {
        answerDao = new AnswerDao(MongoAnswer.class, this.datastore);
        idStoreDao = new IdStoreDao(MongoManagementId.class, this.datastore);
        resultDao = new ResultDao(MongoResult.class, this.datastore);
    }

//    @Override
//    public Long insert(Answer answer) {
//        answer.setAnswerId(idStoreDao.create("answerId"));
//        answerDao.save(MongoAnswer.fromDomain(answer));
//        return answer.getAnswerId();
//    }

//    @Override
//    public List<Long> insertMany(List<Answer> answerList) {
//        List<Long> idList = new ArrayList<>();
//        for(Answer answer: answerList) {
//            answer.setAnswerId(idStoreDao.create("answerId"));
//            answerDao.save(MongoAnswer.fromDomain(answer));
//            idList.add(answer.getAnswerId());
//        }
//        return idList;
//    }

    @Override
    public List<Answer> findAnyByResultId(Long resultId) {
        Query<MongoAnswer> query = answerDao.createQuery().filter("resultId", resultId);
        return answerDao.find(query).asList().stream().map(MongoAnswer::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Answer> findAnyByQuestionnaireId(Long questionnaireId) {
        Query<MongoResult> queryResult = resultDao.createQuery().filter("questionnaireId", questionnaireId);
        List<Long> resultIdList = resultDao.find(queryResult).asList().stream().map(MongoResult::getResultId).collect(Collectors.toList());
        List<Answer> answerList = new ArrayList<>();
        for(Long resultId : resultIdList) {
            Query<MongoAnswer> query = answerDao.createQuery().filter("resultId", resultId);
            answerList.addAll(answerDao.find(query).asList().stream().map(MongoAnswer::toDomain).collect(Collectors.toList()));
        }
        return answerList;
    }

//    @Override
//    public List<Answer> findAnyByQuestionnaireIdAndStudentId(Long questionnaireId, String studentId) {
//        Query<MongoResult> queryResult = resultDao.createQuery().filter("questionnaireId", questionnaireId).filter("student.userId", studentId);
//        List<Long> resultIdList = resultDao.find(queryResult).asList().stream().map(MongoResult::getResultId).collect(Collectors.toList());
//        List<Answer> answerList = new ArrayList<>();
//        for(Long resultId : resultIdList) {
//            Query<MongoAnswer> query = answerDao.createQuery().filter("resultId", resultId);
//            answerList.addAll(answerDao.find(query).asList().stream().map(MongoAnswer::toDomain).collect(Collectors.toList()));
//        }
//        return answerList;
//    }

    @Override
    public List<Answer> findAnyByQuestionnaireIdNewAnswers(Long questionnaireId) {
        Query<MongoResult> queryResult = resultDao.createQuery().filter("questionnaireId", questionnaireId).order("-responseTime");
        List<MongoResult> resultList = resultDao.find(queryResult).asList();
        List<Answer> answerList = new ArrayList<>();
        List<String> studentIdList = new ArrayList<>();
        for(MongoResult result : resultList) {
            if(!studentIdList.contains(result.getStudent().getUserId())) {
                studentIdList.add(result.getStudent().getUserId());
                Query<MongoAnswer> query = answerDao.createQuery().filter("resultId", result.getResultId());
                answerList.addAll(answerDao.find(query).asList().stream().map(MongoAnswer::toDomain).collect(Collectors.toList()));
            }
        }
        return answerList;
    }

    @Override
    public void deleteAnswer(Long answerId) {
    }
}
