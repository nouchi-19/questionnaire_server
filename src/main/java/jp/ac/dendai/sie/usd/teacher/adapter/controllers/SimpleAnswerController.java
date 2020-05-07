package jp.ac.dendai.sie.usd.teacher.adapter.controllers;

import jp.ac.dendai.sie.usd.teacher.model.request.UserInformationReq;
import jp.ac.dendai.sie.usd.teacher.model.response.SimpleAnswerRes;

import java.util.List;

public interface SimpleAnswerController {
    List<SimpleAnswerRes> getSimpleAnswers(Long subjectId, Long questionnaireId, UserInformationReq userInformationReq);
}
