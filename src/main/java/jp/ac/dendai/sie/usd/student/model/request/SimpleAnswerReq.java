package jp.ac.dendai.sie.usd.student.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SimpleAnswerReq {
    @NotNull
    public Long simpleQuestionId;
    @NotNull
    private List<String> responses;
}
