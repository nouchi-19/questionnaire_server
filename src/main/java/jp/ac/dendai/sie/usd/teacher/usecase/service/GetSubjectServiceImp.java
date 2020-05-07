package jp.ac.dendai.sie.usd.teacher.usecase.service;

import jp.ac.dendai.sie.usd.domain.model.*;
import jp.ac.dendai.sie.usd.teacher.model.response.SubjectRes;
import jp.ac.dendai.sie.usd.teacher.usecase.presenter.SubjectPresenter;
import jp.ac.dendai.sie.usd.teacher.usecase.repository.QuestionRepository;
import jp.ac.dendai.sie.usd.teacher.usecase.repository.QuestionnaireRepository;
import jp.ac.dendai.sie.usd.teacher.usecase.repository.ResultRepository;
import jp.ac.dendai.sie.usd.teacher.usecase.repository.SubjectRepository;

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
    public List<SubjectRes> getSubjectList(User teacher) {
        List<Subject> subjectList = subjectRepository.findAnyByTeacherId(teacher.getUserId());
        List<Questionnaire> questionnaires = questionnaireRepository.findAnyByTeacherId(teacher.getUserId());
        List<Question> questionList = questionRepository.findAnyByTeacherId(teacher.getUserId());
//        System.out.println("kokokokokoko");
//        System.out.println(subjectList);
//        System.out.println(questionnaires);
//        System.out.println(questionList);
//        System.out.println(resultList);
        return subjectPresenter.toSubjectRes(subjectList, questionnaires, questionList);
    }

    @Override
    public SubjectRes getSubject(Long subjectId, User teacher) {
        Subject subject = this.tryGet(subjectId, teacher);
        List<Questionnaire> questionnaires = questionnaireRepository.findAnyBySubjectId(subjectId);
        List<Question> questionList = questionRepository.findAnyBySubjectId(subjectId);
        return subjectPresenter.toSubjectRes(subject, questionnaires, questionList);
    }

    @Override
    public Subject tryGet(Long subjectId, User student) {
        Subject subject = subjectRepository.findBySubjectId(subjectId)
                .orElseThrow(() -> new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity("指定したsubjectIdが存在しません.").build()));
        //権限確認するならここ
        return subject;
    }
}
