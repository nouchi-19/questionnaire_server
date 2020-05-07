package jp.ac.dendai.sie.usd.student.adapter.controllers;

import jp.ac.dendai.sie.usd.student.adapter.mappers.UserInformationMapper;
import jp.ac.dendai.sie.usd.student.model.response.SimpleQuestionRes;
import jp.ac.dendai.sie.usd.student.usecase.service.GetSimpleQuestionService;
import jp.ac.dendai.sie.usd.student.model.request.UserInformationReq;

import javax.inject.Inject;
import java.util.List;

public class SimpleQuestionControllerImp implements SimpleQuestionController{

    @Inject
    GetSimpleQuestionService getSimpleQuestionService;

    @Inject
    UserInformationMapper userInformationMapper;

    @Override
    public List<SimpleQuestionRes> getSimpleQuestionsNoAnswer(Long subjectId, UserInformationReq userInformationReq, Boolean answered) {
        return getSimpleQuestionService.getSimpleQuestionListNoAnswer(subjectId, userInformationMapper.toDomain(userInformationReq), answered);
    }

    @Override
    public List<SimpleQuestionRes> getSimpleQuestions(Long subjectId, Long questionnaireId, UserInformationReq userInformationReq) {
        return getSimpleQuestionService.getSimpleQuestionList(questionnaireId);
    }
}
