package jp.ac.dendai.sie.usd.student.adapter.controllers;

import jp.ac.dendai.sie.usd.student.adapter.mappers.UserInformationMapper;
import jp.ac.dendai.sie.usd.student.model.request.UserInformationReq;
import jp.ac.dendai.sie.usd.student.model.response.AggregateRes;
import jp.ac.dendai.sie.usd.student.usecase.service.GetAggregateService;
import jp.ac.dendai.sie.usd.student.usecase.service.GetSubjectService;

import javax.inject.Inject;

public class AggregateControllerImp implements AggregateController{
    @Inject
    GetSubjectService getSubjectService;

    @Inject
    GetAggregateService getAggregateService;

    @Inject
    UserInformationMapper userInformationMapper;

    @Override
    public AggregateRes getAggregate(Long subjectId, Long questionnaireId, UserInformationReq userInformationReq) {
        getSubjectService.tryGet(subjectId, userInformationMapper.toDomain(userInformationReq));
        return getAggregateService.getAggregate(subjectId, questionnaireId, userInformationMapper.toDomain(userInformationReq));
    }
}
