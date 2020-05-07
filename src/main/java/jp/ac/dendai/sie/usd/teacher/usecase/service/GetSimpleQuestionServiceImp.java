package jp.ac.dendai.sie.usd.teacher.usecase.service;

import jp.ac.dendai.sie.usd.teacher.model.response.SimpleQuestionRes;
import jp.ac.dendai.sie.usd.teacher.usecase.presenter.SimpleQuestionPresenter;
import jp.ac.dendai.sie.usd.teacher.usecase.repository.SimpleQuestionRepository;

import javax.inject.Inject;
import java.util.List;

public class GetSimpleQuestionServiceImp implements GetSimpleQuestionService {

    @Inject
    SimpleQuestionRepository simpleQuestionRepository;

    @Inject
    SimpleQuestionPresenter simpleQuestionPresenter;

    @Override
    public List<SimpleQuestionRes> getSimpleQuestionList(Long questionnaireId) {
        return simpleQuestionPresenter.toSimpleQuestionRes(simpleQuestionRepository.findAnyByQuestionnaireId(questionnaireId));
    }
}
