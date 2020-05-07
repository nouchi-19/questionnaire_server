package jp.ac.dendai.sie.usd.teacher.usecase.service;

import jp.ac.dendai.sie.usd.domain.model.*;
import jp.ac.dendai.sie.usd.teacher.model.response.QuestionnaireRes;
import jp.ac.dendai.sie.usd.teacher.usecase.presenter.QuestionnairePresenter;
import jp.ac.dendai.sie.usd.teacher.usecase.repository.QuestionRepository;
import jp.ac.dendai.sie.usd.teacher.usecase.repository.QuestionnaireRepository;
import jp.ac.dendai.sie.usd.teacher.usecase.repository.ResultRepository;
import jp.ac.dendai.sie.usd.teacher.usecase.repository.SubjectRepository;

import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by guest1 on 2018/10/25.
 */
public class GetQuestionnaireServiceImp implements GetQuestionnaireService {
    @Inject
    SubjectRepository subjectRepository;

    @Inject
    QuestionnaireRepository questionnaireRepository;

    @Inject
    QuestionRepository questionRepository;

    @Inject
    QuestionnairePresenter questionnairePresenter;

    @Override
    public List<QuestionnaireRes> getQuestionnaireList(Long subjectId) {
        List<Questionnaire> questionnaireList = questionnaireRepository.findAnyBySubjectId(subjectId);
        Subject subject = subjectRepository.findBySubjectId(subjectId).orElseThrow(() -> new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity("指定したsubjectIdが存在しません.").build()));
        List<Question> questionList = questionRepository.findAnyBySubjectId(subjectId);
        return questionnairePresenter.toQuestionnaireRes(questionnaireList, subject, questionList);
    }

    @Override
    public QuestionnaireRes getQuestionnaire(Long subjectId, Long questionnaireId) {
        Questionnaire questionnaire = this.tryGet(subjectId, questionnaireId);
        Subject subject = subjectRepository.findBySubjectId(subjectId).orElseThrow(() -> new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity("指定したsubjectIdが存在しません.").build()));
        List<Question> questionList = questionRepository.findAnyByQuestionnaireId(questionnaireId);
        return questionnairePresenter.toQuestionnaireRes(questionnaire, subject, questionList);
    }

    @Override
    public Questionnaire tryGet(Long subjectId, Long questionnaireId) {
        Questionnaire questionnaire = questionnaireRepository.findByQuestionnaireId(questionnaireId)
                .orElseThrow(() -> new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity("指定したquestionnaireIdが存在しません.").build()));
        if(!questionnaire.getSubjectId().equals(subjectId)) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity("指定したsubjectIdが存在しません.").build());
        }
        return questionnaire;
    }


}
