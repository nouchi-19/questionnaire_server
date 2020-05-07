package jp.ac.dendai.sie.usd.student.usecase.service;

import jp.ac.dendai.sie.usd.domain.model.SimpleAnswer;
import jp.ac.dendai.sie.usd.student.model.response.SimpleAnswerRes;

import java.util.List;

public interface GetSimpleAnswerAggregateService {
    List<SimpleAnswerRes> getSimpleAggregateResList(Long questionnaireId);
}
