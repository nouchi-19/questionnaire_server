package jp.ac.dendai.sie.usd.teacher.usecase.service;

import jp.ac.dendai.sie.usd.domain.model.*;
import jp.ac.dendai.sie.usd.teacher.model.response.ResultRes;
import jp.ac.dendai.sie.usd.teacher.usecase.presenter.ResultPresenter;
import jp.ac.dendai.sie.usd.teacher.usecase.repository.*;

import javax.inject.Inject;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by guest1 on 2018/10/26.
 */
public class GetResultServiceImp implements GetResultService {

    @Inject
    SubjectRepository subjectRepository;

    @Inject
    QuestionnaireRepository questionnaireRepository;

    @Inject
    QuestionRepository questionRepository;

    @Inject
    ResultRepository resultRepository;

    @Inject
    AnswerRepository answerRepository;

    @Inject
    ResultPresenter resultPresenter;

    @Override
    public List<ResultRes> getResultList(Long subjectId, Long questionnaireId) {
        Subject subject = subjectRepository.findBySubjectId(subjectId).orElseThrow(() -> new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity("指定したsubjectIdが存在しません.").build()));
        Questionnaire questionnaire = questionnaireRepository.findByQuestionnaireId(questionnaireId).orElseThrow(() -> new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity("指定したquestionnaireIdが存在しません.").build()));
        List<Question> questionList = questionRepository.findAnyByQuestionnaireId(questionnaireId);
        List<Result> resultList = resultRepository.findAnyByQuestionnaireId(questionnaireId);
        List<Answer> answerList = answerRepository.findAnyByQuestionnaireId(questionnaireId);
        System.out.println("ddddddddddddddddddddddd");
        System.out.println(resultList);
        System.out.println(answerList);
        return resultPresenter.toResultRes(resultList, questionnaire, subject, questionList, answerList);
    }

    @Override
    public ResultRes getResult(Long subjectId, Long questionnaireId, Long resultId) {
        Subject subject = subjectRepository.findBySubjectId(subjectId).orElseThrow(() -> new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity("指定したsubjectIdが存在しません.").build()));
        Questionnaire questionnaire = questionnaireRepository.findByQuestionnaireId(questionnaireId).orElseThrow(() -> new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity("指定したquestionnaireIdが存在しません.").build()));
        List<Question> questionList = questionRepository.findAnyByQuestionnaireId(questionnaireId);
        Result result = tryGet(questionnaireId, resultId);
        List<Answer> answerList = answerRepository.findAnyByResultId(resultId);
        return resultPresenter.toResultRes(result, questionnaire,subject, questionList, answerList);
    }

    @Override
    public Result tryGet(Long questionnaireId, Long resultId) {
        Result result = resultRepository.findByResultId(resultId)
                .orElseThrow(() -> new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity("指定したresultIdが存在しません.").build()));
        if(!result.getQuestionnaireId().equals(resultId)) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity("指定したquestionnaireIdが存在しません.").build());
        }
//        if(!result.getStudent().equals(student)) {
//            throw new ForbiddenException("他人の回答を閲覧することは禁止されています");
//        }
        return result;
    }
}
