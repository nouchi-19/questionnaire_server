package jp.ac.dendai.sie.usd.teacher.infrastructure.api;

import jp.ac.dendai.sie.usd.teacher.adapter.controllers.SimpleAnswerController;
import jp.ac.dendai.sie.usd.teacher.model.request.UserInformationReq;
import jp.ac.dendai.sie.usd.teacher.model.response.SimpleAnswerRes;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("questionnaires/{questionnaireId}")
public class SimpleAnswerResource {
    @Inject
    SimpleAnswerController simpleAnswerController;

    @Path("simpleAnswers")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SimpleAnswerRes> getSimpleAnswers(@QueryParam("subjectId")Long subjectId, @PathParam("questionnaireId")Long questionnaireId) {
        return simpleAnswerController.getSimpleAnswers(subjectId, questionnaireId, getTestUser());
    }


    public UserInformationReq getTestUser() {
        UserInformationReq teacher = new UserInformationReq();
        teacher.setUserId("2211");
        teacher.setFirstName("宮川");
        teacher.setLastName("治");
        return teacher;
    }
}
