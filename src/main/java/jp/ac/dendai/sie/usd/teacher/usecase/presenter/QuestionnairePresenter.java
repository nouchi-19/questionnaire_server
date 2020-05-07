package jp.ac.dendai.sie.usd.teacher.usecase.presenter;

import jp.ac.dendai.sie.usd.domain.model.Question;
import jp.ac.dendai.sie.usd.domain.model.Questionnaire;
import jp.ac.dendai.sie.usd.domain.model.Result;
import jp.ac.dendai.sie.usd.domain.model.Subject;
import jp.ac.dendai.sie.usd.teacher.model.response.QuestionnaireRes;

import java.util.List;

public interface QuestionnairePresenter {
    QuestionnaireRes toQuestionnaireRes(Questionnaire questionnaire, Subject subject, List<Question> questionList);
    List<QuestionnaireRes> toQuestionnaireRes(List<Questionnaire> questionnaireList, Subject subject, List<Question> questionList);
}
