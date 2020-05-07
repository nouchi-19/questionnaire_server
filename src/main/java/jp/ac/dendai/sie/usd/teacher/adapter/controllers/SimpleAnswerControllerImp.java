package jp.ac.dendai.sie.usd.teacher.adapter.controllers;

import jp.ac.dendai.sie.usd.teacher.adapter.mappers.UserInformationMapper;
import jp.ac.dendai.sie.usd.teacher.model.request.UserInformationReq;
import jp.ac.dendai.sie.usd.teacher.model.response.SimpleAnswerRes;
import jp.ac.dendai.sie.usd.teacher.usecase.service.GetSimpleAnswerService;

import javax.inject.Inject;
import java.util.List;

public class SimpleAnswerControllerImp implements SimpleAnswerController {

    @Inject
    GetSimpleAnswerService getSimpleAnswerService;

    @Inject
    UserInformationMapper userInformationMapper;

    @Override
    public List<SimpleAnswerRes> getSimpleAnswers(Long subjectId, Long questionnaireId, UserInformationReq userInformationReq) {
        return getSimpleAnswerService.getSimpleAnswerList(questionnaireId, userInformationMapper.toDomain(userInformationReq));
    }
}
