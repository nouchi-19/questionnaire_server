package jp.ac.dendai.sie.usd.teacher.adapter.controllers;

import jp.ac.dendai.sie.usd.teacher.model.request.QuestionnaireReq;
import jp.ac.dendai.sie.usd.teacher.model.request.UserInformationReq;
import jp.ac.dendai.sie.usd.teacher.model.response.QuestionnaireRes;

import java.util.List;

/**
 * Created by guest1 on 2018/10/25.
 */
public interface QuestionnaireController {
    Long createQuestionnaire(Long subjectId, QuestionnaireReq questionnaireReq, UserInformationReq userInformationReq);
    Long updateRelease(Long subjectId, Long questionnaireId, Boolean release);
    List<QuestionnaireRes> getQuestionnaireList(Long subjectId, UserInformationReq userInformationReq);
    QuestionnaireRes getQuestionnaire(Long subjectId, Long questionnaireId, UserInformationReq userInformationReq);
    void delete(Long questionnaireId);
}
