package jp.ac.dendai.sie.usd.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Answer {
    private Long answerId;
    private Long questionId;
    private List<String> responseList;
    private Long resultId;
}
