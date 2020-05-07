package jp.ac.dendai.sie.usd.student.usecase.service;

import jp.ac.dendai.sie.usd.domain.model.*;
import jp.ac.dendai.sie.usd.student.model.response.SubjectRes;
import jp.ac.dendai.sie.usd.student.usecase.presenter.SubjectPresenter;
import jp.ac.dendai.sie.usd.student.usecase.repository.QuestionRepository;
import jp.ac.dendai.sie.usd.student.usecase.repository.QuestionnaireRepository;
import jp.ac.dendai.sie.usd.student.usecase.repository.ResultRepository;
import jp.ac.dendai.sie.usd.student.usecase.repository.SubjectRepository;

import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;

public class GetSubjectServiceImp implements GetSubjectService {
    @Inject
    SubjectRepository subjectRepository;

    @Inject
    QuestionnaireRepository questionnaireRepository;

    @Inject
    QuestionRepository questionRepository;

    @Inject
    ResultRepository resultRepository;

    @Inject
    SubjectPresenter subjectPresenter;

    @Override
    public List<SubjectRes> getSubjectList(User student) {
        List<Subject> subjectList = subjectRepository.findAnyByStudentId(student.getUserId());
        List<Questionnaire> questionnaires = questionnaireRepository.findAnyByStudentId(student.getUserId());
        List<Question> questionList = questionRepository.findAnyByStudentId(student.getUserId());
        List<Result> resultList = resultRepository.findAnyByStudentId(student.getUserId());
//        System.out.println("kokokokokoko");
//        System.out.println(subjectList);
//        System.out.println(questionnaires);
//        System.out.println(questionList);
//        System.out.println(resultList);
        return subjectPresenter.toSubjectRes(subjectList, questionnaires, questionList, resultList);
    }

    @Override
    public SubjectRes getSubject(Long subjectId, User student) {
        Subject subject = this.tryGet(subjectId, student);
        List<Questionnaire> questionnaires = questionnaireRepository.findAnyBySubjectId(subjectId);
        List<Question> questionList = questionRepository.findAnyBySubjectId(subjectId);
        List<Result> resultList = resultRepository.findAnyBySubjectIdAndStudentId(subjectId, student.getUserId());
        return subjectPresenter.toSubjectRes(subject, questionnaires, questionList, resultList);
    }

    @Override
    public Subject tryGet(Long subjectId, User student) {
        Subject subject = subjectRepository.findBySubjectId(subjectId)
                .orElseThrow(() -> new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity("指定したsubjectIdが存在しません.").build()));
        //権限確認するならここ
        return subject;
    }
}
