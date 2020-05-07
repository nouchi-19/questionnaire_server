package jp.ac.dendai.sie.usd.teacher.usecase.service;

import jp.ac.dendai.sie.usd.domain.model.SimpleQuestion;
import jp.ac.dendai.sie.usd.teacher.usecase.repository.SimpleQuestionRepository;

import javax.inject.Inject;

public class CreateSimpleQuestionServiceImp implements CreateSimpleQuestionService{
    @Inject
    SimpleQuestionRepository simpleQuestionRepository;

    @Override
    public Long insert(SimpleQuestion simpleQuestion) {
        return simpleQuestionRepository.insert(simpleQuestion);
    }
}
