package jp.ac.dendai.sie.usd.student.infrastructure.repository.db.mongo;

import jp.ac.dendai.sie.usd.domain.model.SimpleQuestion;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.config.MongoDBHelper;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.dao.QuestionnaireDao;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.dao.SimpleAnswerDao;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.dao.SimpleQuestionDao;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity.MongoQuestionnaire;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity.MongoSimpleAnswer;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity.MongoSimpleQuestion;
import jp.ac.dendai.sie.usd.student.usecase.repository.SimpleQuestionRepository;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MongoSimpleQuestionRepositoryImp implements SimpleQuestionRepository {
    private SimpleQuestionDao simpleQuestionDao;

    private QuestionnaireDao questionnaireDao;

    private SimpleAnswerDao simpleAnswerDao;

    private Datastore datastore = MongoDBHelper.getDatastore();

    public MongoSimpleQuestionRepositoryImp() {
        simpleQuestionDao = new SimpleQuestionDao(MongoSimpleQuestion.class, datastore);
        questionnaireDao = new QuestionnaireDao(MongoQuestionnaire.class, datastore);
        simpleAnswerDao = new SimpleAnswerDao(MongoSimpleAnswer.class, datastore);
    }

    @Override
    public Optional<SimpleQuestion> findBySimpleQuestionId(Long simpleQuestion) {
        return Optional.empty();
    }

    @Override
    public List<SimpleQuestion> findAnyByQuestionnaireId(Long questionnaireId) {
        Query<MongoSimpleQuestion> query = simpleQuestionDao.createQuery().filter("questionnaireId", questionnaireId);
        return simpleQuestionDao.find(query).asList().stream().map(MongoSimpleQuestion::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<SimpleQuestion> findAnyBySubjectId(Long subjectId) {
        Query<MongoQuestionnaire> q = questionnaireDao.createQuery().filter("subjectId", subjectId);
        List<Long> questionnaireIdList = questionnaireDao.find(q).asList().stream().map(MongoQuestionnaire::getQuestionnaireId).collect(Collectors.toList());
        List<SimpleQuestion> simpleQuestionList = new ArrayList<>();
        for(Long questionnaireId: questionnaireIdList) {
            Query<MongoSimpleQuestion> query = simpleQuestionDao.createQuery().filter("questionnaireId", questionnaireId);
            simpleQuestionList.addAll(simpleQuestionDao.find(query).asList().stream().map(MongoSimpleQuestion::toDomain).collect(Collectors.toList()));
        }
        return simpleQuestionList;
    }

    @Override
    public List<SimpleQuestion> findAnyBySubjectIdAndNoAnswerStudentId(Long subjectId, String studentId) {
        List<SimpleQuestion> simpleQuestionList = findAnyBySubjectId(subjectId);
        Query<MongoSimpleAnswer> querySimpleAnswer = simpleAnswerDao.createQuery().filter("student.userId", studentId);
        List<Long> answeredSimpleQuestionIdList = simpleAnswerDao.find(querySimpleAnswer).asList().stream().map(MongoSimpleAnswer::getSimpleQuestionId).collect(Collectors.toList());
        List<SimpleQuestion> answeredSimpleQuestionList = new ArrayList<>();
        for(SimpleQuestion simpleQuestion:simpleQuestionList) {
            for(Long sId:answeredSimpleQuestionIdList) {
                if(simpleQuestion.getSimpleQuestionId().equals(sId)) {
                    answeredSimpleQuestionList.add(simpleQuestion);
                }
            }
        }
        System.out.println(answeredSimpleQuestionList);
        simpleQuestionList.removeAll(answeredSimpleQuestionList);
        return simpleQuestionList;
//        return simpleQuestionList.stream().filter(simpleQuestion -> !answeredSimpleQuestionIdList.contains(simpleQuestion.getSimpleQuestionId())).collect(Collectors.toList());
    }
}
