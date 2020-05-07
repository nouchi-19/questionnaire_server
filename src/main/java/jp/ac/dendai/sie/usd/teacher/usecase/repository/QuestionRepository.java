package jp.ac.dendai.sie.usd.teacher.usecase.repository;

import jp.ac.dendai.sie.usd.domain.model.Question;

import java.util.List;

public interface QuestionRepository {
    default List<Question> questionListAll() {return null;}

    List<Long> insertMany(List<Question> questionList);

//    Optional<Question> findByQuestionId(Long questionId);

    List<Question> findAnyByQuestionnaireId(Long questionnaireId);

    List<Question> findAnyBySubjectId(Long subjectId);

    List<Question> findAnyByTeacherId(String teacherId);
}
