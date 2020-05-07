package jp.ac.dendai.sie.usd.student.adapter.presenters;

import jp.ac.dendai.sie.usd.domain.model.*;
import jp.ac.dendai.sie.usd.student.adapter.mappers.QuestionMapper;
import jp.ac.dendai.sie.usd.student.adapter.mappers.QuestionnaireMapper;
import jp.ac.dendai.sie.usd.student.model.response.*;
import jp.ac.dendai.sie.usd.student.usecase.presenter.QuestionnairePresenter;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class QuestionnairePresenterImp implements QuestionnairePresenter {
    @Inject
    QuestionnaireMapper questionnaireMapper;

    @Inject
    QuestionMapper questionMapper;

    @Override
    public QuestionnaireRes toQuestionnaireRes(Questionnaire questionnaire, Subject subject, List<Question> questionList, List<Result> resultList) {
        List<QuestionRes> questionResList = questionList.stream().map(question -> questionMapper.toRes(question)).collect(Collectors.toList());
        return questionnaireMapper.toRes(questionnaire, subject, questionResList, resultList);
    }

    @Override
    public List<QuestionnaireRes> toQuestionnaireRes(List<Questionnaire> questionnaireList, Subject subject, List<Question> questionList, List<Result> resultList) {
        List<QuestionnaireRes> questionnaireResList = new ArrayList<>();
        Map<Long, List<Question>> questionListMap = questionList.stream().collect(Collectors.groupingBy(Question::getQuestionnaireId));
        for(Questionnaire questionnaire : questionnaireList) {
            List<QuestionRes> questionResList = questionListMap.get(questionnaire.getQuestionnaireId()).stream().map(question -> questionMapper.toRes(question)).collect(Collectors.toList());
            List<Result> questionnaireResultList = resultList.stream().filter(result -> result.getQuestionnaireId().equals(questionnaire.getQuestionnaireId())).collect(Collectors.toList());
            questionnaireResList.add(questionnaireMapper.toRes(questionnaire, subject, questionResList, questionnaireResultList));
        }
        return questionnaireResList;
    }
}
