package jp.ac.dendai.sie.usd.student.adapter.controllers;

import jp.ac.dendai.sie.usd.student.adapter.mappers.SimpleAnswerMapper;
import jp.ac.dendai.sie.usd.student.adapter.mappers.UserInformationMapper;
import jp.ac.dendai.sie.usd.student.model.request.SimpleAnswerReq;
import jp.ac.dendai.sie.usd.student.model.request.UserInformationReq;
import jp.ac.dendai.sie.usd.student.model.response.SimpleAnswerRes;
import jp.ac.dendai.sie.usd.student.usecase.service.CreateSimpleAnswerService;
import jp.ac.dendai.sie.usd.student.usecase.service.GetSimpleAnswerAggregateService;
import jp.ac.dendai.sie.usd.student.usecase.service.GetSimpleAnswerService;

import javax.inject.Inject;
import java.util.List;

public class SimpleAnswerControllerImp implements SimpleAnswerController{

    @Inject
    CreateSimpleAnswerService createSimpleAnswerService;

    @Inject
    GetSimpleAnswerService getSimpleAnswerService;

    @Inject
    GetSimpleAnswerAggregateService simpleAnswerAggregateService;

    @Inject
    SimpleAnswerMapper simpleAnswerMapper;

    @Inject
    UserInformationMapper userInformationMapper;

    @Override
    public Long createSimpleAnswer(Long subjectId, Long questionnaireId,  SimpleAnswerReq simpleAnswerReq, UserInformationReq userInformationReq) {
        return createSimpleAnswerService.insert(simpleAnswerMapper.toDomain(questionnaireId, simpleAnswerReq, userInformationReq));
    }

    @Override
    public List<SimpleAnswerRes> getSimpleAnswers(Long subjectId, Long questionnaireId, UserInformationReq userInformationReq) {
        return getSimpleAnswerService.getSimpleAnswerList(questionnaireId, userInformationMapper.toDomain(userInformationReq));
    }

    @Override
    public List<SimpleAnswerRes> getSimpleAnswersAggregate(Long subjectId, Long questionnaireId, UserInformationReq userInformationReq) {
        return simpleAnswerAggregateService.getSimpleAggregateResList(questionnaireId);
    }
}
