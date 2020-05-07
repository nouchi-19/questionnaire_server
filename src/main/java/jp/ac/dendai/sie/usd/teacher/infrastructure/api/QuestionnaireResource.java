package jp.ac.dendai.sie.usd.teacher.infrastructure.api;

import jp.ac.dendai.sie.usd.teacher.model.request.QuestionnaireReq;
import jp.ac.dendai.sie.usd.teacher.model.request.UserInformationReq;
import jp.ac.dendai.sie.usd.teacher.model.response.QuestionnaireRes;
import jp.ac.dendai.sie.usd.teacher.adapter.controllers.QuestionnaireController;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("subjects/{subjectId}/questionnaires")
public class QuestionnaireResource {

    @Inject
    QuestionnaireController questionnaireController;

    //No.2-1:アンケート一覧を取得
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<QuestionnaireRes> getQuestionnaires(@PathParam("subjectId") Long subjectId) {
        return questionnaireController.getQuestionnaireList(subjectId, getTestUser());
    }

    //No.2-2:アンケートを取得
    @Path("{questionnaireId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public QuestionnaireRes getQuestionnaire(@PathParam("subjectId") Long subjectId, @PathParam("questionnaireId") Long questionnaireId) {
        return questionnaireController.getQuestionnaire(subjectId, questionnaireId, getTestUser());
    }

//    No.2-3:アンケートを登録する(教員用APIへ移行)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postQuestionnaire(@PathParam("subjectId") Long subjectId,@Valid QuestionnaireReq questionnaireReq) {
//        System.out.println(questionnaireReq);
        Long questionnaireId = questionnaireController.createQuestionnaire(subjectId, questionnaireReq, getTestUser());
        URI uri = URI.create("api/subjects/" + subjectId + "/questionnaires/" + questionnaireId);
        return Response.created(uri).build();
    }

    @Path("{questionnaireId}")
    @PUT
    public Response putQuestionnaireRelease(@PathParam("subjectId") Long subjectId, @PathParam("questionnaireId") Long questionnaireId, @QueryParam("release")Boolean release) {
        questionnaireController.updateRelease(subjectId, questionnaireId, release);
        return Response.noContent().build();
    }

    @Path("{questionnaireId}")
    @DELETE
    public Response deleteQuestionnaire(@PathParam("subjectId") Long subjectId, @PathParam("questionnaireId") Long questionnaireId) {
        questionnaireController.delete(questionnaireId);
        return Response.noContent().build();
    }

    public UserInformationReq getTestUser() {
        UserInformationReq teacher = new UserInformationReq();
        teacher.setUserId("2211");
        teacher.setFirstName("宮川");
        teacher.setLastName("治");
        return teacher;
    }

}
