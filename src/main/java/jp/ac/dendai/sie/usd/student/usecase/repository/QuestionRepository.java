package jp.ac.dendai.sie.usd.student.usecase.repository;

import jp.ac.dendai.sie.usd.domain.model.Question;

import java.util.List;

public interface QuestionRepository {
    default List<Question> questionListAll() {return null;}

//    Optional<Question> findByQuestionId(Long questionId);

    List<Question> findAnyByQuestionnaireId(Long questionnaireId);

    List<Question> findAnyBySubjectId(Long subjectId);

    List<Question> findAnyByStudentId(String studentId);
}
