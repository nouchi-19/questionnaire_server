package jp.ac.dendai.sie.usd.student.adapter.mappers;

import jp.ac.dendai.sie.usd.domain.model.SimpleAnswer;
import jp.ac.dendai.sie.usd.student.model.request.SimpleAnswerReq;
import jp.ac.dendai.sie.usd.student.model.request.UserInformationReq;
import jp.ac.dendai.sie.usd.student.model.response.SimpleAnswerRes;
import jp.ac.dendai.sie.usd.student.model.response.SimpleQuestionRes;

import java.time.LocalDateTime;

public class SimpleAnswerMapperImp implements SimpleAnswerMapper{


    @Override
    public SimpleAnswer toDomain(Long questionnaireId, SimpleAnswerReq simpleAnswerReq, UserInformationReq userInformationReq) {
        return new SimpleAnswer(
                null,
                simpleAnswerReq.getResponses(),
                TimeGetter.getNowTime(),
                new UserInformationMapperImp().toDomain(userInformationReq),
                simpleAnswerReq.getSimpleQuestionId(),
                questionnaireId
        );
    }

    @Override
    public SimpleAnswerRes toRes(SimpleAnswer simpleAnswer, SimpleQuestionRes simpleQuestionRes) {
        return new SimpleAnswerRes(
                simpleAnswer.getSimpleAnswerId(),
                simpleQuestionRes,
                simpleAnswer.getResponses(),
                simpleAnswer.getResponseTime()
        );
    }
}
