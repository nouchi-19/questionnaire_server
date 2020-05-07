package jp.ac.dendai.sie.usd.teacher.adapter.controllers;

import jp.ac.dendai.sie.usd.domain.model.Question;
import jp.ac.dendai.sie.usd.teacher.adapter.mappers.QuestionMapper;
import jp.ac.dendai.sie.usd.teacher.adapter.mappers.QuestionnaireMapper;
import jp.ac.dendai.sie.usd.teacher.model.request.QuestionnaireReq;
import jp.ac.dendai.sie.usd.teacher.model.request.UserInformationReq;
import jp.ac.dendai.sie.usd.teacher.model.response.QuestionnaireRes;
import jp.ac.dendai.sie.usd.teacher.adapter.mappers.UserInformationMapper;
import jp.ac.dendai.sie.usd.teacher.usecase.service.CreateQuestionnaireService;
import jp.ac.dendai.sie.usd.teacher.usecase.service.DeleteQuestionnaireService;
import jp.ac.dendai.sie.usd.teacher.usecase.service.GetQuestionnaireService;
import jp.ac.dendai.sie.usd.teacher.usecase.service.GetSubjectService;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionnaireControllerImp implements QuestionnaireController {

    @Inject
    CreateQuestionnaireService createQuestionnaireService;

    @Inject
    GetSubjectService getSubjectService;

    @Inject
    GetQuestionnaireService getQuestionnaireService;

    @Inject
    QuestionnaireMapper questionnaireMapper;

    @Inject
    QuestionMapper questionMapper;

    @Inject
    UserInformationMapper userInformationMapper;

    @Inject
    DeleteQuestionnaireService deleteQuestionnaireService;


    @Override
    public Long createQuestionnaire(Long subjectId, QuestionnaireReq questionnaireReq, UserInformationReq userInformationReq) {
        List<Question> questionList = questionnaireReq.getQuestionList().stream().map(questionReq -> questionMapper.toDomain(questionReq)).collect(Collectors.toList());
        return createQuestionnaireService.insert(questionnaireMapper.toDomain(subjectId, questionnaireReq), questionList);
    }

    @Override
    public Long updateRelease(Long subjectId, Long questionnaireId, Boolean release) {
        return createQuestionnaireService.updateRelease(questionnaireId, release);
    }

    @Override
    public List<QuestionnaireRes> getQuestionnaireList(Long subjectId, UserInformationReq userInformationReq) {
        getSubjectService.tryGet(subjectId, userInformationMapper.toDomain(userInformationReq));
        return getQuestionnaireService.getQuestionnaireList(subjectId);
    }

    @Override
    public QuestionnaireRes getQuestionnaire(Long subjectId, Long questionnaireId, UserInformationReq userInformationReq) {
        getSubjectService.tryGet(subjectId, userInformationMapper.toDomain(userInformationReq));
        return getQuestionnaireService.getQuestionnaire(subjectId, questionnaireId);
    }

    @Override
    public void delete(Long questionnaireId) {
        deleteQuestionnaireService.delete(questionnaireId);
    }
}
