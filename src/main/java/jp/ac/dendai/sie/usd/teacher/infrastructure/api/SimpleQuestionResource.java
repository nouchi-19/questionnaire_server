package jp.ac.dendai.sie.usd.teacher.infrastructure.api;

import jp.ac.dendai.sie.usd.teacher.adapter.controllers.SimpleQuestionController;
import jp.ac.dendai.sie.usd.teacher.model.request.SimpleQuestionReq;
import jp.ac.dendai.sie.usd.teacher.model.response.SimpleQuestionRes;
import jp.ac.dendai.sie.usd.teacher.model.request.UserInformationReq;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("questionnaires/{questionnaireId}/simpleQuestions")
public class SimpleQuestionResource {

    @Inject
    SimpleQuestionController simpleQuestionController;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SimpleQuestionRes> getSimpleQuestions(@QueryParam("subjectId")Long subjectId, @PathParam("questionnaireId")Long questionnaireId) {
        return simpleQuestionController.getSimpleQuestions(subjectId, questionnaireId, getTestUser());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postSimpleQuestion(@QueryParam("subjectId")Long subjectId, @PathParam("questionnaireId")Long questionnaireId,@Valid SimpleQuestionReq simpleQuestionReq) {
        Long simpleQuestionId = simpleQuestionController.createSimpleQuestion(subjectId, questionnaireId, simpleQuestionReq, getTestUser());
        URI uri = URI.create("api/questionnaires" + questionnaireId + "simpleQuestions");
        return Response.created(uri).build();
    }

    public UserInformationReq getTestUser() {
        UserInformationReq teacher = new UserInformationReq();
        teacher.setUserId("2211");
        teacher.setFirstName("宮川");
        teacher.setLastName("治");
        return teacher;
    }
}