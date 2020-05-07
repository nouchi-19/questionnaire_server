package jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity;

import jp.ac.dendai.sie.usd.domain.model.Answer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MongoAnswer {
    @Id
    private Long answerId;
    private Long questionId;
    private List<String> responseList;
    private Long resultId;

    public Answer toDomain() {
        return new Answer(
                this.answerId,
                this.questionId,
                this.responseList,
                this.resultId
        );
    }

    public static MongoAnswer fromDomain(Answer answer) {
        return new MongoAnswer(
                answer.getAnswerId(),
                answer.getQuestionId(),
                answer.getResponseList(),
                answer.getResultId()
        );
    }
}
