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
public class SimpleQuestionReq {
    @NotNull
    private String questionTitle;
    @NotNull
    private String questionType;
    @JsonProperty("options")
    @NotNull
    private List<String> optionList;
}
