package jp.ac.dendai.sie.usd.teacher.usecase.repository;

import jp.ac.dendai.sie.usd.domain.model.Result;

import java.util.List;
import java.util.Optional;

/**
 * Created by guest1 on 2018/10/25.
 */
public interface ResultRepository {
    default List<Result> getResultAll() {return null;}
//    Long insert(Result result);
    Optional<Result> findByResultId(Long resultId);
    List<Result> findAnyByQuestionnaireId(Long questionnaireId);
//    List<Result> findAnyByQuestionnaireIdAndTeacherId(Long questionnaireId, String teacherId);
    //SubjectIdの保有するQuestionnaireのUserが答えた回答の一覧
//    List<Result> findAnyBySubjectIdAndTeacherId(Long subjectId, String teacherId);
    List<Result> findAnyByTeacherId(String teacherId);
//    List<Result> findAnyByStudentId(TestUser student);
}