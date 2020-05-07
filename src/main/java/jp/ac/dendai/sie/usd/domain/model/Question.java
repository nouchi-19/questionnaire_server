package jp.ac.dendai.sie.usd.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Question {
    private Long questionId;
    private Long questionNumber;
    private String questionTitle;
    private Boolean required;
    private QuestionType questionType;
    private List<String> optionList;
    private Long questionnaireId;
}
