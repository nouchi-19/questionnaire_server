package jp.ac.dendai.sie.usd.student.usecase.service;

import jp.ac.dendai.sie.usd.domain.model.User;
import jp.ac.dendai.sie.usd.student.usecase.repository.SubjectRepository;

import javax.inject.Inject;

public class CheckSubjectServiceImp implements CheckSubjectService {
    @Inject
    SubjectRepository subjectRepository;

    @Override
    public Boolean checkSubject(Long subjectId, User student) {
        return subjectRepository.permissionStudentId(subjectId, student.getUserId());
    }
}
