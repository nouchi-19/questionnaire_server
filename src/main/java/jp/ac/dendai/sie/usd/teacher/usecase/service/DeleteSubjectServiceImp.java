package jp.ac.dendai.sie.usd.teacher.usecase.service;

import jp.ac.dendai.sie.usd.teacher.usecase.repository.QuestionnaireRepository;
import jp.ac.dendai.sie.usd.teacher.usecase.repository.SubjectRepository;

import javax.inject.Inject;

public class DeleteSubjectServiceImp implements DeleteSubjectService{
    @Inject
    SubjectRepository subjectRepository;

    @Inject
    QuestionnaireRepository questionnaireRepository;

    @Override
    public void delete(Long subjectId) {
        subjectRepository.delete(subjectId);
        questionnaireRepository.deleteBySubjectId(subjectId);
    }
}
