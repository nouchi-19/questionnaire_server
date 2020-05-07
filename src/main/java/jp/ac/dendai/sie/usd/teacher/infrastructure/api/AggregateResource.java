package jp.ac.dendai.sie.usd.teacher.infrastructure.api;

import jp.ac.dendai.sie.usd.teacher.model.request.UserInformationReq;
import jp.ac.dendai.sie.usd.teacher.model.response.AggregateRes;
import jp.ac.dendai.sie.usd.teacher.adapter.controllers.AggregateController;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("questionnaires/{questionnaireId}/aggregate")
public class AggregateResource {
//    @Inject
//    AggregateController aggregateController;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public AggregateRes getAggregate(@QueryParam("subjectId")Long subjectId, @PathParam("questionnaireId")Long questionnaireId) {
//        return aggregateController.getAggregate(subjectId, questionnaireId, getTestUser());
        return null;
    }

    public UserInformationReq getTestUser() {
        UserInformationReq student = new UserInformationReq();
        student.setUserId("15jk119");
        student.setFirstName("佐々木");
        student.setLastName("瞭");
        return student;
    }
}
