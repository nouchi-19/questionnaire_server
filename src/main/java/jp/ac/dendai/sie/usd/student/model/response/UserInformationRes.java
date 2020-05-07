package jp.ac.dendai.sie.usd.student.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserInformationRes {
    String userId;
    String firstName;
    String lastName;
}
