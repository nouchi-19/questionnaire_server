package jp.ac.dendai.sie.usd.teacher.usecase.presenter;

import jp.ac.dendai.sie.usd.domain.model.SimpleAnswer;
import jp.ac.dendai.sie.usd.domain.model.SimpleQuestion;
import jp.ac.dendai.sie.usd.teacher.model.response.SimpleAnswerRes;

import java.util.List;

public interface SimpleAnswerPresenter {
    List<SimpleAnswerRes> toSimpleAnswerRes(List<SimpleAnswer> simpleAnswerList, List<SimpleQuestion> simpleQuestionList);
}
