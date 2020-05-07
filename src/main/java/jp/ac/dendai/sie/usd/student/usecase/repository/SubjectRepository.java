package jp.ac.dendai.sie.usd.student.usecase.repository;

import jp.ac.dendai.sie.usd.domain.model.Subject;
import jp.ac.dendai.sie.usd.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface SubjectRepository {
    default List<Subject> subjectListAll() {
        return null;
    }
    //subjectIdと一致するSubjectを取得
    Optional<Subject> findBySubjectId(Long subjectId);

    List<Subject> findAnyByStudentId(String studentId);
    void registrationStudent(Long subjectId, User student);
    Boolean permissionStudentId(Long subjectId, String studentId);
    Long courseNumber(Long subjectId);
}
