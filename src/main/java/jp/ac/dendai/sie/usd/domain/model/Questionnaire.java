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
public class Questionnaire {
    private Long questionnaireId;
    private String questionnaireTitle;
    private Long subjectId;
    private LocalDateTime createTime;
    private Boolean release;
}
