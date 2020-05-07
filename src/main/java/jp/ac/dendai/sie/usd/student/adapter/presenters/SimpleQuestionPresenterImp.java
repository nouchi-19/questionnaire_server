package jp.ac.dendai.sie.usd.student.adapter.presenters;

import jp.ac.dendai.sie.usd.domain.model.SimpleQuestion;
import jp.ac.dendai.sie.usd.student.adapter.mappers.SimpleQuestionMapper;
import jp.ac.dendai.sie.usd.student.model.response.SimpleQuestionRes;
import jp.ac.dendai.sie.usd.student.usecase.presenter.SimpleQuestionPresenter;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleQuestionPresenterImp implements SimpleQuestionPresenter {

    @Inject
    SimpleQuestionMapper simpleQuestionMapper;

    @Override
    public List<SimpleQuestionRes> toSimpleQuestionRes(List<SimpleQuestion> simpleQuestionList) {
        return simpleQuestionList.stream().map(simpleQuestion -> simpleQuestionMapper.toRes(simpleQuestion)).collect(Collectors.toList());
    }
}
