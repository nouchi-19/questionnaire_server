package jp.ac.dendai.sie.usd.student.usecase.service;

import jp.ac.dendai.sie.usd.domain.model.User;
import jp.ac.dendai.sie.usd.student.model.response.SimpleAnswerRes;
import jp.ac.dendai.sie.usd.student.usecase.presenter.SimpleAnswerPresenter;
import jp.ac.dendai.sie.usd.student.usecase.repository.SimpleAnswerRepository;
import jp.ac.dendai.sie.usd.student.usecase.repository.SimpleQuestionRepository;

import javax.inject.Inject;
import java.util.List;

public class GetSimpleAnswerServiceImp implements GetSimpleAnswerService{
    @Inject
    SimpleAnswerPresenter simpleAnswerPresenter;

    @Inject
    SimpleQuestionRepository simpleQuestionRepository;

    @Inject
    SimpleAnswerRepository simpleAnswerRepository;

    @Override
    public List<SimpleAnswerRes> getSimpleAnswerList(Long questionnaireId, User student) {
        return simpleAnswerPresenter.toSimpleAnswerRes(
                simpleAnswerRepository.findAnyByQuestionnaireIdAndStudentId(questionnaireId, student.getUserId()),
                simpleQuestionRepository.findAnyByQuestionnaireId(questionnaireId)
                );
    }
}
