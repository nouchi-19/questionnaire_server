package jp.ac.dendai.sie.usd.student.infrastructure.api;

import jp.ac.dendai.sie.usd.student.adapter.controllers.AggregateController;
import jp.ac.dendai.sie.usd.student.model.request.UserInformationReq;
import jp.ac.dendai.sie.usd.student.model.response.AggregateRes;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("questionnaires/{questionnaireId}/aggregate")
public class AggregateResource {
    @Inject
    AggregateController aggregateController;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public AggregateRes getAggregate(@QueryParam("subjectId")Long subjectId, @PathParam("questionnaireId")Long questionnaireId) {
        return aggregateController.getAggregate(subjectId, questionnaireId, getTestUser());
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
