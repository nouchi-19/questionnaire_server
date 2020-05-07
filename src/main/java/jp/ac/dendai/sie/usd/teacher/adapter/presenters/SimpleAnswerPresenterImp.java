package jp.ac.dendai.sie.usd.teacher.adapter.presenters;

import jp.ac.dendai.sie.usd.domain.model.SimpleAnswer;
import jp.ac.dendai.sie.usd.domain.model.SimpleQuestion;
import jp.ac.dendai.sie.usd.teacher.adapter.mappers.SimpleAnswerMapper;
import jp.ac.dendai.sie.usd.teacher.adapter.mappers.SimpleQuestionMapper;
import jp.ac.dendai.sie.usd.teacher.model.response.SimpleAnswerRes;
import jp.ac.dendai.sie.usd.teacher.usecase.presenter.SimpleAnswerPresenter;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class SimpleAnswerPresenterImp implements SimpleAnswerPresenter {
    @Inject
    SimpleQuestionMapper simpleQuestionMapper;

    @Inject
    SimpleAnswerMapper simpleAnswerMapper;

    @Override
    public List<SimpleAnswerRes> toSimpleAnswerRes(List<SimpleAnswer> simpleAnswerList, List<SimpleQuestion> simpleQuestionList) {
        List<SimpleAnswerRes> simpleAnswerResList = new ArrayList<>();
        for(SimpleAnswer simpleAnswer :simpleAnswerList) {
            for(SimpleQuestion simpleQuestion:simpleQuestionList) {
                if(simpleAnswer.getSimpleQuestionId().equals(simpleQuestion.getSimpleQuestionId())) {
                    simpleAnswerResList.add(simpleAnswerMapper.toRes(simpleAnswer,simpleQuestionMapper.toRes(simpleQuestion)));
                }
            }
        }
        return simpleAnswerResList;
    }
}
