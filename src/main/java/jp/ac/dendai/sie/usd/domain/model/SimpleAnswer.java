package jp.ac.dendai.sie.usd.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SimpleAnswer {
    private Long simpleAnswerId;
    private List<String> responses;
    private LocalDateTime responseTime;
    private User student;
    private Long simpleQuestionId;
    private Long questionnaireId;
}
