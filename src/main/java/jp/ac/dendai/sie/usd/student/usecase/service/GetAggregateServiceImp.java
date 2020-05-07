package jp.ac.dendai.sie.usd.student.usecase.service;

import jp.ac.dendai.sie.usd.domain.model.*;
import jp.ac.dendai.sie.usd.student.model.response.AggregateRes;
import jp.ac.dendai.sie.usd.student.usecase.presenter.AggregatePresenter;
import jp.ac.dendai.sie.usd.student.usecase.repository.*;

import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import java.util.List;
import java.util.Optional;

public class GetAggregateServiceImp implements GetAggregateService{
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
    AggregatePresenter aggregatePresenter;

    @Override
    public AggregateRes getAggregate(Long subjectId, Long questionnaireId, User student) {
        Optional<Subject> subjectOptional = subjectRepository.findBySubjectId(subjectId);
        Subject subject = subjectOptional.orElseThrow(() -> new BadRequestException("subjectIdが存在しません"));
        Optional<Questionnaire> questionnaireOptional = questionnaireRepository.findByQuestionnaireId(questionnaireId);
        Questionnaire questionnaire = questionnaireOptional.orElseThrow(() -> new BadRequestException("questionnaireIdが存在しません"));
        List<Question> questionList = questionRepository.findAnyByQuestionnaireId(questionnaireId);
        List<Result> resultList = resultRepository.findAnyByQuestionnaireIdAndStudentId(questionnaireId, student.getUserId());
        List<Answer> answerList = answerRepository.findAnyByQuestionnaireIdNewAnswers(questionnaireId);
        Long courseNumber = subjectRepository.courseNumber(subjectId);
        return aggregatePresenter.toRes(subject, questionnaire, questionList,resultList, answerList, courseNumber);
    }
}
