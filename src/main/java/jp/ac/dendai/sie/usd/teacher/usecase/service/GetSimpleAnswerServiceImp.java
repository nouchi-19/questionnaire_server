package jp.ac.dendai.sie.usd.teacher.usecase.service;

import jp.ac.dendai.sie.usd.domain.model.User;
import jp.ac.dendai.sie.usd.teacher.model.response.SimpleAnswerRes;
import jp.ac.dendai.sie.usd.teacher.usecase.presenter.SimpleAnswerPresenter;
import jp.ac.dendai.sie.usd.teacher.usecase.repository.SimpleAnswerRepository;
import jp.ac.dendai.sie.usd.teacher.usecase.repository.SimpleQuestionRepository;

import javax.inject.Inject;
import java.util.List;

public class GetSimpleAnswerServiceImp implements GetSimpleAnswerService {
    @Inject
    SimpleAnswerPresenter simpleAnswerPresenter;

    @Inject
    SimpleQuestionRepository simpleQuestionRepository;

    @Inject
    SimpleAnswerRepository simpleAnswerRepository;

    @Override
    public List<SimpleAnswerRes> getSimpleAnswerList(Long questionnaireId, User student) {
        return simpleAnswerPresenter.toSimpleAnswerRes(
                simpleAnswerRepository.findAnuByQuestionnaireIdNewAnswers(questionnaireId),
                simpleQuestionRepository.findAnyByQuestionnaireId(questionnaireId)
                );
    }
}
