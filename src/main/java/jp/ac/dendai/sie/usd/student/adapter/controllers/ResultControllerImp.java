package jp.ac.dendai.sie.usd.student.adapter.controllers;

import jp.ac.dendai.sie.usd.domain.model.Answer;
import jp.ac.dendai.sie.usd.student.adapter.mappers.AnswerMapper;
import jp.ac.dendai.sie.usd.student.adapter.mappers.ResultMapper;
import jp.ac.dendai.sie.usd.student.adapter.mappers.UserInformationMapper;
import jp.ac.dendai.sie.usd.student.model.request.ResultReq;
import jp.ac.dendai.sie.usd.student.model.request.UserInformationReq;
import jp.ac.dendai.sie.usd.student.model.response.ResultRes;
import jp.ac.dendai.sie.usd.student.usecase.service.CreateResultService;
import jp.ac.dendai.sie.usd.student.usecase.service.GetQuestionnaireService;
import jp.ac.dendai.sie.usd.student.usecase.service.GetResultService;
import jp.ac.dendai.sie.usd.student.usecase.service.GetSubjectService;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by guest1 on 2018/10/26.
 */
public class ResultControllerImp implements ResultController{

    @Inject
    GetSubjectService getSubjectService;

    @Inject
    GetQuestionnaireService getQuestionnaireService;

    @Inject
    GetResultService getResultService;

    @Inject
    CreateResultService createResultService;

    @Inject
    UserInformationMapper userInformationMapper;

    @Inject
    ResultMapper resultMapper;

    @Inject
    AnswerMapper answerMapper;

    @Override
    public Long createResult(Long subjectId, Long questionnaireId, ResultReq resultReq, UserInformationReq userInformationReq) {
        getSubjectService.tryGet(subjectId, userInformationMapper.toDomain(userInformationReq));
        getQuestionnaireService.tryGet(subjectId, questionnaireId);
        List<Answer> answerList = resultReq.getAnswerList().stream().map(answerReq -> answerMapper.toDomain(answerReq)).collect(Collectors.toList());
        return createResultService.insert(resultMapper.toDomain(questionnaireId, userInformationReq), answerList);
    }

    @Override
    public List<ResultRes> getResultList(Long subjectId, Long questionnaireId, UserInformationReq userInformationReq) {
        getSubjectService.tryGet(subjectId, userInformationMapper.toDomain(userInformationReq));
        return getResultService.getResultList(subjectId, questionnaireId, userInformationMapper.toDomain(userInformationReq));
    }

    @Override
    public ResultRes getResult(Long subjectId, Long questionnaireId, Long resultId, UserInformationReq userInformationReq) {
        getSubjectService.tryGet(subjectId, userInformationMapper.toDomain(userInformationReq));
        return getResultService.getResult(subjectId, questionnaireId, resultId, userInformationMapper.toDomain(userInformationReq));
    }
}
