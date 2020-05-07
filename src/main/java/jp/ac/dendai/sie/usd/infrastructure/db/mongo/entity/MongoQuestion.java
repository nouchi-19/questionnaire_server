package jp.ac.dendai.sie.usd.infrastructure.db.mongo.entity;

import jp.ac.dendai.sie.usd.domain.model.Question;
import jp.ac.dendai.sie.usd.domain.model.QuestionType;
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
public class MongoQuestion {
    @Id
    private Long questionId;
    private Long questionNumber;
    private String questionTitle;
    private Boolean required;
    private String questionType;
    private List<String> optionList;
    private Long questionnaireId;

    public Question toDomain() {
        return new Question(
                this.questionId,
                this.questionNumber,
                this.questionTitle,
                this.required,
                QuestionType.valueOf(this.questionType),
                this.optionList,
                this.questionnaireId
        );
    }

    public static MongoQuestion fromDomain(Question question) {
        return new MongoQuestion(
                question.getQuestionId(),
                question.getQuestionNumber(),
                question.getQuestionTitle(),
                question.getRequired(),
                question.getQuestionType().toString(),
                question.getOptionList(),
                question.getQuestionnaireId()
        );
    }
}
