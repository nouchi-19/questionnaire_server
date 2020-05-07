package jp.ac.dendai.sie.usd.teacher.usecase.repository;

import jp.ac.dendai.sie.usd.domain.model.Subject;
import jp.ac.dendai.sie.usd.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface SubjectRepository {
    default List<Subject> subjectListAll() {
        return null;
    }
    Long insert(Subject subject);

    void delete(Long subjectId);
    //subjectIdと一致するSubjectを取得
    Optional<Subject> findBySubjectId(Long subjectId);

    List<Subject> findAnyByTeacherId(String teacherId);
//    void registrationStudent(Long subjectId, User student);
    Boolean permissionStudentId(Long subjectId, String teacherId);
    Long courseNumber(Long subjectId);

    //registration用のクラスに移動?
    List<User> findAnyByUser(Long subjectId);
}
