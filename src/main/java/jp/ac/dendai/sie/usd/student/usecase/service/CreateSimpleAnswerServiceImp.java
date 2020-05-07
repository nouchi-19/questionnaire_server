package jp.ac.dendai.sie.usd.student.usecase.service;

import jp.ac.dendai.sie.usd.domain.model.SimpleAnswer;
import jp.ac.dendai.sie.usd.student.usecase.repository.SimpleAnswerRepository;

import javax.inject.Inject;

public class CreateSimpleAnswerServiceImp implements CreateSimpleAnswerService {
    @Inject
    SimpleAnswerRepository simpleAnswerRepository;

    @Override
    public Long insert(SimpleAnswer simpleAnswer) {
        return simpleAnswerRepository.insert(simpleAnswer);
    }
}
