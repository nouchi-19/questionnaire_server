package jp.ac.dendai.sie.usd.student.infrastructure.api;

import jp.ac.dendai.sie.usd.student.adapter.controllers.SimpleAnswerController;
import jp.ac.dendai.sie.usd.student.model.request.SimpleAnswerReq;
import jp.ac.dendai.sie.usd.student.model.request.UserInformationReq;
import jp.ac.dendai.sie.usd.student.model.response.SimpleAnswerRes;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("questionnaires/{questionnaireId}")
public class SimpleAnswerResource {
    @Inject
    SimpleAnswerController simpleAnswerController;

    @Path("simpleAnswers")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postSimpleAnswer(@QueryParam("subjectId")Long subjectId, @PathParam("questionnaireId")Long questionnaireId, @Valid SimpleAnswerReq simpleAnswerReq) {
        Long simpleAnswerId = simpleAnswerController.createSimpleAnswer(subjectId, questionnaireId, simpleAnswerReq, getTestUser());
        URI uri = URI.create("" + simpleAnswerId);
        return Response.created(uri).build();
    }

    @Path("simpleAnswers")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SimpleAnswerRes> getSimpleAnswers(@QueryParam("subjectId")Long subjectId, @PathParam("questionnaireId")Long questionnaireId) {
        return simpleAnswerController.getSimpleAnswers(subjectId, questionnaireId, getTestUser());
    }


    @Path("simpleAggregate")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SimpleAnswerRes> getSimpleAnswersAggregate(@QueryParam("subjectId")Long subjectId, @PathParam("questionnaireId")Long questionnaireId) {
        return simpleAnswerController.getSimpleAnswersAggregate(subjectId, questionnaireId, getTestUser());
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
