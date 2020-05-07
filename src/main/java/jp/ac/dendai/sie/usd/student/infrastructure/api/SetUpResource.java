package jp.ac.dendai.sie.usd.student.infrastructure.api;

import jp.ac.dendai.sie.usd.infrastructure.db.mongo.dao.RegistrationDao;
import jp.ac.dendai.sie.usd.mytest.PersonRepository;
import jp.ac.dendai.sie.usd.student.adapter.controllers.ResultController;
import jp.ac.dendai.sie.usd.student.adapter.controllers.SubjectController;
import jp.ac.dendai.sie.usd.student.model.request.AnswerReq;
import jp.ac.dendai.sie.usd.student.model.request.ResultReq;
import jp.ac.dendai.sie.usd.student.model.request.UserInformationReq;
import jp.ac.dendai.sie.usd.student.usecase.service.SetUpService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Path("setup")
public class SetUpResource {
    @Inject
    SetUpService setUpService;

    @Inject
    ResultController resultController;

    @Inject
    SubjectController subjectController;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String setup() {
        setUpService.setUp();
        registrationSetup1();
        resultSetup1();
        resultSetup2();
        resultSetup3();
        return "complete set up";
    }

    @Path("test")
    @GET
    public String test() {
        PersonRepository personRepository = new PersonRepository();
        personRepository.test();
        return "ok";
    }

    @Path("test2")
    @GET
    public String test2() {
        PersonRepository personRepository = new PersonRepository();
        personRepository.test2();
        return "ok2";
    }

    @Path("result")
    @GET
    public String test3() {
//        registrationSetup1();
//        resultSetup1();
//        resultSetup2();
//        resultSetup3();
        return "setUp3";
    }

    public void registrationSetup1() {

        UserInformationReq student1 = new UserInformationReq();
        student1.setUserId("15AJ162");
        student1.setFirstName("田中");
        student1.setLastName("太郎");
        subjectController.registrationSubject(0L, student1);

        UserInformationReq student2 = new UserInformationReq();
        student2.setUserId("15AJ163");
        student2.setFirstName("佐藤");
        student2.setLastName("綾");
        subjectController.registrationSubject(0L, student2);

        UserInformationReq student3 = new UserInformationReq();
        student3.setUserId("15AJ048");
        student3.setFirstName("伊藤");
        student3.setLastName("翼");
        subjectController.registrationSubject(0L, student3);


    }

    public void resultSetup1() {
        UserInformationReq student1 = new UserInformationReq();
        student1.setUserId("15AJ162");
        student1.setFirstName("田中");
        student1.setLastName("太郎");
        subjectController.registrationSubject(0L, student1);


        ResultReq resultReq1 = new ResultReq();

        List<AnswerReq> answerReqList = new ArrayList<>();

        AnswerReq answerReq1 = new AnswerReq();
        answerReq1.setQuestionId(0L);
        answerReq1.setResponseList(Arrays.asList("はい"));

        AnswerReq answerReq2 = new AnswerReq();
        answerReq2.setQuestionId(1L);
        answerReq2.setResponseList(Arrays.asList("java","C"));

        AnswerReq answerReq3 = new AnswerReq();
        answerReq3.setQuestionId(2L);
        answerReq3.setResponseList(Arrays.asList("いちご"));

        AnswerReq answerReq4 = new AnswerReq();
        answerReq4.setQuestionId(3L);
        answerReq4.setResponseList(Arrays.asList("面白かった"));

        answerReqList.add(answerReq1);
        answerReqList.add(answerReq2);
        answerReqList.add(answerReq3);
        answerReqList.add(answerReq4);

        resultReq1.setAnswerList(answerReqList);
        resultController.createResult(0L, 0L, resultReq1, student1);
    }

