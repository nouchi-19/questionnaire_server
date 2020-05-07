package jp.ac.dendai.sie.usd.teacher.adapter.presenters;

import jp.ac.dendai.sie.usd.domain.model.*;
import jp.ac.dendai.sie.usd.teacher.model.response.AggregateRes;
import jp.ac.dendai.sie.usd.teacher.model.response.AnswerRes;
import jp.ac.dendai.sie.usd.teacher.model.response.QuestionRes;
import jp.ac.dendai.sie.usd.teacher.model.response.QuestionnaireRes;
import jp.ac.dendai.sie.usd.teacher.adapter.mappers.AggregateMapper;
import jp.ac.dendai.sie.usd.teacher.adapter.mappers.AnswerMapper;
import jp.ac.dendai.sie.usd.teacher.adapter.mappers.QuestionMapper;
import jp.ac.dendai.sie.usd.teacher.adapter.mappers.QuestionnaireMapper;
import jp.ac.dendai.sie.usd.teacher.usecase.presenter.AggregatePresenter;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AggregatePresenterImp implements AggregatePresenter {
//    @Inject
//    AggregateMapper aggregateMapper;
//
//    @Inject
//    QuestionnaireMapper questionnaireMapper;
//
//    @Inject
//    QuestionMapper questionMapper;
//
//    @Inject
//    AnswerMapper answerMapper;
//
//
//    @Override
//    public AggregateRes toRes(Subject subject, Questionnaire questionnaire, List<Question> questionList, List<Result> resultList, List<Answer> answerList, Long courseNumber) {
//        List<QuestionRes> questionResList = questionList.stream().map(question -> questionMapper.toRes(question)).collect(Collectors.toList());
//        QuestionnaireRes questionnaireRes = questionnaireMapper.toRes(questionnaire, subject, questionResList, resultList);
//
//        List<AnswerRes> answerResList = new ArrayList<>();
//        for(Answer answer : answerList) {
//            for(Question question: questionList) {
//                if(answer.getQuestionId().equals(question.getQuestionId())) {
//                    answerResList.add(answerMapper.toRes(answer, questionMapper.toRes(question)));
//                }
//            }
//        }
//        return aggregateMapper.toRes(questionnaireRes, answerResList, courseNumber);
//    }
}
