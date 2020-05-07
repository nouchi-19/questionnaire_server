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
public class AnswerRes {
    private Long answerId;
    @JsonProperty("question")
    private QuestionRes questionRes;
    @JsonProperty("responses")
    private List<String> responseList;
}
