package jp.ac.dendai.sie.usd.student.adapter.mappers;

import jp.ac.dendai.sie.usd.domain.model.SimpleAnswer;
import jp.ac.dendai.sie.usd.student.model.request.SimpleAnswerReq;
import jp.ac.dendai.sie.usd.student.model.request.UserInformationReq;
import jp.ac.dendai.sie.usd.student.model.response.SimpleAnswerRes;
import jp.ac.dendai.sie.usd.student.model.response.SimpleQuestionRes;

public interface SimpleAnswerMapper {
    SimpleAnswer toDomain(Long questionnaireId, SimpleAnswerReq simpleAnswerReq, UserInformationReq userInformationReq);
    SimpleAnswerRes toRes(SimpleAnswer simpleAnswer, SimpleQuestionRes simpleQuestionRes);

}
