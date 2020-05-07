package jp.ac.dendai.sie.usd.teacher.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuestionReq {
    @NotNull
    private Long questionNumber;
    @NotNull
    private String questionTitle;
    @NotNull
    private Boolean required;
    @NotNull
    private QuestionTypeReq questionType;
    @JsonProperty("options")
    @NotNull
    private List<String> optionList;
}