    public void resultSetup2() {

        UserInformationReq student2 = new UserInformationReq();
        student2.setUserId("15AJ163");
        student2.setFirstName("佐藤");
        student2.setLastName("綾");
        subjectController.registrationSubject(0L, student2);

        ResultReq resultReq1 = new ResultReq();

        List<AnswerReq> answerReqList = new ArrayList<>();

        AnswerReq answerReq1 = new AnswerReq();
        answerReq1.setQuestionId(0L);
        answerReq1.setResponseList(Arrays.asList("いいえ"));

        AnswerReq answerReq2 = new AnswerReq();
        answerReq2.setQuestionId(1L);
        answerReq2.setResponseList(Arrays.asList("java","C","C++"));

        AnswerReq answerReq3 = new AnswerReq();
        answerReq3.setQuestionId(2L);
        answerReq3.setResponseList(Arrays.asList("めろん"));

        AnswerReq answerReq4 = new AnswerReq();
        answerReq4.setQuestionId(3L);
        answerReq4.setResponseList(Arrays.asList("いい感じ"));

        answerReqList.add(answerReq1);
        answerReqList.add(answerReq2);
        answerReqList.add(answerReq3);
        answerReqList.add(answerReq4);

        resultReq1.setAnswerList(answerReqList);

        resultController.createResult(0L, 0L, resultReq1, student2);
    }

