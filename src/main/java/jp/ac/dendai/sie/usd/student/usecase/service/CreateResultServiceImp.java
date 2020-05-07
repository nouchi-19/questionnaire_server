package jp.ac.dendai.sie.usd.student.usecase.service;

import jp.ac.dendai.sie.usd.domain.model.Answer;
import jp.ac.dendai.sie.usd.domain.model.Result;
import jp.ac.dendai.sie.usd.student.usecase.repository.AnswerRepository;
import jp.ac.dendai.sie.usd.student.usecase.repository.ResultRepository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by guest1 on 2018/10/26.
 */
public class CreateResultServiceImp implements CreateResultService{
    @Inject
    ResultRepository resultRepository;

    @Inject
    AnswerRepository answerRepository;

    @Override
    public Long insert(Result result, List<Answer> answerList) {
        Long resultId = resultRepository.insert(result);
        answerList.forEach(answer -> answer.setResultId(resultId));
//        answerList.forEach(answer -> answerRepository.insert(answer));
        answerRepository.insertMany(answerList);
        return resultId;
    }
}
