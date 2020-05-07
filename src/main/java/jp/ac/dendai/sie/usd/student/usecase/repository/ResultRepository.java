package jp.ac.dendai.sie.usd.student.usecase.repository;

import jp.ac.dendai.sie.usd.domain.model.Result;

import java.util.List;
import java.util.Optional;

/**
 * Created by guest1 on 2018/10/25.
 */
public interface ResultRepository {
    default List<Result> getResultAll() {return null;}
    Long insert(Result result);
    Optional<Result> findByResultId(Long resultId);
    List<Result> findAnyByQuestionnaireId(Long questionnaireId);
    List<Result> findAnyByQuestionnaireIdAndStudentId(Long questionnaireId, String studentId);
    //SubjectIdの保有するQuestionnaireのUserが答えた回答の一覧
    List<Result> findAnyBySubjectIdAndStudentId(Long subjectId, String studentId);
    List<Result> findAnyByStudentId(String studentId);
//    List<Result> findAnyByStudentId(TestUser student);
}