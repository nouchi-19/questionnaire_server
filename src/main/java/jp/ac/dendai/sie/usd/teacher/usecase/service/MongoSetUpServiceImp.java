package jp.ac.dendai.sie.usd.teacher.usecase.service;

import com.mongodb.client.ClientSession;
import jp.ac.dendai.sie.usd.domain.model.*;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.config.MongoConfig;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.config.MongoDBHelper;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.config.VirtualHostConfig;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.dao.*;
import jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity.*;
import org.mongodb.morphia.Datastore;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by guest1 on 2018/10/29.
 */
public class MongoSetUpServiceImp implements SetUpService {

//    @Inject
    MongoConfig mongoConfig = new VirtualHostConfig();

    SubjectDao subjectDao;
    RegistrationDao registrationDao;
    QuestionnaireDao questionnaireDao;
    QuestionDao questionDao;
    IdStoreDao idStoreDao;

    private Datastore datastore = MongoDBHelper.getDatastore();

    public MongoSetUpServiceImp() {
//        subjectDao = new SubjectDao(MongoSubject.class, mongoConfig.getClient(), mongoConfig.getMorphia(), mongoConfig.getDatabaseName());
//        registrationDao = new RegistrationDao(MongoRegistration.class, mongoConfig.getClient(), mongoConfig.getMorphia(), mongoConfig.getDatabaseName());
//        questionnaireDao = new QuestionnaireDao(MongoQuestionnaire.class, mongoConfig.getClient(), mongoConfig.getMorphia(), mongoConfig.getDatabaseName());
//        questionDao = new QuestionDao(MongoQuestion.class, mongoConfig.getClient(), mongoConfig.getMorphia(), mongoConfig.getDatabaseName());
//        idStoreDao = new IdStoreDao(MongoManagementId.class, mongoConfig.getClient(), mongoConfig.getMorphia(), mongoConfig.getDatabaseName());

    }

    @Override
    public void setUp() {
//        subjectDao = new SubjectDao(MongoSubject.class, mongoConfig.getClient(), mongoConfig.getMorphia(), mongoConfig.getDatabaseName());
//        registrationDao = new RegistrationDao(MongoRegistration.class, mongoConfig.getClient(), mongoConfig.getMorphia(), mongoConfig.getDatabaseName());
//        questionnaireDao = new QuestionnaireDao(MongoQuestionnaire.class, mongoConfig.getClient(), mongoConfig.getMorphia(), mongoConfig.getDatabaseName());
//        questionDao = new QuestionDao(MongoQuestion.class, mongoConfig.getClient(), mongoConfig.getMorphia(), mongoConfig.getDatabaseName());
//        idStoreDao = new IdStoreDao(MongoManagementId.class, mongoConfig.getClient(), mongoConfig.getMorphia(), mongoConfig.getDatabaseName());
        subjectDao = new SubjectDao(MongoSubject.class, this.datastore);
        registrationDao = new RegistrationDao(MongoRegistration.class, this.datastore);
        questionnaireDao = new QuestionnaireDao(MongoQuestionnaire.class, this.datastore);
        questionDao = new QuestionDao(MongoQuestion.class, this.datastore);
        idStoreDao = new IdStoreDao(MongoManagementId.class, this.datastore);



        idcreate();
        Subject subject1 = setUpSubject();
        setUpQuestionnaire(subject1);
        setUpQuestionnaire2(subject1);

        Subject subject2 = setUpSubject2();
        setUpQuestionnaire3(subject2);

        Subject subject3 = setUpSubject3();
        setUpQuestionnaire4(subject3);

    }

    public void setUp2() {
        idStoreDao = new IdStoreDao(MongoManagementId.class, this.datastore);
    idStoreDao.save(new MongoManagementId(null, 0L, "simpleQuestionId"));
//        idStoreDao.save(new MongoManagementId(null, 0L, "questionId"));
    }

    public void idcreate() {
        idStoreDao.save(new MongoManagementId(null, 0L, "subjectId"));
        idStoreDao.save(new MongoManagementId(null, 0L, "questionId"));
        idStoreDao.save(new MongoManagementId(null, 0L, "questionnaireId"));
        idStoreDao.save(new MongoManagementId(null, 0L, "resultId"));
        idStoreDao.save(new MongoManagementId(null, 0L, "answerId"));
        idStoreDao.save(new MongoManagementId(null, 0L, "simpleQuestionId"));
    }

