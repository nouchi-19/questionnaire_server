package jp.ac.dendai.sie.usd.student.adapter.controllers;

import jp.ac.dendai.sie.usd.student.model.request.UserInformationReq;
import jp.ac.dendai.sie.usd.student.model.response.QuestionnaireRes;

import java.util.List;

/**
 * Created by guest1 on 2018/10/25.
 */
public interface QuestionnaireController {
    List<QuestionnaireRes> getQuestionnaireList(Long subjectId, UserInformationReq userInformationReq);
    QuestionnaireRes getQuestionnaire(Long subjectId, Long questionnaireId, UserInformationReq userInformationReq);
}
