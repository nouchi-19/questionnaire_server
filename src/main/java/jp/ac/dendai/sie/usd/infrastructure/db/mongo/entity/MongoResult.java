package jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity;


import jp.ac.dendai.sie.usd.domain.model.Result;
import jp.ac.dendai.sie.usd.domain.model.User;
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
public class MongoResult {
    @Id
    private Long resultId;
    private Long questionnaireId;
    private MongoUser student;
    private LocalDateTime responseTime;

    public Result toDomain() {
        return new Result(
                this.resultId,
                this.questionnaireId,
                this.student.toDomain(),
                this.responseTime
        );
    }

    public static MongoResult fromDomain(Result result) {
        return new MongoResult(
                result.getResultId(),
                result.getQuestionnaireId(),
                MongoUser.fromDomain(result.getStudent()),
                result.getResponseTime()
        );
    }
}
