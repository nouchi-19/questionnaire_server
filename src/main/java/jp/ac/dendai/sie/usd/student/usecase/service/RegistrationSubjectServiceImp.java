package jp.ac.dendai.sie.usd.student.usecase.service;

import jp.ac.dendai.sie.usd.domain.model.User;
import jp.ac.dendai.sie.usd.student.usecase.repository.SubjectRepository;

import javax.inject.Inject;

public class RegistrationSubjectServiceImp implements RegistrationSubjectService {
    @Inject
    SubjectRepository subjectRepository;

    @Override
    public void registrationSubject(Long subjectId, User student) {
        subjectRepository.registrationStudent(subjectId, student);
    }
}
