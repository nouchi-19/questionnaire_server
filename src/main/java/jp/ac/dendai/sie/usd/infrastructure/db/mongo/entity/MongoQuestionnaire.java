package jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity;


import jp.ac.dendai.sie.usd.domain.model.Questionnaire;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MongoQuestionnaire {
    @Id
    private Long questionnaireId;
    private String questionnaireTitle;
    private Long subjectId;
    private LocalDateTime createTime;
    private Boolean release;

    public Questionnaire toDomain() {
        return new Questionnaire(
                this.questionnaireId,
                this.questionnaireTitle,
                this.subjectId,
                this.createTime,
                this.release
        );
    }

    public static MongoQuestionnaire fromDomain(Questionnaire questionnaire) {
        return new MongoQuestionnaire(
                questionnaire.getQuestionnaireId(),
                questionnaire.getQuestionnaireTitle(),
                questionnaire.getSubjectId(),
                questionnaire.getCreateTime(),
                questionnaire.getRelease()
        );
    }
}
