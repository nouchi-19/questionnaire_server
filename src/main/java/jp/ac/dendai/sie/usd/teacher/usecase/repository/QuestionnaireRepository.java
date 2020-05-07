package jp.ac.dendai.sie.usd.teacher.usecase.repository;

import jp.ac.dendai.sie.usd.domain.model.Questionnaire;

import java.util.List;
import java.util.Optional;

public interface QuestionnaireRepository {
    default List<Questionnaire> questionnaireListAll() {return null;}

    Long insert(Questionnaire questionnaire);

    void delete(Long questionnaireId);
    void deleteBySubjectId(Long subjectId);

    Long updateRelease(Long questionnaireId, Boolean release);

    Optional<Questionnaire> findByQuestionnaireId(Long questionnaireId);

    List<Questionnaire> findAnyBySubjectId(Long subjectId);

    List<Questionnaire> findAnyByTeacherId(String TeacherId);


//    void saveQuestionnaire(Questionnaire questionnaire);
//
//    void addQuestion(Long questionnaireId, Question question);
}
