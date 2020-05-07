package jp.ac.dendai.sie.usd.student.usecase.presenter;

import jp.ac.dendai.sie.usd.domain.model.*;
import jp.ac.dendai.sie.usd.student.model.response.AggregateRes;

import java.util.List;

public interface AggregatePresenter {
    AggregateRes toRes(Subject subject, Questionnaire questionnaire, List<Question> questionList, List<Result> resultList, List<Answer> answerList, Long courseNumber);
}
