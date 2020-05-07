package jp.ac.dendai.sie.usd.teacher.adapter.controllers;

import jp.ac.dendai.sie.usd.teacher.model.request.UserInformationReq;
import jp.ac.dendai.sie.usd.teacher.model.response.ResultRes;
import jp.ac.dendai.sie.usd.teacher.adapter.mappers.AnswerMapper;
import jp.ac.dendai.sie.usd.teacher.adapter.mappers.ResultMapper;
import jp.ac.dendai.sie.usd.teacher.adapter.mappers.UserInformationMapper;
import jp.ac.dendai.sie.usd.teacher.usecase.service.GetQuestionnaireService;
import jp.ac.dendai.sie.usd.teacher.usecase.service.GetResultService;
import jp.ac.dendai.sie.usd.teacher.usecase.service.GetSubjectService;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by guest1 on 2018/10/26.
 */
public class ResultControllerImp implements ResultController {

    @Inject
    GetSubjectService getSubjectService;

    @Inject
    GetQuestionnaireService getQuestionnaireService;

    @Inject
    GetResultService getResultService;

    @Inject
    UserInformationMapper userInformationMapper;

    @Inject
    ResultMapper resultMapper;

    @Inject
    AnswerMapper answerMapper;

    @Override
    public List<ResultRes> getResultList(Long subjectId, Long questionnaireId, UserInformationReq userInformationReq) {
        getSubjectService.tryGet(subjectId, userInformationMapper.toDomain(userInformationReq));
        return getResultService.getResultList(subjectId, questionnaireId);
    }

    @Override
    public ResultRes getResult(Long subjectId, Long questionnaireId, Long resultId, UserInformationReq userInformationReq) {
        getSubjectService.tryGet(subjectId, userInformationMapper.toDomain(userInformationReq));
        return getResultService.getResult(subjectId, questionnaireId, resultId);
    }
}
