package jp.ac.dendai.sie.usd.teacher.usecase.presenter;

import jp.ac.dendai.sie.usd.domain.model.SimpleQuestion;
import jp.ac.dendai.sie.usd.teacher.model.response.SimpleQuestionRes;

import java.util.List;

public interface SimpleQuestionPresenter {
    List<SimpleQuestionRes> toSimpleQuestionRes(List<SimpleQuestion> simpleQuestionList);
}
