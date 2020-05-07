package jp.ac.dendai.sie.usd.teacher.usecase.repository;

import jp.ac.dendai.sie.usd.domain.model.SimpleAnswer;

import java.util.List;

public interface SimpleAnswerRepository {
    List<SimpleAnswer> findAnuByQuestionnaireIdNewAnswers(Long questionnaireId);
}
