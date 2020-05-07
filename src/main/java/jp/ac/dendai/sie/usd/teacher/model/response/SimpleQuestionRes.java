package jp.ac.dendai.sie.usd.teacher.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SimpleQuestionRes {
    private Long simpleQuestionId;
    private String questionTitle;
    private String questionType;
    @JsonProperty("options")
    private List<String> optionList;
}
