package jp.ac.dendai.sie.usd.teacher.infrastructure.api;

import jp.ac.dendai.sie.usd.teacher.model.request.SubjectReq;
import jp.ac.dendai.sie.usd.teacher.model.request.UserInformationReq;
import jp.ac.dendai.sie.usd.teacher.model.response.SubjectRes;
import jp.ac.dendai.sie.usd.teacher.adapter.controllers.SubjectController;
import jp.ac.dendai.sie.usd.teacher.model.response.UserInformationRes;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("subjects")
public class SubjectResource {

    @Inject
    SubjectController subjectController;

    //No.1-1:教科を登録
    @POST
    public Response postSubjects(@Valid SubjectReq subjectReq) {
        System.out.println(subjectReq);
//        subjectController.registrationSubject(subjectId, getTestUser());
        Long subjectId = subjectController.createSubject(subjectReq, getTestUser());
        URI uri = URI.create("api/subjects/" + subjectId);
        return Response.created(uri).build();
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

    //No.1-4:教科を削除
    @Path("{subjectId}")
    @DELETE
    public Response deleteSubjectId(@PathParam("subjectId")Long subjectId) {
        subjectController.delete(subjectId);
        return Response.noContent().build();
    }

    @Path("{subjectId}/students")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserInformationRes> getStudents(@PathParam("subjectId") Long subjectId) {
        return subjectController.getStudentList(subjectId, getTestUser());
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

    public UserInformationReq getTestUser() {
        UserInformationReq teacher = new UserInformationReq();
        teacher.setUserId("2211");
        teacher.setFirstName("宮川");
        teacher.setLastName("治");
        return teacher;
    }
}
