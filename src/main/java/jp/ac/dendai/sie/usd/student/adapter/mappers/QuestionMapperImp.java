package jp.ac.dendai.sie.usd.student.adapter.mappers;

import jp.ac.dendai.sie.usd.domain.model.Question;
import jp.ac.dendai.sie.usd.student.model.response.QuestionRes;

/**
 * Created by guest1 on 2018/10/26.
 */
public class QuestionMapperImp implements QuestionMapper{

    @Override
    public QuestionRes toRes(Question question) {
        return new QuestionRes(
                question.getQuestionId(),
                question.getQuestionNumber(),
                question.getQuestionTitle(),
                question.getRequired(),
                question.getQuestionType().toString(),
                question.getOptionList()
        );
    }
}
