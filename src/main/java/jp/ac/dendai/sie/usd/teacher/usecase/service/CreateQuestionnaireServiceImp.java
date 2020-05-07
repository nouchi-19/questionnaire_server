package jp.ac.dendai.sie.usd.teacher.usecase.service;

import jp.ac.dendai.sie.usd.domain.model.Question;
import jp.ac.dendai.sie.usd.domain.model.Questionnaire;
import jp.ac.dendai.sie.usd.teacher.usecase.repository.QuestionRepository;
import jp.ac.dendai.sie.usd.teacher.usecase.repository.QuestionnaireRepository;

import javax.inject.Inject;
import java.util.List;

public class CreateQuestionnaireServiceImp implements CreateQuestionnaireService{

    @Inject
    QuestionnaireRepository questionnaireRepository;

    @Inject
    QuestionRepository questionRepository;

    @Override
    public Long insert(Questionnaire questionnaire, List<Question> questionList) {
        Long questionnaireId = questionnaireRepository.insert(questionnaire);
        questionList.forEach(question -> question.setQuestionnaireId(questionnaireId));
        questionRepository.insertMany(questionList);
        return questionnaireId;
    }

    @Override
    public Long updateRelease(Long questionnaireId, Boolean release) {
        return questionnaireRepository.updateRelease(questionnaireId, release);
    }
}