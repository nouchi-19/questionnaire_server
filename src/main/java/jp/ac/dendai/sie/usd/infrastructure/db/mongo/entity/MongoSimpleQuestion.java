package jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity;


import jp.ac.dendai.sie.usd.domain.model.QuestionType;
import jp.ac.dendai.sie.usd.domain.model.SimpleQuestion;
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
public class MongoSimpleQuestion {
    @Id
    private Long simpleQuestionId;
    private String questionTitle;
    private String questionType;
    private List<String> optionList;
    private LocalDateTime createTime;
    private Long questionnaireId;

    public SimpleQuestion toDomain() {
        return new SimpleQuestion(
                this.simpleQuestionId,
                this.questionTitle,
                QuestionType.valueOf(this.questionType),
                this.optionList,
                this.createTime,
                this.questionnaireId
        );
    }

    public static MongoSimpleQuestion fromDomain(SimpleQuestion simpleQuestion) {
        return new MongoSimpleQuestion(
                simpleQuestion.getSimpleQuestionId(),
                simpleQuestion.getQuestionTitle(),
                simpleQuestion.getQuestionType().toString(),
                simpleQuestion.getOptionList(),
                simpleQuestion.getCreateTime(),
                simpleQuestion.getQuestionnaireId()
        );
    }
}
