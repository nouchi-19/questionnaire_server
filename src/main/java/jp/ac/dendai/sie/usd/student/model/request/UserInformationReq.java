package jp.ac.dendai.sie.usd.student.model.request;

import jp.ac.dendai.sie.usd.domain.model.User;
import lombok.Data;
import lombok.Setter;

import javax.ws.rs.HeaderParam;
import java.nio.charset.StandardCharsets;


public class UserInformationReq {
//    @HeaderParam("oidc_claim_preferred_username")
    @Setter
    private String userId;
//    @HeaderParam("oidc_claim_given_name")
    @Setter
    private String firstName;
//    @HeaderParam("oidc_claim_family_name")
    @Setter
    private String lastName;

    public String getUserId() {
//        return new String(this.userId.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        return this.userId;
    }

    public String getFirstName() {
//        return new String(this.firstName.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        return this.firstName;
    }

    public String getLastName() {
//        return new String(this.lastName.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        return this.lastName;
    }
}
