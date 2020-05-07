package jp.ac.dendai.sie.usd.student.usecase.repository;

import jp.ac.dendai.sie.usd.domain.model.Answer;

import java.util.List;

public interface AnswerRepository {
    default List<Answer> answerListAll(){return null;}

//    Optional<Answer> findByAnswerId(Long answerId);

//    List<Answer> findAnyByQuestionId(Long questionId);

    Long insert(Answer answer);

    List<Long> insertMany(List<Answer> answerList);

    List<Answer> findAnyByResultId(Long resultId);

    List<Answer> findAnyByQuestionnaireId(Long questionnaireId);

    List<Answer> findAnyByQuestionnaireIdAndStudentId(Long questionnaireId, String studentId);

    List<Answer> findAnyByQuestionnaireIdNewAnswers(Long questionnaireId);

//    List findByStudentIdList(String studentId);
//
//    List<Question> findByQuestionIdList(Long questionId);


//    Question findByStudentIdLatest(String studentId);

//    Optional<Question> findByQuestionIdLatest(Long questionId);

    void deleteAnswer(Long answerId);
}
