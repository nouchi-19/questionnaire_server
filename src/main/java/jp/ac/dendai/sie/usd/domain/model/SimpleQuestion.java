package jp.ac.dendai.sie.usd.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SimpleQuestion {
    private Long simpleQuestionId;
    private String questionTitle;
    private QuestionType questionType;
    private List<String> optionList;
    private LocalDateTime createTime;
    private Long questionnaireId;
}
