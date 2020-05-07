package jp.ac.dendai.sie.usd.student.usecase.service;

import jp.ac.dendai.sie.usd.domain.model.Questionnaire;
import jp.ac.dendai.sie.usd.domain.model.User;
import jp.ac.dendai.sie.usd.student.model.response.QuestionnaireRes;

import java.util.List;

/**
 * Created by guest1 on 2018/10/25.
 */
public interface GetQuestionnaireService {
    List<QuestionnaireRes> getQuestionnaireList(Long subjectId, User student);

    QuestionnaireRes getQuestionnaire(Long subjectId, Long questionnaireId, User student);

    Questionnaire tryGet(Long subjectId, Long questionnaireId);
}
