package jp.ac.dendai.sie.usd.student.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class AnswerReq {
    @NotNull
    public Long questionId;
    @JsonProperty("responses")
    @NotNull
    public List<String> responseList;
}
