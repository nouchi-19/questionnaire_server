package jp.ac.dendai.sie.usd.teacher.infrastructure.api;

//import jp.ac.dendai.sie.usd.mytest.PersonRepository;
import jp.ac.dendai.sie.usd.teacher.usecase.service.SetUpService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("setup")
public class SetUpResource {
    @Inject
    SetUpService setUpService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String setup() {
        setUpService.setUp();
//        setUpService.setUp2();
        return "complete set up";
    }

//    @Path("test")
//    @GET
//    public String test() {
//        PersonRepository personRepository = new PersonRepository();
//        personRepository.test();
//        return "ok";
//    }
//
//    @Path("test2")
//    @GET
//    public String test2() {
//        PersonRepository personRepository = new PersonRepository();
//        personRepository.test2();
//        return "ok2";
//    }


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
//        Student student = new Student();
//        student.setStudentId("15jk119");
//        student.setName("佐々木 瞭");
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
//        Student student = new Student();
//        student.setStudentId("15jk162");
//        student.setName("竹ノ内宏亘");
//
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
