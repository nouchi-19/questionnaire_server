package jp.ac.dendai.sie.usd.teacher.adapter.presenters;

import jp.ac.dendai.sie.usd.domain.model.Question;
import jp.ac.dendai.sie.usd.domain.model.Questionnaire;
import jp.ac.dendai.sie.usd.domain.model.Result;
import jp.ac.dendai.sie.usd.domain.model.Subject;
import jp.ac.dendai.sie.usd.teacher.model.response.QuestionRes;
import jp.ac.dendai.sie.usd.teacher.model.response.QuestionnaireRes;
import jp.ac.dendai.sie.usd.teacher.adapter.mappers.QuestionMapper;
import jp.ac.dendai.sie.usd.teacher.adapter.mappers.QuestionnaireMapper;
import jp.ac.dendai.sie.usd.teacher.usecase.presenter.QuestionnairePresenter;

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
    public QuestionnaireRes toQuestionnaireRes(Questionnaire questionnaire, Subject subject, List<Question> questionList) {
        List<QuestionRes> questionResList = questionList.stream().map(question -> questionMapper.toRes(question)).collect(Collectors.toList());
        return questionnaireMapper.toRes(questionnaire, subject, questionResList);
    }

    @Override
    public List<QuestionnaireRes> toQuestionnaireRes(List<Questionnaire> questionnaireList, Subject subject, List<Question> questionList) {
        List<QuestionnaireRes> questionnaireResList = new ArrayList<>();
        Map<Long, List<Question>> questionListMap = questionList.stream().collect(Collectors.groupingBy(Question::getQuestionnaireId));
        for(Questionnaire questionnaire : questionnaireList) {
            List<QuestionRes> questionResList = new ArrayList<>();
            questionResList = questionListMap.get(questionnaire.getQuestionnaireId()).stream().map(question -> questionMapper.toRes(question)).collect(Collectors.toList());
            questionnaireResList.add(questionnaireMapper.toRes(questionnaire, subject, questionResList));
        }
        return questionnaireResList;

    }
}
