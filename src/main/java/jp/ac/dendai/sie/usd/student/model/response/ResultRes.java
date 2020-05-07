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
public class ResultRes {
    private Long resultId;
    @JsonProperty("questionnaire")
    private QuestionnaireRes questionnaireRes;
    private UserInformationRes student;
    @JsonProperty("answers")
    private List<AnswerRes> answerList;
    private LocalDateTime responseTime;
}
