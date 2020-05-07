package jp.ac.dendai.sie.usd.student.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuestionnaireRes {
    private Long questionnaireId;
    private String questionnaireTitle;
    @JsonProperty("subjectInformation")
    private SubjectInformationRes subjectInformationRes;
    private Boolean submission;
    @JsonProperty("questions")
    private List<QuestionRes> questionList;
    private LocalDateTime createTime;
}
