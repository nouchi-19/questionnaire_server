package jp.ac.dendai.sie.usd.student.adapter.controllers;

import jp.ac.dendai.sie.usd.student.model.request.SimpleAnswerReq;
import jp.ac.dendai.sie.usd.student.model.request.UserInformationReq;
import jp.ac.dendai.sie.usd.student.model.response.SimpleAnswerRes;

import java.util.List;

public interface SimpleAnswerController {
    Long createSimpleAnswer(Long subjectId,Long questionnaireId, SimpleAnswerReq simpleAnswerReq, UserInformationReq userInformationReq);
    List<SimpleAnswerRes> getSimpleAnswers(Long subjectId, Long questionnaireId, UserInformationReq userInformationReq);
    List<SimpleAnswerRes> getSimpleAnswersAggregate(Long subjectId, Long questionnaireId, UserInformationReq userInformationReq);
}
