package jp.ac.dendai.sie.usd.teacher.adapter.presenters;

import jp.ac.dendai.sie.usd.domain.model.*;
import jp.ac.dendai.sie.usd.teacher.model.response.AnswerRes;
import jp.ac.dendai.sie.usd.teacher.model.response.QuestionRes;
import jp.ac.dendai.sie.usd.teacher.model.response.ResultRes;
import jp.ac.dendai.sie.usd.teacher.adapter.mappers.*;
import jp.ac.dendai.sie.usd.teacher.usecase.presenter.ResultPresenter;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by guest1 on 2018/10/26.
 */
public class ResultPresenterImp implements ResultPresenter {
    @Inject
    ResultMapper resultMapper;

    @Inject
    SubjectMapper subjectMapper;

    @Inject
    QuestionnaireMapper questionnaireMapper;

    @Inject
    QuestionMapper questionMapper;

    @Inject
    AnswerMapper answerMapper;

    @Override
    public ResultRes toResultRes(Result result, Questionnaire questionnaire, Subject subject, List<Question> questionList, List<Answer> answerList) {
        //todo refactor
        //key :resultId
//        Map<Long, List<Answer>> answerListMap = answerList.stream().collect(Collectors.groupingBy(Answer::getResultId));

        List<QuestionRes> questionResList = questionList.stream().map(question -> questionMapper.toRes(question)).collect(Collectors.toList());

        List<AnswerRes> answerResList = new ArrayList<>();
        for(Answer answer : answerList) {
            for(Question question: questionList) {
                if(answer.getQuestionId().equals(question.getQuestionId())) {
                    answerResList.add(answerMapper.toRes(answer, questionMapper.toRes(question)));
                }
            }
        }

        List<Result> resultList = new ArrayList<>();
        resultList.add(result);
        return resultMapper.toRes(result, questionnaireMapper.toRes(questionnaire, subject, questionResList), answerResList);
    }

    @Override
    public List<ResultRes> toResultRes(List<Result> resultList, Questionnaire questionnaire, Subject subject, List<Question> questionList, List<Answer> answerList) {
        //todo refactor

        //key :resultId
        Map<Long, List<Answer>> answerListMap = answerList.stream().collect(Collectors.groupingBy(Answer::getResultId));

        //ker: questionnaireId
        Map<Long, List<Question>> questionListMap = questionList.stream().collect(Collectors.groupingBy(Question::getQuestionnaireId));

        List<ResultRes> resultResList = new ArrayList<>();

        for(Result result: resultList) {
            Optional<List<Answer>> answerList1 = Optional.ofNullable(answerListMap.get(result.getResultId()));
//            answerList1.
//            List<Answer> answerList1 = answerListMap.get(result.getResultId());
//            if(answerList1==null) {
//                answerList1 = new ArrayList<>();
//            }
            List<AnswerRes> answerResList = new ArrayList<>();
            List<QuestionRes> questionResList = questionListMap.get(result.getQuestionnaireId()).stream().map(question -> questionMapper.toRes(question)).collect(Collectors.toList());
            for(Answer answer : answerList1.orElse(new ArrayList<>())) {
                for(Question question: questionList) {
                    if(answer.getQuestionId().equals(question.getQuestionId())) {
                        answerResList.add(answerMapper.toRes(answer, questionMapper.toRes(question)));
                    }
                }
            }
            List<Result> resultList1 = new ArrayList<>();
            resultList1.add(result);
            resultResList.add(resultMapper.toRes(result, questionnaireMapper.toRes(questionnaire, subject, questionResList), answerResList));
        }
        return resultResList;
    }
}
