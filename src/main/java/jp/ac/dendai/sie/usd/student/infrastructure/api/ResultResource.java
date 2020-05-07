package jp.ac.dendai.sie.usd.student.infrastructure.api;

import jp.ac.dendai.sie.usd.student.adapter.controllers.ResultController;
import jp.ac.dendai.sie.usd.student.model.request.ResultReq;
import jp.ac.dendai.sie.usd.student.model.request.UserInformationReq;
import jp.ac.dendai.sie.usd.student.model.response.ResultRes;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("questionnaires/{questionnaireId}/results")
public class ResultResource {

    @Inject
    ResultController resultController;

    //No.3-1:回答されたアンケートを登録
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postResults(@QueryParam("subjectId")Long subjectId, @PathParam("questionnaireId")Long questionnaireId,@Valid ResultReq resultReq) {
        System.out.println(resultReq.toString());
        Long resultId = resultController.createResult(subjectId, questionnaireId, resultReq, getTestUser());
        URI uri = URI.create("api/questionnaires/" + questionnaireId + "/results/" + resultId);
        return Response.created(uri).build();
    }

    //No.3-2:回答されたアンケート一覧を取得
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ResultRes> getResults(@QueryParam("subjectId")Long subjectId, @PathParam("questionnaireId")Long questionnaireId) {
        return resultController.getResultList(subjectId, questionnaireId, getTestUser());
    }

    //No.3-3:回答された最新のアンケートを取得
    @Path("{resultId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResultRes getResult(@QueryParam("subjectId")Long subjectId, @PathParam("questionnaireId")Long questionnaireId, @PathParam("resultId")Long resultId) {
        return resultController.getResult(subjectId, questionnaireId, resultId, getTestUser());
    }

    //No.3-4:回答したアンケートを削除
    @Path("{resultId}")
    @DELETE
    public Response deleteResult(@QueryParam("subjectId")String subjectId, @PathParam("questionnaireId")String questionnaireId, @PathParam("resultId")String resultId) {
        throw new NotFoundException("ごめんまだ実装してない");
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