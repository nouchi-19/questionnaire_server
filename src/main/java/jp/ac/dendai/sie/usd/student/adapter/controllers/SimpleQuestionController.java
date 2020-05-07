package jp.ac.dendai.sie.usd.student.adapter.controllers;

import jp.ac.dendai.sie.usd.domain.model.SimpleQuestion;
import jp.ac.dendai.sie.usd.student.model.response.SimpleQuestionRes;
import jp.ac.dendai.sie.usd.student.model.request.UserInformationReq;

import java.util.List;

public interface SimpleQuestionController {
    List<SimpleQuestionRes> getSimpleQuestionsNoAnswer(Long subjectId, UserInformationReq userInformationReq, Boolean answered);
    List<SimpleQuestionRes> getSimpleQuestions(Long subjectId,Long questionnaireId, UserInformationReq userInformationReq);
}
