package jp.ac.dendai.sie.usd.teacher.model.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubjectInformationRes {
    private Long subjectId;
    private String subjectTitle;
    private UserInformationRes teacher;
}
