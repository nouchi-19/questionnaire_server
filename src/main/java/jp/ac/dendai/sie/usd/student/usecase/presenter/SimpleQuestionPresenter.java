package jp.ac.dendai.sie.usd.student.usecase.presenter;

import jp.ac.dendai.sie.usd.domain.model.SimpleQuestion;
import jp.ac.dendai.sie.usd.student.model.response.SimpleQuestionRes;

import java.util.List;

public interface SimpleQuestionPresenter {
    List<SimpleQuestionRes> toSimpleQuestionRes(List<SimpleQuestion> simpleQuestionList);
}
