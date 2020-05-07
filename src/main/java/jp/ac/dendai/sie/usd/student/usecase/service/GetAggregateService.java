package jp.ac.dendai.sie.usd.student.usecase.service;

import jp.ac.dendai.sie.usd.domain.model.User;
import jp.ac.dendai.sie.usd.student.model.response.AggregateRes;


public interface GetAggregateService {
    AggregateRes getAggregate(Long subjectId, Long questionnaireId, User student);
}
