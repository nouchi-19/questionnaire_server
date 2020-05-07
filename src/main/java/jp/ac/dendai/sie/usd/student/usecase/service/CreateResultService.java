package jp.ac.dendai.sie.usd.student.usecase.service;

import jp.ac.dendai.sie.usd.domain.model.Answer;
import jp.ac.dendai.sie.usd.domain.model.Result;

import java.util.List;

/**
 * Created by guest1 on 2018/10/26.
 */
public interface CreateResultService {
    Long insert(Result result, List<Answer> answerList);
}
