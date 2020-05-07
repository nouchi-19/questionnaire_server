package jp.ac.dendai.sie.usd.student.adapter.controllers;

import jp.ac.dendai.sie.usd.student.adapter.mappers.UserInformationMapper;
import jp.ac.dendai.sie.usd.student.model.request.UserInformationReq;
import jp.ac.dendai.sie.usd.student.model.response.QuestionnaireRes;
import jp.ac.dendai.sie.usd.student.usecase.service.GetQuestionnaireService;
import jp.ac.dendai.sie.usd.student.usecase.service.GetSubjectService;

import javax.inject.Inject;
import java.util.List;

public class QuestionnaireControllerImp implements QuestionnaireController{

    @Inject
    GetSubjectService getSubjectService;

    @Inject
    GetQuestionnaireService getQuestionnaireService;

    @Inject
    UserInformationMapper userInformationMapper;

    @Override
    public List<QuestionnaireRes> getQuestionnaireList(Long subjectId, UserInformationReq userInformationReq) {
        getSubjectService.tryGet(subjectId, userInformationMapper.toDomain(userInformationReq));
        return getQuestionnaireService.getQuestionnaireList(subjectId, userInformationMapper.toDomain(userInformationReq));
    }

    @Override
    public QuestionnaireRes getQuestionnaire(Long subjectId, Long questionnaireId, UserInformationReq userInformationReq) {
        getSubjectService.tryGet(subjectId, userInformationMapper.toDomain(userInformationReq));
        return getQuestionnaireService.getQuestionnaire(subjectId, questionnaireId, userInformationMapper.toDomain(userInformationReq));
    }
}
