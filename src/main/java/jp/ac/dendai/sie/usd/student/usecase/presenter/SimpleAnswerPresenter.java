package jp.ac.dendai.sie.usd.student.usecase.presenter;

import jp.ac.dendai.sie.usd.domain.model.SimpleAnswer;
import jp.ac.dendai.sie.usd.domain.model.SimpleQuestion;
import jp.ac.dendai.sie.usd.student.model.response.SimpleAnswerRes;

import java.util.List;

public interface SimpleAnswerPresenter {
    List<SimpleAnswerRes> toSimpleAnswerRes(List<SimpleAnswer> simpleAnswerList, List<SimpleQuestion> simpleQuestionList);
}
