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
public class QuestionRes {
    private Long questionId;
    private Long questionNumber;
    private String questionTitle;
    private Boolean required;
    private String questionType;
    @JsonProperty("options")
    private List<String> optionList;
}
