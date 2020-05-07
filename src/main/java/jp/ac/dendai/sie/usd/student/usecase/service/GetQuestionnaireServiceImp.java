package jp.ac.dendai.sie.usd.student.usecase.service;

import jp.ac.dendai.sie.usd.domain.model.*;
import jp.ac.dendai.sie.usd.student.model.response.QuestionnaireRes;
import jp.ac.dendai.sie.usd.student.usecase.presenter.QuestionnairePresenter;
import jp.ac.dendai.sie.usd.student.usecase.repository.QuestionRepository;
import jp.ac.dendai.sie.usd.student.usecase.repository.QuestionnaireRepository;
import jp.ac.dendai.sie.usd.student.usecase.repository.ResultRepository;
import jp.ac.dendai.sie.usd.student.usecase.repository.SubjectRepository;

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
    ResultRepository resultRepository;

    @Inject
    QuestionnairePresenter questionnairePresenter;

    @Override
    public List<QuestionnaireRes> getQuestionnaireList(Long subjectId, User student) {
        List<Questionnaire> questionnaireList = questionnaireRepository.findAnyBySubjectId(subjectId);
        Subject subject = subjectRepository.findBySubjectId(subjectId).orElseThrow(() -> new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity("指定したsubjectIdが存在しません.").build()));
        List<Question> questionList = questionRepository.findAnyBySubjectId(subjectId);
        List<Result> resultList = resultRepository.findAnyBySubjectIdAndStudentId(subjectId, student.getUserId());
        return questionnairePresenter.toQuestionnaireRes(questionnaireList, subject, questionList, resultList);
    }

    @Override
    public QuestionnaireRes getQuestionnaire(Long subjectId, Long questionnaireId, User student) {
        Questionnaire questionnaire = this.tryGet(subjectId, questionnaireId);
        Subject subject = subjectRepository.findBySubjectId(subjectId).orElseThrow(() -> new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity("指定したsubjectIdが存在しません.").build()));
        List<Question> questionList = questionRepository.findAnyByQuestionnaireId(questionnaireId);
        List<Result> resultList = resultRepository.findAnyByQuestionnaireIdAndStudentId(questionnaireId, student.getUserId());
        return questionnairePresenter.toQuestionnaireRes(questionnaire, subject, questionList, resultList);
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
