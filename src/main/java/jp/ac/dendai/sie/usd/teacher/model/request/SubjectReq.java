package jp.ac.dendai.sie.usd.teacher.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubjectReq {
    @NotNull(message = "yahoooooooo")
    private String subjectTitle;
}
