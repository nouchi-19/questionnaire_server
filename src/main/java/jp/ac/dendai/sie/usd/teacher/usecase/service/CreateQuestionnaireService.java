package jp.ac.dendai.sie.usd.teacher.usecase.service;

import jp.ac.dendai.sie.usd.domain.model.Question;
import jp.ac.dendai.sie.usd.domain.model.Questionnaire;

import java.util.List;

public interface CreateQuestionnaireService {
    Long insert(Questionnaire questionnaire, List<Question> questionList);
    Long updateRelease(Long questionnaireId, Boolean release);
}
