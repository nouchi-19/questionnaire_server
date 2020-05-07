package jp.ac.dendai.sie.usd.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Subject {
    private Long subjectId;
    private String subjectTitle;
    private User teacher;
}
