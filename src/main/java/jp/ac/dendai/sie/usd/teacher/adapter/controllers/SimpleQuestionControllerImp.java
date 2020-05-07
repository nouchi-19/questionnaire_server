package jp.ac.dendai.sie.usd.teacher.adapter.controllers;

import jp.ac.dendai.sie.usd.teacher.adapter.mappers.SimpleQuestionMapper;
import jp.ac.dendai.sie.usd.teacher.adapter.mappers.UserInformationMapper;
import jp.ac.dendai.sie.usd.teacher.model.request.SimpleQuestionReq;
import jp.ac.dendai.sie.usd.teacher.model.request.UserInformationReq;
import jp.ac.dendai.sie.usd.teacher.model.response.SimpleQuestionRes;
import jp.ac.dendai.sie.usd.teacher.usecase.service.CreateSimpleQuestionService;
import jp.ac.dendai.sie.usd.teacher.usecase.service.GetSimpleQuestionService;

import javax.inject.Inject;
import java.util.List;

public class SimpleQuestionControllerImp implements SimpleQuestionController {

    @Inject
    GetSimpleQuestionService getSimpleQuestionService;

    @Inject
    CreateSimpleQuestionService createSimpleQuestionService;

    @Inject
    SimpleQuestionMapper simpleQuestionMapper;

    @Override
    public Long createSimpleQuestion(Long subjectId, Long questionnaireId, SimpleQuestionReq simpleQuestionReq, UserInformationReq userInformationReq) {
        return createSimpleQuestionService.insert(simpleQuestionMapper.toDomain(questionnaireId, simpleQuestionReq));
    }

    @Override
    public List<SimpleQuestionRes> getSimpleQuestions(Long subjectId, Long questionnaireId, UserInformationReq userInformationReq) {
        return getSimpleQuestionService.getSimpleQuestionList(questionnaireId);
    }
}
