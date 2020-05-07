package jp.ac.dendai.sie.usd.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result {
    private Long resultId;
    private Long questionnaireId;
    private User student;
    private LocalDateTime responseTime;
}
