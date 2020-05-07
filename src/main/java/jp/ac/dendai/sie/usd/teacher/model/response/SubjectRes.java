package jp.ac.dendai.sie.usd.teacher.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubjectRes {
    public Long subjectId;
    public String subjectTitle;
    @JsonProperty("questionnaires")
    public List<QuestionnaireRes> questionnaireResList;
    public UserInformationRes teacher;
}
