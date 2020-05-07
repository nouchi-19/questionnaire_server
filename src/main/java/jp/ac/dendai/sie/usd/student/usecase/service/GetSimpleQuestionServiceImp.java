package jp.ac.dendai.sie.usd.student.usecase.service;

import jp.ac.dendai.sie.usd.domain.model.SimpleQuestion;
import jp.ac.dendai.sie.usd.domain.model.User;
import jp.ac.dendai.sie.usd.student.model.response.SimpleQuestionRes;
import jp.ac.dendai.sie.usd.student.usecase.presenter.SimpleQuestionPresenter;
import jp.ac.dendai.sie.usd.student.usecase.repository.SimpleQuestionRepository;

import javax.inject.Inject;
import java.util.List;

public class GetSimpleQuestionServiceImp implements GetSimpleQuestionService{

    @Inject
    SimpleQuestionRepository simpleQuestionRepository;

    @Inject
    SimpleQuestionPresenter simpleQuestionPresenter;


    @Override
    public List<SimpleQuestionRes> getSimpleQuestionListNoAnswer(Long subjectId, User student, Boolean answered) {
        if(answered) {
            return simpleQuestionPresenter.toSimpleQuestionRes(simpleQuestionRepository.findAnyBySubjectId(subjectId));
        }
        return simpleQuestionPresenter.toSimpleQuestionRes(simpleQuestionRepository.findAnyBySubjectIdAndNoAnswerStudentId(subjectId, student.getUserId()));
    }

    @Override
    public List<SimpleQuestionRes> getSimpleQuestionList(Long questionnaireId) {
        return simpleQuestionPresenter.toSimpleQuestionRes(simpleQuestionRepository.findAnyByQuestionnaireId(questionnaireId));
    }
}
