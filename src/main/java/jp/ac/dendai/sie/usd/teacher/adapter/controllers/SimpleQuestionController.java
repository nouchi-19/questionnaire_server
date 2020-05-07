package jp.ac.dendai.sie.usd.teacher.adapter.controllers;

import jp.ac.dendai.sie.usd.teacher.model.request.SimpleQuestionReq;
import jp.ac.dendai.sie.usd.teacher.model.request.UserInformationReq;
import jp.ac.dendai.sie.usd.teacher.model.response.SimpleQuestionRes;

import java.util.List;

public interface SimpleQuestionController {
    Long createSimpleQuestion(Long subjectId, Long questionnaireId, SimpleQuestionReq simpleQuestionReq, UserInformationReq userInformationReq);
    List<SimpleQuestionRes> getSimpleQuestions(Long subjectId, Long questionnaireId, UserInformationReq userInformationReq);
}
