package jp.ac.dendai.sie.usd.student.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.ac.dendai.sie.usd.domain.model.Questionnaire;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AggregateRes {
    @JsonProperty("questionnaire")
    private QuestionnaireRes questionnaireRes;
    @JsonProperty("answers")
    private List<AnswerRes> answerResList;
    private Long courseNumber;
}
