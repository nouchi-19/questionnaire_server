package jp.ac.dendai.sie.usd.teacher.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SimpleAnswerRes {
    private Long simpleAnswerId;
    @JsonProperty("simpleQuestion")
    private SimpleQuestionRes simpleQuestionRes;
    private List<String> responses;
    private LocalDateTime responseTime;
    private UserInformationRes student;
}
