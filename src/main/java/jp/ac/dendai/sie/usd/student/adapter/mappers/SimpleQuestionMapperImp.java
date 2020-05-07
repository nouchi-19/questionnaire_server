package jp.ac.dendai.sie.usd.student.adapter.mappers;

import jp.ac.dendai.sie.usd.domain.model.SimpleQuestion;
import jp.ac.dendai.sie.usd.student.model.response.SimpleQuestionRes;

public class SimpleQuestionMapperImp implements SimpleQuestionMapper{
    @Override
    public SimpleQuestionRes toRes(SimpleQuestion simpleQuestion) {
        return new SimpleQuestionRes(
                simpleQuestion.getSimpleQuestionId(),
                simpleQuestion.getQuestionTitle(),
                simpleQuestion.getQuestionType().toString(),
                simpleQuestion.getOptionList(),
                simpleQuestion.getQuestionnaireId()
        );
    }
}
