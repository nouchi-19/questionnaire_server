package jp.ac.dendai.sie.usd.student.usecase.repository;

import jp.ac.dendai.sie.usd.domain.model.SimpleAnswer;

import java.util.List;

public interface SimpleAnswerRepository {
    Long insert(SimpleAnswer simpleAnswer);
    List<SimpleAnswer> findAnyByQuestionnaireIdAndStudentId(Long questionnaireId, String studentId);
    List<SimpleAnswer> findAnuByQuestionnaireIdNewAnswers(Long questionnaireId);
}
