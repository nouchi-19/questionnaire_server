package jp.ac.dendai.sie.usd.student.usecase.service;

import jp.ac.dendai.sie.usd.student.model.response.SimpleAnswerRes;
import jp.ac.dendai.sie.usd.student.usecase.presenter.SimpleAnswerPresenter;
import jp.ac.dendai.sie.usd.student.usecase.repository.SimpleAnswerRepository;
import jp.ac.dendai.sie.usd.student.usecase.repository.SimpleQuestionRepository;

import javax.inject.Inject;
import java.util.List;

public class GetSimpleAnswerAggregateServiceImp implements GetSimpleAnswerAggregateService {
    @Inject
    SimpleAnswerPresenter simpleAnswerPresenter;

    @Inject
    SimpleQuestionRepository simpleQuestionRepository;

    @Inject
    SimpleAnswerRepository simpleAnswerRepository;

    @Override
    public List<SimpleAnswerRes> getSimpleAggregateResList(Long questionnaireId) {
        return simpleAnswerPresenter.toSimpleAnswerRes(
                simpleAnswerRepository.findAnuByQuestionnaireIdNewAnswers(questionnaireId),
                simpleQuestionRepository.findAnyByQuestionnaireId(questionnaireId)
        );
    }
}
