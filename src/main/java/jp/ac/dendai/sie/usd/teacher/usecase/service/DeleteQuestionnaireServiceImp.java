package jp.ac.dendai.sie.usd.teacher.usecase.service;

import jp.ac.dendai.sie.usd.teacher.usecase.repository.QuestionnaireRepository;

import javax.inject.Inject;

public class DeleteQuestionnaireServiceImp implements DeleteQuestionnaireService{
    @Inject
    QuestionnaireRepository questionnaireRepository;

    @Override
    public void delete(Long questionnaireId) {
        questionnaireRepository.delete(questionnaireId);
    }
}
