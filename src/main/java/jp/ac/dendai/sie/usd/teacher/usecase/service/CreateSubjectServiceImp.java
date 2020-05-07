package jp.ac.dendai.sie.usd.teacher.usecase.service;

import jp.ac.dendai.sie.usd.domain.model.Subject;
import jp.ac.dendai.sie.usd.teacher.usecase.repository.SubjectRepository;

import javax.inject.Inject;

public class CreateSubjectServiceImp implements CreateSubjectService{

    @Inject
    SubjectRepository subjectRepository;
    @Override
    public Long insert(Subject subject) {
        return subjectRepository.insert(subject);
    }
}
