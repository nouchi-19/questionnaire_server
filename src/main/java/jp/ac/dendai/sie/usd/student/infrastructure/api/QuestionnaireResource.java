package jp.ac.dendai.sie.usd.student.infrastructure.api;

import jp.ac.dendai.sie.usd.student.adapter.controllers.QuestionnaireController;
import jp.ac.dendai.sie.usd.student.model.request.UserInformationReq;
import jp.ac.dendai.sie.usd.student.model.response.QuestionnaireRes;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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

    //No.2-3:アンケートを登録する(教員用APIへ移行)
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response postQuestionnaire(@QueryParam("subjectId") String subjectId, QuestionnaireReq questionnaireReq) {
//        return null;
//    }

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