    public void resultSetup3() {

        UserInformationReq student3 = new UserInformationReq();
        student3.setUserId("15AJ048");
        student3.setFirstName("伊藤");
        student3.setLastName("翼");
        subjectController.registrationSubject(0L, student3);

        ResultReq resultReq1 = new ResultReq();

        List<AnswerReq> answerReqList = new ArrayList<>();

        AnswerReq answerReq1 = new AnswerReq();
        answerReq1.setQuestionId(0L);
        answerReq1.setResponseList(Arrays.asList("はい"));

        AnswerReq answerReq2 = new AnswerReq();
        answerReq2.setQuestionId(1L);
        answerReq2.setResponseList(Arrays.asList("C","C++"));

        AnswerReq answerReq3 = new AnswerReq();
        answerReq3.setQuestionId(2L);
        answerReq3.setResponseList(Arrays.asList("いちご","みかん","めろん"));

        AnswerReq answerReq4 = new AnswerReq();
        answerReq4.setQuestionId(3L);
        answerReq4.setResponseList(Arrays.asList("やばみ"));

        answerReqList.add(answerReq1);
        answerReqList.add(answerReq2);
        answerReqList.add(answerReq3);
        answerReqList.add(answerReq4);

        resultReq1.setAnswerList(answerReqList);
        resultController.createResult(0L, 0L, resultReq1, student3);
    }


//    @Inject
//    MemoryQuestionnaireData memoryQuestionnaireData = MemoryQuestionnaireData.getInstance();

//    @Inject
//    MemoryAnswerData memoryAnswerData;

//    @Path("questionnaires")
//    @GET
//    public void setUpQuestionnaire() {
//        memoryQuestionnaireData.setQuestionnaire(question());
//    }
//
//    @Path("answers")
//    @GET
//    public void setUpAnswers() {
//        memoryAnswerData.setAnswer(answer(question()));
//        memoryAnswerData.setAnswer(answer2(question()));
//    }


//    public Questionnaire question() {
//        Questionnaire questionnaire = new Questionnaire();
//
//        Subject subject = new Subject();
//        subject.setSubjectId("2018KDJVPD93");
//        subject.setTitle("2018コンピュータープログラミングA");
//
//        Student student = new Student();
//        student.setStudentId("");
//        student.setName("");
//
//        Teacher teacher = new Teacher();
//        teacher.setTeacherId("0291");
//        teacher.setName("宮川 治");
//
//
//        TimeSet timeSet = new TimeSet();
//        timeSet.setBeginning(LocalDateTime.MIN);
//        timeSet.setEnd(LocalDateTime.MIN);
//        timeSet.setPosted(LocalDateTime.MIN);
//
//        Question question1 = new Question();
//        question1.setQuestionId("1");
//        question1.setTitle("理解できましたか");
//        question1.setRequired(true);
//        question1.setQuestionType(QuestionType.RADIO);
//        question1.setOptions(Arrays.asList("はい", "いいえ"));
//        question1.setResponses(Arrays.asList());
//        question1.setTimeSet(timeSet);
//
//        Question question2 = new Question();
//        question2.setQuestionId("2");
//        question2.setTitle("プログラム経験は?");
//        question2.setRequired(true);
//        question2.setQuestionType(QuestionType.CHECKBOX);
//        question2.setOptions(Arrays.asList("java", "c", "javaScript"));
//        question2.setResponses(Arrays.asList());
//        question2.setTimeSet(timeSet);
//
//        Question question3 = new Question();
//        question3.setQuestionId("3");
//        question3.setRequired(true);
//        question3.setTitle("好きな食べ物");
//        question3.setQuestionType(QuestionType.CHECKBOX);
//        question3.setOptions(Arrays.asList("いちご", "りんご", "めろん"));
//        question3.setResponses(Arrays.asList());
//        question3.setTimeSet(timeSet);
//
//        Question question4 = new Question();
//        question4.setQuestionId("4");
//        question4.setRequired(false);
//        question4.setTitle("今日の感想は");
//        question4.setQuestionType(QuestionType.TEXTAREA);
//        question4.setOptions(Arrays.asList());
//        question4.setResponses(Arrays.asList());
//        question4.setTimeSet(timeSet);
//
//        questionnaire.setUniqueId("2018KNSD294NDKC3");
//        questionnaire.setQuestionnaireId("1");
//        questionnaire.setTitle("第一回理解度調査");
//        questionnaire.setSubject(subject);
//        questionnaire.setSubmission(true);
//        questionnaire.setStudent(student);
//        questionnaire.setTeacher(teacher);
//        questionnaire.setQuestions(Arrays.asList(question1, question2, question3, question4));
//        questionnaire.setCreateDate(LocalDateTime.parse("2018-04-01T00:00:00"));
//        questionnaire.setAnsweredDate(LocalDateTime.MIN);
//
//        return questionnaire;
//    }
//
//
//    public Questionnaire answer(Questionnaire questionnaire) {
//
//
//        TimeSet timeSet = new TimeSet();
//        timeSet.setBeginning(LocalDateTime.parse("2018-04-04T13:24:30"));
//        timeSet.setEnd(LocalDateTime.parse("2018-04-04T14:05:24"));
//        timeSet.setPosted(LocalDateTime.parse("2018-04-14T14:00:43"));
//
//        questionnaire.getQuestions().get(0).setResponses(Arrays.asList("はい"));
//        questionnaire.getQuestions().get(0).setTimeSet(timeSet);
//
//        questionnaire.getQuestions().get(1).setResponses(Arrays.asList("java", "c", "javaScript"));
//        questionnaire.getQuestions().get(1).setTimeSet(timeSet);
//
//        questionnaire.getQuestions().get(2).setResponses(Arrays.asList("いちご"));
//        questionnaire.getQuestions().get(2).setTimeSet(timeSet);
//
//        questionnaire.getQuestions().get(3).setResponses(Arrays.asList("面白かった"));
//        questionnaire.getQuestions().get(3).setTimeSet(timeSet);
//
//        questionnaire.setUniqueId("2018KNSD294NDKC1");
//        questionnaire.setStudent(student);
//        questionnaire.setCreateDate(LocalDateTime.parse("2018-04-13T18:02:30"));
//        questionnaire.setAnsweredDate(LocalDateTime.parse("2018-04-14T14:10:34"));
//
//        return questionnaire;
//    }
//
//    public Questionnaire answer2(Questionnaire questionnaire) {
//        TimeSet timeSet = new TimeSet();
//        timeSet.setBeginning(LocalDateTime.parse("2018-04-04T13:23:34"));
//        timeSet.setEnd(LocalDateTime.parse("2018-04-04T13:54:04"));
//        timeSet.setPosted(LocalDateTime.parse("2018-04-14T14:39:24"));
//
//        questionnaire.getQuestions().get(0).setResponses(Arrays.asList("いいえ"));
//        questionnaire.getQuestions().get(0).setTimeSet(timeSet);
//
//        questionnaire.getQuestions().get(1).setResponses(Arrays.asList("java", "javaScript"));
//        questionnaire.getQuestions().get(1).setTimeSet(timeSet);
//
//        questionnaire.getQuestions().get(2).setResponses(Arrays.asList("いちご", "めろん"));
//        questionnaire.getQuestions().get(2).setTimeSet(timeSet);
//
//        questionnaire.getQuestions().get(3).setResponses(Arrays.asList("楽しかった"));
//        questionnaire.getQuestions().get(3).setTimeSet(timeSet);
//
//        questionnaire.setUniqueId("2018KNSD294NDKC2");
//        questionnaire.setStudent(student);
//        questionnaire.setCreateDate(LocalDateTime.parse("2018-04-13T18:02:30"));
//        questionnaire.setAnsweredDate(LocalDateTime.parse("2018-04-14T14:14:33"));
//
//        return questionnaire;
//    }
}