    public Subject setUpSubject() {
        User teacher = new User("2211", "宮川", "治");
        Long subjectId = idStoreDao.create("subjectId");
        Subject subject = new Subject(subjectId, "オブジェクト指向設計", teacher);
        subjectDao.save(MongoSubject.fromDomain(subject));
        registrationDao.save(new MongoRegistration(null, subjectId, new ArrayList<>()));
        return subject;
    }

    public Subject setUpSubject2() {
        User teacher = new User("2211", "宮川", "治");
        Long subjectId = idStoreDao.create("subjectId");
        Subject subject = new Subject(subjectId, "コンピュータ・プログラミングⅠ", teacher);
        subjectDao.save(MongoSubject.fromDomain(subject));
        registrationDao.save(new MongoRegistration(null, subjectId, new ArrayList<>()));
        return subject;
    }

    public Subject setUpSubject3() {
        User teacher = new User("2212", "小濱", "隆司");
        Long subjectId = idStoreDao.create("subjectId");
        Subject subject = new Subject(subjectId, "UML演習", teacher);
        subjectDao.save(MongoSubject.fromDomain(subject));
        registrationDao.save(new MongoRegistration(null, subjectId, new ArrayList<>()));
        return subject;
    }

    public void setUpQuestionnaire(Subject subject) {
        Questionnaire questionnaire = new Questionnaire(
                idStoreDao.create("questionnaireId"),
                "第一回理解度調査",
                subject.getSubjectId(),
                LocalDateTime.now(),
                false
        );


        List<Question> questionList = new ArrayList<>();
        questionList.add(new Question(
                idStoreDao.create("questionId"),
                        null,
                        "理解できましたか",
                        true,
                        QuestionType.RADIO,
                        Arrays.asList("はい", "いいえ"),
                        questionnaire.getQuestionnaireId()
                )
        );

        questionList.add(new Question(
                        idStoreDao.create("questionId"),
                        null,
                        "触れたことのある言語はどれですか",
                        true,
                        QuestionType.CHECKBOX,
                        Arrays.asList("java", "C", "C++", "Python"),
                        questionnaire.getQuestionnaireId()
                )
        );

        questionList.add(new Question(
                        idStoreDao.create("questionId"),
                        null,
                        "好きな食べ物を選択してください",
                        true,
                        QuestionType.CHECKBOX,
                        Arrays.asList("いちご", "みかん", "めろん"),
                        questionnaire.getQuestionnaireId()
                )
        );

        questionList.add(new Question(
                        idStoreDao.create("questionId"),
                        null,
                        "今日の講義の感想を述べてください",
                        false,
                        QuestionType.TEXTAREA,
                        Arrays.asList(),
                        questionnaire.getQuestionnaireId()
                )
        );

        for (Integer i = 0; i < questionList.size(); i++) {
            questionList.get(i).setQuestionNumber(i.longValue());
        }
        questionnaireDao.save(MongoQuestionnaire.fromDomain(questionnaire));

//        memoryQuestionnaireSingleton.getQuestionnaireList().add(questionnaire);
        for (Question question : questionList) {
//            memoryQuestionSingleton.getQuestionList().add(question);
            questionDao.save(MongoQuestion.fromDomain(question));
        }
    }

    public void setUpQuestionnaire2(Subject subject) {
        Questionnaire questionnaire = new Questionnaire(
                idStoreDao.create("questionnaireId"),
                "第二回理解度調査",
                subject.getSubjectId(),
                LocalDateTime.now(),
                false
        );


        List<Question> questionList = new ArrayList<>();
        questionList.add(new Question(
                idStoreDao.create("questionId"),
                null,
                        "オブジェクトについて理解できましたか",
                        true,
                        QuestionType.RADIO,
                        Arrays.asList("はい", "いいえ"),
                        questionnaire.getQuestionnaireId()
                )
        );

        questionList.add(new Question(
                        idStoreDao.create("questionId"),
                        null,
                        "インスタンス変数は理解できましたか",
                        true,
                        QuestionType.RADIO,
                        Arrays.asList("はい", "いいえ"),
                        questionnaire.getQuestionnaireId()
                )
        );

        questionList.add(new Question(
                        idStoreDao.create("questionId"),
                        null,
                        "好きなコンビニを選択してください",
                        true,
                        QuestionType.CHECKBOX,
                        Arrays.asList("セブンイレブン", "ローソン", "ファミリーマート"),
                        questionnaire.getQuestionnaireId()
                )
        );

        questionList.add(new Question(
                        idStoreDao.create("questionId"),
                        null,
                        "今日の講義の感想を述べてください",
                        false,
                        QuestionType.TEXTAREA,
                        Arrays.asList(),
                        questionnaire.getQuestionnaireId()
                )
        );

        for (Integer i = 0; i < questionList.size(); i++) {
            questionList.get(i).setQuestionNumber(i.longValue());
        }

//        memoryQuestionnaireSingleton.getQuestionnaireList().add(questionnaire);
        questionnaireDao.save(MongoQuestionnaire.fromDomain(questionnaire));
        for (Question question : questionList) {
//            memoryQuestionSingleton.getQuestionList().add(question);
            questionDao.save(MongoQuestion.fromDomain(question));
        }

    }

