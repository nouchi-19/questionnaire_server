package jp.ac.dendai.sie.usd.student.usecase.presenter;

import jp.ac.dendai.sie.usd.domain.model.*;
import jp.ac.dendai.sie.usd.student.model.response.ResultRes;

import java.util.List;

/**
 * Created by guest1 on 2018/10/26.
 */
public interface ResultPresenter {
//    QuestionnaireRes toQuestionnaireRes(Questionnaire questionnaire, Subject subject, List<Question> questionList);
//    List<QuestionnaireRes> toQuestionnaireRes(List<Questionnaire> questionnaireList, Subject subject, List<Question> questionList);
    ResultRes toResultRes(Result result, Questionnaire questionnaire, Subject subject, List<Question> questionList, List<Answer> answerList);
    List<ResultRes> toResultRes(List<Result> resultList, Questionnaire questionnaire, Subject subject, List<Question> questionList, List<Answer> answerList);
}
