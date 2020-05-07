package jp.ac.dendai.sie.usd.student.usecase.service;

import jp.ac.dendai.sie.usd.domain.model.User;

public interface RegistrationSubjectService {
    void registrationSubject(Long subjectId, User student);
}
