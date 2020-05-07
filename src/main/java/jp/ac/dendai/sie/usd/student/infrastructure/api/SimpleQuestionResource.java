package jp.ac.dendai.sie.usd.student.infrastructure.api;

import jp.ac.dendai.sie.usd.student.adapter.controllers.SimpleQuestionController;
import jp.ac.dendai.sie.usd.student.model.request.UserInformationReq;
import jp.ac.dendai.sie.usd.student.model.response.SimpleQuestionRes;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("questionnaires/{questionnaireId}")
public class SimpleQuestionResource {

    @Inject
    SimpleQuestionController simpleQuestionController;

//    @Path("subjects/{subjectId}/simpleQuestions")
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<SimpleQuestionRes> getSimpleQuestionsNoAnswer(@PathParam("subjectId")Long subjectId) {
//        System.out.println(subjectId);
//        System.out.println("sddddfslgknwkrgn");
////        return simpleQuestionController.getSimpleQuestions(subjectId, getTestUser());
//        return simpleQuestionController.getSimpleQuestionsNoAnswer(subjectId, getTestUser());
//    }

    @Path("simpleQuestions")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SimpleQuestionRes> getSimpleQuestions(@QueryParam("subjectId")Long subjectId, @PathParam("questionnaireId") Long questionnaireId) {
//        return simpleQuestionController.getSimpleQuestions(subjectId, getTestUser());
        return simpleQuestionController.getSimpleQuestions(subjectId, questionnaireId, getTestUser());
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