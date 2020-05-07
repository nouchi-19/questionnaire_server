package jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity;

import com.mongodb.Mongo;
import jp.ac.dendai.sie.usd.domain.model.SimpleAnswer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MongoSimpleAnswer {
    @Id
    private Long simpleAnswerId;
    private List<String> responses;
    private LocalDateTime responseTime;
    private MongoUser student;
    private Long simpleQuestionId;
    private Long questionnaireId;

    public SimpleAnswer toDomain() {
        return new SimpleAnswer(
                this.simpleAnswerId,
                this.responses,
                this.responseTime,
                this.student.toDomain(),
                this.simpleQuestionId,
                this.questionnaireId
        );
    }

    public static MongoSimpleAnswer fromDomain(SimpleAnswer simpleAnswer) {
        return new MongoSimpleAnswer(
                simpleAnswer.getSimpleAnswerId(),
                simpleAnswer.getResponses(),
                simpleAnswer.getResponseTime(),
                MongoUser.fromDomain(simpleAnswer.getStudent()),
                simpleAnswer.getSimpleQuestionId(),
                simpleAnswer.getQuestionnaireId()
        );
    }
}
