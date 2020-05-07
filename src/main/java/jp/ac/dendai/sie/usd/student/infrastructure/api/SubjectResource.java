package jp.ac.dendai.sie.usd.student.infrastructure.api;

import jp.ac.dendai.sie.usd.student.adapter.controllers.SimpleQuestionController;
import jp.ac.dendai.sie.usd.student.adapter.controllers.SubjectController;
import jp.ac.dendai.sie.usd.student.model.request.UserInformationReq;
import jp.ac.dendai.sie.usd.student.model.response.SimpleQuestionRes;
import jp.ac.dendai.sie.usd.student.model.response.SubjectRes;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("subjects")
public class SubjectResource {

    @Inject
    SubjectController subjectController;

    //No.1-1:履修したい教科を登録
    @Path("{subjectId}/registration")
    @POST
    public Response postRegistration(@PathParam("subjectId")Long subjectId) {
        subjectController.registrationSubject(subjectId, getTestUser());
        return Response.ok().build();
//        return subjectController.registrationSubject(subjectId, student);
    }

    //No.1-2:履修している教科一覧を取得
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SubjectRes> getSubjects() {
        return subjectController.getSubjectList(getTestUser());
    }


    //No.1-3:教科を取得
    @Path("{subjectId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public SubjectRes getSubjectId(@PathParam("subjectId")Long subjectId) {
        return subjectController.getSubject(subjectId, getTestUser());
    }

    //No.1-4:履修を取り消す
    @Path("{subjectId}")
    @DELETE
    public Response deleteSubjectId(@PathParam("subjectId")Long subjectId) {
        return null;
    }

    //No.1-5:教科を登録する(教員用APIへ移行)
//    @POST
//    public Response getSubjectId(SubjectReq subjectReq) {
//        UserInformationReq teacher = new UserInformationReq();
//        teacher.setUserId("2222");
//        teacher.setFirstName("宮川");
//        teacher.setLastName("治");
////        return subjectController.addSubject(subjectReq ,teacher);
//        return null;
//    }

    @Inject
    SimpleQuestionController simpleQuestionController;

    @Path("{subjectId}/simpleQuestions")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SimpleQuestionRes> getSimpleQuestionsNoAnswer(@PathParam("subjectId")Long subjectId , @QueryParam("answered") Boolean answered) {
//        return simpleQuestionController.getSimpleQuestions(subjectId, getTestUser());
        System.out.println(answered);
        return simpleQuestionController.getSimpleQuestionsNoAnswer(subjectId, getTestUser(), Optional.ofNullable(answered).orElse(false));
    }

    public UserInformationReq getTestUser() {
        UserInformationReq student = new UserInformationReq();
        student.setUserId("15AJ119");
        student.setFirstName("佐々木");
        student.setLastName("漣");
//        student.setUserId("15jk119");
//        student.setFirstName("佐々木");
//        student.setLastName("瞭");
        return student;
    }
}
