package jp.ac.dendai.sie.usd.teacher.adapter.mappers;

import jp.ac.dendai.sie.usd.domain.model.QuestionType;
import jp.ac.dendai.sie.usd.domain.model.SimpleQuestion;
import jp.ac.dendai.sie.usd.teacher.model.request.SimpleQuestionReq;
import jp.ac.dendai.sie.usd.teacher.model.response.SimpleQuestionRes;

import java.time.LocalDateTime;

public class SimpleQuestionMapperImp implements SimpleQuestionMapper {
    @Override
    public SimpleQuestion toDomain(Long questionnaireId, SimpleQuestionReq simpleQuestionReq) {
        return new SimpleQuestion(
                null,
                simpleQuestionReq.getQuestionTitle(),
                QuestionType.valueOf(simpleQuestionReq.getQuestionType()),
                simpleQuestionReq.getOptionList(),
                TimeGetter.getNowTime(),
                questionnaireId
        );
    }

    @Override
    public SimpleQuestionRes toRes(SimpleQuestion simpleQuestion) {
        return new SimpleQuestionRes(
                simpleQuestion.getSimpleQuestionId(),
                simpleQuestion.getQuestionTitle(),
                simpleQuestion.getQuestionType().toString(),
                simpleQuestion.getOptionList()
        );
    }
}
