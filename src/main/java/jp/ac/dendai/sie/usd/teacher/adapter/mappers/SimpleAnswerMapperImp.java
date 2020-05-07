package jp.ac.dendai.sie.usd.teacher.adapter.mappers;

import jp.ac.dendai.sie.usd.domain.model.SimpleAnswer;
import jp.ac.dendai.sie.usd.teacher.model.response.SimpleAnswerRes;
import jp.ac.dendai.sie.usd.teacher.model.response.SimpleQuestionRes;

import java.time.LocalDateTime;

public class SimpleAnswerMapperImp implements SimpleAnswerMapper {


    @Override
    public SimpleAnswerRes toRes(SimpleAnswer simpleAnswer, SimpleQuestionRes simpleQuestionRes) {
        return new SimpleAnswerRes(
                simpleAnswer.getSimpleAnswerId(),
                simpleQuestionRes,
                simpleAnswer.getResponses(),
                simpleAnswer.getResponseTime(),
                new UserInformationMapperImp().toRes(simpleAnswer.getStudent())
        );
    }
}
