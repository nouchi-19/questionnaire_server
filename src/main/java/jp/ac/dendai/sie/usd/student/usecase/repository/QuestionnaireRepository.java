package jp.ac.dendai.sie.usd.student.usecase.repository;

import jp.ac.dendai.sie.usd.domain.model.Questionnaire;

import java.util.List;
import java.util.Optional;

public interface QuestionnaireRepository {
    default List<Questionnaire> questionnaireListAll() {return null;}

    Optional<Questionnaire> findByQuestionnaireId(Long questionnaireId);

    List<Questionnaire> findAnyBySubjectId(Long subjectId);

    List<Questionnaire> findAnyByStudentId(String studentId);


//    void saveQuestionnaire(Questionnaire questionnaire);
//
//    void addQuestion(Long questionnaireId, Question question);
}
