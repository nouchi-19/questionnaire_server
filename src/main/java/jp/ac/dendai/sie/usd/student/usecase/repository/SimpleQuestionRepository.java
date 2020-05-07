package jp.ac.dendai.sie.usd.student.usecase.repository;


import jp.ac.dendai.sie.usd.domain.model.SimpleQuestion;

import java.util.List;
import java.util.Optional;

public interface SimpleQuestionRepository {
    Optional<SimpleQuestion> findBySimpleQuestionId(Long simpleQuestion);
    List<SimpleQuestion> findAnyByQuestionnaireId(Long questionnaireId);
    List<SimpleQuestion> findAnyBySubjectId(Long subjectId);
    List<SimpleQuestion> findAnyBySubjectIdAndNoAnswerStudentId(Long subjectId, String studentId);
}