    public void setUpQuestionnaire3(Subject subject) {
        Questionnaire questionnaire = new Questionnaire(
                idStoreDao.create("questionnaireId"),
                "第一回アンケート調査",
                subject.getSubjectId(),
                LocalDateTime.now(),
                false
        );


        List<Question> questionList = new ArrayList<>();
        questionList.add(new Question(
                        idStoreDao.create("questionId"),
                        null,
                        "forについて理解できましたか",
                        true,
                        QuestionType.RADIO,
                        Arrays.asList("はい", "いいえ"),
                        questionnaire.getQuestionnaireId()
                )
        );

        questionList.add(new Question(
                        idStoreDao.create("questionId"),
                        null,
                        "ifについて理解できましたか",
                        true,
                        QuestionType.RADIO,
                        Arrays.asList("はい", "いいえ"),
                        questionnaire.getQuestionnaireId()
                )
        );

        questionList.add(new Question(
                        idStoreDao.create("questionId"),
                        null,
                        "今日の講義の感想を述べてください",
                        false,
                        QuestionType.TEXTAREA,
                        Arrays.asList(),
                        questionnaire.getQuestionnaireId()
                )
        );

        for (Integer i = 0; i < questionList.size(); i++) {
            questionList.get(i).setQuestionNumber(i.longValue());
        }

//        memoryQuestionnaireSingleton.getQuestionnaireList().add(questionnaire);
        questionnaireDao.save(MongoQuestionnaire.fromDomain(questionnaire));
        for (Question question : questionList) {
//            memoryQuestionSingleton.getQuestionList().add(question);
            questionDao.save(MongoQuestion.fromDomain(question));
        }

    }

    public void setUpQuestionnaire4(Subject subject) {
        Questionnaire questionnaire = new Questionnaire(
                idStoreDao.create("questionnaireId"),
                "2018/09/14:アンケート",
                subject.getSubjectId(),
                LocalDateTime.now(),
                false
        );


        List<Question> questionList = new ArrayList<>();
        questionList.add(new Question(
                        idStoreDao.create("questionId"),
                        null,
                        "UMLについて以前に触れたことがありますか",
                        true,
                        QuestionType.RADIO,
                        Arrays.asList("はい", "いいえ"),
                        questionnaire.getQuestionnaireId()
                )
        );

        questionList.add(new Question(
                        idStoreDao.create("questionId"),
                        null,
                        "クラス図について、理解できましたか",
                        true,
                        QuestionType.RADIO,
                        Arrays.asList("はい", "いいえ"),
                        questionnaire.getQuestionnaireId()
                )
        );

        questionList.add(new Question(
                        idStoreDao.create("questionId"),
                        null,
                        "コンピュータ・プログラミングでの担当の教員を選択してください",
                        true,
                        QuestionType.RADIO,
                        Arrays.asList("宮川治", "小濱隆司", "堤智昭"),
                        questionnaire.getQuestionnaireId()
                )
        );

        questionList.add(new Question(
                        idStoreDao.create("questionId"),
                        null,
                        "今日の感想を自由に記述してください",
                        false,
                        QuestionType.TEXTAREA,
                        Arrays.asList(),
                        questionnaire.getQuestionnaireId()
                )
        );

        for (Integer i = 0; i < questionList.size(); i++) {
            questionList.get(i).setQuestionNumber(i.longValue());
        }

//        memoryQuestionnaireSingleton.getQuestionnaireList().add(questionnaire);
        questionnaireDao.save(MongoQuestionnaire.fromDomain(questionnaire));
        for (Question question : questionList) {
//            memoryQuestionSingleton.getQuestionList().add(question);
            questionDao.save(MongoQuestion.fromDomain(question));
        }
    }
}