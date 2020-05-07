package jp.ac.dendai.sie.usd.teacher.usecase.service;

import jp.ac.dendai.sie.usd.domain.model.Result;
import jp.ac.dendai.sie.usd.domain.model.User;
import jp.ac.dendai.sie.usd.teacher.model.response.ResultRes;

import java.util.List;

/**
 * Created by guest1 on 2018/10/26.
 */
public interface GetResultService {

    List<ResultRes> getResultList(Long subjectId, Long questionnaireId);

    ResultRes getResult(Long subjectId, Long questionnaireId, Long resultId);

    Result tryGet(Long questionnaireId, Long resultId);
}
